import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*************************************************************************
 * Program represents a JUnit test file which allow the user to test all *
 * methods within the MonthlyCostComparator.java class.                  *
 *                                                                       *
 * Project 10                                                            *
 * @author Midas Oden                                                    *
 * @version November 22, 2019                                            *
 *************************************************************************/

public class MonthlyCostComparatorTest {

  /** Fixture initialization (common initialization for all tests). **/

   @Before public void setUp() {
   
   }

  /**
   * Tests the different ways monthly costs can be compared.
   */
   
   @Test public void monthlyCostCompareTest() {
   
      Cellular c1 = new Cellular("iPhone X", 100, 60, 1200, 2000);
      Cellular c2 = new Cellular("Samsung Galaxy", 100, 50, 1200, 2000);
      Cellular c3 = new Cellular("Google Pixel", 100, 50, 1200, 2000);
      
      MonthlyCostComparator costCompare = new MonthlyCostComparator();
      
      Assert.assertEquals(-1, costCompare.compare(c1, c2), 0);
      Assert.assertEquals(0, costCompare.compare(c2, c3), 0);
      Assert.assertEquals(1, costCompare.compare(c2, c1), 0);
   
   }

}
