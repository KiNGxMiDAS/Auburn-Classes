  // Import user input
  
import java.util.Scanner;

/**
 * Simple program to display a person's name, age, and gender, along
 * with calculations for age in minutes and centuries as well
 * as the max heart rate based on the age and gender.
 *
 * Activity 2
 * @author Midas Oden
 * @version August 28, 2019
 */
    
public class AgeStatistics
{
    /**
     * User inputs a name, age, and gender and will
     * then calculate for the age and maximum heart rate
     * when given the age and gender.
     *
     * @param args Command line arguments – not used.
     */
     
   public static void main(String[] args) 
   {
   
      Scanner userInput = new Scanner(System.in);
      String name = "";
      int ageInYears;
      int gender;
      double maxHeartRate = 0;
      
      // Prompt the user for their name
      System.out.print("Enter your name: ");
      name = userInput.nextLine();
      
      // Prompt the user for their age
      System.out.print("Enter your age in years: ");
      ageInYears = userInput.nextInt();
      
      // Prompt the user for the gender
      System.out.print("Enter your gender (1 for female and 0 for male): ");
      gender = userInput.nextInt();
      
      // Convert age from years to minutes
      System.out.println("\tYour age in minutes is " 
                              + ageInYears * 525600 + " minutes.");
      
      // Convert age from years to centuries
      System.out.println("\tYour age in centuries is " 
                              + (double) ageInYears / 100 + " centuries.");
                              
      // Display maximum heart rate
      System.out.print("Your max heart rate is ");
      
      if (gender == 1) { 
      // calculate female MHR
         maxHeartRate = 209 - (0.7 * ageInYears);
      }
      else { 
      // calculate male MHR
         maxHeartRate = 214 - (0.8 * ageInYears);
      }
      // Displays maximum calculated heart rate according to gender
      System.out.println(maxHeartRate 
                           + " beats per minute.");                        
   }

}