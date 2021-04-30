# include <iostream>
# include <fstream>
# include <cstdlib> // for exit()

/* ====================================================================================*
 * FILE NAME:    project3_Oden_mto0006.cpp                                             *
 * AUTHOR:       Midas Oden                                                            *
 * VERSION:      02/26/2021                                                            *
 * COMPILE:      g++ project3_Oden_mto0006.cpp -o project3_Oden_mto0006                *
 * EXECUTE:      ./project3_Oden_mto0006                                               *
 * DESCRIPTION:  Program is designed to read a list of integers from two files and     *
 *               combine and sort them in ascending order and will then output the     *
 *               sorted numbers into a new file by whatever the user names it to be.   * 
 * ====================================================================================*/
 
 
using namespace std;
   
const int MAX_SIZE = 100;


// Input:  (1) Array storing data retrieved from the file (i.e., instream)
//         (2) input file stream object
//
// Output: Size of array. Note: you need to use this parameter to control the array size.
int readfile(int inputArray[], ifstream& instream) {
   int index = 0;
   instream >> inputArray[index];

   while (!instream.eof()) {   // is the file input valid?
      index++;  
      instream >> inputArray[index];
   }
   return index;
}

// Input:  (1) Array storing data retrieved from the file
//         (2) Array size retrieved from the file
//         (3) Array storing data retrieved from the file
//         (4) Array size retrieved from the file
//         (5) Array used to save output data
//
// Output: Sorted list of numbers from both input files
int sort(int inputArray1[], int inputArray1_size, int inputArray2[], int inputArray2_size, int outputArray[]) {
   int outputSize = inputArray1_size + inputArray2_size;
   
   int firstIndex = 0;
   int secondIndex = 0;
   int thirdIndex = 0;
   
   while (firstIndex < inputArray1_size && secondIndex < inputArray2_size) { 
      if (inputArray1[firstIndex] < inputArray2[secondIndex]) {
         outputArray[thirdIndex] = inputArray1[firstIndex];
         firstIndex++;
         thirdIndex++;
      }  
      
      else {
         outputArray[thirdIndex] = inputArray2[secondIndex];
         secondIndex++;
         thirdIndex++;
      }
      
   }
   
   if (firstIndex == inputArray1_size) {
      while (secondIndex < inputArray2_size) {
         outputArray[thirdIndex] = inputArray2[secondIndex];
         secondIndex++;
         thirdIndex++;
      }
   } 
   else {
      while (firstIndex < inputArray1_size) {
         outputArray[thirdIndex] = inputArray1[firstIndex];
         firstIndex++;
         thirdIndex++;
      }
   }
   
   return outputSize;

}
       
   
// Input:  (1) Array of combined data from two input files
//         (2) Size of the output array
//
// Output: Creates output file containing the sorted output array
void writefile(int outputArray[], int outputArray_size, ofstream &outStream) {
  
   for (int i = 0; i < outputArray_size; i++) {
      outStream << outputArray[i] << endl;
   }

}
   
   
int main() {
   ifstream inStream1;
   ifstream inStream2;
   ofstream outStream;
   
   string inputFile;
   string outputFilename;
   
   int data;
   int iArray1[MAX_SIZE];
   int iArray1_size;
   int iArray2[MAX_SIZE];
   int iArray2_size;
   int outputArray[MAX_SIZE];
   
   cout << "\n*** Welcome to Midas's sorting program ***\n";
   
   // Input first file
   cout << "Enter the first input file name: ";
   cin >> inputFile;
   
   inStream1.open((char*)inputFile.c_str()); // edit this   
   if (inStream1.fail()) {
      cout << "Error: The file could not be opened!\n";
      exit(1);
   }
   // read the first file into stream, then close.
   iArray1_size = readfile(iArray1, inStream1);
   
   cout << "The list of " << iArray1_size << " numbers in file " << inputFile << " is:" << endl;
   
   while (!inStream1.eof()) {
      cout << data << endl;
      inStream1 >> data;
   }
    
   for (int i = 0; i < iArray1_size; i++) {
      cout << iArray1[i] << endl; 
      cout << "\n";
   }
   
   inStream1.close();
   inStream1.clear();
   
   cout << "\n";
   
   // Input second file
   cout << "\nEnter the second input file name: ";
   cin >> inputFile;
   
   inStream2.open(inputFile.c_str()); // edit this
   if (inStream1.fail()) {
      cout << "Error: The file could not be opened!\n";
      exit(1);
   }
   // read the second file into stream, then close.
   iArray2_size = readfile(iArray2, inStream2);
   
   cout << "The list of " << iArray2_size << " numbers in file " << inputFile << " is:\n";
   
   while (!inStream2.eof()) {
      cout << data << endl;
      inStream2 >> data;
   }
   
   for (int i = 0; i < iArray2_size; i++) {
      cout << iArray2[i] << endl; 
      cout << "\n";
   }
   
   inStream1.close();
   inStream1.clear();
   
   // sort through array
   int outsize = sort(iArray1, iArray1_size, iArray2, iArray2_size, outputArray);
   
   cout << "The sorted list of " << outsize << " numbers is: ";
   
   for (int i = 0; i < outsize; i++) {
      cout << outputArray[i] << " "; // edit
   }
   
   cout << "\nEnter the output file name: ";
   cin >> outputFilename;
   outStream.open((char *) outputFilename.c_str());
   if (outStream.fail()) {
      cout << "Error: The output file could not be opened!";
      exit(1);
   }
   
   writefile(outputArray, outsize, outStream);   
   cout << "*** Please check the new file - output.txt ***\n";
   cout << "*** Goodbye. ***\n";
   
   return 0;
   
}