import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.io.FileNotFoundException;
  
/*****************************************************************************
 * Program that will stores the name of the IceCreamCone list and an         *
 * ArrayList of IceCreamCone object. It also includes methods that return    *
 * the name of the list, the number of IceCreamCone objects, total surface   *
 * area, total volume, average surface area, and the average volume.         *
 *                                                                           *
 * Project 6                                                                 *
 * @author Midas Oden                                                        *
 * @version October 11, 2019                                                 *
 ******************************************************************************/
 
public class IceCreamConeList
{

// Instance Variables (Fields)

   private String listName;
   private ArrayList<IceCreamCone> iceCreamConeObjList;

// Constructor

  /**
   * Constructor creates the IceCreamCone list.
   *
   * @param listNameIn takes input of the list name.
   * @param iceCreamConeObjListIn is the array list of the cone 
   *        objects given by the user.
   */

   public IceCreamConeList(String listNameIn, 
                  ArrayList<IceCreamCone> iceCreamConeObjListIn) {
   
      listName = listNameIn;
      iceCreamConeObjList = iceCreamConeObjListIn;
      
   }
   
// Methods

  /**
   * This methods returns the list name.
   *
   * @return Returns the name of the list
   */

   public String getName() {
   
      return listName;
   
   }
   
  /**
   * This methods returns the number of cones in the list.
   *
   * @return Returns the list size
   */
   
   public int numberOfIceCreamCones() {
   
      return iceCreamConeObjList.size();
   }
   
  /**
   * This methods calculates the total surface area of the cone.
   * 
   * @return Returns the total
   */

   public double totalSurfaceArea() {
   
      double total = 0;
      int index = 0;
      while (index < iceCreamConeObjList.size()) {
         total += iceCreamConeObjList.get(index).surfaceArea();
         index++;
      
      }
      
      return total;
   
   }
   
  /**
   * This methods calculates the total volume of the cone.
   *
   * @return Returns the total
   */
   
   public double totalVolume() {
   
      double total = 0;
      int index = 0;
      while (index < iceCreamConeObjList.size()) {
         total += iceCreamConeObjList.get(index).volume();
         index++;
      }
      return total;      
   }
   
  /**
   * This methods calculates the average surface area of the cone.
   *
   * @return Returns the total
   */

   public double averageSurfaceArea() {
   
      double total = 0;
      int index = 0;
      while (index < iceCreamConeObjList.size()) {
         total += (iceCreamConeObjList.get(index).surfaceArea());
         index++;
      }
         
      if (index == 0) {
         total = 0;
      }
      else {
         total = total / index;
      }
      
      return total;
   
   }
   
  /**
   * This methods calculates the average colume of the cone.
   *
   * @return Returns the total
   */
   
   public double averageVolume() {
   
      double total = 0;
      int index = 0;
      while (index < iceCreamConeObjList.size()) {
         total += (iceCreamConeObjList.get(index).volume()); 
         index++;
      }
      
      if (index == 0) {
         total = 0;
      }
      else {
         total = total / index;
      }
   
      return total;
   }
   
  /**
   * This method prints the information of the IceCreamCone list.
   *
   * @return Returns a the cone information
   */
   
   public String toString() {
   
      String result = listName + "\n";  
      int index = 0;
      while (index < iceCreamConeObjList.size()) {
         result += "\n" + iceCreamConeObjList.get(index) + "\n";
         index++;
      }
      
      return result;
      
   }
   
  /**
   * This method prints the information of the IceCreamCone list.
   *
   * @return the String representation of the IceCreamConeListSummary
   */
   
   public String summaryInfo() {
   
      DecimalFormat thisFormat = new DecimalFormat("#,##0.0##");
      
      return "----- Summary for " + getName() 
            + " -----\n" + "Number of IceCreamCone Objects: " 
            + numberOfIceCreamCones() + "\n" + "Total Surface Area: " 
            + thisFormat.format(totalSurfaceArea()) + "\n" + "Total Volume: " 
            + thisFormat.format(totalVolume()) + "\n"
            + "Average Surface Area: " 
            + thisFormat.format(averageSurfaceArea()) + "\n"
            + "Average Volume: " + thisFormat.format(averageVolume()) + "\n";
            
   }
   
