package bean;

/**
 * Created by 祝文 on 2018/2/23.
 */

public class HelpBean {

    /**
     * id : 11
     * type : null
     * pid : null
     * book : 2.1基础使用
     * standby : null
     */

    private int id;
    private Object type;
    private Object pid;
    private String book;
    private String standby;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public Object getPid() {
        return pid;
    }

    public void setPid(Object pid) {
        this.pid = pid;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getStandby() {
        return standby;
    }

    public void setStandby(String standby) {
        this.standby = standby;
    }
}
