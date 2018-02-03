package bean;

import java.util.List;

/**
 * Created by 祝文 on 2018/2/1.
 */

public class StudyBean {

    /**
     * totalCount : 10
     * pageSize : 1
     * totalPage : 10
     * currPage : 1
     * list : [{"date":"2018-01-12 12:12:12","year":"2017","subject":"语文","stutype":"","title":"北京海淀区高一级第一学期语文期末练习","body":"/download/xtzl/2017/北京海淀区高一年级第一学期语文期末练习.rar","version":"北京","picture":[{"extimg":"/images/project/语文.png","extval":"/images/project/语文点击.png","url":"/images/project/语文2.png"}],"province":"北京","school":"","grade":"高一","ID":31,"category":"习题资料"}]
     */

    private int totalCount;
    private int pageSize;
    private int totalPage;
    private int currPage;
    private List<ListBean> list;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * date : 2018-01-12 12:12:12
         * year : 2017
         * subject : 语文
         * stutype :
         * title : 北京海淀区高一级第一学期语文期末练习
         * body : /download/xtzl/2017/北京海淀区高一年级第一学期语文期末练习.rar
         * version : 北京
         * picture : [{"extimg":"/images/project/语文.png","extval":"/images/project/语文点击.png","url":"/images/project/语文2.png"}]
         * province : 北京
         * school :
         * grade : 高一
         * ID : 31
         * category : 习题资料
         */

        private String date;
        private String year;
        private String subject;
        private String stutype;
        private String title;
        private String body;
        private String version;
        private String province;
        private String school;
        private String grade;
        private int ID;
        private String category;
        private List<PictureBean> picture;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getStutype() {
            return stutype;
        }

        public void setStutype(String stutype) {
            this.stutype = stutype;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getSchool() {
            return school;
        }

        public void setSchool(String school) {
            this.school = school;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public List<PictureBean> getPicture() {
            return picture;
        }

        public void setPicture(List<PictureBean> picture) {
            this.picture = picture;
        }

        public static class PictureBean {
            /**
             * extimg : /images/project/语文.png
             * extval : /images/project/语文点击.png
             * url : /images/project/语文2.png
             */

            private String extimg;
            private String extval;
            private String url;

            public String getExtimg() {
                return extimg;
            }

            public void setExtimg(String extimg) {
                this.extimg = extimg;
            }

            public String getExtval() {
                return extval;
            }

            public void setExtval(String extval) {
                this.extval = extval;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
