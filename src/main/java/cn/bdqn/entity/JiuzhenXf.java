package cn.bdqn.entity;


public class JiuzhenXf {

  private long id;
  private long jzId;
  private double xfMoney;
  private java.sql.Date xfTime;
  private String remark;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getJzId() {
    return jzId;
  }

  public void setJzId(long jzId) {
    this.jzId = jzId;
  }


  public double getXfMoney() {
    return xfMoney;
  }

  public void setXfMoney(double xfMoney) {
    this.xfMoney = xfMoney;
  }


  public java.sql.Date getXfTime() {
    return xfTime;
  }

  public void setXfTime(java.sql.Date xfTime) {
    this.xfTime = xfTime;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

}
