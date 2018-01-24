package untils;

import java.util.List;
import java.util.Map;


import base.BaseBean;
import bean.NewsBean;
import bean.SlideshowBean;
import bean.UserBean;
import io.reactivex.Flowable;
import io.reactivex.Observable;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by 地地 on 2017/11/12.
 * 邮箱：461211527@qq.com.
 */

public interface QuestInterface {



    //轮播图接口
    @GET("/app/boardpicture/queryInfo")
    Flowable<BaseBean<List<SlideshowBean>>> Slideshow(@Query("board_id") int board_id);

    //新闻接口
    @GET("/app/news/newsInfo")
    Flowable<BaseBean<NewsBean>> News(@Query("category") String category, @Query("province") String province, @Query("page") String page, @Query("limit") String limit);

    //登录接口
    @POST("/app/login")
    Flowable<BaseBean> Login(@Body RequestBody requestBody);

    @POST("/app/loginByMobilePwd")
    @FormUrlEncoded
    Flowable<BaseBean<UserBean>> loginByMobilePwd(@Field("mobile") String mobile,@Field("password") String password);
    //获取登录验证码
    @GET("/app/mobileLoginCaptcha")
    Flowable<BaseBean> LogCaptcha(@Query("mobile") String mobile);
    //获取注册验证码
    @GET("/app/mobileRegisterCaptcha")
    Flowable<BaseBean> RegisterCaptcha(@Query("mobile") String mobile);
    //忘记密码验证码
    @GET("/app/mobileFindPwdCaptcha")
    Flowable<BaseBean> UpdateCaptcha(@Query("mobile") String mobile);
    //手机号验证码登录
    @POST("/app/MobileLoginByCaptcha")
    @FormUrlEncoded
    Flowable<BaseBean<UserBean>> phoneLogin(@Field("mobile") String mobile,@Field("captcha") String captcha);
    //找回密码
    @POST("/app/findPwdByMobile")
    @FormUrlEncoded
    Flowable<BaseBean> findPwdByMobile(@Field("mobile") String mobile,@Field("captcha") String captcha,@Field("newpassword") String newpasswprd);
    //注册接口
    @POST("/app/registerByMobile")
    @FormUrlEncoded
    Flowable<BaseBean> register(@Field("mobile") String mobile,@Field("password") String password,@Field("captcha") String captcha);


    //修改手机号验证码
    @GET("/app/mobileUpdateCaptcha")
    Flowable<BaseBean> mobileUpdateCaptcha(@Query("mobile") String mobile);


    //提交建议的接口
    @POST("/app/proposal/pro")
    @FormUrlEncoded
    Flowable<BaseBean> suggest(@Field("proposal") String proposal,@Field("contactInformation") String contactInformation );



/*
    @GET("/quarter/getJokes")
    Observable<Basebean<List<Duanzibean>>> getdata(@Query("page") int page);

    @POST("user/getUserInfo")
    @FormUrlEncoded
    Observable<Basebean<UserBean>> getuser(@FieldMap Map<String, Object> maps);



    @Multipart
    @POST("/quarter/publishJoke")
    Observable<Basebean> faduanzi(@Part() List<MultipartBody.Part> file);

    @Multipart
    @POST("/file/upload")
    Observable<Basebean> changeicon(@Part() List<MultipartBody.Part> file);


    @POST("/user/updateNickName")
    @FormUrlEncoded
    Observable<Basebean> xiunicheng(@Field("uid") int uid, @Field("nickname") String nickname);

    @GET("/quarter/getAd")
    Observable<Basebean<List<Guanggao>>> getad();


    @GET("/quarter/getVideos")
    Observable<Basebean<List<TuijianBean>>> gettuijian(@Query("uid") String uid, @Query("type") int type, @Query("page") int page);


    @Multipart
    @POST("/quarter/publishVideo")
    Observable<Basebean> upvideo(@Part() List<MultipartBody.Part> file);

    @GET("/quarter/getHotVideos")
    Observable<Basebean<List<TuijianBean>>> spremen(@Query("page") int page);


    @POST("/quarter/getUserVideos")
    @FormUrlEncoded
    Flowable<Basebean<List<TuijianBean>>> getuserdata(@Field("uid") int uid, @Field("page") int page);

     @GET("/quarter/getVersion")
     Flowable<Basebean<VisionBean>> upvision();

    @GET("/quarter/follow")
    Flowable<Basebean> guanzhu(@Query("uid") int uid, @Query("followId") String followId);

     @GET("/quarter/getFollowUsers")
     Flowable<Basebean<List<GuanzhuBean>>> Iguanzhudata(@Query("uid") int uid);

    @GET("/quarter/searchFriends")
    Flowable<Basebean<List<GuanzhuBean>>> sousuo(@Query("keywords") String keywords, @Query("page") String page);

    @GET("/quarter/getVideoDetail")
    Flowable<Basebean<TuijianBean>> Xiangqing(@Query("wid") int wid);

    @POST("/quarter/comment")
    @FormUrlEncoded
    Flowable<Basebean> pinglun(@FieldMap Map<String, Object> maps);*/


}