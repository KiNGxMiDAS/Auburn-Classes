/****************************************************************************
 * Program that represents the LTE service for a wireless network or device *
 * This program is derived from Cellular.java and will compute the cost     *
 * for a wireless or device based on if the data usage is less than or      *
 * equal to the limit on the data.                                          *
 *                                                                          *
 * Project 9                                                                *
 * @author Midas Oden                                                       *
 * @version November 7, 2019                                                *
 ****************************************************************************/

public class LTE extends Cellular {

// Instance Variable(s) - fields

  /**
   * Cost Factor for an LTE service network is 4.0.
   */
   public static final double COST_FACTOR = 4.0;

// Constructor

  /**
   * @param nameIn takes in the name
   * @param bandwidthIn takes in Mbps usage
   * @param monthlyFixedCostIn takes in the monthly fixed cost
   * @param timeIn takes in the time usage
   * @param dataLimitIn takes in the limit on the data
   */

   public LTE(String nameIn, double bandwidthIn, 
                  double monthlyFixedCostIn, double timeIn, 
                  double dataLimitIn) {
      super(nameIn, bandwidthIn, monthlyFixedCostIn, timeIn, dataLimitIn); 
   
   }
   
  /**
   * @return Returns the monthlyFixedCost
   */

   public double monthlyCost() {
   
      if (dataUsage() <= dataLimit) {
         return monthlyFixedCost;
      } else {
         return (monthlyFixedCost + (dataUsage() - dataLimit) 
                                       * LTE.COST_FACTOR * 2);
      }
   
   }

}
