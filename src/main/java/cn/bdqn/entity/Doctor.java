package cn.bdqn.entity;


import java.sql.Date;

public class Doctor {

  private long id;
  private String dName;
  private String dPinyin;
  private java.sql.Date birthDate;
  private java.sql.Date cyDate;
  private String eAddress;
  private String postion;
  private String edcuation;
  private String graduate;
  private String resume;

  public String getsAddress() {
    return sAddress;
  }

  public void setsAddress(String sAddress) {
    this.sAddress = sAddress;
  }

  private long kId;
  private long isExpert;
  private String achievement;
  private String photopath;
  private long status;
  private String remark;
  private String kName;
  private String sAddress;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getdName() {
    return dName;
  }

  public void setdName(String dName) {
    this.dName = dName;
  }

  public String getdPinyin() {
    return dPinyin;
  }

  public void setdPinyin(String dPinyin) {
    this.dPinyin = dPinyin;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public Date getCyDate() {
    return cyDate;
  }

  public void setCyDate(Date cyDate) {
    this.cyDate = cyDate;
  }

  public String geteAddress() {
    return eAddress;
  }

  public void seteAddress(String eAddress) {
    this.eAddress = eAddress;
  }

  public String getPostion() {
    return postion;
  }

  public void setPostion(String postion) {
    this.postion = postion;
  }

  public String getEdcuation() {
    return edcuation;
  }

  public void setEdcuation(String edcuation) {
    this.edcuation = edcuation;
  }

  public String getGraduate() {
    return graduate;
  }

  public void setGraduate(String graduate) {
    this.graduate = graduate;
  }

  public String getResume() {
    return resume;
  }

  public void setResume(String resume) {
    this.resume = resume;
  }

  public long getkId() {
    return kId;
  }

  public void setkId(long kId) {
    this.kId = kId;
  }

  public long getIsExpert() {
    return isExpert;
  }

  public void setIsExpert(long isExpert) {
    this.isExpert = isExpert;
  }

  public String getAchievement() {
    return achievement;
  }

  public void setAchievement(String achievement) {
    this.achievement = achievement;
  }

  public String getPhotopath() {
    return photopath;
  }

  public void setPhotopath(String photopath) {
    this.photopath = photopath;
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

  public String getkName() {
    return kName;
  }

  public void setkName(String kName) {
    this.kName = kName;
  }
}
