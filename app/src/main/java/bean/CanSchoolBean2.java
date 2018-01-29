package bean;

/**
 * Created by 祝文 on 2018/1/27.
 */

public class CanSchoolBean2 {
    private String imgurl;
    private String name;
    private String address;
    private String typeRank;

    public String getImgurl() {
        return imgurl;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTypeRank() {
        return typeRank;
    }

    public CanSchoolBean2(String imgurl, String name, String address, String typeRank) {
        this.imgurl = imgurl;
        this.name = name;
        this.address = address;
        this.typeRank = typeRank;
    }
}
