package bean;

import java.util.List;

/**
 * Created by 祝文 on 2018/1/27.
 */

public class CanSchoolBean {

    /**
     * totalCount : 49
     * pageSize : 5
     * totalPage : 10
     * currPage : 1
     * list : [{
     * "name":"北京大学",
     * "ranking":"全国1",
     * "typeRank":"综合1",
     * "address":"北京市",
     * "father":"教育部",
     * "univType":"大学",
     * "url":"/images/school/201202161100413470.jpg",
     * "info":null
     * }
     * ,{"name":"清华大学","ranking":"全国2","
     * typeRank":"理工1",
     * "address":"北京市","father":"教育部",
     * "univType":"大学","url":"/images/school/201201090552434112.jpg",
     * "info":null},{"name":"中国人民大学","ranking":"全国8","typeRank":"综合7",
     * "address":"北京市","father":"教育部","univType":"大学",
     * "url":"/images/school/201202020436067980.jpg","info":null
     * },
     * {"name":"北京师范大学","ranking":"全国19","typeRank":"师范1","address":"北京市","father":"教育部","univType":"大学","url":"/images/school/201201300512159411.jpg","info":null},{"name":"北京航空航天大学","ranking":"全国23","typeRank":"理工6","address":"北京市","father":"工业和信息化部","univType":"大学","url":"/images/school/201201180153041855.jpg","info":null}]
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
         * name : 北京大学
         * ranking : 全国1
         * typeRank : 综合1
         * address : 北京市
         * father : 教育部
         * univType : 大学
         * url : /images/school/201202161100413470.jpg
         * info : null
         */

        private String name;
        private String ranking;
        private String typeRank;
        private String address;
        private String father;
        private String univType;
        private String url;
        private Object info;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRanking() {
            return ranking;
        }

        public void setRanking(String ranking) {
            this.ranking = ranking;
        }

        public String getTypeRank() {
            return typeRank;
        }

        public void setTypeRank(String typeRank) {
            this.typeRank = typeRank;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getFather() {
            return father;
        }

        public void setFather(String father) {
            this.father = father;
        }

        public String getUnivType() {
            return univType;
        }

        public void setUnivType(String univType) {
            this.univType = univType;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Object getInfo() {
            return info;
        }

        public void setInfo(Object info) {
            this.info = info;
        }
    }
}
