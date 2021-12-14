import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*************************************************************************
 * Program represents a JUnit test file which allow the user to test all *
 * methods within the WirelessNetworkList.java class.                    *
 *                                                                       *
 * Project 10                                                            *
 * @author Midas Oden                                                    *
 * @version November 22, 2019                                            *
 *************************************************************************/

public class WirelessNetworkListTest {


  /** Fixture initialization (common initialization for all tests). **/

   @Before public void setUp() {
   
   }

  /**
   * This method will test the getWirelessNetworksArray() method.
   */
   
   @Test public void getWirelessNetworksArrayTest() {
   
      WirelessNetworkList objList = new WirelessNetworkList();
      WirelessNetwork[] wirelessNetworkObject = new WirelessNetwork[0];
      
      Assert.assertArrayEquals("getWirelessNetworksArray Test", 
         wirelessNetworkObject, objList.getWirelessNetworksArray());
   
   }
   
  /**
   * This method will test the getInvalidRecordsArray() method.
   */
   
   @Test public void getInvalidRecordsArrayTest() {
   
      WirelessNetworkList objList = new WirelessNetworkList();
      String[] invalidRecords = new String[0];     
          
      Assert.assertArrayEquals("getInvalidRecordsArray Test", invalidRecords, 
         objList.getInvalidRecordsArray());
   
   }
   
  /**
   * This method will test the addWirelessNetworks() method.
   */
   
   @Test public void addWirelessNetworksTest() {
   
      WirelessNetworkList objList = new WirelessNetworkList();
      WiFi n1 = new WiFi("My WiFi", 450, 40.00, 5.00);
      WiFi n2 = new WiFi("My WiFi x2", 550, 50.00, 7.00);
   
      WirelessNetwork[] wirelessNetworkObject = new WirelessNetwork[2];
      wirelessNetworkObject[0] = n1;
      wirelessNetworkObject[1] = n2;
      objList.addWirelessNetwork(n1); 
      objList.addWirelessNetwork(n2);  
          
      Assert.assertArrayEquals("addWirelessNetwork Test", 
         objList.getWirelessNetworksArray(), wirelessNetworkObject);
   }
   
  /**
   * This method will test the addInvalidRecord() method.
   */
   
   @Test public void addInvalidRecordTest() {
   
      WirelessNetworkList objList = new WirelessNetworkList();
      String n1 = new String("My WiFi");
      String n2 = new String("My WiFi x2");
   
      String[] invalidRecordObject = new String[2];
      invalidRecordObject[0] = n1;
      invalidRecordObject[1] = n2;
      objList.addInvalidRecord(n1); 
      objList.addInvalidRecord(n2);  
          
      Assert.assertArrayEquals("addInvalidRecord Test", 
         objList.getInvalidRecordsArray(), invalidRecordObject);
   }
   
  /**
   * This method will test the readFile() method.
   *
   * @throws Exception throws an exception for the file
   */
   
   @Test public void readFileTest1() throws Exception {
   
      WirelessNetworkList objList = new WirelessNetworkList();
      objList.readFile("wireless_network_data1.csv");
      
      Assert.assertTrue("readFile Test1", 
         objList.generateReport().contains("Monthly Wireless Network Report"));
   }
   
  /**
   * This method will test the readFile() method.
   *
   * @throws Exception throws an exception for the file
   */
   
   @Test public void readFileTest2() throws Exception {
   
      WirelessNetworkList objList = new WirelessNetworkList();
      objList.readFile("wireless_network_data1.csv");
      
      Assert.assertTrue("readFile Test2", 
         objList.generateReportByName().contains("by Name"));  
   }
   
  /**
   * This method will test the readFile() method.
   *
   * @throws Exception throws an exception for the file
   */
   
   @Test public void readFileTest3() throws Exception {
   
      WirelessNetworkList objList = new WirelessNetworkList();
      objList.readFile("wireless_network_data1.csv");
      
      Assert.assertTrue("readFile Test3", 
         objList.generateReportByBandwidth().contains("by Bandwidth"));  
   }
   
  /**
   * This method will test the readFile() method.
   *
   * @throws Exception throws an exception for the file
   */
   
   @Test public void readFileTest4() throws Exception {
   
      WirelessNetworkList objList = new WirelessNetworkList();
      objList.readFile("wireless_network_data1.csv");
      
      Assert.assertTrue("readFile Test4", 
         objList.generateReportByMonthlyCost().contains("by Monthly Cost"));  
   }
   
