/*****************************************************************************
 * Program designed to hold an array of numerical values and provide methods  *
 * that allows the user to interact the Scores class.                        *
 *                                                                           *
 * Activity 7 (Chapter 8)                                                    *
 * @author Midas Oden                                                        *
 * @version October 14, 2019                                                 *
 *****************************************************************************/

public class Scores {

// Instance Variables (Fields)

   private int[] numbers;

// Constructor

   /**
    * @param numbersIn takes in numbers and assigns it
    */
    
   public Scores(int[] numbersIn) {
   
      numbers = numbersIn;
   
   }

   /**
    * @return the even numbers in the array
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
    * @return the odd numbers in the array
    */
    
   public int[] findOdds() {
   
      int numberOdds = 0;    
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] % 2 != 0) {
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