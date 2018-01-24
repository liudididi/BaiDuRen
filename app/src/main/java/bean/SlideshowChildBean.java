package bean;

/**
 * Created by 祝文 on 2018/1/21.
 */

public class SlideshowChildBean {
    public String name;
    public Object extimg;
    public String url;

    @Override
    public String toString() {
        return "SlideshowChildBean{" +
                "name='" + name + '\'' +
                ", extimg='" + extimg + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExtimg(String extimg) {
        this.extimg = extimg;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public SlideshowChildBean() {
    }

    public String getName() {
        return name;
    }

    public Object getExtimg() {
        return extimg;
    }

    public String getUrl() {
        return url;
    }

    public SlideshowChildBean(String name, String extimg, String url) {
        this.name = name;
        this.extimg = extimg;
        this.url = url;
    }
}
