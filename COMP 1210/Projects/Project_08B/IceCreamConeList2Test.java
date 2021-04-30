import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;

 /****************************************************************************
 * Program represents a JUnit test file which allow the user to test all     *
 * methods within the IceCreamConeList2.java class file. This particular     *
 * java test file includes several test methods that will essentially call   *
 * to the methods within IceCreamConeList2.java.                             *
 *                                                                           *
 * Project 8B                                                                *
 * @author Midas Oden                                                        *
 * @version November 1, 2019                                                 *
 *****************************************************************************/

public class IceCreamConeList2Test {

/** Fixture initialization (common initialization for all tests). **/

   @Before public void setUp() {
   
   }
   
  /**
   * This method will test the getName() method.
   */
   
   @Test public void getNameTest() {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      IceCreamConeList2 iccList2 = 
         new IceCreamConeList2("Label", iccElements, 0);
   
      Assert.assertEquals("getName Test", "Label", iccList2.getName()); 
   
   }
   
  /**
   * This method will test the numberOfIceCreamCones() method.
   */
   
   @Test public void numberOfIceCreamConesTest() {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      IceCreamConeList2 iccList2 = 
         new IceCreamConeList2("Label", iccElements, 2);
   
      Assert.assertEquals("numberOfIceCreamCones test",
         1, iccList2.numberOfIceCreamCones());
   
   }
   
  /**
   * This method will test the totalSurfaceArea() method.
   */

   @Test public void totalSurfaceAreaTest() {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      
      IceCreamCone cone1 = new IceCreamCone("Label1", 1, 2);
      IceCreamCone cone2 = new IceCreamCone("Label2", 3, 4);
      IceCreamCone cone3 = new IceCreamCone("Label3", 5, 6);
   
      iccElements[0] = cone1;
      iccElements[1] = cone2;
      iccElements[2] = cone3;
      
      IceCreamConeList2 iccList2 = 
         new IceCreamConeList2("iccCones", iccElements, 3);
      
      double surfaceAreaTestVar = 
         cone1.surfaceArea() + cone2.surfaceArea() + cone3.surfaceArea();
      
      Assert.assertEquals("totalSurfaceArea test", 
         surfaceAreaTestVar, iccList2.totalSurfaceArea(), 0.000001);
   
   }
   
  /**
   * This method will test the totalVolume() method.
   */
   
   @Test public void totalVolumeTest() {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      
      IceCreamCone cone1 = new IceCreamCone("Label1", 1, 2);
      IceCreamCone cone2 = new IceCreamCone("Label2", 3, 4);
      IceCreamCone cone3 = new IceCreamCone("Label3", 5, 6);
   
      iccElements[0] = cone1;
      iccElements[1] = cone2;
      iccElements[2] = cone3;
   
      IceCreamConeList2 iccList2 = 
         new IceCreamConeList2("iccCones", iccElements, 3);
   
      double totalVolumeTestVar = 
         cone1.volume() + cone2.volume() + cone3.volume();
   
      Assert.assertEquals("totalVolume test", 
         totalVolumeTestVar, iccList2.totalVolume(), 0.000001);
   
   }
   
  /**
   * This method will test the averageSurfaceArea() method.
   */
   
   @Test public void averageSurfaceAreaTest() {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      
      IceCreamCone cone1 = new IceCreamCone("Label1", 1, 2);
      IceCreamCone cone2 = new IceCreamCone("Label2", 3, 4);
      IceCreamCone cone3 = new IceCreamCone("Label3", 5, 6);
   
      iccElements[0] = cone1;
      iccElements[1] = cone2;
      iccElements[2] = cone3;
   
      IceCreamConeList2 iccList2 = 
         new IceCreamConeList2("iccCones", iccElements, 3);
   
      Assert.assertEquals("averageSurfaceArea test", 
         132.25, iccList2.averageSurfaceArea(), 0.01);
   
   }
   
  /**
   * This method will test the averageSurfaceArea() method.
   * This test ensures that an IceCreamConeList2 array is empty (null).
   */
   
