  // Import user input
  
import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;
  
/**
 * Program will accept coded football ticket information as input 
 * that includes the ticket price, discount, time, date, section,
 * row, and seat followed by the description of the game. Note that below 
 * the five digits for price and two digits for discount have an implied
 * decimal point. The program will then print the ticket information 
 * including the actual cost, which is the price with the discount applied.
 * The last line of the ticket will contain a random "prize number" between
 * 1 and 9999999 inclusive that should always be printed as seven digits
 * (e.g. 1 should be printed as 0000001). The coded input is formatted 
 * as follows: 0500070180009142019043121Team1 vs Team2
 *
 * Project 3
 * @author Midas Oden
 * @version September 10, 2019
 */
    
public class TicketDecoder
{

    /**
     * Program will read data for a ticket order and
     * then interpret and print the formatted ticket
     * information.
     *
     * @param args Command line arguments – not used.
     */
     
   public static void main(String[] args) 
   {
   
      Random prizeNumberGenerator = new Random();  
      Scanner userInput = new Scanner(System.in);
      DecimalFormat prizeNumberFormat = new DecimalFormat("0000000");
      DecimalFormat priceFormat = new DecimalFormat("$#,##0.00");
      DecimalFormat discountFormat = new DecimalFormat("0%");
               
   // Local Variables
      String inputTicket;    
      String ticket;
      String price;
      String discount;
      String section;
      String row;
      String game;
      String seat;
      String hour;
      String minutes;
      String day;
      String month;
      String year;
      double priceDouble;
      double priceDiscount;
      double actualCost;
      int prizeNumber;
      
   // Prompt user for the ticket code and trim 
      System.out.print("Enter your ticket code: ");
      /*String*/ inputTicket = userInput.nextLine();
      
      System.out.println();
      /*String*/ ticket = inputTicket.trim();
      
   // Check for valid ticket
      if (ticket.length() < 26) {
         System.out.println("Invalid Ticket Code. "
            + "\nTicket code must have at least 26 characters.");
         return;
      }
      
   // Evaluate ticket price
      /*String*/ price = ticket.substring(0, 5);
      /*double*/ priceDouble = Double.parseDouble(price) / 100;
          
      // Evaluate discount of the ticket
      /*String*/ discount = ticket.substring(5, 7);
      /*double*/ priceDiscount = Double.parseDouble(discount) / 100;
      if (priceDiscount == 0) {
         actualCost = priceDouble;
      }
       // ~~~ Apply discount to game ticket ~~~ //
      else {
         actualCost = priceDouble - (priceDouble * priceDiscount);
      }
      
      /*String*/ hour = ticket.substring(7, 9);
      /*String*/ minutes = ticket.substring(9, 11);
      /*String*/ month = ticket.substring(11, 13);
      /*String*/ day = ticket.substring(13, 15);
      /*String*/ year = ticket.substring(15, 19);
      /*String*/ section = ticket.substring(19, 21);
      /*String*/ row = ticket.substring(21, 23);
      /*String*/ seat = ticket.substring(23, 25);
      /*String*/ game = ticket.substring(25, ticket.length());
      /*int*/ prizeNumber = prizeNumberGenerator.nextInt(9999999) + 1;
     
         
      System.out.print("Game: " + game);
      System.out.print("   Date: " + month + "/" + day + "/" + year);
      System.out.println("   Time: " + hour + ":" + minutes);
      System.out.print("Section: " + section);
      System.out.print("   Row: " + row);
      System.out.println("   Seat: " + seat);
      System.out.print("Price: " + priceFormat.format(priceDouble));
      System.out.print("   Discount: " + discountFormat.format(priceDiscount));
      System.out.println("   Cost: " + priceFormat.format(actualCost));
      System.out.println("Prize Number: " + prizeNumber);
      
   }
     
}