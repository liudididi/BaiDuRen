package bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 地地 on 2018/3/12.
 * 邮箱：461211527@qq.com.
 */

public class WeiXinBean {


    /**
     * appId : wx6a6810597dadc392
     * nonceStr : 1554591700
     * package : Sign=WXPay
     * partnerId : 1496598622
     * prepayId : wx20180312155458207208
     * sign : AB71D9B28331A27F848D7CCD78996E08
     * timeStamp : 1520841302
     */

    private String appId;
    private String nonceStr;
    @SerializedName("package")
    private String packageX;
    private String partnerId;
    private String prepayId;
    private String sign;
    private String timeStamp;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getPackageX() {
        return packageX;
    }

    public void setPackageX(String packageX) {
        this.packageX = packageX;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
