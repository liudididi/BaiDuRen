package base;

/**
 * Created by 地地 on 2017/11/12.
 * 邮箱：461211527@qq.com.
 */

public class Basepresent<V> {
    private  V view;
    public Basepresent(V view) {
        this.view=view;
    }
    /**
     * View层解耦
     */
    public  void  onDeach(){
      view=null;
    }
}
