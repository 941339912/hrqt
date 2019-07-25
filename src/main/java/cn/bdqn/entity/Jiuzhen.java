package cn.bdqn.entity;


public class Jiuzhen {

  private long id;
  private String ybCard;
  private double money;
  private java.sql.Date createDate;
  private String password;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getYbCard() {
    return ybCard;
  }

  public void setYbCard(String ybCard) {
    this.ybCard = ybCard;
  }


  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
  }


  public java.sql.Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(java.sql.Date createDate) {
    this.createDate = createDate;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
