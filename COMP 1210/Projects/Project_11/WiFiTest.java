import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*************************************************************************
 * Program represents a JUnit test file which allow the user to test all *
 * methods within the WiFi.java and WirelessNetwork.java class files.    *
 *                                                                       *
 * Project 10                                                            *
 * @author Midas Oden                                                    *
 * @version November 21, 2019                                            *
 *************************************************************************/

public class WiFiTest {

   /** Fixture initialization (common initialization for all tests). **/

   @Before public void setUp() {
   
   }
   
   //------------------------------------------------------------------------//
 //                        WiFi.java ~ TEST METHODS                           //
  //------------------------------------------------------------------------//
   
  /**
   * This method will test the getModemCost() method within WiFi.java.
   */
         
   @Test public void getModemCostTest() {
   
      WiFi wifiObj = new WiFi("My WiFi", 450, 40.00, 5.00);
      Assert.assertEquals("getModemCost test", 5, wifiObj.getModemCost(), 0.01);
   
   }
   
  /**
   * This method will test the setModemCost() method within WiFi.java.
   */

   @Test public void setModemCostTest() {
   
      WiFi wifiObj = new WiFi("My WiFi", 450, 40.00, 1);  
      wifiObj.setModemCost(5);
      
      Assert.assertEquals("setModemCost test", 5, wifiObj.getModemCost(), 0.01);
   
   }
   
  /**
   * This method will test the monthlyWiFiCost() method within WiFi.java.
   */
   
   @Test public void monthlyWiFiCostTest() {
   
      WiFi wifiObj = new WiFi("My WiFi", 450, 40.00, 5);  
      Assert.assertEquals("monthlyWiFiCost test", 45, 
                         wifiObj.monthlyCost(), 0.000001);
   
   }
   
   //------------------------------------------------------------------------//
 //                   WirelessNetWork.java ~ TEST METHODS                     //
  //------------------------------------------------------------------------//
   
  /**
   * This method will test the getName() method within WirelessNetwork.java.
   */

   @Test public void getNameTest() {
   
      WiFi wifiObj = new WiFi("My WiFi", 450, 40.00, 5);  
      Assert.assertEquals("getName test", "My WiFi", wifiObj.getName());
   
   }
   
  /**
   * This method will test the setName() method within WirelessNetwork.java.
   */

   @Test public void setNameTest() {
   
      WiFi wifiObj = new WiFi("WiFi My", 450, 40.00, 5);  
      wifiObj.setName("My WiFi");
      
      Assert.assertEquals("setName test", "My WiFi", wifiObj.getName());
   
   }
   
  /**
   * This method will test the getBandwidth() method 
   * within WirelessNetwork.java.
   */
  
   @Test public void getBandwidthTest() {
   
      WiFi wifiObj = new WiFi("My WiFi", 450, 40.00, 5.00);
      Assert.assertEquals("getBandwidth test", 450, 
                         wifiObj.getBandwidth(), 0.000001);
            
   }
    
  /**
   * This method will test the setBandwidth() method 
   * within WirelessNetwork.java.
   */

   @Test public void setBandwidthTest() {
   
      WiFi wifiObj = new WiFi("My WiFi", 450, 40.00, 5.00);
      wifiObj.setBandwidth(500);
      
      Assert.assertEquals("setBandwidth test", 500, 
                         wifiObj.getBandwidth(), 0.000001);
            
   }
    
  /**
   * This method will test the getMonthlyFixedCost() method 
   * within WirelessNetwork.java.
   */
   
   @Test public void getMonthlyFixedCostTest() {
   
      WiFi wifiObj = new WiFi("My WiFi", 450, 40.00, 5.00); 
      Assert.assertEquals("getMonthlyFixedCost test", 40, 
                         wifiObj.getMonthlyFixedCost(), 0.000001);
            
   }
   
  /**
   * This method will test the setMonthlyFixedCost() method 
   * within WirelessNetwork.java.
   */

   @Test public void setMonthlyFixedCostTest() {
   
      WiFi wifiObj = new WiFi("My WiFi", 450, 40.00, 5.00);
      wifiObj.setMonthlyFixedCost(60);
      
      Assert.assertEquals("setMonthlyFixedCost test", 60, 
                         wifiObj.getMonthlyFixedCost(), 0.000001);
            
   } 
   
  /**
   * This method will test the getCount() method within WirelessNetwork.java.
   * This test will print the amount of WiFi.java objects after the amount 
   * has been reset ... this resulting in a one object.
   */

   @Test public void getCount() {
   
      WiFi wifiObj = new WiFi("My WiFi", 450, 40.00, 5.00);    
      wifiObj.resetCount();
      
      WiFi wifiObj2 = new WiFi("My WiFi", 1, 2, 3);    
      Assert.assertEquals("getCount test2", 1, wifiObj.getCount(), 0.000001);
            
   }
   
  /**
   * This method will test the resetCount() method within WirelessNetwork.java.
   * This test will reset the amount of WiFi.java object created so far ... thus
   * resulting in zero objects.
   */
   
   @Test public void resetCount1() {
   
      WiFi wifiObj = new WiFi("My WiFi", 450, 40.00, 5.00);    
      wifiObj.resetCount();
        
      Assert.assertEquals("resetCount test", 0, wifiObj.getCount(), 0.000001);
            
   }
   
  /**
   * This method will test the resetCount() method within WirelessNetwork.java.
   * This test will reset the amount of WiFi.java object created so far ... thus
   * resulting in zero objects.
   */
   
   @Test public void resetCount2() {
   
      WiFi wifiObj1 = new WiFi("My WiFi", 450, 40.00, 5.00);  
      WiFi wifiObj2 = new WiFi("My WiFi", 450, 40.00, 5.00);    
      wifiObj2.resetCount();
        
      Assert.assertEquals("resetCount test", 0, wifiObj2.getCount(), 0.000001);
            
   }
  
  /**
   * This method will test the toString() method within WirelessNetwork.java.
   * This test will create a WiFi.java object and ensures that the name of the 
   * wireless network (or device) is printed as well as the cost and bandwidth.
   */

   @Test public void toStringTest1() {
   
      WiFi wifiObj = new WiFi("My WiFi", 450, 40.00, 5.00);
      
      boolean output1 = wifiObj.toString().contains("Bandwidth");
      boolean output2 = wifiObj.toString().contains("My WiFi");
      boolean output3 = wifiObj.toString().contains("(class WiFi)");
      boolean output4 = wifiObj.toString().contains("Wassup Ya'll");
      boolean output5 = wifiObj.toString().contains("Doesn't not belong");
   
      Assert.assertEquals(true, 
         output1 || output2 || output3 
         && !(output4 && output5) && !(output1 && output5));
            
   }
   
  /**
   * This method will test the toString() method within WirelessNetwork.java.
   * This test will create a WiFi.java object and ensures that the name of the 
   * wireless network (or device) is printed as well as the cost and bandwidth.
   */

   @Test public void toStringTest2() {
   
      WiFi wifiObj = new WiFi("My WiFi", 450, 40.00, 5.00);
      
      boolean output1 = wifiObj.toString().contains("Bandwidth");
      boolean output2 = wifiObj.toString().contains("My WiFi");
      boolean output3 = wifiObj.toString().contains("(class WiFi)");
      boolean output4 = wifiObj.toString().contains("Wassup Ya'll");
      boolean output5 = wifiObj.toString().contains("Doesn't not belong");
      
      Assert.assertEquals(false, 
         output1 && output4 || output4 && output5);
            
   }

}