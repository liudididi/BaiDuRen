package bean;

/**
 * Created by 祝文 on 2018/1/30.
 */

public class RanKingSchoolBean2 {
    private String name;
    private String address;
    private String typeRank;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTypeRank() {
        return typeRank;
    }

    public RanKingSchoolBean2(String name, String address, String typeRank) {
        this.name = name;
        this.address = address;
        this.typeRank = typeRank;
    }
}
