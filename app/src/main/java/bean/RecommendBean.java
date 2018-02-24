package bean;

/**
 * Created by 祝文 on 2018/1/22.
 */

public class RecommendBean {
    public String img;
    public String tv_title;
    public int newsId;
    public String time;
    public String count;

    public RecommendBean(String img, String tv_title,int newsId, String time, String count) {
        this.img = img;
        this.tv_title = tv_title;
        this.newsId = newsId;
        this.time = time;
        this.count = count;
    }
}