   @Test public void emptyAverageSurfaceAreaTest() {
   
      IceCreamConeList2 iccList2 = new IceCreamConeList2(null, null, 0);
   
      Assert.assertEquals("averageSurfaceArea Test", 0, 
         iccList2.averageSurfaceArea(), 0.000001);
      
   }
   
  /**
   * This method will test the averageVolume() method.
   */
   
   @Test public void averageVolumeTest() {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      
      IceCreamCone cone1 = new IceCreamCone("Label1", 1, 2);
      IceCreamCone cone2 = new IceCreamCone("Label2", 3, 4);
      IceCreamCone cone3 = new IceCreamCone("Label3", 5, 6);
   
      iccElements[0] = cone1;
      iccElements[1] = cone2;
      iccElements[2] = cone3;
   
      IceCreamConeList2 iccList2 = 
         new IceCreamConeList2("iccCones", iccElements, 3);
      
      Assert.assertEquals("averageVolume test", 
         172.44, iccList2.averageVolume(), 0.01);
   
   }
   
  /**
   * This method will test the averageVolume() method.
   * This test ensures that an IceCreamConeList2 array is empty (null).
   */
   
   @Test public void emptyAverageVolumeTest() {
   
      IceCreamConeList2 iccList2 = new IceCreamConeList2(null, null, 0);
   
      Assert.assertEquals("averageVolume Test", 0, 
         iccList2.averageVolume(), 0.000001);
      
   }
   
  /**
   * This method will test the toString() method.
   */
   
   @Test public void toStringTest() {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      
      IceCreamCone icc = new IceCreamCone("Label", 1, 2);
      iccElements[0] = icc;
      
      IceCreamConeList2 iccList2 = 
         new IceCreamConeList2("iccCones", iccElements, 1);
   
      Assert.assertTrue("toString test", 
         iccList2.toString().contains("radius"));
      
   }
   
  /**
   * This method will test the summaryInfo() method.
   */
   
   @Test public void summaryInfoTest() {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      
      IceCreamCone icc = new IceCreamCone("Label", 1, 2);
      iccElements[0] = icc;
      
      IceCreamConeList2 iccList2 = 
         new IceCreamConeList2("iccCones", iccElements, 1);
   
      Assert.assertTrue("summaryInfo test", 
         iccList2.summaryInfo().contains("Number of IceCreamCone Objects: 1"));
   
   }
   
  /**
   * This method will test the getList() method.
   */
   
   @Test public void getListTest() {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      IceCreamConeList2 iccList2 = 
         new IceCreamConeList2("Label", iccElements, 1);
   
      Assert.assertArrayEquals("getList test", iccElements, iccList2.getList());
   
   }
   
  /**
   * This method will test the readFile() method.
   * @throws FileNotFoundException for scanning the
   *         IceCreamCone_data_1.txt file.
   */
   
   @Test public void readFileTest() throws FileNotFoundException {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      IceCreamConeList2 iccList2 = 
         new IceCreamConeList2("IceCreamCones", iccElements, 3);
   
      iccList2 = iccList2.readFile("IceCreamCone_data_1.txt");
     
      Assert.assertEquals("readFile test", 
         "IceCreamCone Test List", iccList2.getName());
   
   }
   
  /**
   * This method will test the readFile() method.
   * @throws FileNotFoundException for scanning the
             IceCreamCone_data_0.txt file.
   */
   
   @Test public void readFileTest2() throws FileNotFoundException {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      IceCreamConeList2 iccList2 = 
         new IceCreamConeList2(null, null, 0);
   
      iccList2 = iccList2.readFile("IceCreamCone_data_0.txt");
     
      Assert.assertEquals("readFile test", 
         "IceCreamCone Empty Test List", iccList2.getName());
         
   }
   
  /**
   * This method will test the readFile() method.
   * @throws FileNotFoundException for scanning the
             IceCreamCone_data_st.txt file.
   */
   
   @Test public void readFileTest3() throws FileNotFoundException {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      IceCreamConeList2 iccList2 = 
         new IceCreamConeList2("IceCreamCones", iccElements, 3);
   
      iccList2 = iccList2.readFile("IceCreamCone_data_st.txt");
     
      Assert.assertEquals("readFile test", 
         "IceCreamCone Secret Test List", iccList2.getName());
   
   }
   
