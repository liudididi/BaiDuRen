package bean;

/**
 * Created by 祝文 on 2018/2/1.
 */

public class StudyBean2 {
    private String url;
    private String title;
    private String body;

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public StudyBean2(String url, String title, String body) {
        this.url = url;
        this.title = title;
        this.body = body;
    }
}
