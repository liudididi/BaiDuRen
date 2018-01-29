package bean;

/**
 * Created by 祝文 on 2018/1/28.
 */

public class CanSchoolBean3 {
    private String imgurl;
    private String name;
    private String address;
    private String father;
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

    public String getFather() {
        return father;
    }

    public String getTypeRank() {
        return typeRank;
    }

    public CanSchoolBean3(String imgurl, String name, String address, String father, String typeRank) {
        this.imgurl = imgurl;
        this.name = name;
        this.address = address;
        this.father = father;
        this.typeRank = typeRank;
    }
}