  /**
   * This method will test the addIceCreamCone() method.
   */
   
   @Test public void addIceCreamConeTest() {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      IceCreamConeList2 iccList2 = 
         new IceCreamConeList2("Label", iccElements, 1);
         
      iccList2.addIceCreamCone("Ex 1", 1, 2);
         
      Assert.assertEquals("addIceCreamCone test", 1, 
         iccList2.numberOfIceCreamCones());
   
   }
   
  /**
   * This method will test the findIceCreamCone() method.
   */
   
   @Test public void findIceCreamConeTest() {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      IceCreamConeList2 iccList2 = 
         new IceCreamConeList2("Label", iccElements, 0);
         
      iccList2.addIceCreamCone("Ex 1", 1, 2);  
      iccList2.addIceCreamCone("Ex 2", 3, 4);   
      iccList2.addIceCreamCone("Ex 3", 5, 6);
         
      Assert.assertEquals("findIceCreamCone test", 
         iccElements[1], iccList2.findIceCreamCone("Ex 2"));
   
   }
   
  /**
   * This method will test the findIceCreamCone() method.
   */
   
   @Test public void findIceCreamConeTest2() {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      IceCreamConeList2 iccList2 = 
         new IceCreamConeList2("Label", iccElements, 0);
         
      iccList2.addIceCreamCone("Ex 1", 1, 2);  
      iccList2.addIceCreamCone("Ex 2", 3, 4);   
      iccList2.addIceCreamCone("Ex 3", 5, 6);
         
      Assert.assertEquals("findIceCreamCone test", 
         null, iccList2.findIceCreamCone("Ex 4"));
   
   }
   
  /**
   * This method will test the findIceCreamCone() method.
   * This test ensures that an IceCreamConeList2 array is empty (null).
   */
   
   @Test public void findEmptyIceCreamConeTest() {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      IceCreamConeList2 iccList2 = 
         new IceCreamConeList2(null, null, 0);
         
      Assert.assertEquals("findIceCreamCone test", 
         null, iccList2.findIceCreamCone("Ex 2"));
   
   }
  
  /**
   * This method will test the deleteIceCreamCone() method.
   */
   
   @Test public void deleteIceCreamConeTest() {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      IceCreamConeList2 iccList2 = 
         new IceCreamConeList2("Label", iccElements, 0);
         
      iccList2.addIceCreamCone("Ex 1", 1, 2);  
      iccList2.addIceCreamCone("Ex 2", 3, 4);   
      iccList2.addIceCreamCone("Ex 3", 5, 6);
   
      iccList2.deleteIceCreamCone("Ex 1");
   
      Assert.assertEquals("deleteIceCreamCone test", null, iccElements[3]);
   
   }
   
  /**
   * This method will test the deleteIceCreamCone() method.
   */
   
   @Test public void deleteIceCreamConeTest2() {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      IceCreamConeList2 iccList2 = 
         new IceCreamConeList2("Label", iccElements, 0);
         
      iccList2.addIceCreamCone("Ex 1", 1, 2);  
      iccList2.addIceCreamCone("Ex 2", 3, 4);   
      iccList2.addIceCreamCone("Ex 3", 5, 6);
   
      iccList2.deleteIceCreamCone("ex 2");
   
      Assert.assertEquals("deleteIceCreamCone test", null, iccElements[3]);
      
   }
   
  /**
   * This method will test the deleteIceCreamCone() method.
   * This test ensures that an IceCreamConeList2 array is empty (null).
   */
   
   @Test public void deleteEmptyIceCreamConeTest() {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      IceCreamConeList2 iccListNull = 
         new IceCreamConeList2("Label", null, 0);
         
      Assert.assertEquals("deleteIceCreamCone test", 
         null, iccListNull.deleteIceCreamCone("null"));
         
   }
   
  /**
   * This method will test the editIceCreamCone() method.
   */
   
   @Test public void editIceCreamConeTest() {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      IceCreamConeList2 iccList2 = 
         new IceCreamConeList2("Label", iccElements, 0);
         
      iccList2.addIceCreamCone("Ex 1", 1, 2);  
      iccList2.addIceCreamCone("Ex 2", 3, 4);   
      iccList2.addIceCreamCone("Ex 3", 5, 6);
   
      iccList2.editIceCreamCone("Ex 2", 7, 8);
   
      Assert.assertEquals("editIceCreamCone test", 5, 
         iccElements[2].getRadius(), 0.001);
   
   }
   
