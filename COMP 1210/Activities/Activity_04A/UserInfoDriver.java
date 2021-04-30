/*******************************************************************************
 * Driver program will read user input and print information regarding what    *
 * the user decides based on: first and last name, the user's age, location    *
 * and status. This class will call to the arguments used in UserInfo.java file*
 *                                                                             *
 *                                                                             *
 * Activity 4A                                                                 *
 * @author Midas Oden                                                          *
 * @version September 15, 2019                                                 *
 ******************************************************************************/

public class UserInfoDriver {

    /**
     * User inputs a first and last name, age, location,
     * and status and outputs the information.
     *
     * @param args Command line arguments – not used.
     */

   public static void main(String[] args) {
   
      UserInfo user1 = new UserInfo("Pat", "Doe");
      System.out.println("\n" + user1);
      user1.setLocation("Auburn");
      user1.setAge(19);
      user1.logOn();
      System.out.println("\n" + user1);
   
      UserInfo user2 = new UserInfo("Sam", "Jones");
      System.out.println("\n" + user2);
      user2.setLocation("Atlanta");
      user2.setAge(21);
      user2.logOn();
      System.out.println("\n" + user2);
   
   
   }  
 
}
