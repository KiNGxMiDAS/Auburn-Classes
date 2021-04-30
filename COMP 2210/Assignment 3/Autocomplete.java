import java.util.Arrays;
import java.util.Comparator;

/**
 * Autocomplete uses the Term and BinarySearch class
 * to provide complete autocomplete functionality
 * for a given set of strings and weights.
 *
 * @author  Midas Oden (mto0006@auburn.edu)
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version 2020/10/04
 */
public class Autocomplete {
   private Term[] terms;

   /**
    * Initializes a data structure from the given array of terms.
    * This method throws a NullPointerException if terms is null.
    */
   public Autocomplete(Term[] terms) {
      if (terms == null) throw new NullPointerException("Terms can't be null");
   
      this.terms = terms;
      Arrays.sort(terms);
   }

   /**
    * Returns all terms that start with the given prefix, in descending order of weight.
    * This method throws a NullPointerException if prefix is null.
    */
   public Term[] allMatches(String prefix) {
      if (prefix == null) {
         throw new java.lang.NullPointerException();
      }
      Term temp = new Term(prefix, 0);
   
      int i = BinarySearch.firstIndexOf(terms, temp,
             Term.byPrefixOrder(prefix.length()));
      int j = BinarySearch.lastIndexOf(terms, temp,
             Term.byPrefixOrder(prefix.length()));
      if (i == -1 || j == -1) {
         throw new java.lang.NullPointerException();
      }
      Term[] matches = new Term[j - i + 1];
      matches = Arrays.copyOfRange(terms, i, j);
      Arrays.sort(matches, Term.byDescendingWeightOrder());
      return matches;
   
   }

}