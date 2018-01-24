package com.example.login_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import base.BaseActivity;

public class UserAgreenActivity extends BaseActivity {



    @Override
    public int getId() {
        return R.layout.activity_user_agreen;
    }

    @Override
    public void InIt() {
       ImageView  back = findViewById(R.id.useragreen_iv_back);
       back.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();
           }
       });

    }
}
