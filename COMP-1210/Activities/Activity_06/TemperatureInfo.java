import java.util.Scanner;
import java.util.ArrayList;
  
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
 * Activity 6                                                                *
 * @author Midas Oden                                                        *
 * @version October 6, 2019                                                  *
 *****************************************************************************/


public class TemperatureInfo {

  /**
   * This method will give the user a menu with a list of
   * options enabling them to print out information regarding
   * temperature values.
   *
   * @param args Command line arguments – not used.
   */
   
   public static void main(String[] args) {
   
   // Read in input from the designated user
      Scanner userInput = new Scanner(System.in);
   // Create an ArrayList that holds temperature values
      ArrayList<Integer> tempsList = new ArrayList<Integer>();
   
   // Loop will read in temperature values and are then added to tempsList
      String tempInput = "";
      do {
         System.out.print("Enter a temperature (or nothing to end list): ");
         tempInput = userInput.nextLine().trim();
         if (!tempInput.equals("")) {
            tempsList.add(Integer.parseInt(tempInput));
         }
      
      } while (!tempInput.equals(""));
   
   // Creates a Temperatures object with the tempsList
      Temperatures temps = new Temperatures(tempsList);
      
   // Creates a menu with choices that allows the user to select from
      char choice = 'E';
      do {
         System.out.print("Enter choice - [L]ow temp, [H]igh temp, "
                        + "[P]rint, [E]nd: ");
         choice = userInput.nextLine().toUpperCase().charAt(0);
         switch (choice) {
            case 'L':
               System.out.println("\tLow is " + temps.getLowTemp());
               break;
         
            case 'H':
               System.out.println("\tHigh is " + temps.getHighTemp());
               break;
               
            case 'P':
               System.out.println(temps);
               break;
         //Program will terminate if this choice is selected      
            case 'E':
               System.out.println("\tDone");
               break;
               
            default:
               System.out.println("\tInvalid choice!");
         }
         
      } while (choice != 'E');
   
   }

}