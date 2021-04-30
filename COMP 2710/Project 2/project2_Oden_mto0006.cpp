# include <iostream>
# include <stdlib.h>
# include <assert.h>
# include <ctime>

/* ====================================================================================*
 * FILE NAME:    project2_Oden_mto0006.cpp                                             *
 * AUTHOR:       Midas Oden                                                            *
 * VERSION:      02/11/2021                                                            *
 * COMPILE:      g++ project2_Oden_mto0006.cpp -o project2_Oden_mto0006                *
 * EXECUTE:      ./project2_Oden_mto0006                                               *
 * DESCRIPTION:  Program is designed to determine the winner of a duel                 *
 *               based on the player's probability.                                    *
 * ====================================================================================*/
 
using namespace std;



//================VARIABLES======================================================================

// probabilities for each player: Aaron, Bob, and Charlie
const double A_ACCURACY = (1.0/3.0) * 100.0;
const double B_ACCURACY = (1.0/2.0) * 100.0;
const double C_ACCURACY = 100;

// player status
bool A_alive = true;
bool B_alive = true;
bool C_alive = true;

// player wins
double aaronWins1 = 0;
double aaronWins2 = 0;
double bobWins = 0;
double charlieWins = 0;

// total duels to simulate
const int TOTAL_RUNS = 10000;



//============METHODS/FUNCTIONS==================================================================

/*
 * Input: A_alive indicates Aaron is alive true for alive, false for dead
 *        B_alive indicates Bob is alive
 *        C_alive indicates Charlie is alive
 *
 * Return: true if at least two are alive otherwise return false
 */
bool at_least_two_alive(bool A_alive, bool B_alive, bool C_alive) {

   return ( (A_alive && B_alive) || (A_alive && C_alive) || ( B_alive && C_alive) || (A_alive && B_alive && C_alive));
   
}  
       
      
/*
 * Call by reference
 *
 * Strategy 1: Everyone shoots to kill the highest accuracy player alive
 *
 * Input:  B_alive indicates Bob is alive or dead
 *         C_alive indicates Aaron is alive or dead
 *
 * Return: Change B_alive into false if Bob is killed
 *         Change C_alive into false if Charlie is killed
 */
void Aaron_shoots1(bool& B_alive, bool& C_alive) { 
   
   double shooting_result = rand() % 100;
       
   if (shooting_result <= A_ACCURACY) {
      if (C_alive) {
         C_alive = false;
         //cout << "Charlie is dead.\n";
      } 
      else if (B_alive) {
         B_alive = false;
         //cout << "Bob is dead.\n";
      }
   } 
           
}
   

/*
 * Call by reference
 *
 * Strategy 1: Everyone shoots to kill the highest accuracy player alive
 *
 * Input:  A_alive indicates if Aaron is alive or dead
 *         C_alive indicates whether Charlie is alive or dead
 *
 * Return: Change A_alive into false if Aaron is killed
 *         Change C_alive into false if Charlie is killed
 */
void Bob_shoots(bool& A_alive, bool& C_alive) {

   double shooting_result = rand() % 100;
   
   if (shooting_result <= B_ACCURACY) {
      if (C_alive) {
         C_alive = false;
         //cout << "Charlie is dead.\n";
      }
      else {
         A_alive = false;
         //cout << "Aaron is dead.\n";
      }
   }
   
}
   

/* Call by reference
 *
 * Input:  A_alive indicates if Aaron is alive or dead
 *         B_alive indicates whether Bob is alive or dead
 *
 * Return: Change A_alive into false if Aaron is killed.
 *         Change B_alive into false if Bob is killed.
 */
void Charlie_shoots(bool& A_alive, bool& B_alive) {

   if (B_alive) {
      B_alive = false;
      //cout << "Bob is dead.\n";
   }
   else {
      A_alive = false;
      //cout << "Aaron is dead.\n";
   }
   
}
   

/* Strategy 2: Use call by reference
 *
 * Input:  B_alive indicates whether Bob alive or dead
 *         C_alive indicates whether Charlie is alive or dead
 *
 * Return: Change B_alive into false if Bob is killed.
 *         Change C_alive into false if Charlie is killed.
 */
void Aaron_shoots2(bool& B_alive, bool& C_alive) {

   double shooting_result = rand() % 100;
   
   if (!(B_alive && C_alive)) {
      if (shooting_result <= A_ACCURACY) {
         if (C_alive) {
            C_alive = false;
            //cout << "Charlie is dead.\n";
         }
         else if (B_alive) {
            B_alive = false;
            //cout << "Bob is dead.\n"; 
         
         }
      }          
   } 
   else {
      //cout << "Aaron missed.\n";
   }
     
}
   

