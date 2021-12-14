import java.util.Comparator;

/****************************************************************************
 * Program implements the Comparator interface for WirelessNetwork objects. *
 * Hence, it implements the compare() method and defines the ordering from  *
 * lowest to highest based on the wireless network's bandwidth.             *
 *                                                                          *
 * Project 10                                                               *
 * @author Midas Oden                                                       *
 * @version November 21, 2019                                               *
 ****************************************************************************/

public class BandwidthComparator implements Comparator<WirelessNetwork> { 

 /**
  * @param n1 represents object 1
  * @param n2 represents object 2
  * @return Returns sorted bandwidth
  */
  
   public int compare(WirelessNetwork n1, WirelessNetwork n2) {
   
      if (n1.getBandwidth() < n2.getBandwidth()) {
         return -1;
      }
      else if (n1.getBandwidth() > n2.getBandwidth()) {
         return 1;
      } else {
         return 0;
      }
   }  
}