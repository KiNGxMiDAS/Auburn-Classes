/*****************************************************************************
 * Program designed to hold an integer value(s) and provide methods to       *
 * perform various mathematical operations on that value. Program will call  *
 * to NumberOperationsDriver.class to and initialise operations according to *
 * the methods in NumberOperations.java                                      *
 *                                                                           *
 * Activity 5                                                                *
 * @author Midas Oden                                                        *
 * @version September 24, 2019                                               *
 *****************************************************************************/
 
public class NumberOperations {

// Instance Variables

   private int number;

// Constructor

  /**
   * @param numberIn takes input for integer values 
   * from the NumberOperationsDriver.class
   */

   public NumberOperations(int numberIn) {
   
      number = numberIn;
   
   }
   
// Methods

  /**
   * Gets the integer values initiated by the user.
   *
   * @return Returns values after operations are initiated
   */

   public int getValue() {
   
      return number;
   
   }
   
  /**
   * @return Returns the output of the of odd integers under the input value
   */
   
   public String oddsUnder() {
   
      String output = "";
      int i = 0;
      while (i < number) {
         if (i % 2 != 0) {
            output += i + "\t";
         }
         i++;
      }
      
      return output;
   
   }
   
  /**
   * @return Returns the output of the powers of 2 under the input value 
   */

   public String powersTwoUnder() {
   
      String output = "";
      int powers = 1;
      while (powers < number) {
         output += powers + "\t"; // concatenate to output
         powers = powers * 2; // get next power of 2
      }
      
      return output;
   
   }
   
  /**
   * @param compareNumber input for integer to compare
   * @return Returns a positive or negative integer or 0 depending
   *         if number is greater, lesser, or equal to input value.
   */
   
   public int isGreater(int compareNumber) {
   
      if (number > compareNumber) {
         return 1;
      }
      else if (number < compareNumber) {
         return -1;
      }
      else {
         return 0;
      }
   
   }
   
  /**
   * @return Returns a string of numbers after NumberOperationsDriver 
   *         is initiated.
   */
   
   public String toString() {
   
      return number + "";
   
   }
   
}