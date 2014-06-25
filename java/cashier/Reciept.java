
public class Reciept {

  public static class Item {

    private Product product;
    public Product getProduct() {
      return product;
    }

    private int quantity;
    public int getQuantity() {
      return quantity;
    }

    private boolean inStock;
    public boolean isInStock() {
      return inStock;
    }

    public Item(Product product, int quantity, boolean inStock) {
      this.product    = product;
      this.quantity   = quantity;
      this.inStock = inStock;
    }

  }

  public Reciept(
    Item[] items, double subtotal, double payed, double remaining, String note
  ) {
    this.items          = items;
    this.subtotal       = subtotal;
    this.payedMoney     = payed;
    this.remainingMoney = remaining;
    this.note           = note;
  }

  private Item[] items;
  public Item[] getItems() {
    return items;
  }

  private double subtotal;
  public double getSubtotal() {
    return subtotal;
  }

  private double payedMoney;
  public double getPayedMoney() {
    return payedMoney;
  }

  private double remainingMoney;
  public double getRemainingMoney() {
    return remainingMoney;
  }

  private String note;
  public String getNote() {
    return note;
  }
 
}
