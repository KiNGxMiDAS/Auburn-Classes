import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**************************************************************************
 * Program that represents the wifi usage that adds the cost for a modem. *
 * This class is a child class to WirelessNetwork.java and will call to   *
 * the methods used.                                                      *
 *                                                                        *
 * Project 10                                                             *
 * @author Midas Oden                                                     *
 * @version November 20, 2019                                             *
 **************************************************************************/
 
public class WirelessNetworkList {
 
// Instance Variable(s) - fields
 
   private WirelessNetwork[] wirelessNetworkObject;
   private String[] invalidRecords;
 
// Constructor

  /**
   * Constructor method intitialises both Arrays to 0 length.
   */
 
   public WirelessNetworkList() {
   
      wirelessNetworkObject = new WirelessNetwork[0];
      invalidRecords = new String[0];
   
   }
   
// Methods

  /**
   * @return Returns the WirelessNetwork Array
   */
   
   public WirelessNetwork[] getWirelessNetworksArray() {
      return wirelessNetworkObject;
   
   }
   
  /**
   * @return Returns the String invalidRecords Array
   */

   public String[] getInvalidRecordsArray() {
      return invalidRecords;
   
   }
   
  /**
   * Adds an extra slot into the WirelessNetwork Array
   * and adds a new object into the array.
   *
   * @param newWNElement Takes in a WirelessNetwork object
   *        to add to the array
   */

   public void addWirelessNetwork(WirelessNetwork newWNElement) {
   
      wirelessNetworkObject = Arrays.copyOf(wirelessNetworkObject, 
                              wirelessNetworkObject.length + 1);
      wirelessNetworkObject[wirelessNetworkObject.length - 1] = newWNElement;
   
   }

  /**
   * Adds an extra slot into the String Array
   * and adds a new object into the array.
   *
   * @param newStringElement Takes in a String object
   *        to add to the array
   */

   public void addInvalidRecord(String newStringElement) {
      invalidRecords = Arrays.copyOf(invalidRecords, invalidRecords.length + 1);
      invalidRecords[invalidRecords.length - 1] = newStringElement;
   }
   
  /**
   * Takes in a dataFileName as a String and iterates through
   * the file creating new WirelessNetwork objects. The method
   * then adds the objects into the WirelessNetwork object arrays.
   *
   * @param dataFileName String parameter for a file name.
   * @throws FileNotFoundException Throws FileNotFoundException for the file.
   */

   public void readFile(String dataFileName) throws FileNotFoundException {
      // Reads in file name and creates a Scanner object
      Scanner scanFile = new Scanner(new File(dataFileName));
      // Assigns the data from the file to different categories
      while (scanFile.hasNext()) {
         Scanner scanData = new Scanner(scanFile.nextLine());
         scanData.useDelimiter(",");
      
         String deviceType = scanData.next();
         char charInput = deviceType.toUpperCase().charAt(0);
         WirelessNetwork obj;
         // Assigns device type to different category
         switch (charInput) {
            case 'W':
               String nameIn = scanData.next();
               double bandwidthIn = Double.parseDouble(scanData.next());
               double monthlyFixedCostIn = Double.parseDouble(scanData.next());
               double modemCostIn = Double.parseDouble(scanData.next());
                
               obj = new WiFi(nameIn, bandwidthIn, 
                             monthlyFixedCostIn, modemCostIn);
               addWirelessNetwork(obj);
               
               break;
               
            case 'C':
               nameIn = scanData.next();
               bandwidthIn = Double.parseDouble(scanData.next());
               monthlyFixedCostIn = Double.parseDouble(scanData.next());
               double timeIn = Double.parseDouble(scanData.next());
               double dataLimitIn = Double.parseDouble(scanData.next());
               
               obj = new Cellular(nameIn, bandwidthIn, 
                          monthlyFixedCostIn, timeIn, dataLimitIn);
               addWirelessNetwork(obj);
               
               break;
                       
            case 'L':
               nameIn = scanData.next();
               bandwidthIn = Double.parseDouble(scanData.next());
               monthlyFixedCostIn = Double.parseDouble(scanData.next()); 
               timeIn = Double.parseDouble(scanData.next());
               dataLimitIn = Double.parseDouble(scanData.next());
               
               obj = new LTE(nameIn, bandwidthIn, 
                            monthlyFixedCostIn, timeIn, dataLimitIn);
               addWirelessNetwork(obj);
               
               break;
               
            case 'F':
               nameIn = scanData.next();
               bandwidthIn = Double.parseDouble(scanData.next());
               monthlyFixedCostIn = Double.parseDouble(scanData.next()); 
               timeIn = Double.parseDouble(scanData.next());
               dataLimitIn = Double.parseDouble(scanData.next());
               
               obj = new FiveG(nameIn, bandwidthIn, monthlyFixedCostIn, 
                              timeIn, dataLimitIn);
               addWirelessNetwork(obj);
               
               break;
               
            default:
               continue;
         
         }    
      }          
   }
   
