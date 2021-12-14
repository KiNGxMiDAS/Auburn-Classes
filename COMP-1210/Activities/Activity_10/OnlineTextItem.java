/*****************************************************************************
 * Program represents an online text inventory item that users can buy (such *
 * as an electronic book or journal article). This class does not need to be *
 * instantiated as it is just a concept that represents a number of items,   *
 * so it is an abstract class for InventoryItem.java. Online text items will *
 * have all of the characteristics of Inventory items and will take into     *
 * account shipping costs.                                                   *
 *                                                                           *
 * Activity 9                                                                *
 * @author Midas Oden                                                        *
 * @version November 4, 2019                                                 *
 *****************************************************************************/

public abstract class OnlineTextItem extends InventoryItem {

  /**
   * @param nameIn takes in the name of an item
   * @param priceIn takes in the price of an item
   */

   public OnlineTextItem(String nameIn, double priceIn) {
      super(nameIn, priceIn);
   
   }
   
  /**
   * @return Returns the total cost without tax included
   */

   public double calculateCost() {
   
      return price;
   
   }

}