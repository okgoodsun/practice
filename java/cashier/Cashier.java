import java.util.*;

class Cashier {

  private ProductManager productManager;

  public Cashier(ProductManager productManager) {
    this.productManager = productManager;
  }

  public Reciept check(CashierInput input) {
    ArrayList<Reciept.Item> itemList = new ArrayList<Reciept.Item>();
    String note = null;
    double subtotal = 0;

    CashierInput.Product[] iproducts = input.getProducts();
    for (int i = 0; i < iproducts.length; i++) {
      String ename  = iproducts[i].getEname();
      int quantity  = iproducts[i].getQuantity();

      Product product = productManager.findProduct(ename);
      if (product == null) {
        note = String.format("Cannot find the product with ename '%s'!", ename);
        continue;
      }

      if (product.getInventory() < quantity) {
        // Don't have enough products in stock
        itemList.add(new Reciept.Item(product, quantity, false));
      } else {
        // Have enough products in stock and sums up into subtotal
        itemList.add(new Reciept.Item(product, quantity, true));
        subtotal += product.getPrice() * quantity;
      }
    }

    double payed      = input.getMoney();
    double remaining  = payed - subtotal;
    if (remaining < 0) {
      note = "Payed money is not enough!";
    }

    return new Reciept(
      itemList.toArray(new Reciept.Item[itemList.size()]),
      subtotal, 
      payed,
      remaining, 
      note
    );
  }

  public static void main(String[] args) {
    ProductManager productManager = new ProductManager("sell.xml");
    Cashier cashier = new Cashier(productManager);

    Reciept reciept = cashier.check(new CashierCommandlineInput(args));

    new SimpleRecieptPrinter().print(reciept, System.out);
  }

}
