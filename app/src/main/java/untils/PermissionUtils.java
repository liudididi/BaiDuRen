package untils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

/**
 * 权限工具
 * Created by yejiurui on 17/3/22.
 */
public class PermissionUtils {
    Activity context;

    // 所有的权限
    final String[] PERMISSIONS = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,

    };

 /*   final String[] PERMISSIONS = new String[]{
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.WRITE_CONTACTS,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION
    };*/


    //权限获取成功响应吗
    public static final int PERMISSIONS_REQUEST_CODE = 200;

//    private static PermissionUtils instance = null;
//
//    public static PermissionUtils getInstance(Activity context) {
//        if (instance == null) {
//            instance = new PermissionUtils(context);
//        }
//        return instance;
//    }

    public PermissionUtils(Activity context) {
        this.context = context;
    }

    public static boolean isAndroidOSM() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }

    /*
    *
    * 申请授予所有权限
    * 回调代码
    * CALL_PHONE  READ_EXTERNAL_STORAGE CAMERA  READ_CONTACTS GET_ACCOUNTS ACCESS_FINE_LOCATION
    * */
    public void requestAllPermissions() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return;
        }
        ActivityCompat.requestPermissions(context,
                PERMISSIONS,
                PERMISSIONS_REQUEST_CODE);

    }

    /**
     * 申请单个权限
     *
     * @param permission
     * @param requestCode 传任意回调值
     * @return
     */
    public boolean requestPermissions(String permission, int requestCode) {
        if (!hasPermission(permission)) {//没有权限
            ActivityCompat.requestPermissions(context,
                    new String[]{permission},
                    requestCode);
            return false;
        } else {
            return true;
        }
    }


    // 判断权限集合
    public boolean hasPermissions(String... permissions) {
        for (int i = 0; i < permissions.length; i++) {
            if (!hasPermission(permissions[i])) {//无权限
                return true;
            }
        }
        return false;
    }

    // 判断单个权限  有权限返回true
    public boolean hasPermission(String permission) {
        return ContextCompat.checkSelfPermission(context, permission) ==
                PackageManager.PERMISSION_GRANTED;
    }

    //常用权限申请

    /**
     * 获取电话权限
     *
     * @return
     */
    public boolean requesCallPhonePermissions(int requestCode) {
        boolean isSuccess = requestPermissions(Manifest.permission.CALL_PHONE, requestCode);
        if (!isSuccess) {
            Toast.makeText(context, "获取电话权限失败，请手动开启权限", Toast.LENGTH_SHORT).show();

        }
        return isSuccess;
    }

    /**
     * 获取手机信息
     *
     * @return
     */
    public boolean requesPhoneStatePermissions(int requestCode) {
        boolean isSuccess = requestPermissions(Manifest.permission.READ_PHONE_STATE, requestCode);
        if (!isSuccess) {
            Toast.makeText(context, "获取电话权限失败，请手动开启权限", Toast.LENGTH_SHORT).show();
        }
        return isSuccess;
    }

    /**
     * 获取sdk权限CO
     *
     * @param requestCode
     * @return
     */
    public boolean requestReadSDCardPermissions(int requestCode) {
        return requestPermissions(Manifest.permission.READ_EXTERNAL_STORAGE, requestCode);
    }

    /**
     * 读取相机权限
     *
     * @param requestCode
     * @return
     */
    public boolean requestCamerPermissions(int requestCode) {
        return requestPermissions(Manifest.permission.CAMERA, requestCode);
    }

    /**
     * 读取联系人权限
     *
     * @param requestCode
     * @return
     */
    public boolean requestReadConstantPermissions(int requestCode) {
        return requestPermissions(Manifest.permission.READ_CONTACTS, requestCode);
    }

    public boolean requestGET_ACCOUNTSPermissions(int requestCode) {
        return requestPermissions(Manifest.permission.GET_ACCOUNTS, requestCode);
    }

    /**
     * 获取位置权限
     *
     * @param requestCode
     * @return
     */
    public boolean requestLocationPermissions(int requestCode) {
        return requestPermissions(Manifest.permission.ACCESS_FINE_LOCATION, requestCode);
    }


    /**
     * 是否有照相机权限
     *
     * @return
     */
    public boolean hasCameraPermission() {
        boolean ishasPermission = hasPermission(Manifest.permission.CAMERA);
        if (Build.VERSION.SDK_INT >= 23 && !ishasPermission) {
            requestPermissions(Manifest.permission.CAMERA, PermissionUtils.PERMISSIONS_REQUEST_CODE);
            return false;
        }
        return true;
    }

    /**
     * 二次认证摄像头是否可以打开
     * @return
     */
    public static boolean checkCameraForcePermission() {
        boolean canUse = true;
        Camera mCamera = null;
        try {
            mCamera = Camera.open(0);
            mCamera.setDisplayOrientation(90);
        } catch (Exception e) {
            canUse = false;
        }
        if (canUse) {
            try {
                mCamera.release();
                mCamera = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return canUse;
    }


}