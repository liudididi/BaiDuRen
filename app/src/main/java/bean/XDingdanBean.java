package bean;

/**
 * Created by 地地 on 2018/3/10.
 * 邮箱：461211527@qq.com.
 */

public class XDingdanBean {


    /**
     * productId : 1538786
     * createTime : 2018-03-10 16:26:06
     * price : 0.01
     * outTradeNo : 2018031016260614933445
     * payway : 3
     * payState : 0
     * attach : null
     * useType : 0
     * paytype : 1
     */

    private String productId;
    private String createTime;
    private double price;
    private String outTradeNo;
    private int payway;
    private int payState;
    private Object attach;
    private int useType;
    private int paytype;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public int getPayway() {
        return payway;
    }

    public void setPayway(int payway) {
        this.payway = payway;
    }

    public int getPayState() {
        return payState;
    }

    public void setPayState(int payState) {
        this.payState = payState;
    }

    public Object getAttach() {
        return attach;
    }

    public void setAttach(Object attach) {
        this.attach = attach;
    }

    public int getUseType() {
        return useType;
    }

    public void setUseType(int useType) {
        this.useType = useType;
    }

    public int getPaytype() {
        return paytype;
    }

    public void setPaytype(int paytype) {
        this.paytype = paytype;
    }
}
