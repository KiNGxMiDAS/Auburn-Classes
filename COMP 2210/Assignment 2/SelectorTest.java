import org.junit.Test;
//import org.testing.annotations.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.lang.IllegalArgumentException;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class SelectorTest {

   @Test
   public void min1() {
      Collection<Integer> a = Arrays.asList(2, 8, 7, 3, 4);
      int expected = 2;
      int actual = Selector.min(a, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test
   public void min2() {
      Collection<Integer> a = Arrays.asList(5, 9, 1, 7, 3);
      int expected = 1;
      int actual = Selector.min(a, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test
   public void min3() {
      Collection<Integer> a = Arrays.asList(8, 7, 6, 5, 4);
      int expected = 4;
      int actual = Selector.min(a, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test
   public void min4() {
      Collection<Integer> a = Arrays.asList(8, 2, 8, 7, 3, 3, 4);
      int expected = 2;
      int actual = Selector.min(a, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test(expected = IllegalArgumentException.class)
   public void min5() {
      Collection<Integer> a = null;
      Selector.min(a, nullComp);
   }

   @Test(expected = NoSuchElementException.class)
   public void min6() {
      Collection<Integer> a = Arrays.asList();
      Selector.min(a, ascendingInteger);
   }

   @Test
   public void max1() {
      Collection<Integer> a = Arrays.asList(2, 8, 7, 3, 4);
      int expected = 8;
      int actual = Selector.max(a, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test
   public void max2() {
      Collection<Integer> a = Arrays.asList(5, 9, 1, 7, 3);
      int expected = 9;
      int actual = Selector.max(a, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test
   public void max3() {
      Collection<Integer> a = Arrays.asList(8, 7, 6, 5, 4);
      int expected = 8;
      int actual = Selector.max(a, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test
   public void max4() {
      Collection<Integer> a = Arrays.asList(8, 2, 8, 7, 3, 3, 4);
      int expected = 8;
      int actual = Selector.max(a, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test(expected = IllegalArgumentException.class)
   public void max5() {
      Collection<Integer> a = null;
      Selector.max(a, nullComp);
   }

   @Test(expected = NoSuchElementException.class)
   public void max6() {
      Collection<Integer> a = Arrays.asList();
      Selector.max(a, ascendingInteger);
   }

   @Test(expected = IllegalArgumentException.class)
   public void kmin1() {
      Collection<Integer> a = null;
      int k = 1;
      Selector.kmin(a, k, nullComp);
   }

   @Test(expected = NoSuchElementException.class)
   public void kmin2() {
      Collection<Integer> a = Arrays.asList();
      int k = 1;
      Selector.kmin(a, k, ascendingInteger);
   }

   @Test
   public void kmin3() {
      Collection<Integer> a = Arrays.asList(2147483647);
      int k = 1;
      int expected = 2147483647;
      int actual = Selector.kmin(a, k, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test
   public void kmin4() {
      Collection<Integer> a = Arrays.asList(5, 7);
      int k = 1;
      int expected = 5;
      int actual = Selector.kmin(a, k, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test
   public void kmin5() {
      Collection<Integer> a = Arrays.asList(1,3,5,7,9);
      int k = 1;
      int expected = 1;
      int actual = Selector.kmin(a, k, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test(expected = NoSuchElementException.class)
   public void kmin6() {
      Collection<Integer> a = Arrays.asList(2, 4, 4, 4, 4, 4, 2);
      int k = 3;
      Selector.kmin(a, k, ascendingInteger);
   }

   @Test
   public void kmin7() {
      Collection<Integer> a = Arrays.asList(2, 8, 7, 3, 4);
      int k = 1;
      int expected = 2;
      int actual = Selector.kmin(a, k, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test
   public void kmin8() {
      Collection<Integer> a = Arrays.asList(5, 9, 1, 7, 3);
      int k = 3;
      int expected = 5;
      int actual = Selector.kmin(a, k, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test
   public void kmin9() {
      Collection<Integer> a = Arrays.asList(8, 7, 6, 5, 4);
      int k = 5;
      int expected = 8;
      int actual = Selector.kmin(a, k, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test
   public void kmin10() {
      Collection<Integer> a = Arrays.asList(8, 2, 8, 7, 3, 3, 4);
      int k = 3;
      int expected = 4;
      int actual = Selector.kmin(a, k, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test(expected = IllegalArgumentException.class)
   public void kmax1() {
      Collection<Integer> a = null;
      int k = 1;
      Selector.kmax(a, k, nullComp);
   }

   @Test(expected = NoSuchElementException.class)
   public void kmax2() {
      Collection<Integer> a = Arrays.asList();
      int k = 1;
      Selector.kmax(a, k, ascendingInteger);
   }

   @Test
   public void kmax3() {
      Collection<Integer> a = Arrays.asList(-2147483648);
      int k = 1;
      int expected = -2147483648;
      int actual = Selector.kmax(a, k, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test
   public void kmax4() {
      Collection<Integer> a = Arrays.asList(5, 7);
      int k = 1;
      int expected = 7;
      int actual = Selector.kmax(a, k, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test(expected = NoSuchElementException.class)
   public void kmax5() {
      Collection<Integer> a = Arrays.asList(2, 4, 4, 4, 4, 4, 2);
      int k = 3;
      Selector.kmax(a, k, ascendingInteger);
   }

   @Test
   public void kmax6() {
      Collection<Integer> a = Arrays.asList(2, 8, 7, 3, 4);
      int k = 1;
      int expected = 8;
      int actual = Selector.kmax(a, k, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test
   public void kmax7() {
      Collection<Integer> a = Arrays.asList(5, 9, 1, 7, 3);
      int k = 3;
      int expected = 5;
      int actual = Selector.kmax(a, k, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test
   public void kmax8() {
      Collection<Integer> a = Arrays.asList(8, 7, 6, 5, 4);
      int k = 5;
      int expected = 4;
      int actual = Selector.kmax(a, k, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test
   public void kmax9() {
      Collection<Integer> a = Arrays.asList(8, 2, 8, 7, 3, 3, 4);
      int k = 3;
      int expected = 4;
      int actual = Selector.kmax(a, k, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test(expected = IllegalArgumentException.class)
   public void range1() {
      Collection<Integer> a = null;
      int low = 1;
      int high = 5;
      Selector.range(a, low, high, nullComp);
   }

   @Test(expected = NoSuchElementException.class)
   public void range2() {
      Collection<Integer> a = Arrays.asList();
      int low = 3;
      int high = 5;
      Selector.range(a, low, high, ascendingInteger);
   }

   @Test
   public void range3() {
      Collection<Integer> a = Arrays.asList(7);
      int low = 7;
      int high = 7;
      Collection<Integer> expected = Arrays.asList(7);
      Collection<Integer> actual = Selector.range(a, low, high, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test
   public void range4() {
      Collection<Integer> a = Arrays.asList(7, 5);
      int low = 5;
      int high = 7;
      Collection<Integer> expected = Arrays.asList(7, 5);
      Collection<Integer> actual = Selector.range(a, low, high, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test
   public void range5() {
      Collection<Integer> a = Arrays.asList(1,9,7,5,3);
      int low = 1;
      int high = 9;
      Collection<Integer> expected = Arrays.asList(1,9,7,5,3);
      Collection<Integer> actual = Selector.range(a, low, high, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test
   public void range6() {
      Collection<Integer> a = Arrays.asList(2, 8, 7, 3, 4);
      int low = 1;
      int high = 5;
      Collection<Integer> expected = Arrays.asList(2, 3, 4);
      Collection<Integer> actual = Selector.range(a, low, high, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test
   public void range7() {
      Collection<Integer> a = Arrays.asList(5, 9, 1, 7, 3);
      int low = 3;
      int high = 5;
      Collection<Integer> expected = Arrays.asList(5, 3);
      Collection<Integer> actual = Selector.range(a, low, high, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test
   public void range8() {
      Collection<Integer> a = Arrays.asList(8, 7, 6, 5, 4);
      int low = 4;
      int high = 8;
      Collection<Integer> expected = Arrays.asList(8, 7, 6, 5, 4);
      Collection<Integer> actual = Selector.range(a, low, high, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test
   public void range9() {
      Collection<Integer> a = Arrays.asList(8, 2, 8, 7, 3, 3, 4);
      int low = 3;
      int high = 7;
      Collection<Integer> expected = Arrays.asList(7, 3, 3, 4);
      Collection<Integer> actual = Selector.range(a, low, high, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test(expected = IllegalArgumentException.class)
   public void ceiling1() {
      Collection<Integer> a = null;
      int key = 1;
      Selector.ceiling(a, key, nullComp);
   }

   @Test(expected = NoSuchElementException.class)
   public void ceiling2() {
      Collection<Integer> a = Arrays.asList();
      int key = 1;
      Selector.ceiling(a, key, ascendingInteger);
   }

   @Test
   public void ceiling3() {
      Collection<Integer> a = Arrays.asList(7);
      int key = 5;
      int expected = 7;
      int actual = Selector.ceiling(a, key, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test
   public void ceiling4() {
      Collection<Integer> a = Arrays.asList(9,7);
      int key = 5;
      int expected = 7;
      int actual = Selector.ceiling(a, key, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test
   public void ceiling5() {
      Collection<Integer> a = Arrays.asList(-3,3,9,7,0);
      int key = -5;
      int expected = -3;
      int actual = Selector.ceiling(a, key, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test
   public void ceiling6() {
      Collection<Integer> a = Arrays.asList(2, 8, 7, 3, 4);
      int key = 1;
      int expected = 2;
      int actual = Selector.ceiling(a, key, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test
   public void ceiling7() {
      Collection<Integer> a = Arrays.asList(5, 9, 1, 7, 3);
      int key = 7;
      int expected = 7;
      int actual = Selector.ceiling(a, key, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test
   public void ceiling8() {
      Collection<Integer> a = Arrays.asList(8, 7, 6, 5, 4);
      int key = 0;
      int expected = 4;
      int actual = Selector.ceiling(a, key, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test
   public void ceiling9() {
      Collection<Integer> a = Arrays.asList(8, 2, 8, 7, 3, 3, 4);
      int key = 5;
      int expected = 7;
      int actual = Selector.ceiling(a, key, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test(expected = IllegalArgumentException.class)
   public void floor1() {
      Collection<Integer> a = null;
      int key = 6;
      Selector.floor(a, key, nullComp);
   }

   @Test(expected = NoSuchElementException.class)
   public void floor2() {
      Collection<Integer> a = Arrays.asList();
      int key = 1;
      Selector.floor(a, key, ascendingInteger);
   }

   @Test
   public void floor3() {
      Collection<Integer> a = Arrays.asList(7);
      int key = 11;
      int expected = 7;
      int actual = Selector.floor(a, key, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test
   public void floor4() {
      Collection<Integer> a = Arrays.asList(9, 7);
      int key = 11;
      int expected = 9;
      int actual = Selector.floor(a, key, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test
   public void floor5() {
      Collection<Integer> a = Arrays.asList(-3,3,9,7,0);
      int key = 11;
      int expected = 9;
      int actual = Selector.floor(a, key, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test
   public void floor6() {
      Collection<Integer> a = Arrays.asList(2, 8, 7, 3, 4);
      int key = 6;
      int expected = 4;
      int actual = Selector.floor(a, key, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test
   public void floor7() {
      Collection<Integer> a = Arrays.asList(5, 9, 1, 7, 3);
      int key = 1;
      int expected = 1;
      int actual = Selector.floor(a, key, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test
   public void floor8() {
      Collection<Integer> a = Arrays.asList(8, 7, 6, 5, 4);
      int key = 9;
      int expected = 8;
      int actual = Selector.floor(a, key, ascendingInteger);
      assertEquals(expected, actual);
   }

   @Test
   public void floor9() {
      Collection<Integer> a = Arrays.asList(8, 2, 8, 7, 3, 3, 4);
      int key = 5;
      int expected = 4;
      int actual = Selector.floor(a, key, ascendingInteger);
      assertEquals(expected, actual);
   }

   /* COMPARATOR DECLARATIONS */
   /**
    * Defines a total order on integers as ascending natural order.
    */
   static Comparator<Integer> ascendingInteger = 
      new Comparator<Integer>() {
         public int compare(Integer i1, Integer i2) {
            return i1.compareTo(i2);
         }
      };

   static Comparator<Integer> nullComp = null;
}