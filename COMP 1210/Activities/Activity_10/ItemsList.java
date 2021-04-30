/*****************************************************************************
 * Program represents an inventory item in a store. This program will serve  *
 * as the parent (base) class for the: ElectronicsItem, OnlineTextItem,      *
 * OnlineArticle, and OnlineBook java class files.                           *
 *                                                                           *
 * Activity 10                                                               *
 * @author Midas Oden                                                        *
 * @version November 11, 2019                                                *
 *****************************************************************************/

public class ItemsList {

// Instance Variable(s) - fields

   private InventoryItem[] inventory;
   private int count;

// Constructor

  /**
   *
   */

   public ItemsList() {
      inventory = new InventoryItem[20];
      count = 0;
   
   }

// Methods

  /**
   * @param itemIn representing an object to add to the items list
   */

   public void addItem(InventoryItem itemIn) {
      inventory[count] = itemIn;
      count++;
   
   }
   
  /**
   * @param electronicsSurcharge takes ina double to multiple
   * @return Returns the cost after it has been calculated
   */

   public double calculateTotal(double electronicsSurcharge) {
      double total = 0;
      for (int i = 0; i < count; i++) {
         if (inventory[i] instanceof ElectronicsItem) {
            total += inventory[i].calculateCost() + electronicsSurcharge;
         } else {
            total += inventory[i].calculateCost();
         }
      }
      
      return total;      
   }
   
  /**
   * @return Returns a String representing the items of the inventory
   */
   
   public String toString() {
      String output = "All inventory:\n\n";
   
      for (int i = 0; i < count; i++) {
         output += inventory[i] + "\n";
      }
   
      return output;
   
   }
   
}