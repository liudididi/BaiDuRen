package bean;

/**
 * Created by 祝文 on 2018/2/23.
 */

public class ForecastBean {

    /**
     * university : null
     * province : null
     * classify : null
     * year : 2015
     * time : 本科一批
     * scoreAvg : 624
     * scoreProvince : null
     * scoreDiffient : null
     * scores : null
     */

    private Object university;
    private Object province;
    private Object classify;
    private String year;
    private String time;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
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
