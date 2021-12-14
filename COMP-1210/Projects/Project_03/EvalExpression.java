  // Import user input
  
import java.util.Scanner;
import java.text.DecimalFormat;
  
/**
 * Program will evaluate the expression in the formula below for a 
 * value 'x' of the type double. The methods: pow(), sqrt(), and abs() 
 * of the Math class are used to perform the calculation. The program will
 * then determine the number of characters (mostly digits) to the left and to 
 * the right of the decimal point in the unformatted result. Finally, the result
 * is printed using the class java.text.DecimalFormat so that to the right of 
 * the decimal there are at most four digits and to the left of the decimal 
 * each group of three digits is separated by a comma in the traditional way.
 * 
 * Project 3
 * @author Midas Oden
 * @version September 10, 2019
 */
    
public class EvalExpression
{
    /**
     * Program will compute the value generated
     * by a specified expression.
     *
     * @param args Command line arguments – not used.
     */
     
   public static void main(String[] args) 
   {
   
      Scanner userInput = new Scanner(System.in);
      
      String numbers;
      double x = 0;
      double result = 0;
      int index = 0;
      int leftNumbers = 0;
      int rightNumbers = 0;
               
      System.out.print("Enter a value for x: ");
      x = Double.parseDouble(userInput.nextLine());
      
      result = ((12.4 * Math.pow(x, 6) - 1.2 * Math.pow(x, 3)) 
               + Math.sqrt(Math.abs(2.6 * Math.pow(x, 5) - 6.8 
               * x + 7))) / (Math.pow(x, 4) + 9);
      
      System.out.println("Result: " + result);
      
      numbers = Double.toString(result);
      index = numbers.indexOf('.');
      String numbersToTheLeft = numbers.substring(0, index);
      String numbersToTheRight = numbers.substring(index + 1, numbers.length());
      leftNumbers = numbersToTheLeft.length();
      rightNumbers = numbersToTheRight.length();
      
      DecimalFormat numberFormat = new DecimalFormat("#,##0.0###");
      
      System.out.println("# of characters to left of decimal point: " 
         + leftNumbers);
      System.out.println("# of characters to right of decimal point: " 
         + rightNumbers);
      System.out.println("Formatted Result: " + numberFormat.format(result));
               
   }
     
}