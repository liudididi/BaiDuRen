package view;

/**
 * Created by 地地 on 2018/1/19.
 * 邮箱：461211527@qq.com.
 */

public interface ChangePhoneView {
    void  getCaptChaSuccess(String msg);
    void  getCaptChafail(String msg);

    void   oldPhonesuccess(String msg);
    void   oldPhonefail(String msg);

    void   newPhonesuccess(String msg);
    void   newPhonefail(String msg);


}