  /**
   * This method will test the generateReport() method.
   */
   
   @Test public void generateReportTest1() {
   
      WirelessNetworkList objList = new WirelessNetworkList();
      WiFi n1 = new WiFi("My WiFi", 450, 40.00, 5.00);
      Cellular n2 = new Cellular("My Note", 5.0, 20.00, 1200, 1.0);
      WirelessNetwork[] obj = new WirelessNetwork[2];
      
      obj[0] = n1;
      obj[1] = n2;
      
      objList.addWirelessNetwork(n1); 
      objList.addWirelessNetwork(n2);  
      
      Assert.assertTrue("generateReport Test1", 
         objList.generateReport().contains("Monthly Wireless Network Report"));
   }
   
  /**
   * This method will test the generateReport() method.
   */
   
   @Test public void generateReportTest2() {
   
      WirelessNetworkList objList = new WirelessNetworkList();
      WiFi n1 = new WiFi("My WiFi", 450, 40.00, 5.00);
      Cellular n2 = new Cellular("My Note", 5.0, 20.00, 1200, 1.0);
      WirelessNetwork[] obj = new WirelessNetwork[2];
      
      obj[0] = n1;
      obj[1] = n2;
      
      objList.addWirelessNetwork(n1); 
      objList.addWirelessNetwork(n2);  
      
      Assert.assertTrue("generateReport Test2", 
         objList.generateReport().contains("My WiFi"));   
   }
   
  /**
   * This method will test the generateReport() method.
   */
   
   @Test public void generateReportTest3() {
   
      WirelessNetworkList objList = new WirelessNetworkList();
      WiFi n1 = new WiFi("My WiFi", 450, 40.00, 5.00);
      Cellular n2 = new Cellular("My Note", 5.0, 20.00, 1200, 1.0);
      WirelessNetwork[] obj = new WirelessNetwork[2];
      
      obj[0] = n1;
      obj[1] = n2;
      
      objList.addWirelessNetwork(n1); 
      objList.addWirelessNetwork(n2);  
      
      Assert.assertTrue("generateReport Test3", 
         objList.generateReport().contains("My Note"));   
   }
   
  /**
   * This method will test the generateReportByName() method.
   */
   
   @Test public void generateReportByNameTest1() {
   
      WirelessNetworkList objList = new WirelessNetworkList();
      WiFi n1 = new WiFi("My WiFi", 450, 40.00, 5.00);
      Cellular n2 = new Cellular("My Note", 5.0, 20.00, 1200, 1.0);
      WirelessNetwork[] obj = new WirelessNetwork[2];
      
      obj[0] = n1;
      obj[1] = n2;
      
      objList.addWirelessNetwork(n1); 
      objList.addWirelessNetwork(n2);  
      
      Assert.assertTrue("generateReportByName Test1", 
         objList.generateReportByName().contains("(by Name)"));  
   }
   
  /**
   * This method will test the generateReportByName() method.
   */
   
   @Test public void generateReportByNameTest2() {
   
      WirelessNetworkList objList = new WirelessNetworkList();
      LTE n3 = new LTE("My iPad", 20.0, 30.00, 1200, 2.0);
      FiveG n4 = new FiveG("My Samsung", 80.0, 50.00, 1200, 10.0);
      WirelessNetwork[] obj = new WirelessNetwork[2];
      
      obj[0] = n3;
      obj[1] = n4;
      
      objList.addWirelessNetwork(n3); 
      objList.addWirelessNetwork(n4);  
      
      Assert.assertTrue("generateReportByName Test2", 
         objList.generateReportByName().contains("My iPad"));   
   }
   
   /**
   * This method will test the generateReportByName() method.
   */
   
   @Test public void generateReportByNameTest3() {
   
      WirelessNetworkList objList = new WirelessNetworkList();
      LTE n3 = new LTE("My iPad", 20.0, 30.00, 1200, 2.0);
      FiveG n4 = new FiveG("My Samsung", 80.0, 50.00, 1200, 10.0);
      WirelessNetwork[] obj = new WirelessNetwork[2];
      
      obj[0] = n3;
      obj[1] = n4;
      
      objList.addWirelessNetwork(n3); 
      objList.addWirelessNetwork(n4);  
      
      Assert.assertTrue("generateReportByName Test3", 
         objList.generateReportByName().contains("My Samsung"));  
   }
   
  /**
   * This method will test the generateReportByBandwidth() method.
   */
   
