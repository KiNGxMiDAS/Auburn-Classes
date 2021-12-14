import java.text.DecimalFormat;

/****************************************************************************
 * Program that represents the cellular usage that adds the amount of time  *
 * spent using the network or device as well as the limit of the data. This *
 * class is a subclass to WirelessNetwork.java.                             *
 *                                                                          *
 * Project 9                                                                *
 * @author Midas Oden                                                       *
 * @version November 7, 2019                                                *
 ****************************************************************************/

public class Cellular extends WirelessNetwork {

// Instance Variable(s) - fields

   protected double time;
   protected double dataLimit;
   
  /**
   * Cost Factor for a cellular network is 1.0.
   */
   public static final double COST_FACTOR = 1.0;

// Constructor

  /**
   * @param nameIn takes in the name
   * @param bandwidthIn takes in Mbps usage
   * @param monthlyFixedCostIn takes in the monthly fixed cost
   * @param timeIn takes in the time usage
   * @param dataLimitIn takes in the limit on the data
   */

   public Cellular(String nameIn, double bandwidthIn, 
                  double monthlyFixedCostIn, double timeIn, 
                  double dataLimitIn) {
      super(nameIn, bandwidthIn, monthlyFixedCostIn); 
      
      time = timeIn;
      dataLimit = dataLimitIn;
      
   }
   
  /**
   * @return Returns the time
   */

   public double getTime() {
   
      return time;
   
   }
   
  /**
   * @param timeIn sets the time
   */

   public void setTime(double timeIn) {
   
      time = timeIn;
   
   }
   
  /**
   * @return Returns the data limit
   */
   
   public double getDataLimit() {
   
      return dataLimit;
   
   }
   
  /**
   * @param dataLimitIn sets the data limit
   */
   
   public void setDataLimit(double dataLimitIn) {
   
      dataLimit = dataLimitIn;
   
   }
   
   /**
   * @return Returns the data usage
   */
   
   public double dataUsage() {
   
      return bandwidth / 8000 * time;
   
   
   } 
    
  /**
   * @return Returns the monthlyFixedCost
   */

   public double monthlyCost() {
   
      if (dataUsage() <= dataLimit) {
         return monthlyFixedCost;
      } else {
         return (monthlyFixedCost + (dataUsage() - dataLimit) 
                                      * Cellular.COST_FACTOR);
      }
   
   }
   
  /**
   * @return Returns the String information
   */
   
   public String toString() {
    
      DecimalFormat formatTime = new DecimalFormat("###0.0");               
      return super.toString() + "\nTime: " + formatTime.format(time) 
                              + " seconds" + "\nData Limit: " 
                              + dataLimit + " GB" + "\nData Used: "
                              + dataUsage() + " GB";
   
   } 

}