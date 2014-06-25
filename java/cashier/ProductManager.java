import java.util.*;
import java.io.*;
import org.jdom.*;
import org.jdom.input.*;

class ProductManager {
 
  private Map<String, Product> productMap;

  public ProductManager(String dataFile) {
    productMap = new HashMap<String, Product>();

    SAXBuilder builder = new SAXBuilder();
    File xmlFile = new File(dataFile);
    try {
      Document document = (Document) builder.build(xmlFile);
      Element rootNode = document.getRootElement();
      List list = rootNode.getChildren("goods");

      for (int i = 0; i < list.size(); i++) {
        Element node = (Element) list.get(i);
        
        String id     = node.getChildText("id");
        String name   = node.getChildText("name");
        String ename  = node.getChildText("ename");
        double price  = Double.parseDouble(node.getChildText("price"));
        int left      = Integer.parseInt(node.getChildText("left"));

        productMap.put(
          ename, new Product(id, name, ename, price, left)
        );
      }
    } catch (IOException io) {
      System.out.println(io.getMessage());
    } catch (JDOMException jdomex) {
      System.out.println(jdomex.getMessage());
    }
  }

  public Product findProduct(String productEname) {
    return productMap.get(productEname);
  }

  public String toString() {
    return productMap.toString();
  }

  public static void main(String[] args) {
    String dataFile = args[0];

    ProductManager manager = new ProductManager(dataFile);

    System.out.println(manager); 
  }

}

