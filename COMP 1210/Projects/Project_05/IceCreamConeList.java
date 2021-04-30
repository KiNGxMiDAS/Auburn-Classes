import java.util.ArrayList;
import java.text.DecimalFormat;
  
/*****************************************************************************
 * Program that will stores the name of the IceCreamCone list and an         *
 * ArrayList of IceCreamCone object. It also includes methods that return    *
 * the name of the list, the number of IceCreamCone objects, total surface   *
 * area, total volume, average surface area, and the average volume.         *
 *                                                                           *
 * Project 5                                                                 *
 * @author Midas Oden                                                        *
 * @version October 4, 2019                                                  *
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
   * @return Returns a the cone information.
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
   
}