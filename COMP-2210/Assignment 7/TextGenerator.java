import java.io.File;
import java.io.IOException;

/**
 * TextGenerator.java. Creates an order K Markov model of the supplied source
 * text, and then outputs M characters generated according to the model.
 *
 * @author     Midas Oden   (mto0006@auburn.edu)
 * @author     Dean Hendrix (dh@auburn.edu)
 * @version    2020-11-20
 *
 */
public class TextGenerator {

   /** Drives execution. */
   public static void main(String[] args) {

      if (args.length < 3) {
         System.out.println("Usage: java TextGenerator k length input");
         return;
      }

      // No error checking! You may want some, but it's not necessary.
      int K = Integer.parseInt(args[0]);
      int M = Integer.parseInt(args[1]);
      if ((K < 0) || (M < 0)) {
         System.out.println("Error: Both K and M must be non-negative.");
         return;
      }

      File text;
      try {
         text = new File(args[2]);
         if (!text.canRead()) {
            throw new Exception();
         }
      }
      catch (Exception e) {
         System.out.println("Error: Could not open " + args[2] + ".");
         return;
      }


      // instantiate a MarkovModel with the supplied parameters and
      // generate sample output text ...

      MarkovModel model = new MarkovModel(K, text);
      String kGram = model.getFirstKgram();
      String outputText = kGram;
      int length = kGram.length();

      for (int i = length; i < M; i++) {
         if (model.getNextChar(kGram) == '\u0000') {
            kGram = model.getRandomKgram();
         }

         char character = model.getNextChar(kGram);
         outputText += character;
         kGram = outputText.substring(outputText.length() - K);
      }

      System.out.println(outputText);
   }
}
