import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class TermTest {

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