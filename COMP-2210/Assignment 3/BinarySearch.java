import java.util.Arrays;
import java.util.Comparator;

/**
 * BinarySearch provides two search methods, both
 * of which are variants of the classic binary search
 * presented in lecture. When binary searching a sorted
 * array that contains more than one key equal to the
 * search key, the client may want to know the index of
 * either the first or last matching key.
 *
 * @author  Midas Oden (mto0006@auburn.edu)
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version 2020/10/04
 */
public class BinarySearch {

   /**
    * Returns the index of the first key in a[] that equals the search key,
    * or -1 if no such key exists. This method throws a NullPointerException
    * if any parameter is null.
    */
   public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
      if (a == null || key == null || comparator == null) {
         throw new NullPointerException();
      }
      if (a.length == 0) {
         return -1;
      }
   
      int l = 0;
      int r = a.length - 1;
      int index = -1;
      while (l <= r) {
         int mid = l + (r - l)/2;
         if (comparator.compare(key, a[mid]) < 0) {
            r = mid - 1;
         } else if (comparator.compare(key, a[mid]) > 0) {
            l = mid + 1;
         } else {
            index = mid;
            r = mid - 1;
         }
      }
   
      return index;
   }

   /**
    * Returns the index of the last key in a[] that equals the search key,
    * or -1 if no such key exists. This method throws a NullPointerException
    * if any parameter is null.
    */
   public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
      if (a == null || key == null || comparator == null) {
         throw new java.lang.NullPointerException();
      }
      if (a == null || a.length == 0) {
         return -1;
      }
   
      int l = 0;
      int r = a.length - 1;
      int index = -1;
      while (l <= r) {
         int mid = l + (r - l)/2;
         if (comparator.compare(key, a[mid]) < 0) {
            r = mid - 1;
         } else if (comparator.compare(key, a[mid]) > 0) {
            l = mid + 1;
         } else {
            index = mid;
            l = mid + 1;
         
         }
      
      
      }
      return index;
   }
}