import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*****************************************************************************
 * Program represents a JUnit test file which allow the user to test all     *
 * methods within the IceCreamCone.java class file. This particular java     *
 * test file includes several test methods that will essentially call to     *
 * the methods within IceCreamCone.java.                                     *
 *                                                                           *
 * Project 8B                                                                *
 * @author Midas Oden                                                        *
 * @version October 31, 2019                                                 *
 *****************************************************************************/

public class IceCreamConeTest {

   /** Fixture initialization (common initialization for all tests). **/
    
   @Before public void setUp() {
   
   }
   
  /**
   * This method will test the getLabel() method.
   */
   
   @Test public void getLabelTest() {
   
      IceCreamCone icc = new IceCreamCone("Label", 1, 2);
      Assert.assertEquals("Label", icc.getLabel());
   
   }
   
  /**
   * This method will test the setLabel() method to see if the 
   * inputted label is unequal to the actual set label.
   */
   
   @Test public void setLabelTestFalse() {
   
      IceCreamCone icc = new IceCreamCone("Label", 1, 2);
   
      icc.setLabel("label");
      Assert.assertEquals(false, icc.setLabel(null));
   
   }
   
  /**
   * This method will test the setLabel() method.
   */
   
   @Test public void setLabelTest() {
   
      IceCreamCone icc = new IceCreamCone("Label", 1, 2);
   
      icc.setLabel("icc1");
      Assert.assertEquals("set label to this", "icc1", icc.getLabel());
   
   }
   
  /**
   * This method will test the getRadius() method.
   */
   
   @Test public void getRadiusTest() {
   
      IceCreamCone icc = new IceCreamCone("Label", 1, 2);
      Assert.assertEquals(1, icc.getRadius(), .000001);
   
   }
   
  /**
   * This method will test the setRadius() method.
   */
   
   @Test public void setRadiusTest() {
   
      IceCreamCone icc = new IceCreamCone("Label", 1, 2);
      icc.setRadius(2.0);
   
      Assert.assertEquals(2.0, icc.getRadius(), .000001);
   
   }
   
  /**
   * This method will test the setRadius() method to see if the 
   * inputted radius is less than zero.
   */
   
   @Test public void setRadiusFalseTest() {
   
      IceCreamCone icc = new IceCreamCone("Label", 1, 2);
      icc.setRadius(0);
   
      Assert.assertEquals("setRadiusFalse test", 
         1, icc.getRadius(), .000001);
   
   }
   
  /**
   * This method will test the getHeight() method.
   */
   
   @Test public void getHeightTest() {
   
      IceCreamCone icc = new IceCreamCone("Label", 1, 2);
      Assert.assertEquals(2, icc.getHeight(), .000001);
   
   }
   
  /**
   * This method will test the setHeight() method.
   */
   
   @Test public void setHeightTest() {
   
      IceCreamCone icc = new IceCreamCone("Label", 1, 0);
      icc.setHeight(2.0);
   
      Assert.assertEquals(2.0, icc.getHeight(), .000001);
   
   }
   
  /**
   * This method will test the setHeight() method to see if the 
   * inputted height is less than zero.
   */
   
   @Test public void setHeightFalseTest() {
   
      IceCreamCone icc = new IceCreamCone("Label", 1, 2);
      icc.setHeight(0);
   
      Assert.assertEquals("setHeightFalse test", 
         2, icc.getHeight(), .000001);
   
   }
   
  /**
   * This method will test the surfaceArea() method.
   */
   
   @Test public void surfaceAreaTest() {
   
      IceCreamCone icc = new IceCreamCone("Label", 1, 2);
      
      double coneSideArea = Math.PI * icc.getRadius() 
         * Math.sqrt(Math.pow(icc.getHeight(), 2) 
         + Math.pow(icc.getRadius(), 2));
         
      double hemisphereArea = 2 * Math.PI *  Math.pow(icc.getRadius(), 2);
   
      Assert.assertEquals("surfaceArea test", 
         coneSideArea + hemisphereArea, icc.surfaceArea(), .000001);
   
   }
   
  /**
   * This method will test the volume() method.
   */
   
   @Test public void volumeTest() {
   
      IceCreamCone icc = new IceCreamCone("Label", 1, 2);
      
      double coneVolume = (Math.PI * Math.pow(icc.getRadius(), 2) 
         * icc.getHeight()) / 3;
      double hemisphereVolume = (Math.PI 
         * Math.pow(icc.getRadius(), 3) * 2) / 3;
   
      Assert.assertEquals("volume test", 
         coneVolume + hemisphereVolume, icc.volume(), .000001);
    
   }
   
  /**
   * This method will test the toString() method.
   */
   
