package bean;

/**
 * Created by 地地 on 2018/1/23.
 * 邮箱：461211527@qq.com.
 */

public class MyUserBean  {
    private static UserBean userBean=null;

    public  static void setUserBean(UserBean nuserBean) {
        userBean = nuserBean;
    }

    public  static  UserBean getUserBeanInstans(){
        if(userBean!=null){
           return userBean;
        }
        return  null;
    }


}
