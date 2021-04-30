import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**************************************************************************
 * Program represents a JUnit test file which allow the user to test all  *
 * methods within the LTE.java and WirelessNetwork.java class files.      *
 *                                                                        *
 * Project 10                                                             *
 * @author Midas Oden                                                     *
 * @version November 21, 2019                                             *
 **************************************************************************/
 
public class LTETest {

  /** Fixture initialization (common initialization for all tests). **/
 
   @Before public void setUp() {
   
   }
   
   //------------------------------------------------------------------------//
 //                       LTE.java ~ TEST METHODS                             //
  //------------------------------------------------------------------------//
   
  /**
   * This method will test the monthlyCost() method within LTE.java.
   */
   
   @Test public void monthlyLTECostTest1() {
   
      LTE lte = new LTE("My iPad", 20.0, 30.00, 1200, 2.0);
      Assert.assertEquals("monthlyLTECost test", 38, lte.monthlyCost(), 0.0001);
   
   }
   
  /**
   * This method will test the monthlyCost() method within LTE.java.
   */
   
   @Test public void monthlyLTECostTest2() {
   
      LTE lte = new LTE("My iPad", 20.0, 30.00, 10, 12.0);
      Assert.assertEquals("monthlyLTECost test", 30, lte.monthlyCost(), 0.0001);
   
   }
   
  /**
   * This method will test the monthlyCost() method within LTE.java.
   */
   
   @Test public void monthlyLTECostTest3() {
   
      LTE lte = new LTE("My iPad", 20.0, 30.00, 10, 10.0);
      Assert.assertEquals("monthlyLTECost test", 30, lte.monthlyCost(), 0.0001);
   
   }
  
   //------------------------------------------------------------------------//
 //                   WirelessNetWork.java ~ TEST METHODS                     //
  //------------------------------------------------------------------------//
   
  /**
   * This method will test the getName() method within WirelessNetwork.java.
   */

   @Test public void getNameTest() {
   
      LTE lte = new LTE("My iPad", 20.0, 30.00, 1200, 2.0);
      Assert.assertEquals("getName test", "My iPad", lte.getName());
   
   }
   
  /**
   * This method will test the setName() method within WirelessNetwork.java.
   */

   @Test public void setNameTest() {
   
      LTE lte = new LTE("My iPad", 20.0, 30.00, 1200, 2.0);
      lte.setName("My iPad Mini");
      
      Assert.assertEquals("setName test", 
                          "My iPad Mini", lte.getName());
   
   }
   
  /**
   * This method will test the getBandwidth() method 
   * within WirelessNetwork.java.
   */
  
   @Test public void getBandwidthTest() {
   
      LTE lte = new LTE("My iPad", 20.0, 30.00, 1200, 2.0);
      Assert.assertEquals("getBandwidth test", 20, 
                         lte.getBandwidth(), 0.000001);
            
   }
    
  /**
   * This method will test the setBandwidth() method 
   * within WirelessNetwork.java.
   */

   @Test public void setBandwidthTest() {
   
      LTE lte = new LTE("My iPad", 20.0, 30.00, 1200, 2.0);
      lte.setBandwidth(500);
      
      Assert.assertEquals("setBandwidth test", 500, 
                         lte.getBandwidth(), 0.000001);
            
   }
    
  /**
   * This method will test the getMonthlyFixedCost() method 
   * within WirelessNetwork.java.
   */
   
   @Test public void getMonthlyFixedCostTest() {
   
      LTE lte = new LTE("My iPad", 20.0, 30.00, 1200, 2.0);
      Assert.assertEquals("getMonthlyFixedCost test", 30, 
                         lte.getMonthlyFixedCost(), 0.000001);
            
   }
   
  /**
   * This method will test the setMonthlyFixedCost() method 
   * within WirelessNetwork.java.
   */

   @Test public void setMonthlyFixedCostTest() {
   
      LTE lte = new LTE("My iPad", 20.0, 30.00, 1200, 2.0);
      lte.setMonthlyFixedCost(60);
      
      Assert.assertEquals("setMonthlyFixedCost test", 60, 
                         lte.getMonthlyFixedCost(), 0.000001);
            
   } 
   
  /**
   * This method will test the getCount() method within WirelessNetwork.java.
   * This test will print the amount of LTE.java objects after the amount 
   * has been reset ... this resulting in a one object.
   */

   @Test public void getCount2() {
   
      LTE lte1 = new LTE("My iPad", 20.0, 30.00, 1200, 2.0);
      lte1.resetCount();
      
      LTE lte2 = new LTE("My iPad Mini", 10.0, 40.00, 1500, 5.0);
      Assert.assertEquals("getCount test2", 1, lte1.getCount(), 0.000001);
            
   }
   
  /**
   * This method will test the resetCount() method within WirelessNetwork.java.
   * This test will reset the amount of LTE.java object created so far ... thus
   * resulting in zero objects.
   */
   
   @Test public void resetCount1() {
   
      LTE lte = new LTE("My iPad", 20.0, 30.00, 1200, 2.0);
      lte.resetCount();
        
      Assert.assertEquals("resetCount test", 0, lte.getCount(), 0.000001);
            
   }
   
  /**
   * This method will test the resetCount() method within WirelessNetwork.java.
   * This test will reset the amount of LTE.java object created so far ... thus
   * resulting in zero objects.
   */
   
   @Test public void resetCount2() {
   
      LTE lte1 = new LTE("My iPad", 20.0, 30.00, 1200, 2.0);
      LTE lte2 = new LTE("My iPad Mini", 10.0, 40.00, 1500, 5.0);
      lte2.resetCount();
        
      Assert.assertEquals("resetCount test", 0, lte2.getCount(), 0.000001);
            
   }

}