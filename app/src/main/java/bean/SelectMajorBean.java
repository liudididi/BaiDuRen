package bean;

import java.util.List;

/**
 * Created by 地地 on 2018/1/30.
 * 邮箱：461211527@qq.com.
 */

public class SelectMajorBean {


    /**
     * child : [{"child":[{"child":null,"collectionTime":null,"majorId":"010101","majorName":"哲学","majorType":0,"introduce":null},{"child":null,"collectionTime":null,"majorId":"010102","majorName":"逻辑学","majorType":0,"introduce":null},{"child":null,"collectionTime":null,"majorId":"010103","majorName":"宗教学","majorType":0,"introduce":null},{"child":null,"collectionTime":null,"majorId":"010104","majorName":"伦理学","majorType":0,"introduce":null}],"collectionTime":null,"majorId":"0101","majorName":"哲学类","majorType":0,"introduce":null}]
     * collectionTime : null
     * majorId : 01
     * majorName : 哲学
     * majorType : 0
     * introduce : null
     */

    private Object collectionTime;
    private String majorId;
    private String majorName;
    private int majorType;
    private Object introduce;
    private List<ChildBeanX> child;

    public Object getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(Object collectionTime) {
        this.collectionTime = collectionTime;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public int getMajorType() {
        return majorType;
    }

    public void setMajorType(int majorType) {
        this.majorType = majorType;
    }

    public Object getIntroduce() {
        return introduce;
    }

    public void setIntroduce(Object introduce) {
        this.introduce = introduce;
    }

    public List<ChildBeanX> getChild() {
        return child;
    }

    public void setChild(List<ChildBeanX> child) {
        this.child = child;
    }

    public static class ChildBeanX {
        /**
         * child : [{"child":null,"collectionTime":null,"majorId":"010101","majorName":"哲学","majorType":0,"introduce":null},{"child":null,"collectionTime":null,"majorId":"010102","majorName":"逻辑学","majorType":0,"introduce":null},{"child":null,"collectionTime":null,"majorId":"010103","majorName":"宗教学","majorType":0,"introduce":null},{"child":null,"collectionTime":null,"majorId":"010104","majorName":"伦理学","majorType":0,"introduce":null}]
         * collectionTime : null
         * majorId : 0101
         * majorName : 哲学类
         * majorType : 0
         * introduce : null
         */

        private Object collectionTime;
        private String majorId;
        private String majorName;
        private int majorType;
        private Object introduce;
        private List<ChildBean> child;

        public Object getCollectionTime() {
            return collectionTime;
        }

        public void setCollectionTime(Object collectionTime) {
            this.collectionTime = collectionTime;
        }

        public String getMajorId() {
            return majorId;
        }

        public void setMajorId(String majorId) {
            this.majorId = majorId;
        }

        public String getMajorName() {
            return majorName;
        }

        public void setMajorName(String majorName) {
            this.majorName = majorName;
        }

        public int getMajorType() {
            return majorType;
        }

        public void setMajorType(int majorType) {
            this.majorType = majorType;
        }

        public Object getIntroduce() {
            return introduce;
        }

        public void setIntroduce(Object introduce) {
            this.introduce = introduce;
        }

        public List<ChildBean> getChild() {
            return child;
        }

        public void setChild(List<ChildBean> child) {
            this.child = child;
        }

        public static class ChildBean {
            /**
             * child : null
             * collectionTime : null
             * majorId : 010101
             * majorName : 哲学
             * majorType : 0
             * introduce : null
             */

            private Object child;
            private Object collectionTime;
            private String majorId;
            private String majorName;
            private int majorType;
            private Object introduce;

            public Object getChild() {
                return child;
            }

            public void setChild(Object child) {
                this.child = child;
            }

            public Object getCollectionTime() {
                return collectionTime;
            }

            public void setCollectionTime(Object collectionTime) {
                this.collectionTime = collectionTime;
            }

            public String getMajorId() {
                return majorId;
            }

            public void setMajorId(String majorId) {
                this.majorId = majorId;
            }

            public String getMajorName() {
                return majorName;
            }

            public void setMajorName(String majorName) {
                this.majorName = majorName;
            }

            public int getMajorType() {
                return majorType;
            }

            public void setMajorType(int majorType) {
                this.majorType = majorType;
            }

            public Object getIntroduce() {
                return introduce;
            }

            public void setIntroduce(Object introduce) {
                this.introduce = introduce;
            }
        }
    }
}
