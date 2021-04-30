import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**************************************************************************
 * Program represents a JUnit test file which allow the user to test all  *
 * methods within the WirelessNetworkPart2.java class files.              *
 *                                                                        *
 * Project 10                                                             *
 * @author Midas Oden                                                     *
 * @version November 22, 2019                                             *
 **************************************************************************/

public class WirelessNetworksPart2Test {

  /** Fixture initialization (common initialization for all tests). **/

   @Before public void setUp() {
   
   }
   
  /**
   * This test method will invoke main with no command line argument.
   *
   * @throws Exception throws exception for the file
   */

   @Test public void mainTest1() throws Exception {
   
      WirelessNetworksPart2 app = new WirelessNetworksPart2();
      String[] args1 = {};
      WirelessNetworksPart2.main(args1);
      
      Assert.assertEquals(44, WirelessNetwork.getCount());
   }

  /**
   * This test method will invoke main with the file name as the first
   * and only command line argument.
   *
   * @throws Exception throws exception for the file
   */

   @Test public void mainTest2() throws Exception {
   
      WirelessNetworksPart2 app = new WirelessNetworksPart2();
      String[] args2 = {"wireless_network_data1.csv"};
      WirelessNetworksPart2.main(args2);
      
      Assert.assertEquals(48, WirelessNetwork.getCount());  
   }   
}