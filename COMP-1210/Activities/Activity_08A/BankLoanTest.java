import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*****************************************************************************
 * Program represents a JUnit test file which allow the user to test the     *
 * method in the BankLoan.java class. This particular test file includes     *
 * a test method that essentially includes the statements that the user      *
 * would enter as interactions to informally test the chargeInterest()       *
 * method.                                                                   *
 *                                                                           *
 * Activity 8A                                                               *
 * @author Midas Oden                                                        *
 * @version October 21, 2019                                                 *
 *****************************************************************************/

public class BankLoanTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   
   }
   
  /**
   * This method will test the chargeInterest() method in the
   * BankLoan.java class file.
   */
   
   @Test public void chargeInterestTest() {
   
      BankLoan loan1 = new BankLoan("Jane", .10);
      loan1.borrowFromBank(1000.00);
      loan1.chargeInterest();
      Assert.assertEquals(" ", 1100, loan1.getBalance(), .000001);
   
   }



   /** A test that always fails. **/
   @Test public void defaultTest() {
   
   }
   
}