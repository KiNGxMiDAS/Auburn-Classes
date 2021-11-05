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
struct semaphore *mutex = 0;
struct semaphore *cats_done = 0;
struct semaphore *mice_done = 0;
struct semaphore *dish_mutex = 0;
struct semaphore *cats_queue = 0;
struct semaphore *mice_queue = 0;

/*
 * Counters
 */

// keeps tracking of the number of currently waiting in the queue(no. in cats_queue) and the cats who're eating
// So basically keeps track of the total number of cats
volatile int cat_wait_count[6] = {0,0,0,0,0,0};
volatile int mice_wait_count[2] = {0,0,0,0,0,0};
volatile int dish1 = 0;
volatile int dish2 = 0;


/*
 * Why tf isn't boolean a primitive?
 */
volatile bool no_cat_eat = TRUE;  // 1st cat ^_^              
volatile bool no_mouse_eat = TRUE;
volatile bool dish1_busy = TRUE;
volatile bool dish2_busy = FALSE;
volatile bool all_dishes_available = TRUE;


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
init(void) {
	
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
 * cleanup()
 *
 * Arguments:
 * 	void: ...
 *
 * Returns:
 * 	nothing.
 *
 * Notes:
 * 	...
 *
 */
static
void 
cleanup(void) {
	sem_destroy(dish_mutex);

}


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
			sem_eat("cat", catnumber, 1, cat_wait_count[catnumber]); 
			dish1 = 0;
			
			cat_wait_count[catnumber] = cat_wait_count[catnumber] + 1;
		} else if (dish2 == 0 && dish1 != 2) {
			dish2 = 1;
			sem_eat("cat", catnumber, 2, cat_wait_count[catnumber]); 
			dish2 = 0;
			
			cat_wait_count[catnumber] = cat_wait_count[catnumber] + 1;
		} else {
			kprintf("Stay out the kitchen Kitties!");
		}
		V(dish_mutex);
	}
}


/*
 * cats_eat()
 *
 * Arguments:
 * 	void: ...
 *
 * Returns:
 * 	nothing.
 *
 * Notes:
 * 	...
 *
 */
static
void 
cats_eat()(void) {

	volatile bool first_cat_eat = FALSE;   //
	volatile bool another_cat_eat = FALSE;   //
	volatile int mydish = 0;

	/*
	 * KITCHEN-ENTERING ALGORITHMS -----------------------------------------------------------------------------------------------
	 */
	//-----1st cat eat and no mouse algorithm-----------------------------------	
	P(mutex);
	if (all_dishes_available) {
		all_dishes_available = FALSE;
		V(cats_queue);  /* let the 1st cat inside the kitchen !!!!! */
	}
	cats_wait_count++;
	V(mutex);

	P(cats_queue);   /* first goes in while the others wait */
	if (no_cat_eat) {
		no_cat_eat = FALSE;
		first_cat_eat = TRUE;
	} else {
		first_cat_eat = FALSE;
	}


	//----1st cat maintains controls of the kitchen------------------------
	if (first_cat_eat == TRUE) {
		P(mutex);
		
		if (cat_wait_count > 1) {
			another_cat_eat = TRUE;
			V(cats_queue);  /* let another inside */
		}
		V(mutex);
	}

	kprintf("Cat in the kitchen.\n"); /* cat name */


	//----all cats (first cat and non-first cat) enter the kitchen------------
	P(dish_mutex);  /* protect shared variables */
	if (dish1_busy == FALSE) {
		dish1_busy = TRUE;
		mydish = 1;
	} else {
		assert(dish2_busy == FALSE);
		dish2_busy = TRUE;
		mydish = 2;
	}
	V(dish_mutex);
	kprintf("Cat is eating.\n");  /* cat name*/

	clocksleep(1);   /* enjoys food */  
	kprinf("Cat has finished eating.\n");  /* done. */


	/*
	 * KITCHEN-LEAVING ALGORITHMS -----------------------------------------------------------------------------------------------
	 */
	//----all cats (first cat and non-first cat) release dishes.-----------
	P(dish_mutex);  /* protect shared variables */	
	if (mydish == 1) {  /* release dish 1 */
		dish1_busy = FALSE;
	
	} else {  /* release dish 2 */
		dish2_busy = FALSE;
		V(dish_mutex);
	}

	P(mutex);  /* protect shared variables */
	cat_wait_count--;
	V(mutex);


	//----first cat is leaving the kitchen---------------------------------
	if (first_cat_eat == TRUE) {   /* first cat */
		if (another_cat_eat == TRUE)
			P(cats_done);  /* wait for another cat */
	
			kprintf("First cat is leaving.\n");
			no_cat_eat = TRUE;  /* let next cat control the kitchen */

		//----wake up waiting cats-----------------------------------------
		/* switch to mice if any is waiting */
		P(mutex);  /* protect shared variables */
		if (mice_wait_count > 0) /* mice waiting */
			V(mice_queue);  /* let mice eat */

		else {
			if (cats_wait_count > 0)
				V(cats_queue);  /* let cat eat */	
			else all_dishes_available = TRUE;
		
			V(mutex);
		}
	} 

	else {
		kprintf("Non-first cat is leaving\n");
		V(cats_done);
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
			sem_eat("Mouse", mousenumber, 1, mice_wait_count[mousenumber]); 
			dish1 = 0;
			
			mice_wait_count[mousenumber] = cat_wait_count[mousenumber] + 1;
		} else if (dish2 == 0 && dish1 != 2) {
			dish2 = 1;
			sem_eat("Mouse", mousenumber, 2, mice_wait_count[mousenumber]); 
			dish2 = 0;
			
			mice_wait_count[mousenumber] = mice_wait_count[mousenumber] + 1;
		} else {
			kprintf("NO MOUSE ALLOWED!");
		}
		V(dish_mutex);
	}

}


