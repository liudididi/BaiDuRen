package base;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.login_demo.ConnectionChangeReceiver;
import com.example.login_demo.R;
import com.weavey.loading.lib.LoadingLayout;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.ButterKnife;

/**
 * Created by 地地 on 2017/11/12.
 * 邮箱：461211527@qq.com.
 */

public abstract  class BaseActivity extends AutoLayoutActivity{
    private  boolean  isStatus=false;
    private  boolean  isFullScreen=false;
    public   LoadingLayout loadingLayout;


    private Toast toast;
    /* ProgressDialog */


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        setTheme(R.style.HaveBackGround);
        super.onCreate(savedInstanceState);
        //禁止横屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
// 状态栏颜色
        initztl("#3B9EFF");
        setContentView(getId());
        ButterKnife.bind(this);

        InIt();
    }


    //主布局
    public  abstract int getId();
    //初始化
    public  abstract  void InIt();

    /**
     * 设置状态栏
     * @param color
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public  void initztl(String color){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor(color));
        }
    }
    /**
     * 设置透明状态：沉浸式
     * @param status
     */
    public void setStatus(boolean status) {
        isStatus = status;
        if (isStatus){
            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }
        }
    }
    /**
     * 设置全屏
     * @param fullScreen
     */
    public void setFullScreen(boolean fullScreen) {
        isFullScreen = fullScreen;
        if (isFullScreen){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }
    public  void  Toast(String s){
            toast = Toast.makeText(this, s, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
    }
   public   void  intent(Context packageContext, Class<?> cls){
         Intent intent=new Intent(packageContext,cls);
         startActivity(intent);
   }







}
