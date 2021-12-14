/**************************************************************************
 * Program that represents the wifi usage that adds the cost for a modem. *
 * This class is a child class to WirelessNetwork.java and will call to   *
 * the methods used.                                                      *
 *                                                                        *
 * Project 9                                                              *
 * @author Midas Oden                                                     *
 * @version November 7, 2019                                              *
 **************************************************************************/
 
public class WiFi extends WirelessNetwork {

// Instance Variable(s) - fields

   private double modemCost;

// Constructor

  /**
   * @param nameIn takes in the name
   * @param bandwidthIn takes in Mbps usage
   * @param monthlyFixedCostIn takes in the monthly fixed cost
   * @param modemCostIn takes in the cost for a modem
   */

   public WiFi(String nameIn, double bandwidthIn, 
                  double monthlyFixedCostIn, double modemCostIn) {
      super(nameIn, bandwidthIn, monthlyFixedCostIn);
      
      modemCost = modemCostIn;
      
   }
      
// Methods

  /**
   * @return Returns the cost for the modem
   */

   public double getModemCost() {
   
      return modemCost;
   
   }
   
  /**
   * @param modemCostIn sets the cost for the modem
   */

   public void setModemCost(double modemCostIn) {
   
      this.modemCost = modemCostIn;
   
   }
   
  /**
   * @return Returns the monthly cost for the Wifi
   *         network
   */

   public double monthlyCost() {
   
      return monthlyFixedCost + modemCost;
   
   }
      
}