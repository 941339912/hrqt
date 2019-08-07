package cn.bdqn.entity;


public class News {

  private long id;
  private String title;
  private String content;
  private String createDate;
  private String createRen;
  private String photoPath;
  private long isNewGongGao;
  private long readNum;
  private long status;
  private String remark;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public String getCreateDate() {
    return createDate;
  }

  public void setCreateDate(String createDate) {
    this.createDate = createDate;
  }


  public String getCreateRen() {
    return createRen;
  }

  public void setCreateRen(String createRen) {
    this.createRen = createRen;
  }


  public String getPhotoPath() {
    return photoPath;
  }

  public void setPhotoPath(String photoPath) {
    this.photoPath = photoPath;
  }


  public long getIsNewGongGao() {
    return isNewGongGao;
  }

  public void setIsNewGongGao(long isNewGongGao) {
    this.isNewGongGao = isNewGongGao;
  }


  public long getReadNum() {
    return readNum;
  }

  public void setReadNum(long readNum) {
    this.readNum = readNum;
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
