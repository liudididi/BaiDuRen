package untils;

import java.util.List;


import base.BaseBean;
import bean.AreaBean;
import bean.CanSchoolBean;
import bean.CheckSchoolBean;
import bean.CityBean;
import bean.HotBean;
import bean.InquireBean;
import bean.MajorBean;
import bean.MoreJobBean;
import bean.NewsBean;
import bean.ProviceBean;
import bean.RanKingSchoolBean;
import bean.SchoolBean;
import bean.SearchBean;
import bean.SelectMajorBean;
import bean.SelectSchoolBean;
import bean.SlideshowBean;
import bean.UserBean;
import io.reactivex.Flowable;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by 地地 on 2017/11/12.
 * 邮箱：461211527@qq.com.
 */

public interface QuestInterface {

    //大学排序
    @GET("/app/hotlist/queryHot")
    Flowable<BaseBean<List<HotBean>>> queryHot();
    @POST("/app/hotlist/save")
    Flowable<BaseBean> hotsave(@Query("hot_name") String name);
    //院校库
    @GET("/app/school/check")
    Flowable<BaseBean<List<CheckSchoolBean>>> checkschool(@Query("address") String address, @Query("schooltype") String schooltype, @Query("two") String two, @Query("nine") String nine, @Query("plan") String plan, @Query("student") String student, @Query("recruit") String recruit);

    //大学排序
    @GET("/app/university/selUnivMobil")
    Flowable<BaseBean<RanKingSchoolBean>> ranking(@Query("page") int page, @Query("limit") int limit);

    //首页查询
    @GET("/app/search/majorCollege")
    Flowable<BaseBean<List<SearchBean>>> searchmajorCollege(@Query("name") String name);
    //倒计时
    @GET("/app/countdown/query")
    Flowable<BaseBean> Countdown();

    //专业库
    @GET("/app/major/getAllMajorForMoble")
    Flowable<BaseBean<List<SelectMajorBean>>> selectAllMajor(@Query("majorType") String majorType);

    //职业库
    @GET("/app/job/getAllJobForMobile")
    Flowable<BaseBean<List<MoreJobBean>>> selectAllJob();

    //轮播图接口
    @GET("/app/boardpicture/queryInfo")
    Flowable<BaseBean<List<SlideshowBean>>> Slideshow(@Query("board_id") int board_id);

    //新闻接口
    @GET("/app/news/newsInfo")
    Flowable<BaseBean<NewsBean>> News(@Query("category") String category, @Query("province") String province, @Query("page") String page, @Query("limit") String limit);

    //登录接口
    @POST("/app/userinfo/modifyUserinfo")
    Flowable<BaseBean> modifyUserinfo(@Body RequestBody requestBody );

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


    //获取省份
    @POST("/app/provinces/prov")
    Flowable<BaseBean<List<ProviceBean>>> getprovinces();


    //获取城市
    @GET("/app/cities/cityMobil")
    Flowable<BaseBean<List<CityBean>>> getcitys(@Query("provinceid") String provinceid);


    //修改用户信息
    @POST("/app/userinfo/modifyUserinfoMoble")
    Flowable<BaseBean> modifyUserinfoMoble(@Query("provice") String provice,@Query("city") String city,@Query("area") String area,@Query("midSchool") String midSchool,@Query("grade") String grade,@Query("schoolClass") String schoolClass,@Query("name") String name,@Query("sex") String sex,@Query("examYear") String examYear,@Query("stuType") String stuType,@Query("isSpecial") boolean isSpecial,@Header("token") String token);

    //获取学校
    @GET("/app/highschool/selhighschoolMobil")
    Flowable<BaseBean<List<SelectSchoolBean>>> getschools(@Query("province") String province,@Query("city") String city,@Query("area") String area);







    //填写成绩表
    @POST("/app/result/insertUserResult")
    Flowable<BaseBean>  grade(@Query("testType")Integer testType,@Query("time")Integer time,@Query("chinese")Double chinese,@Query("math")Double math,@Query("languages")Double languages,@Query("physics")Double physics,@Query("chemistry")Double chemistry,@Query("biology")Double biology,@Query("history")Double history,@Query("geography")Double geography,@Query("politics")Double politics,@Query("specialty")Double specialty,@Header("token") String token);

    //查询成绩表
    @GET("/app/result/getResult")
    Flowable<BaseBean<InquireBean>>  inquiregrade(@Query("testType")Integer testType, @Query("testTime")Integer testTime, @Header("token") String token);

    //能上的学校
    @GET("/app/universitytimescore/timescoreMobil")
    Flowable<BaseBean<CanSchoolBean>>  canschool(@Query("province")String province, @Query("classify")String classify, @Query("score_min") String score_min, @Query("score_max") String score_max, @Query("page") String page, @Query("limit") String limit);




    //获取曲县
    @GET("/app/areas/areaMobil")
    Flowable<BaseBean<List<AreaBean>>> getareas(@Query("cityid") String cityid);

    //查询学校收藏
    @GET("/app/collection/getCollection")
    Flowable<BaseBean<List<SchoolBean>>> getCollection(@Query("type") int type, @Header("token") String token);


    //查询学校收藏
    @GET("/app/collection/getCollection")
    Flowable<BaseBean<List<MajorBean>>>   getmajorCollection(@Query("type") int type, @Header("token") String token);

    //志愿表轮播图
    @GET("/app/boardpicture/queryInfo")
    Flowable<BaseBean<List<SlideshowBean>>> Wish(@Query("board_id") int board_id);

    //提交建议的接口
    @POST("/app/proposal/pro")
    @Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
    @FormUrlEncoded
    Flowable<BaseBean> suggest(@Field("proposal") String proposal,@Field("contactInformation") String contactInformation );


    //获取用户信息
    @POST("/app/userinfo/getUserinfo")
    Flowable<BaseBean<UserBean>> getUserinfo(@Header("token") String token);

    @POST("/app/updateMobileVerifyOld")
    Flowable<BaseBean> updateMobileVerifyOld(@Query("mobile")String mobile,@Query("captcha")String captcha,@Header("token") String token);


    @POST("/app/updateMobile")

    Flowable<BaseBean>  updateMobile(@Query("newmobile")String mobile,@Query("captcha")String captcha,@Header("token") String token);


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