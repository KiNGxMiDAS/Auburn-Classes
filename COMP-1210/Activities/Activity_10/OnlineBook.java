/*****************************************************************************
 * Program will inherit from the OnlineTextItem class.                       *
 *                                                                           *
 * Activity 9                                                                *
 * @author Midas Oden                                                        *
 * @version November 4, 2019                                                 *
 *****************************************************************************/

public class OnlineBook extends OnlineTextItem {

// Instance Variable(s) - fields

   protected String author;

 /**
  * @param nameIn takes in the name of an item
  * @param priceIn takes in the price of an item
  */

   public OnlineBook(String nameIn, double priceIn) {
      super(nameIn, priceIn);
      
      author = "Author Not Listed";
   
   }
   
  /**
   * @return Returns the author name's and the price of a book item
   */
   
   public String toString() {
   
      String output = name + " - " + author + ": $" + price;
      return output;
   
   }
   
  /**
   * @param nameIn sets the author's name
   */
   
   public void setAuthor(String nameIn) {
   
      author = nameIn;
      
   }   
   
}