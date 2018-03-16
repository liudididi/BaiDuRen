package bean;

import java.util.List;

/**
 * Created by 地地 on 2018/3/12.
 * 邮箱：461211527@qq.com.
 */

public class jobStarBean {


    /**
     * major : 小学教育
     * g : 0.7720000010728836
     * majorinfo : [{"training_target":"适应新世纪我国社会发展需要，培养基础扎实、知识结构合理，具有现代教育思想和技能，具有一定理论素养、创新精神和实践能力，既能胜任中学综合文科\u201c人文与社会\u201d课程教学需要，又能适应历史、中文、政治分科教学需要，德、智、体、美全面发展的高级应用人才。","year":3,"averagesalary":"5314"}]
     * gai : 0.4571428596973419
     * major_id : 040107
     */

    private String major;
    private double g;
    private double gai;
    private String major_id;
    public  boolean xh;
    private List<MajorinfoBean> majorinfo;

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }

    public double getGai() {
        return gai;
    }

    public void setGai(double gai) {
        this.gai = gai;
    }

    public String getMajor_id() {
        return major_id;
    }

    public void setMajor_id(String major_id) {
        this.major_id = major_id;
    }

    public List<MajorinfoBean> getMajorinfo() {
        return majorinfo;
    }

    public void setMajorinfo(List<MajorinfoBean> majorinfo) {
        this.majorinfo = majorinfo;
    }

    public static class MajorinfoBean {
        /**
         * training_target : 适应新世纪我国社会发展需要，培养基础扎实、知识结构合理，具有现代教育思想和技能，具有一定理论素养、创新精神和实践能力，既能胜任中学综合文科“人文与社会”课程教学需要，又能适应历史、中文、政治分科教学需要，德、智、体、美全面发展的高级应用人才。
         * year : 3
         * averagesalary : 5314
         */

        private String training_target;
        private int year;
        private String averagesalary;

        public String getTraining_target() {
            return training_target;
        }

        public void setTraining_target(String training_target) {
            this.training_target = training_target;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public String getAveragesalary() {
            return averagesalary;
        }

        public void setAveragesalary(String averagesalary) {
            this.averagesalary = averagesalary;
        }
    }
}
