import java.io.File;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.io.FileNotFoundException;
  
/*****************************************************************************
 * Program that will stores the name of the IceCreamCone list, an array of   *
 * IceCreamCone objects, and the number of IceCreamCone objects in the array.*
 * It also includes methods that returns the name of the list, the number of *
 * IceCreamCone objects in the IceCreamConeList2, total surface area, total  *
 * volume, average surface area, and the average volume for all IceCreamCone *
 * objects in the IceCreamConeList2. The toString method returns a String    *
 * containing the name of the list followed by each IceCreamCone in the      *
 * array, and a summaryInfo method that returns summar information about the *
 * list.                                                                     *
 *                                                                           *
 * Project 8B                                                                *
 * @author Midas Oden                                                        *
 * @version November 1, 2019                                                 *
 *****************************************************************************/
 
public class IceCreamConeList2 {

// Instance Variables (Fields)

   private String listName;
   private int numberOfElements;
   private IceCreamCone[] iCCObjectList;

// Constructor

  /**
   * Constructor creates the IceCreamCone list.
   *
   * @param listNameIn takes input of the list name.
   * @param numberOfElementsIn input 'resets' the numberOfElements variable.
   * @param iCCObjectListIn is the array list of the cone 
   *        objects given by the user.
   */

   public IceCreamConeList2(String listNameIn, 
               IceCreamCone[] iCCObjectListIn, int numberOfElementsIn) {
   
      listName = listNameIn;
      iCCObjectList = iCCObjectListIn;
      numberOfElements = numberOfElementsIn;
      
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
   * This method returns the number of ice cream cones in the array.
   *
   * @return Returns the list size
   */
   
   public int numberOfIceCreamCones() {
   
      for (int i = 0; i < numberOfElements; i++) {
         if (iCCObjectList[i] == null) {
            numberOfElements--;
         }
      
      }    
      return numberOfElements;
           
   }
   
  /**
   * This methods calculates the total surface area of the cone.
   * 
   * @return Returns the total
   */

   public double totalSurfaceArea() {
   
      double total = 0;
      for (int i = 0; i < numberOfElements; i++) {
         total += iCCObjectList[i].surfaceArea();
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
      for (int i = 0; i < numberOfElements; i++) {
         total += iCCObjectList[i].volume();
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
      for (int i = 0; i < numberOfElements; i++) {
         total += (iCCObjectList[i].surfaceArea()) / numberOfElements;
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
      for (int i = 0; i < numberOfElements; i++) {
         total += (iCCObjectList[i].volume()) / numberOfElements;
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
      for (int i = 0; i < numberOfElements; i++) {
         result += "\n" + iCCObjectList[i].toString() + "\n";
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
 //                         BEGINNING OF PROJECT 7                           //
  //------------------------------------------------------------------------//

   
  /**
   * @return an ArrayList of ice cream cone objects
   */
   
   public IceCreamCone[] getList() {
   
      return iCCObjectList;
   
   }
   
  /**
   * Reads in ice cream cone data from the file and creates an
   * IceCreamConeList object.
   *
   * @param fileNameIn for fileName to read
   * @return IceCreamConeList
   * @throws FileNotFoundException if the file cannot be opened.
   */
   
   public IceCreamConeList2 readFile(String fileNameIn) 
                  throws FileNotFoundException {
   
      IceCreamCone[] noConeObject = new IceCreamCone[100];
      Scanner scanFile = new Scanner(new File(fileNameIn));
      
      String labelIn = "";
      int numElements = 0;
      double radiusIn, heightIn = 0;
      
      listName = scanFile.nextLine();
      
      while (scanFile.hasNext()) {
         labelIn = scanFile.nextLine();
         radiusIn = Double.parseDouble(scanFile.nextLine());
         heightIn = Double.parseDouble(scanFile.nextLine());
         
         IceCreamCone newObject = 
            new IceCreamCone(labelIn, radiusIn, heightIn);
            
         noConeObject[numElements] = newObject;
         numElements++;
         
      }
      
      numberOfElements = numElements;
      IceCreamConeList2 iCCList = 
         new IceCreamConeList2(listName, noConeObject, numberOfElements);
   
      return iCCList; //iCCList = iceCreamConeList
      
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
   
      IceCreamCone newObject = 
         new IceCreamCone(labelIn, radiusIn, heightIn);
         
      iCCObjectList[numberOfElements] = newObject;
      numberOfElements++;
   
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
   
      if (numberOfElements > 0) {
      
         for (int i = 0; i < numberOfElements; i++) {
            if (iCCObjectList[i].getLabel().equalsIgnoreCase(labelIn)) {
               return iCCObjectList[i];
            
            }
         
         }
      
         return null;
      
      } else {
         return null;
      
      }
          
   }        
   
  /**
   * Deletes an Ice Cream Cone from the list.
   *
   * @param labelIn for the ice cream cone label.
   * @return the object deleted from the ArrayList.
   */
 
   public IceCreamCone deleteIceCreamCone(String labelIn) {
   
      IceCreamCone result = null;
      int numberOfElementsIn = 0;
      for (int i = 0; i < numberOfElements; i++)
      {
         if (iCCObjectList[i].getLabel().equalsIgnoreCase(labelIn))
         {
            result = iCCObjectList[i];
            for (int j = i; j <= numberOfElements - 1; j++)
            {
               iCCObjectList[j] = iCCObjectList[j + 1];
            }
            iCCObjectList[numberOfElements - 1] = null;
            numberOfElements--;
            break;
         }
         
      }
      return result;
      
   }
    
  /**
   * Edits an Ice Cream Cone from the list.
   *
   * @param labelIn takes input for label to find in the ArrayList.
   * @param radius takes in input for radius in the constructor.
   * @param height takes in put for the height in the constructor.
   * @return the newly edited object if the edit was successful.
   */
   
   public boolean editIceCreamCone(String labelIn, 
                        double radius, double height) {
                        
      IceCreamCone result = null;
       
      for (int i = 0; i < numberOfElements; i++) {
         if (iCCObjectList[i].getLabel().equalsIgnoreCase(labelIn))
         {
            iCCObjectList[i].setHeight(height);
            iCCObjectList[i].setRadius(radius);
            result = iCCObjectList[i];
            
            return true;
         }
      }
      return false; 
      
   }
   
   //------------------------------------------------------------------------//
 //                         BEGINNING OF PROJECT 8B                           //
  //------------------------------------------------------------------------//

  /**
   * Find and return the IceCreamCone object with the shortest radius.
   *
   * @return the IceCreamCone with the shortest radius
   */
   
   public IceCreamCone findIceCreamConeWithShortestRadius() {
   
      IceCreamCone result;
     
      if (numberOfElements <= 0) {
         result = null;
      } 
      else {
         double shortR = iCCObjectList[0].getRadius();
         result = iCCObjectList[0];
         
         for (int n = 1; n < numberOfElements; n++) {
            if (iCCObjectList[n].getRadius() < shortR) {
               shortR = iCCObjectList[n].getRadius();
               result = iCCObjectList[n];
            
            }
         
         }
      
      } 
      return result;
     
   }
   
  /**
   * Find and return the IceCreamCone object with the longest radius.
   *
   * @return the IceCreamCone with the longest radius
   */
   
   public IceCreamCone findIceCreamConeWithLongestRadius() {
   
      IceCreamCone result;
     
      if (numberOfElements <= 0) {
         result = null;
      } 
      else {
         double longR = iCCObjectList[0].getRadius();
         result = iCCObjectList[0];
         
         for (int n = 1; n < numberOfElements; n++) {
            if (iCCObjectList[n].getRadius() > longR) {
               longR = iCCObjectList[n].getRadius();
               result = iCCObjectList[n];
            
            }
         
         }
      
      } 
      return result;
     
   }
      
  /**
   * Find and return the IceCreamCone object with the smallest volume.
   *
   * @return the IceCreamCone with the smallest volume
   */
   
   public IceCreamCone findIceCreamConeWithSmallestVolume() {
   
      IceCreamCone result;
     
      if (numberOfElements <= 0) {
         result = null;
      } 
      else {
         double smallV = iCCObjectList[0].volume();
         result = iCCObjectList[0];
         
         for (int n = 1; n < numberOfElements; n++) {
            if (iCCObjectList[n].volume() < smallV) {
               smallV = iCCObjectList[n].volume();
               result = iCCObjectList[n];
            
            }
         
         }
      
      } 
      return result;
     
   }
   
  /**
   * Find and return the IceCreamCone object with the largest volume.
   *
   * @return the IceCreamCone with the largest volume
   */
   
   public IceCreamCone findIceCreamConeWithLargestVolume() {
   
      IceCreamCone result;
     
      if (numberOfElements <= 0) {
         result = null;
      } 
      else {
         double largeV = iCCObjectList[0].volume();
         result = iCCObjectList[0];
         
         for (int n = 1; n < numberOfElements; n++) {
            if (iCCObjectList[n].volume() > largeV) {
               largeV = iCCObjectList[n].volume();
               result = iCCObjectList[n];
            
            }
         
         }
      
      } 
      return result;
     
   }
   
}