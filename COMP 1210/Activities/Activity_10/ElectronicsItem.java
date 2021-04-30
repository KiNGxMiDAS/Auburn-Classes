/*****************************************************************************
 * Program represents an electronics inventory item in a store. This program *
 * will serve as the child (subclass) for InventoryItem.java. Electronics    *
 * items will have all of the characteristics of Inventory items and will    *
 * take into account shipping costs.                                         *
 *                                                                           *
 * Activity 9                                                                *
 * @author Midas Oden                                                        *
 * @version November 4, 2019                                                 *
 *****************************************************************************/

public class ElectronicsItem extends InventoryItem {

// Instance Variable(s) - fields
   
  /**
   * 
   */
   
   public static final double SHIPPING_COST = 1.5;
   protected double weight;
      
// Constructor

  /**
   * @param nameIn takes in the name of an item
   * @param priceIn takes in the price of an item
   * @param weightIn takes in the weight of an item
   */

   public ElectronicsItem(String nameIn, double priceIn, double weightIn) {
      super(nameIn, priceIn);
      
      weight = weightIn;
      
   }
   
  /**
   * This method will override the calculateCost() method
   * within the InventoryItem class so that the shipping cost
   * is equated into the total cost.
   *
   * @return Returns the total cost with tax rate and shipping
   *         costs included
   */
   
   public double calculateCost() {
   
      return super.calculateCost() + (SHIPPING_COST * weight);
   
   }
      
}