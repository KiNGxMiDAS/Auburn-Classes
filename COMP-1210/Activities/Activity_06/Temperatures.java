import java.util.ArrayList;
  
/*****************************************************************************
 * Program that will hold a set of integer values representing daily         *
 * temperatures.                                                             *
 *                                                                           *
 * Activity 6                                                                *
 * @author Midas Oden                                                        *
 * @version October 6, 2019                                                  *
 ******************************************************************************/
 
public class Temperatures {

// Instance Variables (Fields)

   private ArrayList<Integer> temperatures;

// Constructor

  /**
   * Constructor takes an ArrayList of integer values.
   *
   * @param temperaturesIn is the array list of integer 
   *        values representing ranges in temperature.
   */

   public Temperatures(ArrayList<Integer> temperaturesIn) {
   
      temperatures = temperaturesIn;
      
   }
   
// Methods

  /**
   * This method returns the integer representing the lowest temperature.
   * The method will return 0 if the ArrayList is empty.
   *
   * @return Returns an integer value
   */

   public int getLowTemp() {
   
      if (temperatures.isEmpty()) {
         return 0;
      }
      
      int low = temperatures.get(0);
      for (int i = 0; i < temperatures.size(); i++) {
         if (temperatures.get(i) < low) {
            low = temperatures.get(i);
         }
      
      }
      
      return low;
   
   }
   
  /**
   * This methods returns the integer representing the highest temperature.
   * The method will return 0 if there are not temperatures in the ArrayList.
   *
   * @return Returns an integer value
   */
   
   public int getHighTemp() {
   
      if (temperatures.isEmpty()) {
         return 0;
      }
      
      int high = temperatures.get(0);
      for (Integer temp : temperatures) {
         if (temp > high) {
            high = temp;
         }
      
      }
      
      return high;
         
   }
  
   
  /**
   * This method will take an integer value and return the parameter
   * if it is lower than the value returned by the getLowTemp() method.
   * Otherwise, it returns the return of getLowTemp.
   * 
   * @param lowIn takes the lowest integer value.
   * @return Returns an integer
   */

   public int lowerMinimum(int lowIn) {
      
      return lowIn < getLowTemp() ? lowIn : getLowTemp();
   
   }
   
  /**
   * This method will take an integer value and return the parameter
   * if it is greater than the value returned by the getHighTemp() method.
   * Otherwise, it returns the return of getHighTemp.
   *
   * @param highIn takes the highest integer value.
   * @return Returns an integer
   */
   
   public int higherMaximum(int highIn) {
   
      return highIn > getHighTemp() ? highIn : getHighTemp();     
   }
   
  /**
   * This method prints temperatures that the user inputs.
   *
   * @return Returns a String containing the low and high temperatures
   */
   
   public String toString() {
   
      return "\tTemperatures: " + temperatures
           + "\n\tLow: " + getLowTemp()
           + "\n\tHigh: " + getHighTemp();
   
   }
   
}