package cn.bdqn.entity;


public class Koffice {

  private long id;
  private String kName;
  private String resume;
  private long medicalId;
  private long isEmphasis;
  private long status;
  private String remark;
  private String medicalName;

  public String getkName() {
    return kName;
  }

  public void setkName(String kName) {
    this.kName = kName;
  }

  public String getMedicalName() {
    return medicalName;
  }

  public void setMedicalName(String medicalName) {
    this.medicalName = medicalName;
  }

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


  public long getMedicalId() {
    return medicalId;
  }

  public void setMedicalId(long medicalId) {
    this.medicalId = medicalId;
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
