/*****************************************************************************
 * Program that will store information regarding a bank loan. A user is able *
 * to input a customer's name, a specified interest rate, and the balance of *
 * the loan.                                                                 *
 *                                                                           *
 * Activity 8A                                                               *
 * @author Midas Oden                                                        *
 * @version October 21, 2019                                                 *
 *****************************************************************************/
 
public class BankLoan {

// Constant Fields
   private static final int MAX_LOAN_AMOUNT = 100000;

// Instance Variables (can be used within the class)
   private String customerName;
   private double balance, interestRate;
   
 /*^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-*/
   private static int loansCreated = 0;
 /*^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-*/

// Constructor

  /**
   * Constructor for the BankLoan.java class.
   *
   * @param customerNameIn takes input for the user's name.
   * @param interestRateIn takes input for the set interest rate.
   */

   public BankLoan(String customerNameIn, double interestRateIn) {
    
      customerName = customerNameIn;
      interestRate = interestRateIn;
      balance = 0;
      loansCreated++;
      
   }
   
  /**
   * Check to see if a bank load was made and
   * returns a boolean value.
   *
   * @param amount represents the the input for the specified amount.
   * @return if a loan was made
   */

   public boolean borrowFromBank(double amount) {
      
      boolean wasLoanMade = false;
      
      if (balance + amount < MAX_LOAN_AMOUNT) {
         wasLoanMade = true;
         balance += amount;
         
      }
   
      return wasLoanMade;
      
   }
   
  /**
   * Check to see how much the user will need to pay
   * the bank and return a double value.
   *
   * @param amountPaid represents the input for the amount paid.
   * @return the amount the user would need to pay the bank
   */

   public double payBank(double amountPaid) {
   
      double newBalance = balance - amountPaid;
      if (newBalance < 0) {
         balance = 0;
         // paid too much, return the overcharge
         return Math.abs(newBalance);
      } else {
         balance = newBalance;
         return 0;
         
      }
      
   }
   
  /**
   * @return the balance
   */
   
   public double getBalance() {
   
      return balance;
      
   }
   
  /**
   * Takes in a specified interest rate and returns
   * a boolean value if the interest rate was set.
   *
   * @param interestRateIn takes in the interest rate for the user.
   * @return if the interest rate was set
   */
   
   public boolean setInterestRate(double interestRateIn) {
   
      if (interestRateIn >= 0 && interestRateIn <= 1) {
         interestRate = interestRateIn;
         return true;
      } else {
         return false;
         
      }
      
   }
   
  /**
   * @return the interest rate
   */
   
   public double getInterestRate() {
   
      return interestRate;
      
   }
   
  /**
   * This method will charge additional interest if necessary.
   */

   public void chargeInterest() {
   
      balance = balance * (1 + interestRate);
      
   }
   
  /**
   * Prints information regarding the customer, the interest
   * rate, and the balance amount to the string method.
   *
   * @return the output of the above information
   */
   
   public String toString() {
   
      String output = "Name: " + customerName + "\r\n" 
         + "Interest rate: " + interestRate + "%\r\n" 
         + "Balance: $" + balance + "\r\n";
      return output;
      
   }
   
   //----------------------------------------------------------------------//
 //                         BEGINNING OF ACTIVITY 8A                         //
  //----------------------------------------------------------------------//

  /**
   * Method returns true if a loan amount is valid and
   * false otherwise.
   *
   * @param amount represents input for the loan amount.
   * @return if it is a valid amount (greater than zero)
   */
   
   public static boolean isAmountValid(double amount) {
   
      return amount >= 0;
   
   }
   
  /**
   * Method returns true if the loan's balance is greater
   * than zero and false otherwise.
   *
   * @param loan input for the loan object
   * @return if the user is in debt
   */
   
   public static boolean isInDebt(BankLoan loan) {
   
      if (loan.getBalance() > 0) {
         return true;
      }
   
      return false;
   
   }
   
  /**
   * @return the amount of loans created
   */
   
   public static int getLoansCreated() {
   
      return loansCreated;
   
   }
   
  /**
   * Reset the amount of loans created to zero.
   */
   
   public static void resetLoansCreated() {
   
      loansCreated = 0;
   
   }

}
