  // Import user input
  
import java.util.Scanner;

/**
 * Program will allow user to enter three integers assigned to  
 * variables x, y, and z and then solves for the indicated formula: 
 * [(3x + 10.5)(2y + 7.5)(z + 5.5)] / xyz. If xyz is equal to zero, then  
 * result is zero.
 * 
 * Project 2
 * @author Midas Oden
 * @version September 3, 2019
 */
    
public class Formula
{
    /**
     * User inputs three integer values and program 
     * will solve for the result of a specified formula
     * after reading input values for x, y, and z.
     *
     * @param args Command line arguments – not used.
     */
     
   public static void main(String[] args) 
   {
   
      Scanner userInput = new Scanner(System.in);
      double x, y, z, result;
      System.out.println("result = (3x + 10.5) (2y + 7.5) (z + 5.5) / xyz");
      
      System.out.print("\tEnter x: ");
      x = userInput.nextDouble();
      
      System.out.print("\tEnter y: ");
      y = userInput.nextDouble();
      
      System.out.print("\tEnter z: ");
      z = userInput.nextDouble();
   
      if (x == 0 || y == 0 || z == 0) {
         result = 0.0;
      }
           
      else {
         result = (((3 * x + 10.5) * (2 * y + 7.5) * (z + 5.5)) / (x * y * z));
      }
      
      System.out.println("result = " + result);
      
   }
    
}