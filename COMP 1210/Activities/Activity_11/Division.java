/******************************************************************************
 * Program will get integer input from the user and will then perform integer *
 * and decimal division.                                                      *
 *                                                                            *
 * Activity 11                                                                *
 * @author Midas Oden                                                         *
 * @version November 18, 2019                                                 *
 ******************************************************************************/

public class Division {

  /**
   * @param numerator takes input for numerator
   * @param denominator takes input for the denominator
   * @return returns the integer value from the division
   */
  
   public static int intDivide(int numerator, int denominator) {
      try {
         return numerator / denominator;
      } catch (ArithmeticException e) {
         return 0;
      }
   }

  /**
   * @param numerator takes input for numerator
   * @param denominator takes input for the denominator
   * @return returns the float value from the division
   */
   
   public static float decimalDivide(int numerator, int denominator) {
      if (denominator == 0) {
         throw new IllegalArgumentException("The demoninator "
              + "cannot be zero");
      }
      return (float) numerator / denominator;
   }
}