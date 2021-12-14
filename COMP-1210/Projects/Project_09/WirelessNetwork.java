import java.text.DecimalFormat;

/*******************************************************************************
 * Program that represents an abstract class that stores wireless network data *
 * and provides methods to access that data. This class is the parent (super)  *
 * class to: Wifi.java, Cellular.java, LTE.java, and FiveG.java. This file     *
 * will provide information regarding the name of a wireless network or       *
 * device as well as the bandwidth in megabits per second and the monthly    *
 * fixed cost with data usage included in that cost.                        *
 *                                                                         *
 *                                                                        *
 * Project 9                                                             *
 * @author Midas Oden                                                   *
 * @version November 7, 2019                                           *
 *********************************************************************/

public abstract class WirelessNetwork {

// Instance Variable(s) - fields

   protected String name;
   protected double bandwidth;
   protected double monthlyFixedCost; 
   /*^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-*/ 
   protected static int count = 0;
   /*^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-*/

// Constructor

  /**
   * @param nameIn takes in the name of a wireless network
   * @param bandwidthIn takes in Mbps usage of the wireless network or device
   * @param monthlyFixedCostIn takes in the monthly fixed cost for the device
   *                           or the wireless network
   */

   public WirelessNetwork(String nameIn, 
         double bandwidthIn, double monthlyFixedCostIn) {
   
      name = nameIn;
      bandwidth = bandwidthIn;
      monthlyFixedCost = monthlyFixedCostIn;
      count++;
   
   }
   
// Methods

  /**
   * @return Returns the name of the wireless network or device
   */

   public String getName() {
   
      return name;
   
   }
   
  /**
   * @param nameIn sets the name of the wireless network or device
   */

   public void setName(String nameIn) {
   
      this.name = nameIn;
   
   }
   
  /**
   * @return Returns the bandwidth
   */

   public double getBandwidth() {
   
      return bandwidth;
   
   }
   
  /**
   * @param bandwidthIn sets the bandwidth
   */

   public void setBandwidth(double bandwidthIn) {
   
      this.bandwidth = bandwidthIn;
   
   }
   
  /**
   * @return Returns the monthlyFixedCost
   */

   public double getMonthlyFixedCost() {
   
      return monthlyFixedCost;
   
   }
   
  /**
   * @param monthlyFixedCostIn sets the monthlyFixedCost
   */

   public void setMonthlyFixedCost(double monthlyFixedCostIn) {
   
      this.monthlyFixedCost = monthlyFixedCostIn;
   
   }
   
  /**
   * @return Returns the amount of wireless network devices
   */

   public static int getCount() {
   
      return count;
   
   }
   
  /**
   * Resets the amount of wireless network devices to zero.
   */
   
   public static void resetCount() {
   
      WirelessNetwork.count = 0;
   
   }
   
  /**
   * @return Returns the String information regarding the wireless network
   *         device name, monthly cost, and bandwidth
   */

   public String toString() {
   
      DecimalFormat formatCost = new DecimalFormat("$#,##0.00");
      DecimalFormat formatTime = new DecimalFormat("###0.0");
   
      String output = name + " (class " 
                           + this.getClass().toString().substring(6) 
                           + ")" + " Cost: " + formatCost.format(monthlyCost()) 
                           + "\n" + "Bandwidth: " + bandwidth + " Mbps";
    
      return output;
   
   }
   
  /**
   * Abstract method used to call to the monthlyCost() methods 
   * in the other subclasses.
   *
   * @return Returns the monthly cost for a specific wireless network or device
   */
   
   public abstract double monthlyCost();

}