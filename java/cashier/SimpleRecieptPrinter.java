import java.io.*;

public class SimpleRecieptPrinter implements RecieptPrinter {

  public void print(Reciept reciept, PrintStream out) {
    out.println("name\tprice\tquant\ttotal");
    Reciept.Item[] items = reciept.getItems();
    for (int i = 0; i < items.length; i++) {
      Product product = items[i].getProduct();
      String name   = product.getName();
      double price  = product.getPrice();
      int quantity  = items[i].getQuantity();

      if (items[i].isInStock()) {
        out.printf(
          "%s\t%.2f\t%s\t%.2f\n", 
          name, price, quantity, price * quantity
        );
      } else {
        out.printf(
          "%s\t%.2f\t%s\t%s\n", 
          name, price, quantity, "Out of stock" 
        );
      } 
    }

    out.printf("priceall: %.2f\n", reciept.getSubtotal());
    out.printf("pricegive: %.2f\n", reciept.getPayedMoney());
    out.printf("back: %.2f\n", reciept.getRemainingMoney());

    if (reciept.getNote() != null) {
      out.printf("note: %s\n", reciept.getNote());
    }
  }

}

