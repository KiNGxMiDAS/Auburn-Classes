/*
 * catsem.c
 *
 * 30-1-2003 : GWA : Stub functions created for CS161 Asst1.
 *
 * NB: Please use SEMAPHORES to solve the cat syncronization problem in 
 * this file.
 */


/*
 * 
 * Includes
 *
 */
#include <types.h>
#include <lib.h>
#include <synch.h>
#include <test.h>
#include <thread.h>

/*
 * 
 * Constants
 *
 */

/*
 * Boolean data type
 */
typedef int bool;
#define TRUE 1
#define FALSE 0

/*
 * Number of food bowls.
 */
#define NFOODBOWLS 2

/*
 * Number of animals total.
 */
#define NANIMALS 8

/*
 * Number of cats.
 */
#define NCATS 6

/*
 * Number of mice.
 */
#define NMICE 2


//----------GLOBAL DECLARATIONS------------------------------------------------------------

/*
 * Semaphores (6)
 */
struct semaphore *dish_mutex = 0;

/*
 * Counters
 */

// keeps tracking of the number of currently waiting in the queue(no. in cats_queue) and the cats who're eating
// So basically keeps track of the total number of cats
int cat_wait_count[6] = {0,0,0,0,0,0};
int mice_wait_count[2] = {0,0,0,0,0,0};
int dish1 = 0;
int dish2 = 0;


/*
 * 
 * Function Definitions
 * 
 */

/*
 * init()
 *
 * Arguments:
 * 	void: ...
 *
 * Returns:
 * 	nothing.
 *
 * Notes:
 * 	.......
 *
 */
static
void
init() {
	
	// semaphore dish_mutex = 1 ... this is a lock which will always be initialised to TRUE (1)
	// this will dynamically create the memory resources to hold the data
	dish_mutex = sem_create("Dish Mutex", 2);
	if ( dish_mutex == NULL ) {
		panic("Out of memory !!!\n");   // panic() is "write then abort", while assert() is "test and if it's false, write then abort"
	}

}


/*
 * wait_until_all_done()
 *
 * Arguments:
 * 	void: ...
 *
 * Returns:
 * 	nothing.
 *
 * Notes:
 * 	Wait until all animals are done eating
 *
 */
static
void
wait_until_all_done(const char *animal, int count, int dish, int itr){
	//----wait until all animals are done eating---------------------------
	kprintf("%s: %d starts eating: Dish %d, Iteration %d\n", animal, count, dish, itr);
    clocksleep(1);
    kprintf("%s: %d ends eating: Dish %d, Iteration %d\n", animal, count, dish, itr);
}

/*
 * switch_turn()
 *
 * Arguments:
 * 	void: ...
 *
 * Returns:
 * 	nothing.
 *
 * Notes:
 * 	.......
 *
 */
// static
// void
// switch_turn(myname, my_first_cat_eat, my_another_cat_eat) {

// 	volatile bool first_cat_eat = FALSE;   //

// 	P(cats_queue);  /* first cat in while the others wait */
// 	if (no_cat_eat == TRUE) {   
// 		no_cat_eat = FALSE;
// 		first_cat_eat = TRUE;  /*first_cat_eat:local */
// 	} else {
// 		first_cat_eat = FALSE;
// 	}
// }


/*
 * catsem()
 *
 * Arguments:
 *      void * unusedpointer: currently unused.
 *      unsigned long catnumber: holds the cat identifier from 0 to NCATS - 1.
 *
 * Returns:
 *      nothing.
 *
 * Notes:
 *      Write and comment this function using semaphores.
 *
 */
static
void
catsem(void * unusedpointer, 
       unsigned long catnumber) 
{

        /*
         * Avoid unused variable warnings.
         */

        (void) unusedpointer;

	P(dish_mutex);
	while (cat_wait_count[catnumber] < 4) {
		if (dish1 == 0 && dish2 != 2) {
			dish1 = 1;
			wait_until_all_done("Cat", catnumber, 1, cat_wait_count[catnumber]); 
			dish1 = 0;
			
			cat_wait_count[catnumber] = cat_wait_count[catnumber] + 1;
		} else if (dish2 == 0 && dish1 != 2) {
			dish2 = 1;
			wait_until_all_done("Cat", catnumber, 2, cat_wait_count[catnumber]); 
			dish2 = 0;
			
			cat_wait_count[catnumber] = cat_wait_count[catnumber] + 1;
		} else {
			kprintf("Stay out the kitchen Kitties!");
		}
		V(dish_mutex);
	}
}


/*
 * mousesem()
 *
 * Arguments:
 *      void * unusedpointer: currently unused.
 *      unsigned long mousenumber: holds the mouse identifier from 0 to 
 *              NMICE - 1.
 *
 * Returns:
 *      nothing.
 *
 * Notes:
 *      Write and comment this function using semaphores.
 *
 */
static
void
mousesem(void * unusedpointer, 
         unsigned long mousenumber)
{
        /*
         * Avoid unused variable warnings.
         */

        (void) unusedpointer;

        P(dish_mutex);
	while (mice_wait_count[mousenumber] < 4) {
		if (dish1 == 0 && dish2 != 2) {
			dish1 = 1;
			wait_until_all_done("Mouse", mousenumber, 1, mice_wait_count[mousenumber]); 
			dish1 = 0;
			
			mice_wait_count[mousenumber] = cat_wait_count[mousenumber] + 1;
		} else if (dish2 == 0 && dish1 != 2) {
			dish2 = 1;
			wait_until_all_done("Mouse", mousenumber, 2, mice_wait_count[mousenumber]); 
			dish2 = 0;
			
			mice_wait_count[mousenumber] = mice_wait_count[mousenumber] + 1;
		} else {
			kprintf("NO MOUSE ALLOWED!");
		}
		V(dish_mutex);
	}

}


/*
 * catmousesem()
 *
 * Arguments:
 *      int nargs: unused.
 *      char ** args: unused.
 *
 * Returns:
 *      0 on success.
 *
 * Notes:
 *      Driver code to start up catsem() and mousesem() threads.  Change this 
 *      code as necessary for your solution.
 */

int
catmousesem(int nargs,
            char ** args)
{
		init();
		
        int index, error;   // index used to loop, error for just in case thread cannot be created

        /*
         * Avoid unused variable warnings.
         */

        (void) nargs;
        (void) args;
   
        /*
         * Start NCATS catsem() threads.
         */

        for (index = 0; index < NCATS; index++) {
           
                error = thread_fork("catsem Thread", 
                                    NULL, 
                                    index, 
                                    catsem, 
                                    NULL
                                    );
                
                /*
                 * panic() on error.
                 */

                if (error) {
                 
                        panic("catsem: thread_fork failed: %s\n", 
                              strerror(error)
                              );
                }

        }
        
        /*
         * Start NMICE mousesem() threads.
         */

        for (index = 0; index < NMICE; index++) {
   
                error = thread_fork("mousesem Thread", 
                                    NULL, 
                                    index, 
                                    mousesem, 
                                    NULL
                                    );
                
                /*
                 * panic() on error.
                 */

                if (error) {
         
                        panic("mousesem: thread_fork failed: %s\n", 
                              strerror(error)
                              );
                }
        }

        return 0;
}


/*
 * End of catsem.c
 */













