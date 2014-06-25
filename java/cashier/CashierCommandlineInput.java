
public class CashierCommandlineInput implements CashierInput {

  private CashierInput.Product[] products = new CashierInput.Product[0];
  public CashierInput.Product[] getProducts() {
    return products;
  }

  private double money;
  public double getMoney() {
    return money;
  }

  public CashierCommandlineInput(String[] args) {
    if (args.length == 0) return;

    try {
      money = Double.parseDouble(args[0]);
    } catch (NumberFormatException e) {
      // Money is not a number, defaulting to 0
    }
    
    if (args.length > 1) {
      products = new CashierInput.Product[args.length-1];
      for (int i=1; i<args.length; i++) {
        String[] pairs = args[i].split(":");

        // Ignore illegal input
        if (pairs.length < 2) continue;

        String ename    = pairs[0];
        String quantity = pairs[1];

        try {
          products[i-1] = new CashierInput.Product(
            ename, Integer.parseInt(quantity)
          );
        } catch (NumberFormatException e) {
          // Quantity is not a number, ignore
          continue;
        }
      }
    }
  }

}

