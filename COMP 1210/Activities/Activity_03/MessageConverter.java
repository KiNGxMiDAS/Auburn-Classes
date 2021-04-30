  // Import user input
  
import java.util.Scanner;

/*************************************************************************************
 * Program will read in a message from the user and then require                     *
 * the user to enter a number. The following will happen based on                    *
 * the number entered by the user:                                                   *
 *     - If the user enters a 1, the message will be printed trimmed.                *
 *     - If the user enters a 2, the message will be printed in lower case.          *
 *     - If the user enters a 3, the message will be printed in upper case.          *
 *     - If the user enters a 4, the message will be printed with all vowels         *
 *       replaced with underscores.                                                  *
 *     - If the user enters a 5, the message will be printed without the             *
 *       first and last character.                                                   *
 *           ~~~ Any other number should generate an appropriate message ~~~         *
 *                                                                                   *
 * Activity 3                                                                       *
 * @author Midas Oden                                                              *
 * @version September 6, 2019                                                     *
 ********************************************************************************/
    
public class MessageConverter
{
    /**
     * User inputs a number and program will generate 
     * a message five different ways according to algorithm.
     *
     * @param args Command line arguments – not used.
     */
     
   public static void main(String[] args) {
   
      Scanner userInput = new Scanner(System.in);
      
      String message = "";
      String result = "";
      int outputType = 0;
      
      // Prompt the user to type a message
      System.out.print("Type in a message and press enter:\n\t>  ");
      message = userInput.nextLine();
      
      // Converts message to a specific output according to number entered
      System.out.print("\nOutput types:"
         + "\n\t0: As is "
         + "\n\t1: Trimmed"
         + "\n\t2: lower case"
         + "\n\t3: UPPER CASE"
         + "\n\t4: v_w_ls r_pl_c_d"
         + "\n\t5: Without first and last character"
         + "\n\t6: Display first half of String only"
         + "\n\t7: Display second half of String only"
         + "\nEnter your choice: ");
         
      outputType = Integer.parseInt(userInput.nextLine());
      
      if (outputType == 0) {
      
         result = message;
      }
      else if (outputType == 1) { // trimmed
      
         result = message.trim();
      }
      else if (outputType == 2) { // lower case
      
         result = message.toLowerCase();
      }
      else if (outputType == 3) { // upper case
      
         result = message.toUpperCase();
      }
      else if (outputType == 4) { // replace vowels
      
         result = message.replace('a', '_');
         result = result.replace('e', '_');
         result = result.replace('i', '_');
         result = result.replace('o', '_');
         result = result.replace('u', '_');
      }
      else if (outputType == 5) { // without first and last character
      
         result = message.substring(1, message.length() - 1);
      }
      else if (outputType == 6) { // display firstHalf of string only
         result = message.substring(0, message.length() / 2);
      }
      else if (outputType == 7) { // display lastHalf of string only
         result = message.substring(message.length() / 2);
      }
      else { // invalid input
      
         result = "Error: Invalid choice input.";
      }
      
      System.out.println("\n" + result);
         
   }
      
}