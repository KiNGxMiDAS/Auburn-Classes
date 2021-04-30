import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;


import org.junit.Test;

/********************************
 * Test file for Selector.java  *
 *                              *
 * Assignment 1                 *
 * @author Midas Oden           * 
 * @version August 29, 2020     *
/********************************/
public class SelectorTest {


   ///////////////////
  // Illegal cases ///
   //////////////////  
  
  
/** Test that will throw an IllegalArgumentException due to array being empty */
   @Test (expected = IllegalArgumentException.class)
    public void illegalArgTestNull_min() {
      int[] a = null;
      Selector.min((int[])a);         
   }  
   
/** Test that will throw an IllegalArgumentException due to array having zero length */
   @Test (expected = IllegalArgumentException.class)
    public void illegalArgTestZero_min() {
      int[] a = new int[0]; // zero length ... no elements added
      Selector.min(a);         
   }   
   
   
    //////////////////////////////////////
  // Typical cases for the min() method ///
   //////////////////////////////////////
    
    
/** Test with a.length > 0, target found at front */
   @Test public void minTest1() {
      int[] a = {2, 8, 7, 3, 4};
      int expected = 2;
      int actual = Selector.min(a);
      assertEquals(expected, actual);   
   } 
   
/** Test with a.length > 0, target found at rear */
   @Test public void minTest2() {
      int[] a = {8, 4, 6, 5, 4};
      int expected = 4;
      int actual = Selector.min(a);
      assertEquals(expected, actual);   
   } 
  
/** Test with a.length > 0, target found in middle */
   @Test public void minTest3() {
      int[] a = {-5, -9, -1, -7, 0};
      int expected = -9;
      int actual = Selector.min(a);
      assertEquals(expected, actual);   
   } 
   
   
    //////////////////////////////////////
  // Typical cases for the max() method ///
   //////////////////////////////////////
   
   
/** Test with a.length > 0, target found at front */
   @Test public void maxTest1() {
      int[] a = {2, 10, 7, 3, 4};
      int expected = 10;
      int actual = Selector.max(a);
      assertEquals(expected, actual);   
   } 
   
/** Test with a.length > 0, target found at rear */
   @Test public void maxTest2() {
      int[] a = {8, 7, 6, 5, 4};
      int expected = 8;
      int actual = Selector.max(a);
      assertEquals(expected, actual);   
   } 
  
/** Test with a.length > 0, target found in middle */
   @Test public void maxTest3() {
      int[] a = {5, 9, 1, 7, 3};
      int expected = 9;
      int actual = Selector.max(a);
      assertEquals(expected, actual);
   } 
   
   
    //////////////////////////////////////
  // Typical cases for the kmin() method //
   //////////////////////////////////////
 
 
 /** Test with a.length > 0, target found in middle */
   @Test
   public void kmin1() {
      int[] a = {2, 8, 7, 3, 4};
      int k = 1;
      int expected = 2;
      int actual = Selector.kmin(a, k);
      assertEquals(expected, actual);
   }
   
/** Test with a.length > 0, target found in middle */
   @Test
   public void kmin2() {
      int[] a = {5, 9, 1, 7, 3};
      int k = 3;
      int expected = 5;
      int actual = Selector.kmin(a, k);
      assertEquals(expected, actual);
   }
   
  /** Test with a.length > 0, target found in middle */
   @Test
   public void kmin3() {
      int[] a = {8, 7, 6, 5, 4};
      int k = 5;
      int expected = 8;
      int actual = Selector.kmin(a, k);
      assertEquals(expected, actual);
   }
/** Test with a.length > 0, target found in middle */
   @Test
   public void kmin4() {
      int[] a = {8, 2, 8, 7, 3, 3, 4};
      int k = 3;
      int expected = 4;
      int actual = Selector.kmin(a, k);
      assertEquals(expected, actual);
   }