  /**
   * Generates the report for the WirelessNetwork objects.
   * This method processes the WirelessNetwork array using
   * original order from the file to produce the Monthly
   * Wireless Network Report.
   *
   * @return Returns String representation of the report
   */

   public String generateReport() {
      String result = "-------------------------------\n"
         + "Monthly Wireless Network Report" + "\n"
         + "-------------------------------" + "\n";
      for (int i = 0; i < wirelessNetworkObject.length; i++) {
         result += wirelessNetworkObject[i] + "\n\n";
      }
      
      return result;
   }
   
  /**
   * Generates the report for the WirelessNetwork objects
   * categorised by the device name. This method sorts the
   * WirelessNetwork array by its natural ordering, and
   * processes the WirelessNetwork array to produce the
   * Monthly Wireless Network Report (by Name).
   *
   * @return Returns String representation of the report
   */

   public String generateReportByName() {
      Arrays.sort(wirelessNetworkObject);
      String result = "-----------------------------------------\n"
         + "Monthly Wireless Network Report (by Name)" + "\n"
         + "-----------------------------------------" + "\n";
   
      for (int i = 0; i < wirelessNetworkObject.length; i++) {
         result += wirelessNetworkObject[i] + "\n\n";
      }
      
      return result;     
   }
   
  /**
   * Generates the report for the WirelessNetwork objects
   * categorised by the bandwidth of the device. This method 
   * processes the WirelessNetwork array to produce the
   * Monthly Wireless Network Report (by Bandwidth).
   *
   * @return Returns String representation of the report
   */

   public String generateReportByBandwidth() {
      Arrays.sort(getWirelessNetworksArray(), new BandwidthComparator());
      String result = "----------------------------------------------\n"
         + "Monthly Wireless Network Report (by Bandwidth)" + "\n"
         + "----------------------------------------------" + "\n";
      
      for (int i = 0; i < wirelessNetworkObject.length; i++) {
         result += wirelessNetworkObject[i] + "\n\n";
      }
      
      return result;
   }
   
  /**
   * Generates the report for the WirelessNetwork objects
   * categorised by the monthly fixed cost of the device. 
   * This method processes the WirelessNetwork array to 
   * produce the Monthly Wireless Network Report 
   * (by Monthly Cost).
   *
   * @return Returns String representation of the report
   */

   public String generateReportByMonthlyCost() {
      Arrays.sort(getWirelessNetworksArray(), new MonthlyCostComparator());
      String result = "-------------------------------------------------\n"
         + "Monthly Wireless Network Report (by Monthly Cost)" + "\n"
         + "-------------------------------------------------" + "\n";
         
      Arrays.sort(getWirelessNetworksArray(), new MonthlyCostComparator());
      for (int i = 0; i < wirelessNetworkObject.length; i++) {
         result += wirelessNetworkObject[i] + "\n\n";
      }
      
      return result;
   }
 
}