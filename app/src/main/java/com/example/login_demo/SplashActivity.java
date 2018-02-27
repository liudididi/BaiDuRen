package com.example.login_demo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import base.BaseActivity;

public class SplashActivity extends BaseActivity {

    private int time=3;
    private Handler handler;
    private Runnable runnable;

    @Override
    public int getId() {
        return R.layout.activity_splash;
    }

    @Override
    public void InIt() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                time--;
                handler.postDelayed(this,1000);
                if(time==0)
                {
                    startActivity(new Intent(SplashActivity.this,HomeActivity.class));
                    overridePendingTransition(R.anim.enter_anim, R.anim.exit_anim);
                    finish();
                }
            }
        };
        handler.postDelayed(runnable,2000);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(runnable!=null){
            handler.removeCallbacks(runnable);
            handler=null;
        }
    }
}