  /**
   * This method will test the editIceCreamCone() method.
   * This test ensures that a non-existent object inside
   * of the IceCreamConeList2 array is uneditable (null).
   */
   
   @Test public void editEmptyIceCreamConeTest() {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      IceCreamConeList2 iccList2 = 
         new IceCreamConeList2("Label", iccElements, 0);
         
      iccList2.addIceCreamCone("Ex 1", 1, 2); 
      iccList2.addIceCreamCone("Ex 2", 3, 4); 
      iccList2.addIceCreamCone("Ex 3", 5, 6);
   
      iccList2.editIceCreamCone("Empty", 1, 2);
   
      Assert.assertEquals("editIceCreamCone test", 5, 
         iccElements[2].getRadius(), 0.001);
   
   }
   
  /**
   * This method will test the findIceCreamConeWithShortestRadius() method.
   */
   
   @Test public void findIceCreamConeWithShortestRadiusTest() {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      IceCreamConeList2 iccList2 = 
         new IceCreamConeList2("Label", iccElements, 0);
         
      iccList2.addIceCreamCone("Ex 1", 1, 2);  
      iccList2.addIceCreamCone("Ex 2", 3, 4);   
      iccList2.addIceCreamCone("Ex 3", 5, 6);
      
      Assert.assertEquals("findShorterRadius test", 
         iccElements[0], iccList2.findIceCreamConeWithShortestRadius());
   
   }
   
  /**
   * This method will test the findIceCreamConeWithShortestRadius() method.
   */
   
   @Test public void findIceCreamConeWithShortestRadiusTest2() {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      IceCreamConeList2 iccList2 = 
         new IceCreamConeList2("Label", iccElements, 0);
         
      iccList2.addIceCreamCone("Ex 1", 3, 5);  
      iccList2.addIceCreamCone("Ex 2", 1, 4);   
      iccList2.addIceCreamCone("Ex 3", 5, 6);
      
      Assert.assertEquals("findShorterRadius test", 
         iccElements[1], iccList2.findIceCreamConeWithShortestRadius());
   
   }
   
  /**
   * This method will test the findIceCreamConeWithShortestRadius() method.
   * This test ensures that an IceCreamConeList2 array is empty (null).
   */
   
   @Test public void findEmptyIceCreamConeWithShortestRadiusTest() {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      IceCreamConeList2 iccList2 = 
         new IceCreamConeList2(null, null, 0);
      
      Assert.assertEquals("findShorterRadius test", 
         null, iccList2.findIceCreamConeWithShortestRadius());
   
   }
   
  /**
   * This method will test the findIceCreamConeWithLongestRadius() method.
   */
   
   @Test public void findIceCreamConeWithLongestRadiusTest() {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      IceCreamConeList2 iccList2 = 
         new IceCreamConeList2("Label", iccElements, 0);
         
      iccList2.addIceCreamCone("Ex 1", 3, 5);  
      iccList2.addIceCreamCone("Ex 2", 1, 4);   
      iccList2.addIceCreamCone("Ex 3", 5, 6);
      
      Assert.assertEquals("findLongerRadius test", 
         iccElements[2], iccList2.findIceCreamConeWithLongestRadius());
         
   }
   
  /**
   * This method will test the findIceCreamConeWithLongestRadius() method.
   */
   
   @Test public void findIceCreamConeWithLongestRadiusTest2() {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      IceCreamConeList2 iccList2 = 
         new IceCreamConeList2("Label", iccElements, 0);
         
      iccList2.addIceCreamCone("Ex 1", 3, 5);  
      iccList2.addIceCreamCone("Ex 2", 7, 4);   
      iccList2.addIceCreamCone("Ex 3", 5, 6);
      
      Assert.assertEquals("findLongerRadius test", 
         iccElements[1], iccList2.findIceCreamConeWithLongestRadius());
         
   }
   
