package bean;

/**
 * Created by 祝文 on 2018/1/22.
 */

public class HotTopBean {
    public String img;
    public String tv_title;

    public  int newsId;

    public HotTopBean(String img, String tv_title,int newsId) {
        this.img = img;
        this.tv_title = tv_title;
        this.newsId=newsId;
    }
}
