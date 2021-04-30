 # include <iostream>

/* ===========================================
 * FILE NAME: project1_Oden_mto0006.cpp      *
 * AUTHOR:    Midas Oden                     *
 * VERSION:   01/29/2021                     *
 * COMPILE:   g++ project1_Oden_mto0006.cpp  *
 * EXECUTE:   ./a.out                        *
 * ==========================================*/
 
using namespace std;
 
int main() {

   //============VARIABLE INITIALISATION=================
   float loan, interestRate, monthlyPaid = 0.0;
   float interestRateC, interestPaid, principalPaid;   
   float interestTotal = 0;
   int currentMonth = 0;

         
   //===========CURRENCY FORMATTING======================
   cout.setf(ios::fixed);
   cout.setf(ios::showpoint);
   cout.precision(2);
   

   //=========USER INPUT=================================
   cout << "\nLoan Amount: ";
   cin >> loan;  
      
   cout << "Interest Rate (% per year): ";
   cin >> interestRate;  
           
   cout << "Monthly Payments: ";
   cin >> monthlyPaid;


   //===GET PROPER INTEREST RATES FOR CALCULATIONS========
   interestRateC = interestRate / 12 / 100;
   //=====================================================
   
          
   cout << endl;
      
   //========AMORTISATION TABLE============================
   cout << "**********************************************************" << endl
        << "        Amortization Table"                                 << endl
        << "**********************************************************" << endl;

   cout << "Month\tBalance\t  Payment    Rate   Interest\t Principal" << endl;
                   
              
   // LOOP TO FILL TABLE
   while (loan > 0) {
      if (currentMonth == 0) {
         cout << currentMonth++ << "\t$" << loan;
         
         if (loan < 2000) //cout << "\t"; // Formatting MAGIC :-D
            cout << "  N/A\t     N/A    N/A\t         N/A\n";
      }
      else {
      
      // PROPERLY CALCULATE AND DISPLAY "monthlypaid" AND "principal" WHEN 
      // (1) loan * (1 + interestRateC) < mohthlyPaid
      // and (2) loan * (1 + interestRateC) >= monthlyPaid
      
         interestPaid = loan * interestRateC;
         principalPaid = monthlyPaid - interestPaid;
         loan = loan - principalPaid;
         interestTotal = interestTotal + interestPaid;
         
         if (loan < 0) {
            principalPaid = principalPaid + loan;
            monthlyPaid = monthlyPaid + loan;
            loan = 0;
         }
         
         cout << currentMonth++ << "\t$" << loan;
         
         if (loan < 2000)
            cout << "\t";
         
         cout << "  $" << monthlyPaid << "     " << interestRateC * 100 << "   $" << interestPaid << "\t $" << principalPaid << "\t\t\t\n"; 
      }
      
   } // END TABLE
   
   cout << "**********************************************************\n";
   cout << "\nIt takes " << --currentMonth << " months to pay off "
           << "the loan.\n"
           << "Total interest paid is: $" << interestTotal;
   cout << endl << endl;
   return 0;
         
} // END OF PROGRAM
  // HAVING TROUBLE WITH ALIGNMENT FOR AMORTISATION TABLE