   @Test
   public void kmin5() {
      int[] a = {2, 3, 3, 3, 3, 4, 4};
      int k = 3;
      int expected = 4;
      int actual = Selector.kmin(a, k);
      assertEquals(expected, actual);
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void kmin6() throws IllegalArgumentException {
      int[] a = {2, 4, 4, 4, 4, 4, 2};
      int k = 3;
      int actual = Selector.kmin(a, k);
   }


   @Test
   public void kmax1() {
      int[] a = {2, 8, 7, 3, 4};
      int k = 1;
      int expected = 8;
      int actual = Selector.kmax(a, k);
      assertEquals(expected, actual);
   }

   @Test
   public void kmax2() {
      int[] a = {5, 9, 1, 7, 3};
      int k = 3;
      int expected = 5;
      int actual = Selector.kmax(a, k);
      assertEquals(expected, actual);
   }

   @Test
   public void kmax3() {
      int[] a = {8, 7, 6, 5, 4};
      int k = 5;
      int expected = 4;
      int actual = Selector.kmax(a, k);
      assertEquals(expected, actual);
   }

   @Test
   public void kmax4() {
      int[] a = {8, 2, 8, 7, 3, 3, 4};
      int k = 3;
      int expected = 4;
      int actual = Selector.kmax(a, k);
      assertEquals(expected, actual);
   }

   @Test
   public void range1() {
      int[] a = {2, 8, 7, 3, 4};
      int low = 1;
      int high = 5;
      int[] expected = {2, 3, 4};
      int[] actual = Selector.range(a, low, high);
      assertArrayEquals(expected, actual);
   }

   @Test
   public void range2() {
      int[] a = {5, 9, 1, 7, 3};
      int low = 3;
      int high = 5;
      int[] expected = {5, 3};
      int[] actual = Selector.range(a, low, high);
      assertArrayEquals(expected, actual);
   }

   @Test
   public void range3() {
      int[] a = {8, 7, 6, 5, 4};
      int low = 4;
      int high = 8;
      int[] expected = {8, 7, 6, 5, 4};
      int[] actual = Selector.range(a, low, high);
      assertArrayEquals(expected, actual);
   }

   @Test
   public void range4() {
      int[] a = {8, 2, 8, 7, 3, 3, 4};
      int low = 3;
      int high = 7;
      int[] expected = {7, 3, 3, 4};
      int[] actual = Selector.range(a, low, high);
      assertArrayEquals(expected, actual);
   }

   @Test
   public void ceiling1() {
      int[] a = {2, 8, 7, 3, 4};
      int key = 1;
      int expected = 2;
      int actual = Selector.ceiling(a, key);
      assertEquals(expected, actual);
   }

   @Test
   public void ceiling2() {
      int[] a = {5, 9, 1, 7, 3};
      int key = 7;
      int expected = 7;
      int actual = Selector.ceiling(a, key);
      assertEquals(expected, actual);
   }

   @Test
   public void ceiling3() {
      int[] a = {8, 7, 6, 5, 4};
      int key = 0;
      int expected = 4;
      int actual = Selector.ceiling(a, key);
      assertEquals(expected, actual);
   }

   @Test
   public void ceiling4() {
      int[] a = {8, 2, 8, 7, 3, 3, 4};
      int key = 5;
      int expected = 7;
      int actual = Selector.ceiling(a, key);
      assertEquals(expected, actual);
   }

   @Test
   public void floor1() {
      int[] a = {2, 8, 7, 3, 4};
      int key = 6;
      int expected = 4;
      int actual = Selector.floor(a, key);
      assertEquals(expected, actual);
   }

   @Test
   public void floor2() {
      int[] a = {5, 9, 1, 7, 3};
      int key = 1;
      int expected = 1;
      int actual = Selector.floor(a, key);
      assertEquals(expected, actual);
   }

   @Test
   public void floor3() {
      int[] a = {8, 7, 6, 5, 4};
      int key = 9;
      int expected = 8;
      int actual = Selector.floor(a, key);
      assertEquals(expected, actual);
   }

   @Test
   public void floor4() {
      int[] a = {8, 2, 8, 7, 3, 3, 4};
      int key = 5;
      int expected = 4;
      int actual = Selector.floor(a, key);
      assertEquals(expected, actual);
   }

   @Test
   public void floor5() {
      int[] a = {9, 7};
      int key = 8;
      int expected = 7;
      int actual = Selector.floor(a, key);
      assertEquals(expected, actual);
   }

   @Test
   public void floor6() {
      int[] a = {-3, 3, 9, 7, 0};
      int key = 11;
      int expected = 9;
      int actual = Selector.floor(a, key);
      assertEquals(expected, actual);
   }
}



