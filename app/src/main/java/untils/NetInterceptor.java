package untils;

import android.os.Build;
import android.util.Log;


import com.example.login_demo.MyApp;

import java.io.IOException;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by 地地 on 2017/12/10.
 * 邮箱：461211527@qq.com.
 */

public class NetInterceptor {
    private static final int TIMEOUT_CONNECT = 5; //5秒
    private static final int TIMEOUT_DISCONNECT = 60 * 60 * 24 * 7; //7天

    public static final Interceptor REWRITE_RESPONSE_INTERCEPTOR = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            //获取retrofit @headers里面的参数，参数可以自己定义，在本例我自己定义的是cache，跟@headers里面对应就可以了
            String cache = chain.request().header("cache");
            Response originalResponse = chain.proceed(chain.request());

            String cacheControl = originalResponse.header("Cache-Control");
            //如果cacheControl为空，就让他TIMEOUT_CONNECT秒的缓存，本例是5秒，方便观察。注意这里的cacheControl是服务器返回的
            if (cacheControl == null) {
                //如果cache没值，缓存时间为TIMEOUT_CONNECT，有的话就为cache的值
                if (cache == null || "".equals(cache)) {
                    cache = TIMEOUT_CONNECT + "";
                }
                originalResponse = originalResponse.newBuilder()
                        .header("Cache-Control", "public, max-age=" + cache)
                        .build();
                return originalResponse;
            } else {
                return originalResponse;
            }
        }
    };

    public static final Interceptor REWRITE_RESPONSE_INTERCEPTOR_OFFLINE = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            //离线的时候为7天的缓存。
            if (!MyNetUtils.isConnected(MyApp.context)) {
                request = request.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale="+TIMEOUT_DISCONNECT)
                        .build();
            }
            return chain.proceed(request);
        }
    };
  public static final Interceptor REWRITE_RESPONSE_INTERCEPTOR_LOG = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
      @Override
      public void log(String message) {
          System.out.println("MYOKTTP==="+message);
      }
     }).setLevel(HttpLoggingInterceptor.Level.BODY);


    public static final Interceptor REWRITE_RESPONSE_MYINTERCEPTOR=new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            String method=request.method();
            if("POST".equals(method)){
                FormBody.Builder sb = new FormBody.Builder();
                if (request.body() instanceof FormBody) {
                    FormBody body = (FormBody) request.body();
                    for (int i = 0; i < body.size(); i++) {
                        sb.add(body.encodedName(i) , body.encodedValue(i));
                    }
                    body=sb.build();
                    request=request.newBuilder()
                            .post(body)
                            .build();
                }else if (request.body() instanceof MultipartBody){
                    MultipartBody body=(MultipartBody)request.body();
                    MultipartBody.Builder build = new MultipartBody.Builder().setType(MultipartBody.FORM);
                    List<MultipartBody.Part> parts = body.parts();
                    for (MultipartBody.Part part : parts) {
                        build.addPart(part);
                    }
                    request =request.newBuilder().post(build.build())
                            .addHeader("Content-Type","application/json")
                            .addHeader("charset", "utf-8")
                            .build();
                }
            }else {
                HttpUrl httpUrl = request.url()
                        .newBuilder()
                        .build();
              request = request.newBuilder()
                      .addHeader("Connection","close")
                      .get().url(httpUrl).build();
            }
            return  chain.proceed(request);
        }
    };

}
