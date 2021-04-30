import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
  
/*****************************************************************************
 * This class will call to the arguments used in IceCreamCone.class file     *
 * and the methods used in the IceCreamConeList.class file. This driver      *
 * program will read user input which will allow user to enter in the name   *
 * of a text file. The program will then read in the text file and output    * 
 * data regarding the IceCreamCone objects. The program will then print out  *
 * the object's information.                                                 *
 *                                                                           *
 * Project 5                                                                 *
 * @author Midas Oden                                                        *
 * @version October 4, 2019                                                  *
 *****************************************************************************/
 
public class IceCreamConeListApp {

  /**
   * This method prints out an IceCreamConeList.
   *
   * @param args Command line arguments – not used.
   * @throws IOException for scanning text file.
   */
   
   public static void main(String[] args) throws IOException {
    
      ArrayList<IceCreamCone> myList = new ArrayList<IceCreamCone>();
      String coneListName = "";
      String labelIn = "";
      double radiusIn = 0;
      double heightIn = 0;
      Scanner userInput = new Scanner(System.in);
      
   // Output of object information
   
    // Enter the label, radius, and height of the object     
      System.out.print("Enter file name: ");
      String fileName = userInput.nextLine();
   
      Scanner scanFile = new Scanner(new File(fileName));
      coneListName = scanFile.nextLine();
   
      while (scanFile.hasNext()) {
         labelIn = scanFile.nextLine();
         radiusIn = Double.parseDouble(scanFile.nextLine());
         heightIn = Double.parseDouble(scanFile.nextLine());
      
         IceCreamCone newCone = new IceCreamCone(labelIn, radiusIn, heightIn);
         myList.add(newCone);
      
      }
      scanFile.close();
   
      IceCreamConeList myConeList = new IceCreamConeList(coneListName, myList);
      
   // Prints out summary of IceCreamCone object
      System.out.println("\n" + myConeList);
      System.out.println("\n" + myConeList.summaryInfo());
         
   }

}