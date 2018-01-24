package bean;

/**
 * Created by 祝文 on 2018/1/20.
 */

public class SlideshowBean {

    /**
     * id : 2
     * boardId : 1
     * type : type1
     * url : /images/board/2.png
     * name : 首页2
     * content : 首页图片2内容
     * extimg : null
     * extval : null
     * description : 首页图片2内容
     * startTime : null
     * endTime : null
     * clicks : null
     * addTime : 2018/1/3 11:11:11
     * ordid : 99
     * status : 0
     */

    private int id;
    private int boardId;
    private String type;
    private String url;
    private String name;
    private String content;
    private Object extimg;
    private Object extval;
    private String description;
    private Object startTime;
    private Object endTime;
    private Object clicks;
    private String addTime;
    private int ordid;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Object getExtimg() {
        return extimg;
    }

    public void setExtimg(Object extimg) {
        this.extimg = extimg;
    }

    public Object getExtval() {
        return extval;
    }

    public void setExtval(Object extval) {
        this.extval = extval;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getStartTime() {
        return startTime;
    }

    public void setStartTime(Object startTime) {
        this.startTime = startTime;
    }

    public Object getEndTime() {
        return endTime;
    }

    public void setEndTime(Object endTime) {
        this.endTime = endTime;
    }

    public Object getClicks() {
        return clicks;
    }

    public void setClicks(Object clicks) {
        this.clicks = clicks;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public int getOrdid() {
        return ordid;
    }

    public void setOrdid(int ordid) {
        this.ordid = ordid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
