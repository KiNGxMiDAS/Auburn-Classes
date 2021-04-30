/*****************************************************************************
 * Program represents an inventory item in a store. This program will serve  *
 * as the parent (base) class for the: ElectronicsItem, OnlineTextItem,      *
 * OnlineArticle, and OnlineBook java class files.                           *
 *                                                                           *
 * Activity 9                                                                *
 * @author Midas Oden                                                        *
 * @version November 4, 2019                                                 *
 *****************************************************************************/

public class InventoryItem {

// Instance Variables (Fields)

   protected String name;
   protected double price;
   private static double taxRate = 0;

// Constructor

  /**
   * @param nameIn takes in the name of an item
   * @param priceIn takes in the price of an item
   */

   public InventoryItem(String nameIn, double priceIn) {
   
      name = nameIn;
      price = priceIn;
   
   }
   
  /**
   * @return Returns the name of an item
   */

   public String getName() {
   
      return name;
   
   }
   
  /**
   * @return Returns the total cost with tax rate included
   */

   public double calculateCost() {
   
      double calculatedCost = price * (1 + taxRate);
      return calculatedCost;
   
   }
   
  /**
   * @param taxRateIn sets the tax rate
   */

   public static void setTaxRate(double taxRateIn) {
   
      taxRate = taxRateIn;
   
   }
   
  /**
   * @return Returns the name and cost for an item
   */

   public String toString() {
   
      String output = name + ": $" + calculateCost();
      return output;
   
   }

}