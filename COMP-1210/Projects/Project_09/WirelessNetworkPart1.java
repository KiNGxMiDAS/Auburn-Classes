 /*********************************************************************
 * Driver program that will call to the methods within the            *
 * WirelessNetwork.java class. This program includes 4 wireless       *
 * networks/devices all with specified names (labels), monthly costs, *
 * bandwidth length, time usage, data limit, and data usage.          *
 *                                                                    *  
 * Project 9                                                          *
 * @author Midas Oden                                                 *
 * @version November 7, 2019                                          *
 *********************************************************************/
 
public class WirelessNetworkPart1 {

 /**
  * @param args ~ command-line arguments
  */
  
   public static void main(String[] args) {
   
      WiFi wifiObj = new WiFi("My Wifi", 450, 40.00, 5.00);
      Cellular cellular = new Cellular("My Note", 5.0, 20.00, 1200, 1.0);  
      LTE lte = new LTE("My iPad", 20.0, 30.00, 1200, 2.0);
      FiveG fiveG = new FiveG("My Phone", 80.0, 50.00, 1200, 10.0);
   
      System.out.println(wifiObj.toString() + "\n");
      System.out.println(cellular.toString() + "\n");
      System.out.println(lte.toString() + "\n");
      System.out.println(fiveG.toString() + "\n");
   
   }

}