  //------------------------------------------------------------------------//
 //                         BEGINNING OF PROJECT 6                           //
  //------------------------------------------------------------------------//

   
  /**
   * @return an ArrayList of ice cream cone objects
   */
   
   public ArrayList<IceCreamCone> getList() {
   
      return iceCreamConeObjList;
   
   }
   
  /**
   * Reads in ice cream cone data from the file and creates an
   * IceCreamConeList object.
   *
   * @param fileNameIn for fileName to read
   * @return IceCreamConeList
   * @throws FileNotFoundException if the file cannot be opened.
   */
   
   public IceCreamConeList readFile(String fileNameIn) 
                  throws FileNotFoundException {
   
      Scanner scanFile = new Scanner(new File(fileNameIn));
      ArrayList<IceCreamCone> newList = 
         new ArrayList<IceCreamCone>();
      
      String newListName = "";
      String label = "";
      double radius, height = 0;
      
      listName = scanFile.nextLine();
      
      while (scanFile.hasNext()) {
         label = scanFile.nextLine();
         radius = Double.parseDouble(scanFile.nextLine());
         height = Double.parseDouble(scanFile.nextLine());
         
         IceCreamCone iceCreamConeObject = 
            new IceCreamCone(label, radius, height);
            
         newList.add(iceCreamConeObject);
         
      }
   
      IceCreamConeList iCCL = 
         new IceCreamConeList(listName, newList);
   
      return iCCL;
      
   }
   
  /**
   * Add an IceCreamCone object to the list.
   *
   * @param labelIn Label of Ice Cream Cone object.
   * @param radiusIn Radius of Ice Cream Cone object.
   * @param heightIn Height of Ice Cream Cone object.
   */
   
   public void addIceCreamCone(String labelIn, 
                     double radiusIn, double heightIn) {
   
      IceCreamCone iceCreamConeObject = 
         new IceCreamCone(labelIn, radiusIn, heightIn);
         
      iceCreamConeObjList.add(iceCreamConeObject);
   
   }
   
  /**
   * Finds IceCreamCone object from the list.
   *
   * @param labelIn takes the label of an IceCreamCone as a String
   * and searches in the ArrayList for the object.
   * @return the object found in the ArrayList, otherwise return
   * null.
   */
   
   public IceCreamCone findIceCreamCone(String labelIn) {
   
      for (IceCreamCone iceCreamConeObject : iceCreamConeObjList) {
         if (iceCreamConeObject.getLabel().equalsIgnoreCase(labelIn)) {
            return iceCreamConeObject;
            
         }
      
      }
      
      return null;
          
   }        
   
  /**
   * Deletes an Ice Cream Cone from the list.
   *
   * @param labelIn for the ice cream cone label.
   * @return the object deleted from the ArrayList.
   */
 
   public IceCreamCone deleteIceCreamCone(String labelIn) {
   
      int index = iceCreamConeObjList.indexOf(findIceCreamCone(labelIn));
      
      if (index >= 0) {
         return iceCreamConeObjList.remove(index);
      } 
      else {
         return null;
         
      }
      
   }
      
  /**
   * Edits an Ice Cream Cone from the list.
   *
   * @param labelIn takes input for label to find in the ArrayList.
   * @param radiusIn takes in input for radius in the constructor.
   * @param heightIn takes in put for the height in the constructor.
   * @return the newly edited object if the edit was successful.
   */
   
   public boolean editIceCreamCone(String labelIn, 
                        double radiusIn, double heightIn) {
                        
      boolean result = false;
      
      for (IceCreamCone iceCreamConeObject : iceCreamConeObjList) {
         if (iceCreamConeObject.getLabel().equalsIgnoreCase(labelIn)) {
            iceCreamConeObject.setRadius(radiusIn);
            iceCreamConeObject.setHeight(heightIn);
            result = true;
            break;
         
         }
         
      }
      return result;
      
   }
         
}