   @Test public void toStringTest() { 
   
      IceCreamCone icc = new IceCreamCone("Label", 1, 2); 
      Assert.assertEquals("toString test", true,
         icc.toString().contains("radius"));
   
   }
   
  /**
   * This method will test the getCount() method.
   */
   
   @Test public void getCountTest() {
   
      IceCreamCone icc = new IceCreamCone("Label", 1, 2);
      icc.resetCount();
      
      IceCreamCone newICC = new IceCreamCone("Label", 1, 2);  
      Assert.assertEquals("getCount Test", 1, newICC.getCount());
   
   }
   
  /**
   * This method will test the resestCount() method.
   */
   
   @Test public void resetCountTest() {
   
      IceCreamCone icc = new IceCreamCone("Label", 1, 2);
   
      IceCreamCone icc2 = new IceCreamCone("label", 1, 2);
      icc2.resetCount();
      IceCreamCone icc1 = new IceCreamCone("label", 1, 2);
   
      Assert.assertEquals("resetCount test", 1, icc.getCount());
   
   }
   
  /**
   * This method will test the equals() method within the
   * IceCreamCone.java class. This test will compare two 
   * completely identical IceCreamCone objects so that the 
   * condition is true.
   */
   
   @Test public void equalsTrueTest() {
   
      IceCreamCone icc = new IceCreamCone("Label", 1, 2);
      IceCreamCone iccTrue = new IceCreamCone("Label", 1, 2);
   
      Assert.assertEquals(true, icc.equals(iccTrue));
   
   }
   
  /**
   * This method will test the equals() method within the
   * IceCreamCone.java class. This test will compare two 
   * IceCreamCone objects with different labels so that the
   * condition is false.
   */
   
   @Test public void equalsFalseTest1() {
   
      IceCreamCone icc = new IceCreamCone("Label", 1, 2);
      IceCreamCone iccFalse1 = new IceCreamCone("False Label", 1, 2);
   
      Assert.assertEquals(false, icc.equals(iccFalse1));
   
   }
   
  /**
   * This method will test the equals() method within the
   * IceCreamCone.java class. This test will compare two 
   * IceCreamCone objects with the same label, but different
   * values for the radius and height so that the condition 
   * is false.
   */
   
   @Test public void equalsFalseTest2() {
   
      IceCreamCone icc = new IceCreamCone("Label", 1, 2);
      IceCreamCone iccFalse2 = new IceCreamCone("Label", 3, 4);
   
      Assert.assertEquals(false, icc.equals(iccFalse2));
   
   }
   
  /**
   * This method will test the equals() method within the
   * IceCreamCone.java class. This test will compare two 
   * IceCreamCone objects with the same label, but different
   * values for the radius so that the condition is false.
   */
   
   @Test public void equalsFalseTest3() {
   
      IceCreamCone icc = new IceCreamCone("Label", 1, 2);
      IceCreamCone iccFalse3 = new IceCreamCone("Label", 3, 2);
   
      Assert.assertEquals(false, icc.equals(iccFalse3));
   
   }
   
   /**
   * This method will test the equals() method within the
   * IceCreamCone.java class. This test will compare two 
   * IceCreamCone objects with the same label, but different
   * values for the height so that the condition is false.
   */
   
   @Test public void equalsFalseTest4() {
   
      IceCreamCone icc = new IceCreamCone("Label", 1, 2);
      IceCreamCone iccFalse4 = new IceCreamCone("Label", 1, 3);
   
      Assert.assertEquals(false, icc.equals(iccFalse4));
   
   }
   
  /**
   * This method will test the equals() method within the
   * IceCreamCone.java class. This test will compare two 
   * IceCreamCone objects with the same label, but different
   * values for the radius and height with values of zero so
   * that the condition is false.
   */
   
   @Test public void equalsFalseTest5() {
   
      IceCreamCone icc = new IceCreamCone("Label", 1, 0);
      IceCreamCone iccFalse5 = new IceCreamCone("Label", 0, 1);
   
      Assert.assertEquals(false, icc.equals(iccFalse5));
   
   }
   
  /**
   * This method will test the equals() method within the
   * IceCreamCone.java class. This test will compare two 
   * IceCreamCone objects with different labels. The variable
   * iccFalse6 represents input for a label, so that the
   * condition is false.
   */
   
   @Test public void equalsFalseTest6() {
   
      IceCreamCone icc = new IceCreamCone("Label", 1, 0);
      String iccFalse6 = "";
   
      Assert.assertEquals(false, icc.equals(iccFalse6));
   
   }
   
  /**
   * This method will test the hashCode() method.
   */
   
   @Test public void hashCodeTest() {
   
      IceCreamCone icc = new IceCreamCone("Label", 1, 2);
      Assert.assertEquals("hashCode test", 0, icc.hashCode());
      
   }

}