   @Test public void generateReportByBandwidthTest1() {
   
      WirelessNetworkList objList = new WirelessNetworkList();
      WiFi n1 = new WiFi("My WiFi", 450, 40.00, 5.00);
      Cellular n2 = new Cellular("My Note", 5.0, 20.00, 1200, 1.0);
      WirelessNetwork[] obj = new WirelessNetwork[2];
      
      obj[0] = n1;
      obj[1] = n2;
      
      objList.addWirelessNetwork(n1); 
      objList.addWirelessNetwork(n2);  
      
      Assert.assertTrue("generateReportByBandwidth Test1", 
         objList.generateReportByBandwidth().contains("(by Bandwidth)")); 
   }
   
  /**
   * This method will test the generateReportByBandwidth() method.
   */
   
   @Test public void generateReportByBandwidthTest2() {
   
      WirelessNetworkList objList = new WirelessNetworkList();
      WiFi n1 = new WiFi("My WiFi", 450, 40.00, 5.00);
      Cellular n2 = new Cellular("My Note", 5.0, 20.00, 1200, 1.0);
      WirelessNetwork[] obj = new WirelessNetwork[2];
      
      obj[0] = n1;
      obj[1] = n2;
      
      objList.addWirelessNetwork(n1); 
      objList.addWirelessNetwork(n2);  
      
      Assert.assertTrue("generateReportByBandwidth Test2", 
         objList.generateReportByBandwidth().contains("450")); 
   }
   
  /**
   * This method will test the generateReportByBandwidth() method.
   */
   
   @Test public void generateReportByBandwidthTest3() {
   
      WirelessNetworkList objList = new WirelessNetworkList();
      WiFi n1 = new WiFi("My WiFi", 450, 40.00, 5.00);
      Cellular n2 = new Cellular("My Note", 5.0, 20.00, 1200, 1.0);
      WirelessNetwork[] obj = new WirelessNetwork[2];
      
      obj[0] = n1;
      obj[1] = n2;
      
      objList.addWirelessNetwork(n1); 
      objList.addWirelessNetwork(n2);  
      
      Assert.assertTrue("generateReportByBandwidth Test3", 
         objList.generateReportByBandwidth().contains("1200")); 
   }
   
  /**
   * This method will test the generateReportByMonthlyCost() method.
   */
   
   @Test public void generateReportByMonthlyCostTest1() {
   
      WirelessNetworkList objList = new WirelessNetworkList();
      WiFi n1 = new WiFi("My WiFi", 450, 40.00, 5.00);
      Cellular n2 = new Cellular("My Note", 5.0, 20.00, 1200, 1.0);
      WirelessNetwork[] obj = new WirelessNetwork[2];
      
      obj[0] = n1;
      obj[1] = n2;
      
      objList.addWirelessNetwork(n1); 
      objList.addWirelessNetwork(n2);  
      
      Assert.assertTrue("generateReportByMonthlyCost Test1", 
         objList.generateReportByMonthlyCost().contains("(by Monthly Cost)")); 
   }
   
  /**
   * This method will test the generateReportByMonthlyCost() method.
   */
   
   @Test public void generateReportByMonthlyCostTest2() {
   
      WirelessNetworkList objList = new WirelessNetworkList();
      WiFi n1 = new WiFi("My WiFi", 450, 40.00, 5.00);
      Cellular n2 = new Cellular("My Note", 5.0, 20.00, 1200, 1.0);
      WirelessNetwork[] obj = new WirelessNetwork[2];
      
      obj[0] = n1;
      obj[1] = n2;
      
      objList.addWirelessNetwork(n1); 
      objList.addWirelessNetwork(n2);  
      
      Assert.assertTrue("generateReportByMonthlyCost Test2", 
         objList.generateReportByMonthlyCost().contains("1")); 
   }
   
  /**
   * This method will test the generateReportByMonthlyCost() method.
   */
   
   @Test public void generateReportByMonthlyCostTest3() {
   
      WirelessNetworkList objList = new WirelessNetworkList();
      WiFi n1 = new WiFi("My WiFi", 450, 40.00, 5.00);
      Cellular n2 = new Cellular("My Note", 5.0, 20.00, 1200, 1.0);
      WirelessNetwork[] obj = new WirelessNetwork[2];
      
      obj[0] = n1;
      obj[1] = n2;
      
      objList.addWirelessNetwork(n1); 
      objList.addWirelessNetwork(n2);  
      
      Assert.assertTrue("generateReportByMonthlyCost Test3", 
         objList.generateReportByMonthlyCost().contains("$45.00")); 
   }
        
}