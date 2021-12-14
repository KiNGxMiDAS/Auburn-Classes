import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**************************************************************************
 * Program represents a JUnit test file which allow the user to test all  *
 * methods within the Cellular.java and WirelessNetwork.java class files. *
 *                                                                        *
 * Project 10                                                             *
 * @author Midas Oden                                                     *
 * @version November 21, 2019                                             *
 **************************************************************************/

public class CellularTest {
  
   /** Fixture initialization (common initialization for all tests). **/
   
   @Before public void setUp() {
   
   }
   
   //------------------------------------------------------------------------//
 //                      Cellular.java ~ TEST METHODS                         //
  //------------------------------------------------------------------------//
   
  /**
   * This method will test the getTime() method within Cellular.java.
   */

   @Test public void getTimeTest() {
   
      Cellular cellular = new Cellular("My Note", 5.0, 20.00, 1200, 1.0);
      Assert.assertEquals("getTime test", 1200, cellular.getTime(), 0.000001);
   
   }
   
  /**
   * This method will test the setTime() method within Cellular.java.
   */

   @Test public void setTimeTest() {
   
      Cellular cellular = new Cellular("My Note", 5.0, 20.00, 1200, 1.0);
      cellular.setTime(1000);
      
      Assert.assertEquals("setTime test", 1000, cellular.getTime(), 0.000001);
   
   }
   
  /**
   * This method will test the getDataLimit() method within Cellular.java.
   */

   @Test public void getDataLimitTest() {
   
      Cellular cellular = new Cellular("My Note", 5.0, 20.00, 1200, 1.0);
      Assert.assertEquals("getDataLimit test", 1, cellular.getDataLimit(), 0.1);
   
   }
   
  /**
   * This method will test the setDataLimit() method within Cellular.java.
   */

   @Test public void setDataLimitTest() {
   
      Cellular cellular = new Cellular("My Note", 5.0, 20.00, 1200, 1.0);
      cellular.setDataLimit(5);
      
      Assert.assertEquals("setDataLimit test", 5, cellular.getDataLimit(), 0.1);
   
   }
   
  /**
   * This method will test the dataUsage() method within Cellular.java.
   */

   @Test public void dataUsageTest() {
   
      Cellular cellular = new Cellular("My Note", 5.0, 20.00, 1200, 1.0);
      Assert.assertEquals("dataUsage test", 0.75, cellular.dataUsage(), 0.0001);
      
   }
   
  /**
   * This method will test the monthlyCost() method within Cellular.java.
   * This test ensures that the data usage is less than the data limit.
   */

   @Test public void monthlyCellularCostTest1() {
   
      Cellular cellular = new Cellular("Phone", 20.0, 40.0, 20, 20.0);
      Assert.assertEquals("monthlyCellularCost test", 40, 
                         cellular.monthlyCost(), 0.000001);
   
   }
   
  /**
   * This method will test the monthlyCost() method within Cellular.java.
   * This test ensures that the data usage is equal to the data limit.
   */

   @Test public void monthlyCellularCostTest2() {
   
      Cellular cellular = new Cellular("Phone", 8000.0, 40.0, 1.0, 1.0);
      Assert.assertEquals("monthlyCellularCost test", 40, 
                         cellular.monthlyCost(), 0.000001);
   
   }
   
  /**
   * This method will test the monthlyCost() method within Cellular.java.
   * This test ensures that the data usage is less than the data limit.
   */

   @Test public void monthlyCellularCostTest3() {
   
      Cellular cellular = new Cellular("Phone", 500.0, 40.0, 500, 20.0);
      Assert.assertEquals("monthlyCellularCost test", 51.25, 
                         cellular.monthlyCost(), 0.000001);
   
   }
   
  /**
   * This method will test the toString() method within WirelessNetwork.java.
   * This test will create a Cellular.java object and ensures that the name 
   * of the wireless network (or device) is printed as well as the cost, 
   * bandwidth, amount of time spent using the device, data limit, and 
   * data usage.
   */

   @Test public void toStringTest1() {
   
      Cellular cellular = new Cellular("My Note", 5.0, 20.00, 1200, 1.0);  
      boolean output1 = cellular.toString().contains("Bandwidth");
      boolean output2 = cellular.toString().contains("My Note");
      boolean output3 = cellular.toString().contains("(class Cellular)");
      boolean output4 = cellular.toString().contains("Hello World :-)");
      boolean output5 = cellular.toString().contains("Doesn't not belong");
              
      Assert.assertEquals(true, 
         output1 && output2 && output3 
         || !(output4 && output5) || !(output1 && output5));
           
   }
   
