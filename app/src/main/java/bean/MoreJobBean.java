package bean;

import java.util.List;

/**
 * Created by 地地 on 2018/2/1.
 * 邮箱：461211527@qq.com.
 */

public class MoreJobBean {


    /**
     * classifyoneName : 电气/电力
     * id_one : 1
     * jobListTwo : [{"id_two":1,"jobListThree":[{"job":"电气工程师"},{"job":"电器工程师"},{"job":"变压器与磁电工程师"},{"job":"核电·火电工程师"},{"job":"电力工程师"},{"job":"电气维修技术员"},{"job":"调试工程师"}],"classifytwoName":"电气/电力","id_one":1}]
     */

    private String classifyoneName;
    private int id_one;
    private List<JobListTwoBean> jobListTwo;

    public String getClassifyoneName() {
        return classifyoneName;
    }

    public void setClassifyoneName(String classifyoneName) {
        this.classifyoneName = classifyoneName;
    }

    public int getId_one() {
        return id_one;
    }

    public void setId_one(int id_one) {
        this.id_one = id_one;
    }

    public List<JobListTwoBean> getJobListTwo() {
        return jobListTwo;
    }

    public void setJobListTwo(List<JobListTwoBean> jobListTwo) {
        this.jobListTwo = jobListTwo;
    }

    public static class JobListTwoBean {
        /**
         * id_two : 1
         * jobListThree : [{"job":"电气工程师"},{"job":"电器工程师"},{"job":"变压器与磁电工程师"},{"job":"核电·火电工程师"},{"job":"电力工程师"},{"job":"电气维修技术员"},{"job":"调试工程师"}]
         * classifytwoName : 电气/电力
         * id_one : 1
         */

        private int id_two;
        private String classifytwoName;
        private int id_one;
        private List<JobListThreeBean> jobListThree;

        public int getId_two() {
            return id_two;
        }

        public void setId_two(int id_two) {
            this.id_two = id_two;
        }

        public String getClassifytwoName() {
            return classifytwoName;
        }

        public void setClassifytwoName(String classifytwoName) {
            this.classifytwoName = classifytwoName;
        }

        public int getId_one() {
            return id_one;
        }

        public void setId_one(int id_one) {
            this.id_one = id_one;
        }

        public List<JobListThreeBean> getJobListThree() {
            return jobListThree;
        }

        public void setJobListThree(List<JobListThreeBean> jobListThree) {
            this.jobListThree = jobListThree;
        }

        public static class JobListThreeBean {
            /**
             * job : 电气工程师
             */

            private String job;

            public String getJob() {
                return job;
            }

            public void setJob(String job) {
                this.job = job;
            }
        }
    }
}
