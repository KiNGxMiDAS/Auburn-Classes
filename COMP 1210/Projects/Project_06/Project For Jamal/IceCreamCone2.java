import java.text.DecimalFormat;
  
/*****************************************************************************
 * Program that will store a label, radius, and height, in which             *
 * the radius and height must be greater than zero. The IceCreamCone         *
 * class will also include methods to set and get each of these fields,      *
 * as well as methods to calculate the surface area and volume of the cone,  *
 * hemisphere, and the IceCreamCone object, and a method to provide a String *
 * value of an IceCreamCone object (i.e., a class instance).                 *
 *                                                                           *
 * Project 6                                                                 *
 * @author Midas Oden                                                        *
 * @version October 11, 2019                                                 *
 ******************************************************************************/
 
public class IceCreamCone2
{

// Instance Variables (Fields)

   private String label = "";
   private double radius = 0, height = 0;

// Constructor

  /**
   * Constructor for the Ice Cream Cone.
   *
   * @param labelIn takes input for the label of the cone object.
   * @param radiusIn takes input for the radius of the cone object
   * @param heightIn takes input for the height of the cone object.
   */

   public IceCreamCone2(String labelIn, double radiusIn, double heightIn) {
   
      setLabel(labelIn);
      setRadius(radiusIn);
      setHeight(heightIn);
      
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
      }
      else {
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
      }
      else {
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
      }
      else {
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
   
}