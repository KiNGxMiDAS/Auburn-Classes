import java.util.Scanner;
  
/*****************************************************************************
 * This class will call to the arguments used in IceCreamCone.class file     *
 * This driver program will read user input and print information regarding  *
 * what the user decides based on: label, radius, and height. After a value  *
 * is read in for radius, if the value is less than or equal to zero, an     *
 * appropriate message is to be printed followed by a return from the main   *
 * method. This is also similar for the height. After these values are read  *
 * in, the main method creates an IceCreamCone object and will then print a  *
 * new line with the information regarding the object.                       *
 *                                                                           *
 * Project 4                                                                 *
 * @author Midas Oden                                                        *
 * @version September 18, 2019                                               *
 *****************************************************************************/
 
public class IceCreamConeApp {

  /**
   * User inputs the label, radius, and height of
   * an IceCreamCone object and output information
   * pertaining to the created object.
   *
   * @param args Command line arguments – not used.
   */
   
   public static void main(String[] args) {
    
      String label;
      String output;
      double radius;
      double height;
      Scanner userInput = new Scanner(System.in);
      
   // Output of object information
   
    // Enter the label, radius, and height of the object     
      System.out.println("Enter label, radius, and height"
         + " for an ice cream cone.");
   
      System.out.print("\tlabel: ");
      label = userInput.nextLine();
   
      System.out.print("\tradius: ");
      radius = Double.parseDouble(userInput.nextLine());
      
    // Program terminates if radius is less than or equal to zero
      if (radius <= 0) {
         System.out.println("Error: radius must be greater than 0.");
         return;
      }
      
      System.out.print("\theight: ");
      height = Double.parseDouble(userInput.nextLine());
      
    // Program terminates if height is less than or equal to zero
      if (height <= 0) {
         System.out.println("Error: height must be greater than 0.");
         return;
      }
      
      System.out.println();
      
    // Create a new IceCreamCone object
      IceCreamCone newCone = new IceCreamCone(label, radius, height);
      
    // Call to IceCreamCone.class and print object information
      System.out.println(newCone.toString());
    
   }

}