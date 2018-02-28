package com.example.login_demo;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.tencent.bugly.crashreport.CrashReport;
import com.zhy.autolayout.config.AutoLayoutConifg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by 地地 on 2018/1/19.
 * 邮箱：461211527@qq.com.
 */

public class MyApp extends Application {
    public  static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
        AutoLayoutConifg.getInstance().useDeviceSize();
        Context context = getApplicationContext();

// 获取当前包名
        String packageName = context.getPackageName();
// 获取当前进程名
        String processName = getProcessName(android.os.Process.myPid());
// 设置是否为上报进程
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(context);
        strategy.setUploadProcess(processName == null || processName.equals(packageName));
// 初始化Bugly
        CrashReport.initCrashReport(context, "51fb22d762", false, strategy);


    }

    private static String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }
}
