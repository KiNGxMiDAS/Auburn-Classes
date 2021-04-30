# include <iostream>
# include <cstdlib>
# include <assert.h>
# include <string>

/* ====================================================================================*
 * FILE NAME:    project4_Oden_mto0006.cpp                                             *
 * AUTHOR:       Midas Oden                                                            *
 * VERSION:      03/11/2021                                                            *
 * COMPILE:      g++ project4_Oden_mto0006.cpp -o project4_Oden_mto0006                *
 * EXECUTE:      ./project4_Oden_mto0006                                               *
 *                                                                                     *
 * DESCRIPTION:  Program will implement a simple trivia quiz game. It will allow       *
 *               players to create their trivia questions and answers. The questions   *
 *               will be organised and managed using a linked data structure instead   *
 *               of an array.                                                          *
 * ====================================================================================*/
 
using namespace std;

int num_of_questions = 0;


//*** Un-comment the line below to test performance for unit test driver ***//
//#define UNIT_TESTING

// Structure for creating a linked list that holds
// a trivia question, answer, and amount of points earned.
struct TriviaNode {
   string question;
   string answer;
   int points;
   TriviaNode *next;
};
typedef TriviaNode* PointerNode; // creates a pointer to the TriviaNode structure


//=============PROTOTYPES==========================
void init_question_list(PointerNode& q_list);
void add_question(PointerNode& q_list);
int ask_question(PointerNode q_list, int num_ask);
void Unit_Test();

/* Sample user interface for the production version */
#define trivia_quiz
int main() {

//Creates a new trivia game/
//Sets up three original questions/
//Sets up loop for user to input his or her own questions.
//Quiz questions are stored in linked list.
#ifdef trivia_quiz
   PointerNode node_list = new TriviaNode;
   init_question_list(node_list);

// adds question from user input
   cout << "\n*** Welcome to Midas's trivia quiz game ***\n";
   string input;

   do {
      add_question(node_list);
      cout << "Continue? (Yes/No): ";
      getline(cin, input);
   } while (input.compare("Yes") == 0 || input.compare("yes") == 0);
   cout << endl;

// This is start of Trivia quiz game.
   ask_question(node_list, num_of_questions);
   cout << "\n*** Thank you for playing the trivia quiz game. Goodbye! ***";
   return 0;

}
#endif

// Method for debug version
#ifdef UNIT_TESTING
   Unit_Test();
   return 0;
}
#endif


//initializes the quiz to have these three questions inputted into the linked list.
void init_question_list(PointerNode& q_list) {
   PointerNode cur_ptr = new TriviaNode;

// Add first question
   cur_ptr->question = "How long was the shortest war on record? (Hint: how many minutes)";
   cur_ptr->answer = "38";
   cur_ptr->points = 100;

   cur_ptr->next = new TriviaNode;

// initialise q_list to the be question 1
   q_list = cur_ptr;
   cur_ptr = q_list->next;

// Add second question
   cur_ptr->question = "What was Bank of America's original name? (Hint: Bank of Italy or Bank of Germany)";
   cur_ptr->answer = "Bank of Italy";
   cur_ptr->points = 50;

   cur_ptr->next = new TriviaNode;
   cur_ptr = cur_ptr->next;

// Add third question
   cur_ptr->question = "What is the best-selling video game of all time? (Hint: Call of Duty or Wii Sports)";
   cur_ptr->answer = "Wii Sports";
   cur_ptr->points = 20;
   cur_ptr->next = NULL;

   num_of_questions = num_of_questions + 3;

}

//gives user the option to add a question to the linked list.
//question is added to the front of the linked list.
void add_question(PointerNode& q_list) {
// initialises a new pointer to TriviaNode structure
   PointerNode new_ptr = new TriviaNode;

//gets data from user.
   cout << "Enter a new question: ";
   getline(cin, new_ptr->question);

   cout << "Enter an answer: ";
   getline(cin, new_ptr->answer);

   cout << "Enter award points: ";
   cin >> new_ptr->points;

   cin.ignore();

   new_ptr->next = NULL;

   TriviaNode* end_of_list = q_list;
   while (end_of_list->next != NULL) {
      end_of_list = end_of_list->next;
   }
   end_of_list->next = new_ptr;

   num_of_questions++;

}


//Ask the user trivia questions and starts the game
int ask_question(PointerNode q_list, int num_ask) {
   PointerNode cur_ptr = q_list;
   string userAnswer;
   int totalPoints = 0;


   if (q_list == NULL) {
      return 0;
   }

   if(num_ask < 1) {
      cout << "Warning - the number of trivia to be asked must equal to or be larger than 1." << endl;
      return 1;
   } 
   else if (num_of_questions < num_ask) {
      cout << "Warning - There is only " << num_of_questions << " trivia in the list." << endl;
      return 1;
   } 
   else {
      for (int x = 0; x < num_ask; x++) {
         cout << "Question: " << cur_ptr->question << endl;
         cout << "Answer: ";
         getline(cin, userAnswer);
         if (userAnswer.compare(cur_ptr->answer) == 0) { // correct_answer
            cout << "Your answer is correct. You receive " << cur_ptr->points << " points." << endl; 
            totalPoints = totalPoints + cur_ptr->points;
         } 
         else {
            cout << "You answer is wrong. The correct answer is: " << cur_ptr->answer << endl;
         }
      
         cout << "Your total points: " << totalPoints << endl << endl;
      
         cur_ptr = cur_ptr->next;
      
      }
   
   }
   return 0;
}

/* Sample user interface for the debug version */
void Unit_Test() {
   cout << "\n*** This is a debugging version ***\n";

// initialise trivia question list
   PointerNode node_list = new TriviaNode;
   init_question_list(node_list);

// =====================UNIT TEST CASES============================= //
   cout << "Unit Test Case 1: Ask no question. The program should give a warning message." << endl;
   ask_question(node_list, 0);
   cout << "Case 1 Passed\n\n";

   cout << "Unit Test Case 2.1: Ask 1 question in the linked list. The tester enters an incorrect answer." << endl;
   ask_question(node_list, 1);
   cout << "Case 2.1 Passed\n\n";

   cout << "Unit Test Case 2.2: Ask 1 question in the linked list. The tester enters an correct answer." << endl;
   ask_question(node_list, 1);
   cout << "Case 2.2 Passed\n\n";

   cout << "Unit Test Case 3: Ask all the questions of the last trivia in the linked list." << endl;
   ask_question(node_list, 3);
   cout << "Case 3 Passed\n\n";

   cout << "Unit Test Case 4: Ask 5 questions in the linked list." << endl;
   ask_question(node_list, 5);
   cout << "Case 4 Passed\n\n";

//  =================END OF TEST CASES============================ //
   cout << "*** End of the Debugging Version ***" << endl;
   
}