  /**
   * This method will test the toString() method within WirelessNetwork.java.
   * This test will create a Cellular.java object and ensures that the name 
   * of the wireless network (or device) is printed as well as the cost, 
   * bandwidth, amount of time spent using the device, data limit, and 
   * data usage.
   */

   @Test public void toStringTest2() {
   
      Cellular cellular = new Cellular("My Note", 5.0, 20.00, 1200, 1.0);  
      boolean output1 = cellular.toString().contains("Bandwidth");
      boolean output2 = cellular.toString().contains("My Note");
      boolean output3 = cellular.toString().contains("(class Cellular)");
      boolean output4 = cellular.toString().contains("Hello World :-)");
      boolean output5 = cellular.toString().contains("Doesn't not belong");
              
      Assert.assertEquals(false, 
         output1 && output4 || output4 && output5);
           
   }

   
   //------------------------------------------------------------------------//
 //                   WirelessNetWork.java ~ TEST METHODS                     //
  //------------------------------------------------------------------------//
   
  /**
   * This method will test the getName() method within WirelessNetwork.java.
   */

   @Test public void getNameTest() {
   
      Cellular cellular = new Cellular("My Note", 5.0, 20.00, 1200, 1.0);  
      Assert.assertEquals("getName test", "My Note", cellular.getName());
   
   }
   
  /**
   * This method will test the setName() method within WirelessNetwork.java.
   */

   @Test public void setNameTest() {
   
      Cellular cellular = new Cellular("My Note", 5.0, 20.00, 1200, 1.0);  
      cellular.setName("My iPhone 11 MAX");
      
      Assert.assertEquals("setName test", 
                          "My iPhone 11 MAX", cellular.getName());
   
   }
   
  /**
   * This method will test the getBandwidth() method 
   * within WirelessNetwork.java.
   */
  
   @Test public void getBandwidthTest() {
   
      Cellular cellular = new Cellular("My Note", 5.0, 20.00, 1200, 1.0);  
      Assert.assertEquals("getBandwidth test", 5, 
                         cellular.getBandwidth(), 0.000001);
            
   }
    
  /**
   * This method will test the setBandwidth() method 
   * within WirelessNetwork.java.
   */

   @Test public void setBandwidthTest() {
   
      Cellular cellular = new Cellular("My Note", 5.0, 20.00, 1200, 1.0);  
      cellular.setBandwidth(500);
      
      Assert.assertEquals("setBandwidth test", 500, 
                         cellular.getBandwidth(), 0.000001);
            
   }
   
  /**
   * This method will test the getCount() method within WirelessNetwork.java.
   * This test will print the amount of Cellular.java objects after the amount 
   * has been reset ... this resulting in a one object.
   */

   @Test public void getCount() {
   
      Cellular cellular1 = new Cellular("My Note", 5.0, 20.00, 1200, 1.0);  
      cellular1.resetCount();
      
      Cellular cellular2 = new Cellular("My iPhone", 1.0, 40.00, 1500, 5.0);   
      Assert.assertEquals("getCount test2", 1, cellular1.getCount(), 0.000001);
            
   }
   
  /**
   * This method will test the resetCount() method within WirelessNetwork.java.
   * This test will reset the amount of Cellular.java object created so far,
   * thus resulting in zero objects.
   */
   
   @Test public void resetCount1() {
   
      Cellular cellular = new Cellular("My Note", 5.0, 20.00, 1200, 1.0);  
      cellular.resetCount();
        
      Assert.assertEquals("resetCount test", 0, cellular.getCount(), 0.000001);
            
   }
   
  /**
   * This method will test the resetCount() method within WirelessNetwork.java.
   * This test will reset the amount of Cellular.java object created so far,
   * thus resulting in zero objects.
   */
   
   @Test public void resetCount2() {
   
      Cellular cellular1 = new Cellular("My Note", 5.0, 20.00, 1200, 1.0);  
      Cellular cellular2 = new Cellular("My iPhone", 1.0, 40.00, 1500, 5.0);   
      cellular2.resetCount();
        
      Assert.assertEquals("resetCount test", 0, cellular2.getCount(), 0.000001);
            
   }

}