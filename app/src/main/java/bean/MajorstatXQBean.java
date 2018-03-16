package bean;

import java.util.List;

/**
 * Created by 地地 on 2018/3/7.
 * 邮箱：461211527@qq.com.
 */

public class MajorstatXQBean {

    /**
     * need_address : 上海
     * pro_job : 专业需求量最多的行业是“教育/培训/院校”，占60%
     * direction_employment : 教育/培训/院校、互联网/电子商务、专业服务、学术/科研等；专业就业对口率较高。
     * training_target : 适应新世纪我国社会发展需要，培养基础扎实、知识结构合理，具有现代教育思想和技能，具有一定理论素养、创新精神和实践能力，既能胜任中学综合文科“人文与社会”课程教学需要，又能适应历史、中文、政治分科教学需要，德、智、体、美全面发展的高级应用人才。
     * major : 小学教育专业
     * pro_address : 专业需求量最多的地区是“上海”，占16%
     * rank : 所有专业1110个，教育学类共17个本科专业，在“教育学”中就业排名第3
     * ranking : 第 3 名 (教育学)
     * averagesalary : 7428
     * need_major : 教育/培训/院校
     * major_id : 040107
     * jobinfo : [{"jobname":"小学数学教师"},{"jobname":"学习管理师"},{"jobname":"初中数学教师"},{"jobname":"小学语文教师"},{"jobname":"教育咨询师"},{"jobname":"初中英语教师"},{"jobname":"小学英语教师"},{"jobname":"小学数学老师"},{"jobname":"小学英语老师"},{"jobname":"小学语文老师"},{"jobname":"课程顾问"}]
     */

    private String need_address;
    private String pro_job;
    private String direction_employment;
    private String training_target;
    private String major;
    private String pro_address;
    private String rank;
    private String ranking;
    private int averagesalary;
    private String need_major;
    private String major_id;
    private List<JobinfoBean> jobinfo;

    public String getNeed_address() {
        return need_address;
    }

    public void setNeed_address(String need_address) {
        this.need_address = need_address;
    }

    public String getPro_job() {
        return pro_job;
    }

    public void setPro_job(String pro_job) {
        this.pro_job = pro_job;
    }

    public String getDirection_employment() {
        return direction_employment;
    }

    public void setDirection_employment(String direction_employment) {
        this.direction_employment = direction_employment;
    }

    public String getTraining_target() {
        return training_target;
    }

    public void setTraining_target(String training_target) {
        this.training_target = training_target;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPro_address() {
        return pro_address;
    }

    public void setPro_address(String pro_address) {
        this.pro_address = pro_address;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public int getAveragesalary() {
        return averagesalary;
    }

    public void setAveragesalary(int averagesalary) {
        this.averagesalary = averagesalary;
    }

    public String getNeed_major() {
        return need_major;
    }

    public void setNeed_major(String need_major) {
        this.need_major = need_major;
    }

    public String getMajor_id() {
        return major_id;
    }

    public void setMajor_id(String major_id) {
        this.major_id = major_id;
    }

    public List<JobinfoBean> getJobinfo() {
        return jobinfo;
    }

    public void setJobinfo(List<JobinfoBean> jobinfo) {
        this.jobinfo = jobinfo;
    }

    public static class JobinfoBean {
        /**
         * jobname : 小学数学教师
         */

        private String jobname;

        public String getJobname() {
            return jobname;
        }

        public void setJobname(String jobname) {
            this.jobname = jobname;
        }
    }
}
