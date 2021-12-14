import java.io.FileNotFoundException;

/***************************************************************
 * Driver program that will call to the methods within the     *
 * WirelessNetworkList.java class. Within this program, a      *
 * WirelessNetworkList object is created, and then its methods *
 * are invoked to read the file "wireless_network_data1.csv"   *
 * and process the wireless network records.                   *
 *                                                             *  
 * Project 10                                                  *
 * @author Midas Oden                                          *
 * @version November 21, 2019                                  *
 ***************************************************************/

public class WirelessNetworksPart2 {

 /**
  * @param args ~ command-line arguments.
  * @throws FileNotFoundException Throws an exception for the file.
  */
  
   public static void main(String[] args) throws FileNotFoundException {
   
      WirelessNetworkList driverApp = new WirelessNetworkList();
      if (args.length != 0) {
         driverApp.readFile(args[0]);
      
         System.out.print(driverApp.generateReport());
         System.out.print(driverApp.generateReportByName());
         System.out.print(driverApp.generateReportByBandwidth());
         System.out.print(driverApp.generateReportByMonthlyCost());
      
      } else {
         System.out.println("File name expected as command line argument."
            + "\nProgram ending.");
      } 
   }
}