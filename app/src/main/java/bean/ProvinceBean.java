package bean;

import java.util.List;

/**
 * Created by 祝文 on 2018/1/31.
 */

public class ProvinceBean {


    /**
     * province : 北京市
     * year : null
     * classify : 文科
     * time : 专科一批
     * score : null
     * scores : [{"province":null,"year":"2016","classify":null,"time":null,"score":"150","scores":null},{"province":null,"year":"2015","classify":null,"time":null,"score":"150","scores":null}]
     */

    private String province;
    private Object year;
    private String classify;
    private String time;
    private Object score;
    private List<ScoresBean> scores;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Object getYear() {
        return year;
    }

    public void setYear(Object year) {
        this.year = year;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Object getScore() {
        return score;
    }

    public void setScore(Object score) {
        this.score = score;
    }

    public List<ScoresBean> getScores() {
        return scores;
    }

    public void setScores(List<ScoresBean> scores) {
        this.scores = scores;
    }

    public static class ScoresBean {
        /**
         * province : null
         * year : 2016
         * classify : null
         * time : null
         * score : 150
         * scores : null
         */

        private Object province;
        private String year;
        private Object classify;
        private Object time;
        private String score;
        private Object scores;

        public Object getProvince() {
            return province;
        }

        public void setProvince(Object province) {
            this.province = province;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public Object getClassify() {
            return classify;
        }

        public void setClassify(Object classify) {
            this.classify = classify;
        }

        public Object getTime() {
            return time;
        }

        public void setTime(Object time) {
            this.time = time;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public Object getScores() {
            return scores;
        }

        public void setScores(Object scores) {
            this.scores = scores;
        }
    }
}
