/*****************************************************************************
 * Program that will store a label, radius, and height, in which             *
 * the radius and height must be greater than zero. The IceCreamCone         *
 * class will also include methods to set and get each of these fields,      *
 * as well as methods to calculate the surface area and volume of the cone,  *
 * hemisphere, and the IceCreamCone object, and a method to provide a String *
 * value of an IceCreamCone object (i.e., a class instance).                 *
 *                                                                           *
 * Activity 8B                                                               *
 * @author Midas Oden                                                        *
 * @version October 26, 2019                                                 *
 *****************************************************************************/
 
public class Customer implements Comparable<Customer> {

// Instance Variables (Fields)

   private String name;
   private String location;
   private double balance;

// Constructor

  /**
   * Constructor for the Customer class.
   *
   * @param nameIn takes input for the customer's name.
   */

   public Customer(String nameIn) {
   
      name = nameIn;
      location = "";
      balance = 0;
      
   }
   
// Methods

  /**
   * Get the customer's name.
   *
   * @return returns name
   */
    
   public String getName() {
   
      return name;
      
   }

  /**
   * Sets the customer's location.
   *
   * @param locationIn takes input for the customer's location.
   */

   public void setLocation(String locationIn) {
   
      location = locationIn;
   
   }
   
  /**
   * Sets the customer's location. This method allows the user
   * to input a customer's city and state in two separate String
   * parameters.
   *
   * @param city takes input for the customer's city.
   * @param state takes input for the customer's state.
   */
   
   public void setLocation(String city, String state) {
   
      location = city + ", " + state;
   
   }
   
  /**
   * Changes the customer's balance.
   *
   * @param amount adds an amount to the customer's balance.
   */
   
   public void changeBalance(double amount) {
   
      balance = amount + balance;
   
   }
   
  /**
   * Gets the customer's location and returns it.
   * 
   * @return variable for location
   */

   public String getLocation() {
   
      return location;
   
   }
   
  /**
   * Gets the customer's balance and returns it.
   *
   * @return variable for balance
   */
   
   public double getBalance() {
   
      return balance;
      
   }
   
  /**
   * Print customer information which includes the customer's
   * name, location, and balance.
   *
   * @return String input representing customer information
   */
   
   public String toString() {
   
      return getName() + "\n" + getLocation() + "\n" + "$" + getBalance();
   
   }
   
  /**
   * In reference to the Comparable interface, this method
   * compares an object of the Customer.java class to another
   * compatible object indicated by the generic parameter
   * based on some value.
   *
   * @param obj takes in a Customer object
   * @return returns if the objects is less than, 
   *         greater than, or equal to each other.
   */
   
   public int compareTo(Customer obj) {
   
      if (Math.abs(this.balance - obj.getBalance()) < 0.000001) {
         return 0; // consider them equal and return 0
      } 
      else if (this.balance < obj.getBalance()) {
         return -1; // should return a negative number
      }
      else {
         return 1; // should return a positive number
      
      }
      
   }
      
}