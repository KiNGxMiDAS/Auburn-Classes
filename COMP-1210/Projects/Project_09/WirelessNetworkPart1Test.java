import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**************************************************************************
 * Program represents a JUnit test file which allow the user to test all  *
 * methods within the WirelessNetworkPart1.java class files.              *
 *                                                                        *
 * Project 9                                                              *
 * @author Midas Oden                                                     *
 * @version November 7, 2019                                              *
 **************************************************************************/

public class WirelessNetworkPart1Test {

     /** Fixture initialization (common initialization for all tests). **/

   @Before public void setUp() {
   
   }
   
   @Test public void mainTest() {
   
      WirelessNetwork.resetCount();
      WirelessNetworkPart1.main(null);
      Assert.assertEquals("WirelessNetwork count should be 4. ",
         4, WirelessNetwork.getCount());
   }

}