// Simple method to implement pause function in linux
void PressEnter(void) {
   cout << "Press Enter to continue...";
   cin.get();

}

    
//=============TEST PROTOTYPES====================================================================
    
/* Implementation of the test driver for at_least_two_alive() */
void test_at_least_two_alive(void) {
   cout << "Unit Testing 1: Function - at_least_two_alive()\n";
   
   cout << "\t Case 1: Aaron alive, Bob alive, Charlie alive\n";
   assert(true == at_least_two_alive(true, true, true));
   cout << "\t Case passed ...\n";
   
   cout << "\t Case 2: Aaron dead, Bob alive, Charlie alive\n";
   assert(true == at_least_two_alive(false, true, true));
   cout << "\t Case passed ...\n";

   cout << "\t Case 3: Aaron alive, Bob dead, Charlie alive\n";
   assert(true == at_least_two_alive(true, false, true));
   cout << "\t Case passed ...\n";
   
   cout << "\t Case 4: Aaron alive, Bob alive, Charlie dead\n";
   assert(true == at_least_two_alive(true, true, false));
   cout << "\t Case passed ...\n";
   
   cout << "\t Case 5: Aaron dead, Bob dead, Charlie alive\n";
   assert(false == at_least_two_alive(false, false, false));
   cout << "\t Case passed ...\n";
   
   cout << "\t Case 6: Aaron dead, Bob alive, Charlie dead\n";
   assert(false == at_least_two_alive(false, true, false));
   cout << "\t Case passed ...\n";
      
   cout << "\t Case 7: Aaron alive, Bob dead, Charlie dead\n";
   assert(false == at_least_two_alive(true, false, false));
   cout << "\t Case passed ...\n";
   
   cout << "\t Case 8: Aaron dead, Bob dead, Charlie dead\n";
   assert(false == at_least_two_alive(false, false, false));
   cout << "\t Case passed ...\n";
   
   PressEnter();

}


/* Implementation of the test driver for Aaron_shoot1() */
void test_Aaron_shoots1(void) {
   cout << "\nUnit Testing 2: Function Aaron_shoots1(Bob_alive, Charlie_alive)\n";

   cout << "\t Case 1: Bob alive, Charlie alive\n";
   B_alive = true;
   C_alive = true;
   Aaron_shoots1(B_alive, C_alive);
   cout << "\t\t  Aaron is shooting at Charlie\n";  
   
   cout << "\t Case 2: Bob dead, Charlie alive\n";
   B_alive = false;
   C_alive = true;
   Aaron_shoots1(B_alive, C_alive);
   cout << "\t\t  Aaron is shooting at Charlie\n";
   
   cout << "\t Case 3: Bob alive, Charlie dead\n";
   B_alive = true;
   C_alive = false;
   Aaron_shoots1(B_alive, C_alive);
   cout << "\t\t  Aaron is shooting at Bob\n";
   
   PressEnter();   
}


/* Implementation of the test driver for Bob_shoots() */
void test_Bob_shoots() {
   cout << "\nUnit Testing 3: Function Bob_shoots(Aaron_alive, Charlie_alive)\n";
   
   cout << "\t Case 1: Aaron alive, Charlie alive\n";
   A_alive = true;
   C_alive = true;
   Bob_shoots(A_alive, C_alive);
   cout << "\t\t  Bob is shooting at Charlie\n";  
   
   cout << "\t Case 2: Aaron dead, Charlie alive\n";
   A_alive = false;
   C_alive = true;
   Bob_shoots(A_alive, C_alive);
   cout << "\t\t  Bob is shooting at Charlie\n";
   
   cout << "\t Case 3: Aaron alive, Charlie dead\n";
   A_alive = true;
   C_alive = false;
   Aaron_shoots1(B_alive, C_alive);
   cout << "\t\t  Bob is shooting at Aaron\n";
       
   PressEnter();   

}


/* Implementation of the test driver for Charlie_shoots() */
void test_Charlie_shoots() {
   cout << "\nUnit Testing 4: Function Charlie_shoots(Aaron_alive, Bob_alive)\n";
   
   cout << "\t Case 1: Aaron alive, Bob alive\n";
   A_alive = true;
   B_alive = true;
   Charlie_shoots(A_alive, B_alive);
   cout << "\t\t  Charlie is shooting at Bob\n";  
   
   cout << "\t Case 2: Aaron dead, Bob alive\n";
   A_alive = false;
   B_alive = true;
   Charlie_shoots(A_alive, B_alive);
   cout << "\t\t  Charlie is shooting at Bob\n";
   
   cout << "\t Case 3: Aaron alive, Bob dead\n";
   A_alive = true;
   B_alive = false;
   Charlie_shoots(A_alive, B_alive);
   cout << "\t\t  Charlie is shooting at Aaron\n";
   
   PressEnter();   
   
}


