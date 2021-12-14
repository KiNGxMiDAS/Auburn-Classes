/*************************************************************************
 * Driver program that will call to the methods within the InventoryItem *
 * class and the ItemsList class. This program includes 4 inventory item *   
 * objects all with specified item names and prices                      *
 *                                                                       *
 * Activity 10                                                           *
 * @author Midas Oden                                                    *
 * @version November 11, 2019                                            *
 *************************************************************************/

public class InventoryListApp {

 /**
  * @param args ~ command-line arguments
  */

   public static void main(String[] args) {
   
      ItemsList myItems = new ItemsList();
      InventoryItem.setTaxRate(0.05);
     
      myItems.addItem(new ElectronicsItem("laptop", 1234.56, 10));
      myItems.addItem(new InventoryItem("motor oil", 9.8));
      myItems.addItem(new OnlineBook("All Things Java", 12.3));
      myItems.addItem(new OnlineArticle("Useful Acronyms", 3.4));
   
      System.out.println(myItems.toString());
      System.out.println("Total: " + myItems.calculateTotal(2.0));
   
   }

}