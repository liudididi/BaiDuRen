package bean;

/**
 * Created by 地地 on 2017/12/14.
 * 邮箱：461211527@qq.com.
 */

public class VisionBean {

  /**
   * id : 2
   * versionType : PC
   * versionCode : 3
   * versionName : 版本名
   * versionIntroduce : 版本介绍
   * content : 更新内容
   * downloadPath : 下载路径
   * standby1 : null
   * standby2 : null
   * standby3 : null
   */

  private int id;
  private String versionType;
  private int versionCode;
  private String versionName;
  private String versionIntroduce;
  private String content;
  private String downloadPath;
  private Object standby1;
  private Object standby2;
  private Object standby3;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getVersionType() {
    return versionType;
  }

  public void setVersionType(String versionType) {
    this.versionType = versionType;
  }

  public int getVersionCode() {
    return versionCode;
  }

  public void setVersionCode(int versionCode) {
    this.versionCode = versionCode;
  }

  public String getVersionName() {
    return versionName;
  }

  public void setVersionName(String versionName) {
    this.versionName = versionName;
  }

  public String getVersionIntroduce() {
    return versionIntroduce;
  }

  public void setVersionIntroduce(String versionIntroduce) {
    this.versionIntroduce = versionIntroduce;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getDownloadPath() {
    return downloadPath;
  }

  public void setDownloadPath(String downloadPath) {
    this.downloadPath = downloadPath;
  }

  public Object getStandby1() {
    return standby1;
  }

  public void setStandby1(Object standby1) {
    this.standby1 = standby1;
  }

  public Object getStandby2() {
    return standby2;
  }

  public void setStandby2(Object standby2) {
    this.standby2 = standby2;
  }

  public Object getStandby3() {
    return standby3;
  }

  public void setStandby3(Object standby3) {
    this.standby3 = standby3;
  }
}
