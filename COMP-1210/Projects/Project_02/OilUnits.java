  // Import user input
  
import java.util.Scanner;

/**
 * Program will allow user to enter a whole number value that 
 * represents oil in ounces. Program then displays the number of 
 * barrels, gallons, quarts, and ounces. The number of each of these 
 * will be maximised from largest to smallest. The output will display
 * the following conversion values:
 *     1 barrel = 42 gallons, 1 gallon = 128 ounces, 1 quart = 32 ounces
 * 
 * The program will terminate if the input value
 * exceeds over 1 billion.
 * 
 * Project 2
 * @author Midas Oden
 * @version September 3, 2019
 */
    
public class OilUnits
{
    /**
     * User inputs a whole number value amount 
     * that represents oil in ounces and determines 
     * the number of barrels, gallons, quarts, and ounces.
     *
     * @param args Command line arguments – not used.
     */
     
   public static void main(String[] args) 
   {
   
      Scanner oilInOunces = new Scanner(System.in);
      
      int oil = 0;
      int barrels = 0;
      int gallons = 0;
      int quarts = 0;
      int ounces = 0;
      
      // Prompt the user for an oil amount
      System.out.print("Enter amount of oil in ounces: ");
      oil = oilInOunces.nextInt();
      
      // Program terminates if any number larger than 1 billion is entered!
      if (oil > 1000000000) {
         System.out.println("Amount must not exceed 1,000,000,000.");
         
      }
      else {
      // Find the unit conversions from the user input
      
         // first barrels...
         barrels = oil / 5376;
         oil = oil % 5376;
         // now gallons...
         gallons = oil / 128;
         oil = oil % 128;
         // now quarts...
         quarts = oil / 32;
         oil = oil % 32;
         // finally ounces...
         ounces = oil;
      
      // Displays the amount of oil with respect to the defined units
         System.out.println("Oil amount in units: ");
         System.out.println("\tBarrels: " + barrels 
                           + "\n\tGallons: " + gallons
                           + "\n\tQuarts: " + quarts
                           + "\n\tOunces: " + ounces);
                           
      // Break down input value into given units
         oil = (barrels * 5376 + gallons * 128 + quarts * 32 + ounces);
      // Display amount break down! 
         System.out.println(oil + " oz = (" + barrels + " bl * 5376 oz) + ("
                                + gallons + " gal * 128 oz) + (" 
                                + quarts + " qt * 32 oz) + (" 
                                + ounces + " oz)");
        
      }
        
   }
      
}