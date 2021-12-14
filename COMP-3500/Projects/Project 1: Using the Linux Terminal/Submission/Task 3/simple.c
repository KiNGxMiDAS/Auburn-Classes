#include<math.h>   // defines various math functions
#include<stdio.h>  // defines i/o operations



/* ====================================================================================*
 **                                                                                     * 
 *** FILE NAME:     simple.c                                                             *
 ***** AUTHOR:       Midas Oden                                                           *
 ****** VERSION:      08/24/2021                                                           *
 ******* COMPILE:      gcc -g -lm -o simple simple.c                                        *
 ******** EXECUTE:      ./simple                                                             *
 ********* DESCRIPTION:  Program is designed to read 10 numbers as input from the user        *
 **********              then find the sum of the square root of those numbers.                *
 ***********             Lastly, program will output the average of their square roots.         *
 ************                                                                                    *
 ************* ADDITIONAL HELP: I used geeksforgeeks.org to review constants, loops, arrays,      *
 **************                 the math library, method calling, returning strings,               *
 ***************                and format specifiers.                                              *
 ****************====================================================================================*/



//-------------DECLARATIONS-------------------------------------------------------------------

const int ARRAY_SIZE = 10;    // default size for array 

int loop = 0;  // used to loop thru array

double sum = 0.0;   // sum will be used to find the sum of the sqrt of the
                    // numbers in the array

float average = 0;    // average will be the average
                      // of those numbers divide by the size of the array


//------------METHODS/FUNCTIONS---------------------------------------------------------------

/*  
 * Displays a message prompting user to enter 10 numbers
 *
 * Input: none
 *
 * Return: a string of characters displaying message prompting
 *         user to enter in ten numbers
 *
 */
const char * enter10Numbers()
{
    return "\nEnter in 10 numbers (follow with a space after each number and press enter when finished):\n>> ";
}


/*  
 * Displays numbers entered by user 
 * 
 * Input: none
 *
 * Return: a string of characters displaying message showing
 *         what numbers were read as input
 *
 */
const char * displayAllNumbers()
{
    return "\n~ Finding the sum of the square roots inside of array... Σ√([ ";  
}


/*
 * Input: none
 *
 * Return: a string displaying that you've reached the end of the program
 *
 */
const char * endOfProgram()
{
    return "\n\n\n\n\n*** End of Program ***\n\n";
}



//------------DRIVER/SIMULATION-----------------------------------------------------------

int main()
{
    // declare an array of size 10
    int array[ARRAY_SIZE]; 

    // call enter10Numbers() function — print message to user
    printf("%s", enter10Numbers());

    // Loop through to accept all ten numbers entered by user
    for (loop = 0; loop < ARRAY_SIZE; loop++) 
    {
	scanf("%d", &array[loop]);
    }
   
    // call displayAllNumbers() function — display numbers entered by user
    printf("%s", displayAllNumbers());    

    // Loop through to print all numbers entered by user
    for (loop = 0; loop < ARRAY_SIZE; loop++)
    {
	printf("%d ", array[loop]);
    }
    printf("])");
   
    // Loop through the array to calculate the sum of the square root of the numbers
    for (loop = 0; loop < ARRAY_SIZE; loop++)
    {
	// add the square root of the array numbers and store in var sum
        sum += sqrt(array[loop]);
    }

    // calculate the average of the sum of the number's square roots in the array
    average = (float)sum / ARRAY_SIZE;
   
    // print the average of the square roots
    printf("\n>> The average of the square roots in array: %lf", average);

    // call endOfProgram() function — display that you've reached the end of the program
    printf("%s", endOfProgram());
    
  return 0;
}
