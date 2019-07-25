package cn.bdqn.entity;


public class Koffice {

  private long id;
  private String kName;
  private String resume;
  private long dId;
  private long isEmphasis;
  private long status;
  private String remark;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getKName() {
    return kName;
  }

  public void setKName(String kName) {
    this.kName = kName;
  }


  public String getResume() {
    return resume;
  }

  public void setResume(String resume) {
    this.resume = resume;
  }


  public long getDId() {
    return dId;
  }

  public void setDId(long dId) {
    this.dId = dId;
  }


  public long getIsEmphasis() {
    return isEmphasis;
  }

  public void setIsEmphasis(long isEmphasis) {
    this.isEmphasis = isEmphasis;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

}
