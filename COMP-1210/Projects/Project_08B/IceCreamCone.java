import java.text.DecimalFormat;
  
/*****************************************************************************
 * Program that will store a label, radius, and height, in which             *
 * the radius and height must be greater than zero. The IceCreamCone         *
 * class will also include methods to set and get each of these fields,      *
 * as well as methods to calculate the surface area and volume of the cone,  *
 * hemisphere, and the IceCreamCone object, and a method to provide a String *
 * value of an IceCreamCone object (i.e., a class instance).                 *
 *                                                                           *
 * Project 8B                                                                *
 * @author Midas Oden                                                        *
 * @version November 1, 2019                                                 *
 *****************************************************************************/
 
public class IceCreamCone {

// Instance Variables (Fields)

   private String label = "";
   private double radius = 0, height = 0;
     
 /*^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-*/
   private static int count = 0;
 /*^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-*/


// Constructor

  /**
   * Constructor for the Ice Cream Cone.
   *
   * @param labelIn takes input for the label of the cone object.
   * @param radiusIn takes input for the radius of the cone object
   * @param heightIn takes input for the height of the cone object.
   */

   public IceCreamCone(String labelIn, double radiusIn, double heightIn) {
   
      setLabel(labelIn);
      setRadius(radiusIn);
      setHeight(heightIn);
      count++;
      
   }
   
// Methods

  /**
   * Gets the label for the Ice Cream Cone.
   *
   * @return returns the label variable of type String
   */

   public String getLabel() {
   
      return label;
   
   }
   
  /**
   * Sets the label for the Ice Cream Cone.
   *
   * @param labelIn takes the labelIn for the method
   * @return returns the boolean if the variable is set
   */
   
   public boolean setLabel(String labelIn) {
   
      if (labelIn != null) {
         label = labelIn.trim();
         return true;
      } else {
         return false;
      }
   
   }
   
  /**
   * Gets the radius value of the Ice Cream Cone.
   * 
   * @return returns the value for the variable radius.
   */

   public double getRadius() {
   
      return radius;
   
   }
   
  /**
   * Sets the radius value for the Ice Cream Cone.
   *
   * @param radiusIn takes the radiusIn variable and sets it as the 
   * radius variable.
   * @return returns the boolean if the variable was set.
   */
   
   public boolean setRadius(double radiusIn) {
   
      if (radiusIn > 0) {
         radius = radiusIn;
         return true;
      } else {
         return false;
      }
      
   }
   
  /**
   * Gets the height value of the Ice Cream Cone.
   *
   * @return returns the value for the variable height.
   */

   public double getHeight() {
   
      return height;
   
   }
   
  /**
   * Sets the height value for the Ice Cream Cone.
   *
   * @param heightIn takes the heightIn variable and sets it as the 
   * height variable.
   * @return returns the boolean if the variable was set.
   */
   
   public boolean setHeight(double heightIn) {
   
      if (heightIn > 0) {
         height = heightIn;
         return true;
      } else {
         return false;
      }
      
   }
   
  /**
   * Calculates the surface area of the Ice Cream Cone.
   *
   * @return returns the double variable surfaceArea
   */
   
   public double surfaceArea() {
   
      double coneSideArea = Math.PI * radius 
         * Math.sqrt(Math.pow(height, 2) + Math.pow(radius, 2));
         
      double hemisphereArea = 2 * Math.PI *  Math.pow(radius, 2);
         
      double surfaceArea = coneSideArea + hemisphereArea; 
      return surfaceArea;
   
   }
   
  /**
   * Calculates the volume of the Ice Cream Cone.
   *
   * @return returns the double variable volume.
   */
      
   public double volume() {
   
      double coneVolume = (Math.PI * Math.pow(radius, 2) * height) / 3;
      double hemisphereVolume = (Math.PI * Math.pow(radius, 3) * 2) / 3;
   
      double volume = coneVolume + hemisphereVolume;   
      return volume;
      
   }
   
  /**
   * This method prints the Ice Cream Cone's information.
   *
   * @return Returns a string to be printed for the main method
   */
   
   public String toString() {
   
      DecimalFormat thisFormat = new DecimalFormat("#,##0.0######");
      
      return "IceCreamCone \"" + label + "\" with radius = " + radius
         + " and height = " + height + " units has:"
         + "\n\tsurface area = " + thisFormat.format(surfaceArea()) 
         + " square units"
         + "\n\tvolume = " + thisFormat.format(volume()) + " cubic units";
   
   }
   
  /**
   * This method will return the count variable which
   * represents the number of of IceCreamCone objects created.
   *
   * @return the count variable.
   */
   
   public static int getCount() {
   
      return count;
   
   }
   
  /**
   * Reset the number of IceCreamCone objects to zero.
   */
   
   public static void resetCount() {
   
      count = 0;
   
   }
   
  /**
   * This method will return false if the Object is not
   * an IceCreamCone; otherwise, when cast to an IceCreamCone,
   * if it has the same field values as the IceCreamCone upon
   * which the method was called. The equals method with parameter
   * type Object will be callled by the JUnit Assert.assetEquals method
   * when two IceCreamCone objects are checked for equality.
   *
   * @param obj represents input for an object
   * @return if the object is equal
   */
   
   public boolean equals(Object obj) {
   
      if (!(obj instanceof IceCreamCone)) {
         return false;
      } else {
         IceCreamCone icc = (IceCreamCone) obj;
         return (label.equalsIgnoreCase(icc.getLabel())
                  && Math.abs(radius - icc.getRadius()) < .000001
                  && Math.abs(height - icc.getHeight()) < .000001);
      }
      
   }
   
  /**
   * @return returns 0
   */
   
   public int hashCode() {
   
      return 0;
   
   }
   
}