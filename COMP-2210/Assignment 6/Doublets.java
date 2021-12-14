import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

import java.util.stream.Collectors;

/**
 * Provides an implementation of the WordLadderGame interface. 
 *
 * @author Midas Oden (mto0006@auburn.edu)
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2020/11/15
 */
public class Doublets implements WordLadderGame {

   List<String> EMPTY_LADDER = new ArrayList<>();
   // The word list used to validate words.
   // Must be instantiated and populated in the constructor.
   /////////////////////////////////////////////////////////////////////////////
   // DECLARE A FIELD NAMED lexicon HERE. THIS FIELD IS USED TO STORE ALL THE //
   // WORDS IN THE WORD LIST. YOU CAN CREATE YOUR OWN COLLECTION FOR THIS     //
   // PURPOSE OF YOU CAN USE ONE OF THE JCF COLLECTIONS. SUGGESTED CHOICES    //
   // ARE TreeSet (a red-black tree) OR HashSet (a closed addressed hash      //
   // table with chaining).
   HashSet<String> lexicon;
   /////////////////////////////////////////////////////////////////////////////

   /**
    * Instantiates a new instance of Doublets with the lexicon populated with
    * the strings in the provided InputStream. The InputStream can be formatted
    * in different ways as long as the first string on each line is a word to be
    * stored in the lexicon.
    */
   public Doublets(InputStream in) {
      try {
         //////////////////////////////////////
         // INSTANTIATE lexicon OBJECT HERE  //
         /////////////////////////////////////
         lexicon = new HashSet<String>();
         //////////////////////////////////////
         Scanner s =
            new Scanner(new BufferedReader(new InputStreamReader(in)));
         while (s.hasNext()) {
            String str = s.next();
            /////////////////////////////////////////////////////////////
            // INSERT CODE HERE TO APPROPRIATELY STORE str IN lexicon. //
            ////////////////////////////////////////////////////////////
            lexicon.add(str.toLowerCase());
            /////////////////////////////////////////////////////////////
            s.nextLine();
         }
         in.close();
      }
      catch (java.io.IOException e) {
         System.err.println("Error reading from InputStream.");
         System.exit(1);
      }
   }


   //////////////////////////////////////////////////////////////
   // ADD IMPLEMENTATIONS FOR ALL WordLadderGame METHODS HERE  //
   //////////////////////////////////////////////////////////////

   /**
    * Checks to see if the given string is a word.
    *
    * @param  str the string to check
    * @return     true if str is a word, false otherwise
    */
   public boolean isWord(String str) {
      String word = str.toLowerCase();
      return lexicon.contains(word);
   }

   /**
    * Returns the total number of words in the current lexicon.
    *
    * @return number of words in the lexicon
    */
   public int getWordCount() {
      return lexicon.size();
   }

   /**
    * Returns the Hamming distance between two strings, str1 and str2. The
    * Hamming distance between two strings of equal length is defined as the
    * number of positions at which the corresponding symbols are different. The
    * Hamming distance is undefined if the strings have different length, and
    * this method returns -1 in that case. See the following link for
    * reference: https://en.wikipedia.org/wiki/Hamming_distance
    *
    * @param  str1 the first string
    * @param  str2 the second string
    * @return      the Hamming distance between str1 and str2 if they are the
    *                  same length, -1 otherwise
    */
   public int getHammingDistance(String str1, String str2) {
      // return -1 if the Hamming distance between both Strings are not of the same length
      if (str1.length() != str2.length()) {
         return -1;
      }
   
      int count = 0;
      for (int i = 0; i < str2.length(); i++) {
         if (str1.charAt(i) != str2.charAt(i)) {
            count++;
         }
      }
   
      return count;
   }

