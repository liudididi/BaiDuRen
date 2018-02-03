package bean;

import java.util.List;

/**
 * Created by 祝文 on 2018/2/2.
 */

public class ScoreBean2 {

    /**
     * university : 北京大学
     * province : 北京市
     * classify : 文科
     * year : null
     * time : 提前批次
     * scoreAvg : null
     * scoreProvince : null
     * scoreDiffient : null
     * scores : [{"university":null,"province":null,"classify":null,"year":"2016","time":null,"scoreAvg":"674","scoreProvince":null,"scoreDiffient":null,"scores":null}]
     */

    private String university;
    private String province;
    private String classify;
    private Object year;
    private String time;
    private Object scoreAvg;
    private Object scoreProvince;
    private Object scoreDiffient;
    private List<ScoresBean> scores;

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public Object getYear() {
        return year;
    }

    public void setYear(Object year) {
        this.year = year;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Object getScoreAvg() {
        return scoreAvg;
    }

    public void setScoreAvg(Object scoreAvg) {
        this.scoreAvg = scoreAvg;
    }

    public Object getScoreProvince() {
        return scoreProvince;
    }

    public void setScoreProvince(Object scoreProvince) {
        this.scoreProvince = scoreProvince;
    }

    public Object getScoreDiffient() {
        return scoreDiffient;
    }

    public void setScoreDiffient(Object scoreDiffient) {
        this.scoreDiffient = scoreDiffient;
    }

    public List<ScoresBean> getScores() {
        return scores;
    }

    public void setScores(List<ScoresBean> scores) {
        this.scores = scores;
    }

    public static class ScoresBean {
        /**
         * university : null
         * province : null
         * classify : null
         * year : 2016
         * time : null
         * scoreAvg : 674
         * scoreProvince : null
         * scoreDiffient : null
         * scores : null
         */

        private Object university;
        private Object province;
        private Object classify;
        private String year;
        private Object time;
        private String scoreAvg;
        private Object scoreProvince;
        private Object scoreDiffient;
        private Object scores;

        public Object getUniversity() {
            return university;
        }

        public void setUniversity(Object university) {
            this.university = university;
        }

        public Object getProvince() {
            return province;
        }

        public void setProvince(Object province) {
            this.province = province;
        }

        public Object getClassify() {
            return classify;
        }

        public void setClassify(Object classify) {
            this.classify = classify;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public Object getTime() {
            return time;
        }

        public void setTime(Object time) {
            this.time = time;
        }

        public String getScoreAvg() {
            return scoreAvg;
        }

        public void setScoreAvg(String scoreAvg) {
            this.scoreAvg = scoreAvg;
        }

        public Object getScoreProvince() {
            return scoreProvince;
        }

        public void setScoreProvince(Object scoreProvince) {
            this.scoreProvince = scoreProvince;
        }

        public Object getScoreDiffient() {
            return scoreDiffient;
        }

        public void setScoreDiffient(Object scoreDiffient) {
            this.scoreDiffient = scoreDiffient;
        }

        public Object getScores() {
            return scores;
        }

        public void setScores(Object scores) {
            this.scores = scores;
        }
    }
}
