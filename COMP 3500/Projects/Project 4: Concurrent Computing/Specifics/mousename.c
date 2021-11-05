/* 
 * Sample code for COMP 3500 project 4.
 * This sample code demonstrate how to declare an array of mouse names.
 * You may follow this style to create an array of cat names.
 * Compile: gcc mousename.c -o mousename
 * Run: ./mousename
 */
#include <stdio.h>

/* Number of mice. */
#define NUM_OF_MICE 2

static const char *const mousename[NUM_OF_MICE] = {
 "Jerry",
 "Jim",
};

int main() {
    int i;

    for (i = 0; i < NUM_OF_MICE; i++)
        printf("I am mouse %d, my name is: %s\n", i, mousename[i]);

    return 0;
}
