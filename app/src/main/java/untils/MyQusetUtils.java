package untils;



import com.example.login_demo.MyApp;

import java.io.File;
import java.util.concurrent.TimeUnit;


import base.BaseApi;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 地地 on 2017/11/12.
 * 邮箱：461211527@qq.com.
 */

public class MyQusetUtils {
  public static final int TIMEOUT=1000*60;
  public static  MyQusetUtils myQusetUtils;
  private QuestInterface questInterface;

  public MyQusetUtils(QuestInterface questInterface) {
    this.questInterface = questInterface;
  }
  public  QuestInterface getQuestInterface(){
    return  questInterface;
}

    public static MyQusetUtils getInstance(){
      if (myQusetUtils == null) {
          OkHttpClient okHttpClient=null;
          if(okHttpClient==null){
              File cacheFile = new File(MyApp.context.getCacheDir(), "cache");
              Cache cache = new Cache(cacheFile, 1024 * 1024 * 100);
              okHttpClient=new OkHttpClient.Builder()
                      .addInterceptor(NetInterceptor.REWRITE_RESPONSE_INTERCEPTOR_LOG)
                      .addInterceptor(NetInterceptor.REWRITE_RESPONSE_INTERCEPTOR_OFFLINE)
                      .addNetworkInterceptor(NetInterceptor.REWRITE_RESPONSE_INTERCEPTOR)
                      .addInterceptor(NetInterceptor.REWRITE_RESPONSE_MYINTERCEPTOR)
                      .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                      .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                      .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                      .retryOnConnectionFailure(false)
                      .cache(cache).build();
          }
          Retrofit.Builder builder = new Retrofit.Builder()
                  .baseUrl(BaseApi.Api).client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
          QuestInterface questInterface=builder.build().create(QuestInterface.class);
          myQusetUtils=new MyQusetUtils(questInterface);
      }
      return   myQusetUtils;
  }

}
