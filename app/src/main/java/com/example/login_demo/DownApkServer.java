package com.example.login_demo;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.DownloadManager;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.FileProvider;
import android.widget.RemoteViews;
import android.widget.Toast;

import java.io.File;

import retrofit2.http.Query;
import untils.PermissionUtils;

import static com.example.login_demo.MyApp.context;

/**
 * Created by 地地 on 2018/2/7.
 * 邮箱：461211527@qq.com.
 */

public class DownApkServer extends Service {
    private BroadcastReceiver receiver;
    private DownloadManager dm;
    private long enqueue;
    private  Context con;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        receiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
              con=context;
                checkStatus();
                stopSelf();
            }
        };
        IntentFilter filter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
        registerReceiver(receiver, filter);
        startDownload(intent.getStringExtra("downUrl"));
        return Service.START_STICKY;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void startDownload(String downUrl) {

        dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        /*final Notification.Builder builder = new Notification.Builder(this);
        //这里设置图标
        final Notification notif = builder.build();
        mNotifManager.notify("摆渡人",1231,notif);*/
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(downUrl));
        /**设置下载文件的类型*/
        request.setMimeType("application/vnd.android.package-archive");
        /**设置下载存放的文件夹和文件名字*/
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "baiduren.apk");
        /**设置下载时或者下载完成时，通知栏是否显示*/
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setTitle("摆渡人");

        /**执行下载，并返回任务唯一id*/
        enqueue = dm.enqueue(request);




    }

    private void checkIsAndroidO() {
        if (Build.VERSION.SDK_INT >= 26) {
            boolean b = getPackageManager().canRequestPackageInstalls();
            if (b) {

                install(this);

            }
        } else {

            install(this);
        }
    }


     private void checkStatus() {
         DownloadManager.Query query=new DownloadManager.Query();

         query.setFilterById(enqueue);
         Cursor c = dm.query(query);

         if (c.moveToFirst()) {
             int status = c.getInt(c.getColumnIndex(DownloadManager.COLUMN_STATUS));

             switch (status) {
                 //下载暂停
                 case DownloadManager.STATUS_PAUSED:
                     break;
                 //下载延迟
                 case DownloadManager.STATUS_PENDING:
                     break;

                 case DownloadManager.STATUS_RUNNING:
                     break;
                 //下载完成
                 case DownloadManager.STATUS_SUCCESSFUL:


                     checkIsAndroidO();

                     break;
                 case DownloadManager.STATUS_FAILED:
                     Toast.makeText(this, "下载失败", Toast.LENGTH_SHORT).show();
                     break;
             }
             c.close();

         }
     }


    public static void install(Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "摆渡人.apk");
        if (!file.exists()) {
            return;
        }
        Uri downloadUri = null;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            downloadUri = Uri.fromFile(file);
        } else {
            Intent installApkIntent = new Intent();
            installApkIntent.setAction(Intent.ACTION_VIEW);
            installApkIntent.addCategory(Intent.CATEGORY_DEFAULT);
            installApkIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            installApkIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            downloadUri = FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".myFileProvider", file);
        }
        intent.setDataAndType(downloadUri, "application/vnd.android.package-archive");
        context.startActivity(intent);

    }

    @Override
    public void onDestroy() {
        unregisterReceiver(receiver);
        super.onDestroy();
    }


}