   /**
    * Returns all the words that have a Hamming distance of one relative to the
    * given word.
    *
    * @param  word the given word
    * @return      the neighbors of the given word
    */
   public List<String> getNeighbors(String word) {
      List<String> neighbors = new ArrayList<String>();
      String savedWord = word.toLowerCase();
   
      if (word == null || savedWord.length() == 0) {
         return EMPTY_LADDER;
      }
   
      int index = 0; // hold position in word
      String neighbor = "";
      int count = 0;
   
      while (index < savedWord.length()) {
         char[] charArray = savedWord.toCharArray();
         for (charArray[index] = 'a'; count < 26; count++) {
            neighbor = new String(charArray);
         
            if (isWord(neighbor) && (!neighbor.equals(savedWord))) {
               neighbors.add(neighbor);
            
            }
            charArray[index]++;
         }
         index++;
         count = 0;
      
      }
      return neighbors;
   }

   /**
    * Checks to see if the given sequence of strings is a valid word ladder.
    *
    * @param  sequence the given sequence of strings
    * @return          true if the given sequence is a valid word ladder,
    *                       false otherwise
    */
   public boolean isWordLadder(List<String> sequence) {
      if (sequence.isEmpty() || sequence.size() == 0 || sequence == null) {
         return false;
      }
   
      String str1 = "";
      String str2 = "";
      boolean ladder = true;
      int k = 0;
   
      for (int i = 0; i < sequence.size() - 1; i++) {
         if (k == sequence.size()) {
            return ladder;
         }
      
         str1 = sequence.get(i);
         str2 = sequence.get(i + 1);
      
         if (!isWord(str1) || !isWord(str2)) {
            return false;
         }
      
         if (getHammingDistance(str1, str2) != 1) {
            return false;
         }
      
         k++;
      }
      return ladder;
   }

   /**
    * Returns a minimum-length word ladder from start to end. If multiple
    * minimum-length word ladders exist, no guarantee is made regarding which
    * one is returned. If no word ladder exists, this method returns an empty
    * list.
    *
    * Breadth-first search must be used in all implementing classes.
    *
    * @param  start  the starting word
    * @param  end    the ending word
    * @return        a minimum length word ladder from start to end
    */
   public List<String> getMinLadder(String start, String end) {
      String first = start.toLowerCase();
      String last = end.toLowerCase();
      ArrayList<String> ladder = new ArrayList<String>();
      // if the starting word equals the ending word, return the word
      if (first.equals(last)) {
         ladder.add(first);
         return ladder;
      }
   
      // if both the first and last word are words, search throughout
      if(isWord(first) && isWord(last)) {
         ladder = bfsMemory(first, last);
      }
   
      // if no word ladder exists, the HD of the Strings are unequal, or the word is invalid, return an empty list
      if (ladder.isEmpty() || first.length() != last.length() || !isWord(first) || !isWord(last) ) {
         return EMPTY_LADDER;
      }
      return bfsMemory(first, last);
   }

   private ArrayList<String> bfsMemory(String start, String end) {
      Deque<Node> ladder = new ArrayDeque<Node>();
      HashSet<String> visited = new HashSet<String>();
   
      ladder.addLast(new Node(start, null));
      while (!ladder.isEmpty()) {
         Node ladder_node = ladder.removeFirst();
         List<String> neighborhood = getNeighbors(ladder_node.word);
      
         for (String neighbor : neighborhood) {
            if (!isVisited(visited, neighbor)) {
               visit(visited, neighbor);
               ladder.addLast(new Node(neighbor, ladder_node));
            
               if (neighbor.equals(end)) {
                  List<String> newLadder = populateLadder(ladder.removeLast());
                  return (ArrayList<String>) newLadder;
               }
            }
         }
      }
      return (ArrayList<String>) EMPTY_LADDER;
   }

   /**
    * Has this valid position been visited?
    */
   private boolean isVisited(HashSet<String> set, String word) {
      return set.contains(word);
   }

   /**
    * Mark this valid position as having been visited.
    */
   private void visit(HashSet<String> visited, String word) {
      visited.add(word);
   }

   /**
    *
    */
   private List<String> populateLadder(Node n) {
      List<String> population = new ArrayList<String>();
      while (n != null) {
         population.add(n.word);
         n = n.prev;
      }
      java.util.Collections.reverse(population);
      return population;
   }

   /**
    * Constructs a node for linking positions together.
    */
   private class Node {
      String word;
      Node prev;
   
      public Node(String s, Node prev) {
         word = s;
         this.prev = prev;
      }
   }
}