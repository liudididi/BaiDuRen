package bean;

/**
 * Created by 祝文 on 2018/2/5.
 */

public class SchoolEnrollBean {


    /**
     * name : 北京大学
     * type : 文科
     * province : 北京
     * majorName : 文科试验班类(元培学院)
     * planType : 非定向
     * arrangement : 本科
     * classification : 文史
     * number : 5
     * year : 2017
     */

    private String name;
    private String type;
    private String province;
    private String majorName;
    private String planType;
    private String arrangement;
    private String classification;
    private int number;
    private int year;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public String getArrangement() {
        return arrangement;
    }

    public void setArrangement(String arrangement) {
        this.arrangement = arrangement;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
