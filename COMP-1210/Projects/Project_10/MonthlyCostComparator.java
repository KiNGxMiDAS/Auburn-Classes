import java.util.Comparator;

/****************************************************************************
 * Program implements the Comparator interface for WirelessNetwork objects. *
 * Hence, it implements the compare() method and defines the ordering from  *
 * highest to lowest based on the wireless network's bandwidth.             *
 *                                                                          *
 * Project 10                                                               *
 * @author Midas Oden                                                       *
 * @version November 21, 2019                                               *
 ****************************************************************************/

public class MonthlyCostComparator implements Comparator<WirelessNetwork> { 

 /**
  * @param n1 represents object 1
  * @param n2 represents object 2
  * @return Returns sorted monthly cost
  */

   public int compare(WirelessNetwork n1, WirelessNetwork n2) {
   
      if (n1.getMonthlyFixedCost() > n2.getMonthlyFixedCost()) {
         return -1;
      }
      else if (n1.getMonthlyFixedCost() < n2.getMonthlyFixedCost()) {
         return 1;
      } else {
         return 0;
      }
   }   
}