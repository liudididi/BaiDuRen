package bean;

import java.util.List;

/**
 * Created by 祝文 on 2018/1/30.
 */

public class RanKingSchoolBean {

    /**
     * totalCount : 2854
     * pageSize : 1
     * totalPage : 2854
     * currPage : 1
     * list : [{"name":"北京大学","ranking":"全国1","typeRank":"综合1","address":"北京市","father":"教育部","univType":null,"url":null,"info":null}]
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
         * univType : null
         * url : null
         * info : null
         */

        private String name;
        private String ranking;
        private String typeRank;
        private String address;
        private String father;
        private Object univType;
        private Object url;
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

        public Object getUnivType() {
            return univType;
        }

        public void setUnivType(Object univType) {
            this.univType = univType;
        }

        public Object getUrl() {
            return url;
        }

        public void setUrl(Object url) {
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
