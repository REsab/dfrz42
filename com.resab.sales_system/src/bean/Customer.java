package bean;


public class Customer {

  private long customerId;
  private String name;
  private String address;
  private String phone;
  private String fax;
  private String postalCode;
  private String constactPerson;


  public long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(long customerId) {
    this.customerId = customerId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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


  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }


  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }


  public String getConstactPerson() {
    return constactPerson;
  }

  public void setConstactPerson(String constactPerson) {
    this.constactPerson = constactPerson;
  }

}
