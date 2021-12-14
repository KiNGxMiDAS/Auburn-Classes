import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**************************************************************************
 * Program represents a JUnit test file which allow the user to test all  *
 * methods within the FiveG.java and WirelessNetwork.java class files.    *
 *                                                                        *
 * Project 9                                                              *
 * @author Midas Oden                                                     *
 * @version November 7, 2019                                              *
 **************************************************************************/
 
public class FiveGTest {

  /** Fixture initialization (common initialization for all tests). **/

   @Before public void setUp() {
   
   }
   
   //------------------------------------------------------------------------//
 //                      FiveG.java ~ TEST METHODS                            //
  //------------------------------------------------------------------------//
   
  /**
   * This method will test the monthlyCost() method within FiveG.java.
   */
   
   @Test public void monthlyFiveGCostTest1() {
   
      FiveG fiveG = new FiveG("My Phone", 80.0, 50.00, 1200, 10.0);
      Assert.assertEquals("monthlyFiveGCost test", 80, 
                         fiveG.monthlyCost(), 0.000001);
   
   }
   
  /**
   * This method will test the monthlyCost() method within FiveG.java.
   */
   
   @Test public void monthlyFiveGCostTest2() {
   
      FiveG fiveG = new FiveG("My Phone", 80.0, 50.00, 12, 15.0);
      Assert.assertEquals("monthlyFiveGCost test", 50, 
                         fiveG.monthlyCost(), 0.000001);
   
   }
   
  /**
   * This method will test the monthlyCost() method within FiveG.java.
   */
   
   @Test public void monthlyFiveGCostTest3() {
   
      FiveG fiveG = new FiveG("My Phone", 80.0, 50.00, 12, 12.0);
      Assert.assertEquals("monthlyFiveGCost test", 50, 
                         fiveG.monthlyCost(), 0.000001);
   
   }
   
   //------------------------------------------------------------------------//
 //                   WirelessNetWork.java ~ TEST METHODS                     //
  //------------------------------------------------------------------------//
   
  /**
   * This method will test the getName() method within WirelessNetwork.java.
   */

   @Test public void getNameTest() {
   
      FiveG fiveG = new FiveG("My Phone", 80.0, 50.00, 1200, 10.0);
      Assert.assertEquals("getName test", "My Phone", fiveG.getName());
   
   }
   
  /**
   * This method will test the setName() method within WirelessNetwork.java.
   */

   @Test public void setNameTest() {
   
      FiveG fiveG = new FiveG("My Phone", 80.0, 50.00, 1200, 10.0);
      fiveG.setName("My Samsung");
      
      Assert.assertEquals("setName test", 
                          "My Samsung", fiveG.getName());
   
   }
   
  /**
   * This method will test the getBandwidth() method 
   * within WirelessNetwork.java.
   */
  
   @Test public void getBandwidthTest() {
   
      FiveG fiveG = new FiveG("My Phone", 80.0, 50.00, 1200, 10.0);
      Assert.assertEquals("getBandwidth test", 80, 
                         fiveG.getBandwidth(), 0.000001);
            
   }
    
  /**
   * This method will test the setBandwidth() method 
   * within WirelessNetwork.java.
   */

   @Test public void setBandwidthTest() {
   
      FiveG fiveG = new FiveG("My Phone", 80.0, 50.00, 1200, 10.0);
      fiveG.setBandwidth(500);
      
      Assert.assertEquals("setBandwidth test", 500, 
                         fiveG.getBandwidth(), 0.000001);
            
   }
    
  /**
   * This method will test the getMonthlyFixedCost() method 
   * within WirelessNetwork.java.
   */
   
   @Test public void getMonthlyFixedCostTest() {
   
      FiveG fiveG = new FiveG("My Phone", 80.0, 50.00, 1200, 10.0);
      Assert.assertEquals("getMonthlyFixedCost test", 50, 
                         fiveG.getMonthlyFixedCost(), 0.000001);
            
   }
   
  /**
   * This method will test the setMonthlyFixedCost() method 
   * within WirelessNetwork.java.
   */

   @Test public void setMonthlyFixedCostTest() {
   
      FiveG fiveG = new FiveG("My Phone", 80.0, 50.00, 1200, 10.0);
      fiveG.setMonthlyFixedCost(60);
      
      Assert.assertEquals("setMonthlyFixedCost test", 60, 
                         fiveG.getMonthlyFixedCost(), 0.000001);
            
   } 
   
  /**
   * This method will test the getCount() method within WirelessNetwork.java.
   * This test will print the amount of LTE.java objects after the amount 
   * has been reset ... this resulting in a one object.
   */

   @Test public void getCount() {
   
      FiveG fiveG1 = new FiveG("My Phone", 80.0, 50.00, 1200, 10.0);
      fiveG1.resetCount();
      
      FiveG fiveG2 = new FiveG("My Samsung", 70.0, 60.00, 1500, 11.0);
      Assert.assertEquals("getCount test2", 1, fiveG1.getCount(), 0.000001);
            
   }
   
  /**
   * This method will test the resetCount() method within WirelessNetwork.java.
   * This test will reset the amount of LTE.java object created so far ... thus
   * resulting in zero objects.
   */
   
   @Test public void resetCount1() {
   
      FiveG fiveG = new FiveG("My Phone", 80.0, 50.00, 1200, 10.0);
      fiveG.resetCount();
        
      Assert.assertEquals("resetCount test", 0, fiveG.getCount(), 0.000001);
            
   }
   
  /**
   * This method will test the resetCount() method within WirelessNetwork.java.
   * This test will reset the amount of LTE.java object created so far ... thus
   * resulting in zero objects.
   */
   
   @Test public void resetCount2() {
   
      FiveG fiveG1 = new FiveG("My Phone", 80.0, 50.00, 1200, 10.0);
      FiveG fiveG2 = new FiveG("My Samsung", 70.0, 60.00, 1500, 11.0);
      fiveG2.resetCount();
        
      Assert.assertEquals("resetCount test", 0, fiveG2.getCount(), 0.000001);
            
   }

}