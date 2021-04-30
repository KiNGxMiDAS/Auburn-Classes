/*****************************************************************************
 * Driver program that will call to the methods in the Temperature.java file.*
 * This program will allow the user to input a list of temperatures that are *
 * read in as integers, one per line. Each of the corresponding temperature  *
 * values are added to tempsList until the user presses enter with no value  *
 * to indicate that there are no more temperatures to input. The user will   *
 * then be given a menu with a list of options to select from: [L]ow temp,   *
 * [H]igh temp, [P]rint, [E]nd where ‘L' prints the low temperature, ‘H’     *
 * prints the high temperature, ‘P’ prints the Temperatures object temps,    *
 * ‘E’ ends the the program (i.e., ends the do while loop).                  *
 *                                                                           *
 * Activity 7 (Chapter 8)                                                                *
 * @author Midas Oden                                                        *
 * @version October 14, 2019                                                  *
 *****************************************************************************/

public class Scores {

   private int[] numbers;

   /**
    *
    * @param numbersIn takes in numbers and assigns it
    */
   public Scores(int[] numbersIn) {
      numbers = numbersIn;
   }

   /**
    *
    * @return returns the evens in the array
    */
   public int[] findEvens() {
   
      int numberEvens = 0;
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] % 2 == 0) {
            numberEvens++;
         }
      }
      
      int[] evens = new int[numberEvens];
      
      int count = 0;
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] % 2 == 0) {
            evens[count] = numbers[i];
            count++;
         }
      }
      return evens;
   }

   /**
    *
    * @return returns the odds in the array
    */
   public int[] findOdds() {
      int numberOdds = 0;
      
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] % 2 == 0) {
            numberOdds++;
         }
      }
      
      int[] odds = new int[numberOdds];
      
      int count = 0;
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] % 2 != 0) {
            odds[count] = numbers[i];
            count++;
         }
      }
      return odds;
   }

   /**
    *
    * @return returns the average of all elements in the array
    */
   public double calculateAverage() {
      int sum = 0;
      
      for (int i = 0; i < numbers.length; i++) {
         sum += numbers[i];
      }
      return sum / numbers.length;
   }

   /**
    *
    * @return returns the array
    */
   public String toString() {
      String result = "";
      for (int i = 0; i < numbers.length; i++) {
         result += numbers[i] + "\t";
      }
      return result;
   }

   /**
    *
    * @return returns the array in reverse
    */
   public String toStringInReverse() {
      String result = "";
      for (int i = numbers.length - 1; i >= 0; i--) {
         result += numbers[i] + "\t";
      }
      return result;
   }
}