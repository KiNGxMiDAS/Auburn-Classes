import javax.swing.JOptionPane;

/**************************************************************************
 * Driver program that creates a dialog box that allows the user to input *
 * an integer representing the numerator and denominator as a String. The *
 * program will then compute either integer or decimal division.          *
 *                                                                        *
 * Activity 11                                                            *
 * @author Midas Oden                                                     *
 * @version November 18, 2019                                             *
 **************************************************************************/  

public class DivisionDriver {

 /**
  * @param args ~ command-line arguments
  */
  
   public static void main(String[] args) {
   
      String numInput = JOptionPane.showInputDialog("Enter the numerator:");
      String denomInput = JOptionPane.showInputDialog("Enter the denominator:");
      
      try {
         int num = Integer.parseInt(numInput);
         int denom = Integer.parseInt(denomInput);
      
         String result = "Integer division: \n"
                       + Division.intDivide(num, denom)
                       + "\n\nFloating point division: \n"
                       + Division.decimalDivide(num, denom);
      
         JOptionPane.showMessageDialog(null, result, "Result", 
            JOptionPane.PLAIN_MESSAGE);
            
      } catch (NumberFormatException e) {
         JOptionPane.showMessageDialog(null, "Invalid input: enter numerical "
            + "integer values only.", "Error", JOptionPane.ERROR_MESSAGE);
            
      } catch (IllegalArgumentException e) {
         JOptionPane.showMessageDialog(null, e, "Error", 
            JOptionPane.ERROR_MESSAGE);
            
      }
   }
}