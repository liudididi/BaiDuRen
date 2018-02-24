package base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.login_demo.ConnectionChangeReceiver;
import com.example.login_demo.MainActivity;
import com.example.login_demo.R;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.ButterKnife;

/**
 * Created by 地地 on 2017/11/12.
 * 邮箱：461211527@qq.com.
 */

public abstract  class BaseActivity extends AutoLayoutActivity{
    private  boolean  isStatus=false;
    private  boolean  isFullScreen=false;

    private Toast toast;
    /* ProgressDialog */

    private ConnectionChangeReceiver myReceiver;

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



    public void registerReceiver() {
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        //设置网络状态提示布局的状态
//无网的时候，无网提示的展示View展示出来
//重新联接上网络时，自动加载数据
//这个是onresume中实现了数据的刷新，即是，网络连接后，重新拉取数据
        myReceiver = new ConnectionChangeReceiver() {
            @Override
            public void changeNetStatus(boolean flag) {
                //设置网络状态提示布局的状态
                if (flag) {
                    new AlertDialog.Builder(BaseActivity.this)
                            .setTitle("温馨提示")
                            .setMessage("当前无网络，请检查您的网络设置")
                            .show();
                } else {

                }

            }
        };
        this.registerReceiver(myReceiver, filter);
    }

    public void unregisterReceiver() {
        if (myReceiver != null) {
            this.unregisterReceiver(myReceiver);
        }
    }
}
