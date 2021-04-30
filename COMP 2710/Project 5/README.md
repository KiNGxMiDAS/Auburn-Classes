# Project 5

## Objective
Program is designed to simulate the producer/consumer problem. The idea behind the project is to familiarise oneself with the basics of the POSIX thread library.

### POSIX thread library .. ?
The POSIX thread libraries are a standards based thread API for C/C++. It allows one to spawn a new concurrent process flow. It is most effective on multi-processor or multi-core systems where the process flow can be scheduled to run on another processor thus gaining speed through parallel or distributed processing.

### Producer and Consumer Model
The producer and consumer model is to schedule how concurrent processes and threads access the resources. It contains:
1. **Producer:** One or multiple processes/threads that produce data or release hardware resource.
2. **Consumer:** The one process/thread that takes in data or uses hardware resource to do computations.
 * A producer could also be relatively a consumer to the output of another producer and vice versa.
3. **Buffer:** The destination to store the output from producers or resources and later accessed by another consumer.
* **Other concepts involved in our project:**
4. **POSIX thread:** Threads mechanism that satisfy POSIX standard (most operating system).
5. **Mutex:** A "lock" that guarantee that only one person has the access.



In this project we use POSIX threads. The "pthread" is a POSIX thread library written in C++ and provides the basic functions.

To simplify our simulation, we assume there are only 2 POSIX threads. One is the consumer, the other is the producer. The producer generates 1 unit data each time to the buffer, and the
consumer takes 1 unit data from the buffer each time. The size of the buffer is 1. One unit data is
just one integer. The producer generates integers 7, 14, 21 .... into the buffer and consumer read
them out from the buffer.
