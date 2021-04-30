import java.util.Scanner;
import java.util.ArrayList;
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
 * Project 6                                                                 *
 * @author Midas Oden                                                        *
 * @version October 11, 2019                                                 *
 ******************************************************************************/


public class IceCreamConeListMenuApp {

/**
 * This method gives the user 8 options to evaluate 
 * an IceCreamCone_data list file.
 * 
 * @param args (not used).
 * @throws FileNotFoundException if the file cannot be opened.
 */
 
   public static void main(String[] args) throws FileNotFoundException {
   
      String listName =  "*** no list name assigned ***";
      ArrayList<IceCreamCone> myList = 
         new ArrayList<IceCreamCone>();
         
      IceCreamConeList iceCreamConeObjList = 
         new IceCreamConeList(listName, myList);
    
      IceCreamCone findLabel = new IceCreamCone("", 0, 0);
      IceCreamCone deleteLabel = new IceCreamCone("", 0, 0);
         
      String fileName = "no file name";
      
      String label;
      double radius, height;
      
      String userInput = "";
      
      Scanner scanInput = new Scanner(System.in);
      
      System.out.println("IceCreamCone List System Menu\n"
                       + "R - Read File and Create IceCreamCone List\n"
                       + "P - Print IceCreamCone List\n" 
                       + "S - Print Summary\n"
                       + "A - Add IceCreamCone\n"   
                       + "D - Delete IceCreamCone\n"
                       + "F - Find IceCreamCone\n"
                       + "E - Edit IceCreamCone\n"
                       + "Q - Quit");
                       
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
            
               iceCreamConeObjList = iceCreamConeObjList.readFile(fileName);
            
               System.out.println("\tFile read in and "
                  + "IceCreamCone List created\n");
               break;
               
            case 'P': // Print IceCreamConeList
               System.out.println(iceCreamConeObjList);
               break;
               
            case 'S': // Print summary
               System.out.println("\n" + iceCreamConeObjList.summaryInfo());
               break;
            
            case 'A': // Add an IceCreamCone object
               System.out.print("\tLabel: ");
               label = scanInput.nextLine();
               
               System.out.print("\tRadius: ");
               radius = Double.parseDouble(scanInput.nextLine());
               
               System.out.print("\tHeight: ");
               height = Double.parseDouble(scanInput.nextLine());
               
               iceCreamConeObjList.addIceCreamCone(label, radius, height);
               
               System.out.println("\t*** IceCreamCone added ***\n");
               break;
               
            case 'D': // Delete IceCreamCone object
               System.out.print("\tLabel: ");
               
               label = scanInput.nextLine();
               deleteLabel.setLabel(label);
               
               if (iceCreamConeObjList.findIceCreamCone(label) != null) {
                  IceCreamCone obj = iceCreamConeObjList
                                          .deleteIceCreamCone(label);
                  System.out.println("\t\"" + obj.getLabel() 
                     + "\" deleted\n");
               } 
               else {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               break;
               
            case 'F': // Find IceCreamCone object
               System.out.print("\tLabel: ");
               label = scanInput.nextLine();
               
               if (iceCreamConeObjList.findIceCreamCone(label) != null) {
                  System.out.println(iceCreamConeObjList.findIceCreamCone(label)
                                                      .toString() + "\n");
               } else {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               break;
               
            case 'E': // Edit IceCreamCone object
               
               System.out.print("\tLabel: ");
               label = scanInput.nextLine();
               System.out.print("\tRadius: ");
               radius = Double.parseDouble(scanInput.nextLine());
               System.out.print("\tHeight: ");
               height = Double.parseDouble(scanInput.nextLine());
               
               if (iceCreamConeObjList
                        .findIceCreamCone(label) != null) {
                  IceCreamCone obj = iceCreamConeObjList
                                          .findIceCreamCone(label);
                  iceCreamConeObjList.editIceCreamCone(label, radius, height);
                  System.out.println("\t\"" + obj.getLabel() 
                     + "\" successfully edited\n");
               } 
               else {
                  System.out.println("\t\"" + label + "\" not found\n");
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