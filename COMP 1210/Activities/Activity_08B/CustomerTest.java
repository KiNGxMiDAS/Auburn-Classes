import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

 /*****************************************************************************
 * Program represents a JUnit test file which allow the user to test all     *
 * methods within the IceCreamCone.java class file. This particular java     *
 * test file includes several test methods that will essentially call to     *
 * the methods within IceCreamCone.java.                                     *
 *                                                                           *
 * Activity 8B                                                               *
 * @author Midas Oden                                                        *
 * @version October 26, 2019                                                 *
 *****************************************************************************/

public class CustomerTest {

  /** Fixture initialization (common initialization for all tests). **/
  
   @Before public void setUp() {
   
   }
   
  /**
   * This method will test the setLocation() method.
   */
   
   @Test public void setLocationTest1() {
   
      Customer cstmr = new Customer("Lane, Jane");
      cstmr.setLocation("Boston, MA");
      
      Assert.assertEquals("Boston, MA", cstmr.getLocation());
   
   }
   
  /**
   * This method will test the setLocation() method.
   */
   
   @Test public void setLocationTest2() {
   
      Customer cstmr = new Customer("Lane, Jane");
      cstmr.setLocation("Atlanta, GA");
      
      Assert.assertEquals("Atlanta, GA", cstmr.getLocation());
   
   }
   
  /**
   * This method will test the setLocation() method for a set paramter.
   */
   
   @Test public void setLocationTest3() {
   
      Customer cstmr = new Customer("Lane, Jane");
      cstmr.setLocation("Atlanta", "GA");
   
      Assert.assertEquals("Atlanta, GA", cstmr.getLocation());
   
   }
   
  /**
   * This method will test the changeBalance() method.
   */

   @Test public void changeBalanceTest() {
   
      Customer cstmr = new Customer("Lane, Jane");
      cstmr.changeBalance(100);
      
      Assert.assertEquals(100, cstmr.getBalance(), 0.000001);
   
   }
   
  /**
   * This method will test the toString() method.
   */

   @Test public void toStringTest() {
   
      Customer cstmr = new Customer("Lane, Jane");
      cstmr.setLocation("Auburn, AL");
      cstmr.changeBalance(999);
      
      Assert.assertEquals("Lane, Jane\nAuburn, AL\n$999.0", cstmr.toString());
            
   }

  /**
   * This method will test the compareTo() method.
   * This test compares two identical Customer
   * objects and return 0.
   */
    
   @Test public void compareToTest1() {
   
      Customer cstmr1 = new Customer("Lane, Jane");
      cstmr1.changeBalance(500);
      
      Customer cstmr2 = new Customer("Lane, Lois");
      cstmr2.changeBalance(500);
      
      Assert.assertTrue(cstmr1.compareTo(cstmr2) == 0);
      
   }

  /**
   * This method will test the compareTo() method.
   * This test compares two Customer objects with
   * different names and balances. Since we are
   * comparing the "cstmr1" object to the "cstmr2"
   * object and "cstmr1" has a lower balance, this
   * test will return an output of -1.
   */
   
   @Test public void compareToTest2() {
   
      Customer cstmr1 = new Customer("Lane, Jane");
      cstmr1.changeBalance(100);
      
      Customer cstmr2 = new Customer("Lane, Lois");
      cstmr2.changeBalance(500);
      
      Assert.assertTrue(cstmr1.compareTo(cstmr2) < 0);
      
   }

  /**
   * This method will test the compareTo() method.
   * This test compares two Customer objects with 
   * different names and balances.Since we are
   * comparing the "cstmr1" object to the "cstmr2"
   * object and "cstmr1" has a higher balance, this
   * test will return an output of 1.
   */
    
   @Test public void compareToTest3() {
   
      Customer cstmr1 = new Customer("Lane, Jane");
      cstmr1.changeBalance(1000);
      
      Customer cstmr2 = new Customer("Lane, Lois");
      cstmr2.changeBalance(500);
      
      Assert.assertTrue(cstmr1.compareTo(cstmr2) > 0);
      
   }
   
}