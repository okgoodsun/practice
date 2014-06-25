
public interface CashierInput {

  public class Product {
   
    private String ename;
    public String getEname() {
      return ename;
    }

    private int quantity;
    public int getQuantity() {
      return quantity;
    }

    public Product(String ename, int quantity) {
      this.ename    = ename;
      this.quantity = quantity;
    }

  }

  public double getMoney();

  public CashierInput.Product[] getProducts();

}

