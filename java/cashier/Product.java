
class Product {

  private String id;
  public String getID() {
    return id;
  }

  private String name;
  public String getName() {
    return name;
  }

  private String ename;
  public String getEname() {
    return ename;
  }

  private double price;
  public double getPrice() {
    return price;
  }

  private int inventory;
  public int getInventory() {
    return inventory;
  }

  public Product(String id, String name, String ename, double price, int inventory) {
    this.id         = id;
    this.name       = name;
    this.ename      = ename;
    this.price      = price;
    this.inventory  = inventory;
  }

  public String toString() {
    StringBuilder result = new StringBuilder();

    result.append(this.getClass().getName() + "@{");
    result.append("id:" + this.getID() + ",");
    result.append("name:" + this.getName() + ",");
    result.append("ename:" + this.getEname() + ",");
    result.append("price:" + this.getPrice() + ",");
    result.append("inventory:" + this.getInventory() + "");
    result.append("}");

    return result.toString();
  }

  public static void main(String[] args) {
    System.out.println(new Product("1", "name", "ename", 10.00, 10));
  }

}

