import java.io.FileNotFoundException;

/***************************************************************
 * Driver program that will call to the methods within the     *
 * WirelessNetworkList.java class. Within this program, a      *
 * WirelessNetworkList object is created, and then its methods *
 * are invoked to read the file:                               *
 *             "wireless_network_data2.exceptions.csv"         *
 * and process the wireless network records.                   *
 *                                                             *  
 * Project 11                                                  *
 * @author Midas Oden                                          *
 * @version December 5, 2019                                   *
 ***************************************************************/

public class WirelessNetworksPart3 {

 /**
  * @param args ~ command-line arguments.
  */
  
   public static void main(String[] args) {
      try {
         WirelessNetworkList driverApp = new WirelessNetworkList();
         if (args.length != 0) {
            driverApp.readFile(args[0]);
         
            System.out.print(driverApp.generateReport());
            System.out.print(driverApp.generateReportByName());
            System.out.print(driverApp.generateReportByBandwidth());
            System.out.print(driverApp.generateReportByMonthlyCost());
            System.out.print(driverApp.generateInvalidRecordsReport());
         
         } else {
            System.out.print("File name expected as command line argument."
               + "\nProgram ending.");
         } 
      } catch (FileNotFoundException e) {
         System.out.print("*** Attempted to read file: " + args[0] 
                         + " (No such file or directory)");
      }
   }
}