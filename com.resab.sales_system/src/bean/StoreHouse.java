package bean;


public class StoreHouse {

  private long storeHouseId;
  private String address;
  private String phone;
  private long userId;
  private java.sql.Timestamp createDate;


  public long getStoreHouseId() {
    return storeHouseId;
  }

  public void setStoreHouseId(long storeHouseId) {
    this.storeHouseId = storeHouseId;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public java.sql.Timestamp getCreateDate() {
    return createDate;
  }

  public void setCreateDate(java.sql.Timestamp createDate) {
    this.createDate = createDate;
  }

}
