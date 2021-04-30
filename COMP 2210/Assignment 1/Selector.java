import java.util.Arrays;  

/**
 * Defines a library of selection methods
 * on arrays of ints.
 *
 * @author   Midas Oden (mto0006@auburn.edu)
 * @author   Dean Hendrix (dh@auburn.edu)
 * @version  2020/09/06
 *
 */
public final class Selector {

   /**
    * Can't instantiate this class.
    *
    * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
    *
    */
   private Selector() { }


   /**
    * Selects the minimum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    */
   public static int min(int[] a) throws IllegalArgumentException {
      if (a != null && a.length != 0) {
         int smallestValue = 0;
      
         for(int i = 0; i < a.length; ++i) {
            if (a[smallestValue] > a[i]) {
               smallestValue = i;
            }
         }
      
         return a[smallestValue];            
      } else {
         throw new IllegalArgumentException();
      }
   }      
   
   /**
    * Selects the maximum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    */
   public static int max(int[] a) throws IllegalArgumentException {
      if (a != null && a.length != 0) {
         int largestValue = 0;
      
         for(int i = 0; i < a.length; ++i) {
            if (a[largestValue] < a[i]) {
               largestValue = i;
            }
         }
      
         return a[largestValue];
      } else {
         throw new IllegalArgumentException();
      }
   }   

   /**
    * Selects the kth minimum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth minimum value. Note that there is no kth
    * minimum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    */
   public static int kmin(int[] a, int k) throws IllegalArgumentException {
      if (a != null && a.length != 0 && k >= 1 && k <= a.length) {
         int[] copyArray = Arrays.copyOf(a, a.length);
         Arrays.sort(copyArray);
         int[] uniqueArray = new int[copyArray.length];
         int j = 1;
         uniqueArray[0] = copyArray[0];
      
         for(int i = 1; i < copyArray.length; ++i) {
            if (copyArray[i] != copyArray[i - 1]) {
               uniqueArray[j] = copyArray[i];
               ++j;
            }
         }
      
         if (k > j) {
            throw new IllegalArgumentException();
         } else {
            return uniqueArray[k - 1];
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   /**
    * Selects the kth maximum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth maximum value. Note that there is no kth
    * maximum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    */
   public static int kmax(int[] a, int k) throws IllegalArgumentException {
      if (a != null && a.length != 0 && k >= 1 && k <= a.length) {
         int[] copyArray = Arrays.copyOf(a, a.length);
         Arrays.sort(copyArray);
         int[] uniqueArray = new int[copyArray.length];
         int j = 1;
         uniqueArray[0] = copyArray[0];
         for(int i = 1; i < copyArray.length; ++i) {
            if (copyArray[i] != copyArray[i - 1]) {
               uniqueArray[j] = copyArray[i];
               ++j;
            }
         }
      
         if (k > j) {
            throw new IllegalArgumentException();
         } else {
            return uniqueArray[j - k];
         }
      } else {
         throw new IllegalArgumentException();
      }
   } 

   /**
    * Returns an array containing all the values in a in the
    * range [low..high]; that is, all the values that are greater
    * than or equal to low and less than or equal to high,
    * including duplicate values. The length of the returned array
    * is the same as the number of values in the range [low..high].
    * If there are no qualifying values, this method returns a
    * zero-length array. Note that low and high do not have
    * to be actual values in a. This method throws an
    * IllegalArgumentException if a is null or has zero length.
    * The array a is not changed by this method.
    */
   public static int[] range(int[] a, int low, int high) throws IllegalArgumentException {
      if (a != null && a.length != 0) {
         int k = 0;
      
         for (int j : a) {
            if (j >= low && j <= high) {
               ++k;
            }
         }
      
         int[] rangeValues = new int[k];
         int itr = 0;
      
         for (int i : a) {
            if (i >= low && i <= high) {
               rangeValues[itr] = i;
               ++itr;
            }
         }
      
         if (k == 0) {
            return rangeValues;
         } else {
            return rangeValues;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   /**
    * Returns the smallest value in a that is greater than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    */
   public static int ceiling(int[] a, int key) throws IllegalArgumentException {
      if (a != null && a.length != 0) {
         int placeholder = -1;
      
         for (int i = 0; i < a.length; ++i) {
            if ((placeholder < 0 || a[placeholder] > a[i]) && a[i] >= key) {
               placeholder = i;
            }
         }
      
         if (placeholder < 0) {
            throw new IllegalArgumentException();
         } else {
            return a[placeholder];
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
      
   /**
    * Returns the largest value in a that is less than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    */
   public static int floor(int[] a, int key) throws IllegalArgumentException {
      if (a != null && a.length != 0) {
         int placeholder = -1;
      
         for(int i = 0; i < a.length; ++i) {
            if ((placeholder < 0 || a[placeholder] < a[i]) && a[i] <= key) {
               placeholder = i;
            }
         }
      
         if (placeholder < 0) {
            throw new IllegalArgumentException();
         } else {
            return a[placeholder];
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
   
   private static void pressAnyKeyToContinue() { 
      System.out.println("Press Enter key to continue...");
      try
      {
         System.in.read();
      }  
      catch(Exception e) {}  
   }
   
   /**
    * Creates a string representation of an array.
    * @param  a the provided array
    * @return   a string representation of array a
    */
   static String toString(int[] a) {
      StringBuilder s = new StringBuilder();
      s.append("[");
      for (int i : a) {
         s.append(i + ", ");
      }
      s.delete(s.length() - 2, s.length());
      s.append("]");
      return s.toString();
    
   }
   
   public static void main(String[] args) {
   
      System.out.println("\nHello");
      pressAnyKeyToContinue();
      
      int [] arr1 = {2, 3, 4, 5, 6, 7, 8, -9, 1, -1, 0, -4};
      System.out.println("For the min method, our input array is: " + toString(arr1));
      System.out.println("=> min = " + Selector.min(arr1)); 
      
      int [] arr2 = {2, 3, 4, 5, 6, 7, 8, -9, 1, -1, 0, -4};
      System.out.println("\n\nFor the max method, our input array is: " + toString(arr1));
      System.out.println("=> max = " + Selector.max(arr2));    
   
   }
}
