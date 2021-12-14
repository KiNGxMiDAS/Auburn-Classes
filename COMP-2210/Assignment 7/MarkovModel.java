import java.io.File;
import java.util.*;
import java.io.IOException;

/**
 * MarkovModel.java Creates an order K Markov model of the supplied source
 * text. The value of K determines the size of the "kgrams" used to generate
 * the model. A kgram is a sequence of k consecutive characters in the source
 * text.
 *
 * @author     Midas Oden   (mto0006@auburn.edu)
 * @author     Dean Hendrix (dh@auburn.edu)
 * @version    2020-11-20
 *
 */
public class MarkovModel {

   // Map of <kgram, chars following> pairs that stores the Markov model.
   private HashMap<String, String> model;

   // add other fields as you need them ...
   private String first;


   /**
    * Reads the contents of the file sourceText into a string, then calls
    * buildModel to construct the order K model.
    *
    * DO NOT CHANGE THIS CONSTRUCTOR.
    *
    */
   public MarkovModel(int K, File sourceText) {
      model = new HashMap<>();
      try {
         String text = new Scanner(sourceText).useDelimiter("\\Z").next();
         buildModel(K, text);
      }
      catch (IOException e) {
         System.out.println("Error loading source text: " + e);
      }
   }

   /**
    * Calls buildModel to construct the order K model of the string sourceText.
    *
    * DO NOT CHANGE THIS CONSTRUCTOR.
    *
    */
   public MarkovModel(int K, String sourceText) {
      model = new HashMap<>();
      buildModel(K, sourceText);
   }

   /**
    * Builds an order K Markov model of the string sourceText.
    */
   private void buildModel(int K, String sourceText) {
      String placeHolder = "";
      int currentK = K;
      first = sourceText.substring(0, K);
      model = new HashMap<String, String>();
   
      for (int i = 0; currentK < sourceText.length() + 1; i++){
         String kGram = sourceText.substring(i, currentK);
      
         if (!(currentK < sourceText.length())) {
            if (model.containsKey(kGram) == true) {
               return;
            }
            else {
               model.put(kGram, "\u0000");
               return;
            }
         }
      
         if (!model.containsKey(kGram)) {
            model.put(kGram, sourceText.charAt(currentK) + "");
            currentK++;
            continue;
         }
      
         if ((model.containsKey(kGram))) {
         
            if (model.get(kGram) == null){
               model.put(kGram, sourceText.charAt(currentK) + "");
            }
            else {
               placeHolder = model.get(kGram);
               model.put(kGram, placeHolder + sourceText.charAt(currentK) + "");
            }
         }
         int decr = 1;
         currentK++;
      }
   }

   /** Returns the first kgram found in the source text. */
   public String getFirstKgram() {
      return first;
   }
   

   /** Returns a kgram chosen at random from the source text. */
   public String getRandomKgram() {
      Random randomInt = new Random();
      Set<String> kGrams = getAllKgrams();
      String[] elements = new String[model.size()];
      int searchSpace = model.size();
      int index = randomInt.nextInt(kGrams.size());
   
      int incr = 0;
   
      ArrayList<String> keyValues = new ArrayList<String>();
   
      for (String key : kGrams) {
         keyValues.add(key);
      }
   
      for (int i = 0; i < searchSpace; ++i) {
         elements[i] = keyValues.get(i);
      }
   
      String randomKGram = elements[randomInt.nextInt(model.size())];
   
      return randomKGram;
   }

   /**
    * Returns the set of kgrams in the source text.
    *
    * DO NOT CHANGE THIS METHOD.
    *
    */
   public Set<String> getAllKgrams() {
      return model.keySet();
   }

   /**
    * Returns a single character that follows the given kgram in the source
    * text. This method selects the character according to the probability
    * distribution of all characters that follow the given kgram in the source
    * text.
    */
   public char getNextChar(String kgram) {
      Random randomInt = new Random();
      char[] characters = kgram.toCharArray();
   
      if (model.get(kgram) == null) {
         return '\u0000';
      }
   
      int count = model.get(kgram).length();
      int index = randomInt.nextInt(count);
   
      return model.get(kgram).charAt(index);
   
   }

   /**
    * Returns a string representation of the model.
    * This is not part of the provided shell for the assignment.
    *
    * DO NOT CHANGE THIS METHOD.
    *
    */
   @Override
    public String toString() {
      return model.toString();
   }

}
