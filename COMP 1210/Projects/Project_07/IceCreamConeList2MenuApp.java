import java.util.Scanner;
import java.io.FileNotFoundException;

/*****************************************************************************
 * Program when implemented creates an IceCreamListMenuApp class with a main *
 * method that presents the user with a menu with eight options. Each of the *
 * given options are implemented to do the following:                        *
 *                                                                           *
 *    (1) Read the input file and create an IceCreamConeList object          *
 *    (2) Print the IceCreamConeList object                                  *
 *    (3) Print the summary for the IceCreamConeList object                  *
 *    (4) Add an IceCreamCone object to the IceCreamConeList object          *
 *    (5) Delete an IceCreamCone object from the IceCreamConeList object     *
 *    (6) Find an IceCreamCone object in the IceCreamConeList object         *
 *    (7) Edit an IceCreamCone object in the IceCreamConeList object         *
 *    (8) Quit the program                                                   *
 *                                                                           *
 * Project 7                                                                 *
 * @author Midas Oden                                                        *
 * @version October 18, 2019                                                 *
 *****************************************************************************/


public class IceCreamConeList2MenuApp {

/**
 * This method gives the user 8 options to evaluate 
 * an IceCreamCone_data list file.
 * 
 * @param args (not used).
 * @throws FileNotFoundException if the file cannot be opened.
 */
 
   public static void main(String[] args) throws FileNotFoundException {
   
      String labelIn; // instance variable
      double radiusIn, heightIn; // instance variable(s)
   //~--------------------------------------------------------------------------
      String coneListName =  "*** no list name assigned ***";
      IceCreamCone[] noConeObject = new IceCreamCone[100];
      IceCreamConeList2 noConeList = 
               new IceCreamConeList2(coneListName, noConeObject, 0);
               
      String fileName = "no file name";
                 
      String userInput = "";
      Scanner scanInput = new Scanner(System.in);
   //~--------------------------------------------------------------------------
      System.out.println("IceCreamCone List System Menu\n"
                       + "R - Read File and Create IceCreamCone List\n"
                       + "P - Print IceCreamCone List\n" 
                       + "S - Print Summary\n"
                       + "A - Add IceCreamCone\n"   
                       + "D - Delete IceCreamCone\n"
                       + "F - Find IceCreamCone\n"
                       + "E - Edit IceCreamCone\n"
                       + "Q - Quit");
   //~--------------------------------------------------------------------------
      do {
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
                
         userInput = scanInput.nextLine();
         if (userInput.length() == 0) {
            continue;
         }
         userInput = userInput.toUpperCase();
         char charInput = userInput.charAt(0);
      
         switch(charInput) {
            case 'R': // Read in File and Create IceCreamConeList
               System.out.print("\tFile Name: ");
               fileName = scanInput.nextLine();
               noConeList = noConeList.readFile(fileName);
               
               System.out.println("\tFile read in and "
                  + "IceCreamCone List created\n");
               break;
               
            case 'P': // Print IceCreamConeList
               System.out.println(noConeList.toString());
               break;
               
            case 'S': // Print summary
               System.out.println("\n" + noConeList.summaryInfo());
               break;
            
            case 'A': // Add an IceCreamCone object
               System.out.print("\tLabel: ");
               labelIn = scanInput.nextLine();
               
               System.out.print("\tRadius: ");
               radiusIn = Double.parseDouble(scanInput.nextLine());
               
               System.out.print("\tHeight: ");
               heightIn = Double.parseDouble(scanInput.nextLine());
               
               noConeList.addIceCreamCone(labelIn, radiusIn, heightIn);
               
               System.out.println("\t*** IceCreamCone added ***\n");
               break;
               
            case 'D': // Delete IceCreamCone object
               System.out.print("\tLabel: ");
               labelIn = scanInput.nextLine();
               
               if (noConeList.findIceCreamCone(labelIn) != null) {
                  IceCreamCone obj = noConeList.deleteIceCreamCone(labelIn);
                  System.out.println("\t\"" + obj.getLabel() + "\" deleted\n");
               } 
               else {
                  System.out.println("\t\"" + labelIn + "\" not found\n");
               }
               break;
               
            case 'F': // Find IceCreamCone object
               System.out.print("\tLabel: ");
               labelIn = scanInput.nextLine();
               
               if (noConeList.findIceCreamCone(labelIn) != null) {
                  System.out.println(noConeList.findIceCreamCone(labelIn)
                                                      .toString() + "\n");
               } else {
                  System.out.println("\t\"" + labelIn + "\" not found\n");
               }
               break;
               
            case 'E': // Edit IceCreamCone object
               
               System.out.print("\tLabel: ");
               labelIn = scanInput.nextLine();
               System.out.print("\tRadius: ");
               radiusIn = Double.parseDouble(scanInput.nextLine());
               System.out.print("\tHeight: ");
               heightIn = Double.parseDouble(scanInput.nextLine());
               
               if (noConeList.findIceCreamCone(labelIn) != null) {
                  IceCreamCone obj = noConeList.findIceCreamCone(labelIn);
                  noConeList.editIceCreamCone(labelIn, radiusIn, heightIn);
                                             
                  System.out.println("\t\"" + labelIn 
                     + "\" successfully edited\n");
                     
               } else {
                  System.out.println("\t\"" + labelIn + "\" not found\n");
               }
               break;
               
            case 'Q': // Quit the program
               break;
               
            default: // No match, loop is ran again
               System.out.println("\t*** invalid code ***\n");
               
         }
      
      } while (!userInput.equalsIgnoreCase("Q"));
   
   }

}
//~--------------------------------------------------------------------------