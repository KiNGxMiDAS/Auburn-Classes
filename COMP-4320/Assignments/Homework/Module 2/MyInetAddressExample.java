import java.util.Scanner;         // for creating Scanner Objects
import java.net.InetAddress;      // high-level representation of an IP address (IPv4 & IPv6)...also used by Socket, ServerSocket, URL, DatagramSocket, DatagramPacket
import java.net.UnknownHostException;   // thrown to indicate that the IP address of a host could not be determined

/* ====================================================================================*
 * FILE NAME:    MyInetAddressExample.java                                             *
 * AUTHOR:       Midas Oden                                                            *
 * VERSION:      01/28/2022                                                            *
 * COMPILE:      javac MyInetAddressExample.java                                       *
 * EXECUTE:      java MyInetAddressExample                                             *
 *                                                                                     *
 * DESCRIPTION:  This program will prompt the user to enter a hostname,                *
 *               then will display its IP address in binary, binary dotted-quad,       *
 *               and decimal dotted-quad format.                                       *
 *                                                                                     *
 *               $ java MyInetAddressExample                                           *
 *               ...                                                                   *
 *               Enter a hostname (e.g., www.auburn.edu): www.auburn.edu               *
 *                                                                                     *
 *               Hostname: www.auburn.edu                                              *
 *                   binary  format             : 10000011110011001000101010101010     *
 *                   binary  dotted-quad format : 10000011.11001100.10001010.10101010  *
 *                   decimal dotted-quad format : 131.204.138.170                      *
 *               ...                                                                   *
 *                                                                                     *
 * ====================================================================================*/


public class MyInetAddressExample {

   public static void main(String[] args) {

      // create a scanner object to read from the keyboard
      Scanner scan = new Scanner(System.in);

      // prompt the user to enter a hostname
      System.out.print("\nEnter a hostname (e.g., www.auburn.edu): ");
      String hostName = scan.nextLine();
      System.out.println("\nHostname: " + hostName);

      // Create an InetAddress object for the hostname
      InetAddress address = null;
      try {
         address = InetAddress.getByName(hostName);
         String hostAddress = address.getHostAddress();

         // Display the formatted IP addresses
         System.out.println("    binary  format             : " + getBinaryIPAddress(hostAddress));
         System.out.println("    binary  dotted-quad format : " + getBinaryDottedQuad(hostAddress));
         System.out.println("    decimal dotted-quad format : " + hostAddress);
         System.out.println();
      }
      catch (UnknownHostException e) {
         System.out.println("Unknown host: " + hostName);
         System.exit(1);
      }

      // Close the scanner object
      scan.close();
   }

   /**
    * The getBinaryIPAddress method takes in a String representing an IPv4 address (32-bit address) 
    * and returns a String representing the binary version of that IP address.
      * @param String hostname
      * @return String binaryIP
    */
    public static String getBinaryIPAddress(String hostname) {
       // string used to store the binary IP address
       String binaryIP = "";

       // string array used to store the binary IP address
       String[] hostAddArray = hostname.split("\\.");

       // loop over hostAddArray and convert each element to binary and add it to binaryIP string 
       for (String str : hostAddArray) {
         int index = Integer.parseInt(str);
         String binaryHostAddArray = Integer.toBinaryString(index);
         binaryIP += binaryHostAddArray;
      }
      return binaryIP;
   } 
   
    /**
     * This method will take in a String representing an IPv4 address (32-bit address) 
     * and returns a String representing the binary version of that IP address in dotted-quad format. 
       * @param String hostname
       * @return String binaryIP
     */
    public static String getBinaryDottedQuad(String hostname) {
       // string used to store the binary IP address
       String binaryIP = "";

       // string array used to store the binary IP address
       String[] hostAddArray = hostname.split("\\.");
       
       // loop over hostAddArray and convert each element to binary and add it to binaryIP string 
       for (String str : hostAddArray) {
          int index = Integer.parseInt(str);
          String binaryHostAddArray = Integer.toBinaryString(index);
          binaryIP += binaryHostAddArray + ".";
      }

      // remove the last period from the binaryIP string
      return binaryIP.substring(0, binaryIP.length() - 1);
   }

}



