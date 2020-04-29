package bean;


public class StockPile {

  private long stockPileId;
  private long storeHOuseId;
  private long productId;
  private java.sql.Timestamp firstEnterDate;
  private java.sql.Timestamp lastLeaveDate;
  private long quantity;
  private double price;


  public long getStockPileId() {
    return stockPileId;
  }

  public void setStockPileId(long stockPileId) {
    this.stockPileId = stockPileId;
  }


  public long getStoreHOuseId() {
    return storeHOuseId;
  }

  public void setStoreHOuseId(long storeHOuseId) {
    this.storeHOuseId = storeHOuseId;
  }


  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }


  public java.sql.Timestamp getFirstEnterDate() {
    return firstEnterDate;
  }

  public void setFirstEnterDate(java.sql.Timestamp firstEnterDate) {
    this.firstEnterDate = firstEnterDate;
  }


  public java.sql.Timestamp getLastLeaveDate() {
    return lastLeaveDate;
  }

  public void setLastLeaveDate(java.sql.Timestamp lastLeaveDate) {
    this.lastLeaveDate = lastLeaveDate;
  }


  public long getQuantity() {
    return quantity;
  }

  public void setQuantity(long quantity) {
    this.quantity = quantity;
  }


  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

}
