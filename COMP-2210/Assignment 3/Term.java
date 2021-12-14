import java.util.Arrays;
import java.util.Comparator;

/**
 * Term supports being able to sort terms in either lexicographical order,
 * descending order of weight, and lexicographic order by first letter.
 *
 * @author  Midas Oden (mto0006@auburn.edu)
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version 2020/10/04
 */
public class Term implements Comparable<Term> {

   // Fields
   String query;
   long weight;

   /**
    * Initialize a term with the given query and weight.
    * This method throws a NullPointerException if query is null,
    * and an IllegalArgumentException if weight is negative.
    */
   public Term(String query, long weight) {
      if (query == null) {
         throw new NullPointerException("Query cannot be null");
      }
      if (weight < 0) {
         throw new IllegalArgumentException("Weight cannot be negative");
      }
   
      this.query = query;
      this.weight = weight;
   }

   /**
    * Compares the two terms in descending order of weight.
    */
   public static Comparator<Term> byDescendingWeightOrder() {
      return 
         new Comparator<Term>() {
            @Override
            public int compare(Term o1, Term o2) {
               return Long.compare(o2.weight, o1.weight);  // originally ~ (Long) (o2.weight - o1.weight);
            }
         };
   }

   /**
    * Compares the two terms in ascending lexicographic order of query,
    * but using only the first length characters of query. This method
    * throws an IllegalArgumentException if length is less than or equal
    * to zero.
    */
   public static Comparator<Term> byPrefixOrder(int length) {
      if (length <= 0) {
         throw new IllegalArgumentException("Length cannot be less than or equal to zero!");
      }
      return 
         new Comparator<Term>() {
            @Override
            public int compare(Term o1, Term o2) {
               return o1.query.substring(0, length).compareTo(o2.query.substring(0,length));
            }
         };
   }

   /**
    * Compares this term with the other term in ascending lexicographic order
    * of query.
    */
   @Override
   public int compareTo(Term other) {
      return this.query.compareTo(other.query);
   }

   /**
    * Compares this term with the given object for equality.
    */
   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }
      if (obj == this) {
         return true;
      }
      if(obj.getClass() != Term.class) {
         return false;
      }
      Term other = (Term) obj;
      return this.query.compareTo(other.query) == 0;
   }

   /**
    * Returns a string representation of this term in the following format:
    * query followed by a tab followed by weight
    */
   @Override
   public String toString() {
      return this.query + "\t" + Long.toString(this.weight);
   
   }
   
   public static void main(String[] args) {
      Term[] terms = {new Term("Debbie", 3), new Term("Abcd", 8), new Term("Cathy", 5), new Term("Abbcd", 2)};
      for (Term term : terms) System.out.println(term);
      System.out.println();
   	
      Arrays.sort(terms, Term.byDescendingWeightOrder());
      for (Term term : terms) System.out.println(term);
      System.out.println();
   	
      Arrays.sort(terms, Term.byPrefixOrder(2));
      for (Term term : terms) System.out.println(term);
      System.out.println();
   	
      Arrays.sort(terms);
      for (Term term : terms) System.out.println(term);
   }

}