/*
 * mice_eat()
 *
 * Arguments:
 * 	void: ...
 *
 * Returns:
 * 	nothing.
 *
 * Notes:
 * 	...
 *
 */
static
void 
mice_eat()(void) {

	volatile bool first_mouse_eat = FALSE;  //
	volatile bool another_mouse_eat = FALSE;  //
	volatile int mydish = 0;

/*
         * KITCHEN-ENTERING ALGORITHMS -----------------------------------------------------------------------------------------------
         */
		//-----1st mouse and no cat algorithm-----------------------------------	
	P(mutex);
	if (all_dishes_available) {
		all_dishes_available = FALSE;
		V(mice_queue);  /* let the 1st mouse inside the kitchen !!!!! */
	}
	mice_wait_count++;
	V(mutex);

	P(mice_queue);   /* first goes in while the others wait */
	if (no_mouse_eat) {
		no_mouse_eat = FALSE;
		first_mouse_eat = TRUE;
	} else {
		first_mouse_eat = FALSE;
	}


	//----1st mouse maintains controls of the kitchen------------------------
	if (first_mouse_eat == TRUE) {
		P(mutex);
		
		if (mice_wait_count > 1) {
			another_mouse_eat = TRUE;
			V(mice_queue);  /* let another inside */
		}
		V(mutex);
	}

	kprintf("Mouse in the kitchen.\n"); /* mouse name */


	//----all mice (first mouse and non-first mice) in the kitchen------------
	P(dish_mutex);  /* protect shared variables */
	if (dish1_busy == FALSE) {
		dish1_busy = TRUE;
		mydish = 1;
	} else {
		assert(dish2_busy == FALSE);
		dish2_busy = TRUE;
		mydish = 2;
	}
	V(dish_mutex);
	kprintf("Mouse is eating.\n");  /* mouse name*/

	clocksleep(1);   /* enjoys food */
	kprinf("Mice has finished eating.\n");  /* done. */

		/*
         * KITCHEN-LEAVING ALGORITHMS -----------------------------------------------------------------------------------------------
         */
	//----all mice (first mouse and non-first mice) release dishes.-----------
	P(dish_mutex);  /* protect shared variables */	
	if (mydish == 1) {  /* release dish 1 */
		dish1_busy = FALSE;
	
	} else {  /* release dish 2 */
		dish2_busy = FALSE;
		V(dish_mutex);
	}

	P(mutex);  /* protect shared variables */
	mice_wait_count--;
	V(mutex);


	//----first mouse is leaving the kitchen---------------------------------
	if (first_mouse_eat == TRUE) {   /* first mouse */
		if (another_mouse_eat == TRUE)
			P(mice_done);  /* wait for another mouse */
	
			kprintf("First cat is leaving.\n");
			no_mouse_eat = TRUE;  /* let next mouse control the kitchen */

		//----wake up waiting mice-----------------------------------------
		/* switch to cats if any is waiting */
		P(mutex);  /* protect shared variables */
		if (cat_wait_count > 0) /* cats waiting */
			V(cat_queue);  /* let cats eat */

		else {
			if (mice_wait_count > 0)
				V(mice_queue);  /* let mouse eat */	
			else all_dishes_available = TRUE;
		
			V(mutex);
		}
	} 

	else {
		kprintf("Non-first mouse is leaving\n");
		V(mice_done);
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













