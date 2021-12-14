/*****************************************************************************
 * Program represents an a electronic text that keeps track of word count in *
 * addition to everything that is done by OnlineTextItem and InventoryItem.  *
 * This class does not need to be instantiated as it is just a concept that  *
 * represents a number of items, so it is a subclass for InventoryItem.java  *
 * and will inherit the methods from OnlineTextItems.                        *
 *                                                                           *
 * Activity 9                                                                *
 * @author Midas Oden                                                        *
 * @version November 4, 2019                                                 *
 *****************************************************************************/

public class OnlineArticle extends OnlineTextItem {

// Instance Variables(s) - fields

   private int wordCount;
   
  /**
   * @param nameIn takes in the name of an item
   * @param priceIn takes in the price of an item
   */

   public OnlineArticle(String nameIn, double priceIn) {
      super(nameIn, priceIn);
      
      wordCount = 0;
   
   }
   
  /**
   *
   * @param wordsIn sets the word count
   */
    
   public void setWordCount(int wordsIn) {
   
      wordCount = wordsIn;
      
   }   
   
}
