
/*****************************************************************************
 * Program will read user input and print information regarding what         *
 * the user decides based on: first and last name, the user's age, location  *
 * and status.                                                               *
 *                                                                           *
 * Activity 4A                                                               *
 * @author Midas Oden                                                        *
 * @version September 15, 2019                                               *
 *****************************************************************************/


public class UserInfo {

// Instance Variables
   	
   private String firstName;	
   private String lastName;
   private String location;
   private int age;	
   private int status; 	
   private static final int OFFLINE = 0, ONLINE = 1;	
   	
 // Constructor  	
   	
   /**	  	
    * @param firstNameIn user inputs a first name.
    * @param lastNameIn user inputs a last name. 	
    */   
   public UserInfo(String firstNameIn, String lastNameIn) {
      firstName = firstNameIn;
      lastName = lastNameIn;
      location = "Not specified";
      age = 0;
      status = OFFLINE;
   
   }
  
// Methods

  /**
   * @return returns inputs as strings
   */

   public String toString() {
      String output = "Name: " + firstName + " "
         + lastName + "\n";
      output += "Location: " + location + "\n";
      output += "Age: " + age + "\n";
      output += "Status: ";
      if (status == OFFLINE) {
         output += "Offline";
      }
      else {
         output += "Online";
      }
      
      return output;
      
   }
   
   /**
   * @param locationIn takes input from user for the location
   */
   
   public void setLocation(String locationIn) {
      location = locationIn;
   
   }
   
   /**
   * @param ageIn takes input from the user for the age
   * @return returns the variable age and isSet
   */
   
   public boolean setAge(int ageIn) {
      boolean isSet = false;
      if (ageIn > 0) {
         age = ageIn;
         isSet = true;
      }
      return isSet;
      
   }
   
   /**
   * @return returns the age
   */
   
   public int getAge() {
      return age;
      
   }
   
   /**
   * @return returns the location
   */
   
   public String getLocation() {
      return location;
      
   }
   
   /**
    * If user logs off, display will output "Offline".
    */
   
   public void logOff() {
      status = OFFLINE;
   
   }
   
   /**
    * If user logs on, display will output "Online".
    */
   
   public void logOn() {
      status = ONLINE;
   
   }

}