  /**
   * This method will test the findIceCreamConeWithLongestRadius() method.
   * This test ensures that an IceCreamConeList2 array is empty (null).
   */
   
   @Test public void findEmptyIceCreamConeWithLongestRadiusTest() {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      IceCreamConeList2 iccList2 = 
         new IceCreamConeList2(null, null, 0);
   
      Assert.assertEquals("findLongerRadius test", 
         null, iccList2.findIceCreamConeWithLongestRadius());
         
   }
   
  /**
   * This method will test the findIceCreamConeWithSmallestVolume() method.
   */
   
   @Test public void findIceCreamConeWithSmallestVolumeTest() {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      IceCreamConeList2 iccList2 = 
         new IceCreamConeList2("Label", iccElements, 0);
         
      iccList2.addIceCreamCone("Ex 1", 7, 5);  
      iccList2.addIceCreamCone("Ex 2", 3, 1);   
      iccList2.addIceCreamCone("Ex 3", 5, 6);
      
      Assert.assertEquals("findSmallerVolume test", 
         iccElements[1], iccList2.findIceCreamConeWithSmallestVolume());
         
   }
   
  /**
   * This method will test the findIceCreamConeWithSmallestVolume() method.
   */
   
   @Test public void findIceCreamConeWithSmallestVolumeTest2() {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      IceCreamConeList2 iccList2 = 
         new IceCreamConeList2("Label", iccElements, 0);
         
      iccList2.addIceCreamCone("Ex 1", 7, 5);  
      iccList2.addIceCreamCone("Ex 2", 3, 1);   
      iccList2.addIceCreamCone("Ex 3", 1, 2);
      
      Assert.assertEquals("findSmallerVolume test", 
         iccElements[2], iccList2.findIceCreamConeWithSmallestVolume());
         
   }
   
  /**
   * This method will test the findIceCreamConeWithSmallestVolume() method.
   * This test ensures that an IceCreamConeList2 array is empty (null).
   */
   
   @Test public void findEmptyIceCreamConeWithSmallestVolumeTest() {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      IceCreamConeList2 iccList2 = 
         new IceCreamConeList2(null, null, 0);
         
      Assert.assertEquals("findSmallerVolume test", 
         null, iccList2.findIceCreamConeWithSmallestVolume());
         
   }
   
  /**
   * This method will test the findIceCreamConeWithLargestVolume() method.
   */
   
   @Test public void findIceCreamConeWithLargestVolumeTest() {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      IceCreamConeList2 iccList2 = 
         new IceCreamConeList2("Label", iccElements, 0);
         
      iccList2.addIceCreamCone("Ex 1", 7, 5);  
      iccList2.addIceCreamCone("Ex 2", 10, 12);   
      iccList2.addIceCreamCone("Ex 3", 5, 6);
      
      Assert.assertEquals("findLargerVolume test", 
         iccElements[1], iccList2.findIceCreamConeWithLargestVolume());
   
   }
   
  /**
   * This method will test the findIceCreamConeWithLargestVolume() method.
   */
   
   @Test public void findIceCreamConeWithLargestVolumeTest2() {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      IceCreamConeList2 iccList2 = 
         new IceCreamConeList2("Label", iccElements, 0);
         
      iccList2.addIceCreamCone("Ex 1", 7, 5);  
      iccList2.addIceCreamCone("Ex 2", 10, 12);   
      iccList2.addIceCreamCone("Ex 3", 5, 6);
      iccList2.addIceCreamCone("Ex 4", 11, 15);
   
      
      Assert.assertEquals("findLargerVolume test", 
         iccElements[3], iccList2.findIceCreamConeWithLargestVolume());
   
   }
   
  /**
   * This method will test the findIceCreamConeWithLargestVolume() method.
   * This test ensures that an IceCreamConeList2 array is empty (null).
   */
   
   @Test public void findEmptyIceCreamConeWithLargestVolumeTest() {
   
      IceCreamCone[] iccElements = new IceCreamCone[100];
      IceCreamConeList2 iccList2 = 
         new IceCreamConeList2(null, null, 0);
      
      Assert.assertEquals("findLargerVolume test", 
         null, iccList2.findIceCreamConeWithLargestVolume());
   
   }
   
}