package bean;


public class ProductUnit {

  private long unitId;
  private String name;
  private java.sql.Timestamp createDate;
  private long uSerId;
  private String remark;


  public long getUnitId() {
    return unitId;
  }

  public void setUnitId(long unitId) {
    this.unitId = unitId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public java.sql.Timestamp getCreateDate() {
    return createDate;
  }

  public void setCreateDate(java.sql.Timestamp createDate) {
    this.createDate = createDate;
  }


  public long getUSerId() {
    return uSerId;
  }

  public void setUSerId(long uSerId) {
    this.uSerId = uSerId;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

}