/* Implementation of the test driver for Aaron_shoots2() */
void test_Aaron_shoots2() {
   cout << "\nUnit Testing 5: Function Aaron_shoots2(Bob_alive, Charlie_alive))\n";
   
   cout << "\t Case 1: Bob alive, Charlie alive\n";
   B_alive = true;
   C_alive = true;
   Aaron_shoots2(B_alive, C_alive);
   cout << "\t\t  Aaron intentionally misses his first shot\n";
   cout << "\t\t  Both Bob and Charlie are alive.\n";  
   
   cout << "\t Case 2: Bob dead, Charlie alive\n";
   B_alive = false;
   C_alive = true;
   Aaron_shoots2(B_alive, C_alive);
   cout << "\t\t  Aaron is shooting at Charlie\n";
   
   cout << "\t Case 3: Bob alive, Charlie dead\n";
   B_alive = true;
   C_alive = false;
   Aaron_shoots2(B_alive, C_alive);
   cout << "\t\t  Aaron is shooting at Bob\n";
   
   PressEnter();   
   
}
         
         

//================DRIVER/SIMULATION================================================================ 

int main() {
    
   // Initialises random number generator's seed and calls test functions
   srand(time(0));
   
   // Prints the user interface   
   cout << "\n*** Welcome to Midas's Duel Simulator ***\n";
   
   // Unit testing prototypes  
   test_at_least_two_alive();         
   test_Aaron_shoots1(); 
   test_Bob_shoots();
   test_Charlie_shoots();   
   test_Aaron_shoots2();
  
   // Starts strategy 1 and runs 10,000 times
   cout << "\nReady to test strategy 1 (run 10000 times):\n";
   PressEnter();   

   for (int i = 0; i < TOTAL_RUNS; i++) {
      A_alive = true;
      B_alive = true;
      C_alive = true;
   
      while (at_least_two_alive(A_alive, B_alive, C_alive)) {
         if (A_alive) {
            Aaron_shoots1(B_alive, C_alive);
         }
         if (B_alive) {
            Bob_shoots(A_alive, C_alive);
         }
         if (C_alive) {
            Charlie_shoots(A_alive, B_alive);
         }
      }
      
      // Assign points to the winner at the end of the duel
      if (A_alive) {
         aaronWins1++;
      }
      else if (B_alive) {
         bobWins++;
      }
      else if (C_alive) {
         charlieWins++;
      }
   }
   
   
   cout << "\nAaron won " << aaronWins1 << "/10000 duels or " << 
            static_cast<double>(aaronWins1) / TOTAL_RUNS * 100 << "%\n";
           
   cout << "Bob won " << bobWins << "/10000 duels or " << 
               static_cast<double>(bobWins) / TOTAL_RUNS * 100 << "%\n";
              
   cout << "Charlie won " << charlieWins << "/10000 duels or " << 
                static_cast<double>(charlieWins) / TOTAL_RUNS * 100 << "%\n";
                
                   
   // Reinitializes variables and starts strategy 2 to run 10,000 times             
   cout << "\nReady to test strategy 2 (run 10000 times):\n";
   PressEnter();   
   
   for (int i = 0; i < TOTAL_RUNS; i++ ){             
      A_alive = true;
      B_alive = true;
      C_alive = true;
   
      while (at_least_two_alive(A_alive, B_alive, C_alive)) {
         if (A_alive) {
            Aaron_shoots2(B_alive, C_alive);
         }
         if (B_alive) {
            Bob_shoots(A_alive, C_alive);
         }
         if (C_alive) {
            Charlie_shoots(A_alive, B_alive);
         }
      }  
      
      // Assign points to the winner at the end of the duel
      if (A_alive) {
         aaronWins2++;
      }
      else if (B_alive) {
         bobWins++;
      }
      else if (C_alive) {
         charlieWins++;
      }  
        
   }
      
   cout << "\nAaron won " << aaronWins2 << "/10000 duels or " << 
               static_cast<double>(aaronWins2) / TOTAL_RUNS * 100 << "%\n";
               
   cout << "Bob won " << bobWins << "/10000 duels or " << 
                   static_cast<double>(bobWins) / TOTAL_RUNS * 100 << "%\n";
                   
   cout << "Charlie won " << charlieWins << "/10000 duels or " << 
                  static_cast<double>(charlieWins) / TOTAL_RUNS * 100 << "%\n";
         
   // Determine the better strategy              
   if (aaronWins2 < aaronWins1) {
      cout << "\nStrategy 1 is better than strategy 2.\n";
   }
   else {
      cout << "\nStrategy 2 is better than strategy 1.\n\n";
   }
   
   
   return 0;
   
   
}
