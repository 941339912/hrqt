package cn.bdqn.entity;
import java.sql.Date;

public class Doctor {
  private long id;
  private String dName;
  private java.sql.Date birthDate;
  private java.sql.Date cyDate;
  private String eAddress;
  private String hPostion;
  private String nPostion;
  private String edcuation;
  private String graduate;
  private String hospital;
  private String resume;
  private long kId;
  private long isExpert;
  private String achievement;
  private String photopath;
  private long status;
  private String remark;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getDName() {
    return dName;
  }

  public void setDName(String dName) {
    this.dName = dName;
  }


  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(java.sql.Date birthDate) {
    this.birthDate = birthDate;
  }


  public java.sql.Date getCyDate() {
    return cyDate;
  }

  public void setCyDate(java.sql.Date cyDate) {
    this.cyDate = cyDate;
  }


  public String getEAddress() {
    return eAddress;
  }

  public void setEAddress(String eAddress) {
    this.eAddress = eAddress;
  }


  public String getHPostion() {
    return hPostion;
  }

  public void setHPostion(String hPostion) {
    this.hPostion = hPostion;
  }


  public String getNPostion() {
    return nPostion;
  }

  public void setNPostion(String nPostion) {
    this.nPostion = nPostion;
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


  public String getHospital() {
    return hospital;
  }

  public void setHospital(String hospital) {
    this.hospital = hospital;
  }


  public String getResume() {
    return resume;
  }

  public void setResume(String resume) {
    this.resume = resume;
  }


  public long getKId() {
    return kId;
  }

  public void setKId(long kId) {
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

}
