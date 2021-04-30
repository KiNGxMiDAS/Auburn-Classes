import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * An implementation of the WordSearchGame.java
 *
 * @author  Dean Hendrix (dh@auburn.edu)
 * @author  Midas Oden   (mto0006@auburn.edu)
 * @version 2020/10/23
 */
public class WordSearch implements WordSearchGame {
    // Fields
   private TreeSet<String> lexicon; // word list
   private ArrayList<Integer> path; // keeps track of path
   private SortedSet<String> allWords;
   private ArrayList<Position> thePath;
   private String[][] board; // game board
   private String wordSoFar; // keeps tracks of words analysed so far
   private boolean[][] visited; // keeps track of visited positions
   private int width;
   private int height;

   private static final int MAX_NEIGHBOURS = 8;

    /**
     * Construct a new WordSearch object initialized
     * with a default square board
     */
   public WordSearch() {
      lexicon = null;
        // sample 4x4 board
      String[][] board = {
         {"E", "E", "C", "A"},
         {"A", "L", "E", "P"},
         {"H", "N", "B", "O"},
         {"Q", "T", "T", "Y"},
         };
      width = board.length;
      height = board[0].length;
      markAllUnvisited();
   }
   
    /**
     * Loads the lexicon into a data structure for later use.
     *
     * @param fileName A string containing the name of the file to be opened.
     * @throws IllegalArgumentException if fileName is null
     * @throws IllegalArgumentException if fileName cannot be opened.
     */
   @Override
   public void loadLexicon(String fileName) {
      if (fileName == null) {
         throw new IllegalArgumentException();
      }
      lexicon = new TreeSet<String>();
      try {
         Scanner s =
                 new Scanner(new BufferedReader(new FileReader(new File(fileName))));
         while (s.hasNext()) {
            String str = s.next();
               // add to your lexicon here
            s.nextLine();
         }
      }
      catch (Exception e) {
         throw new IllegalArgumentException("Error loading word list: " + fileName + ": " + e);
      }
   }

    /**
     * Stores the incoming array of Strings in a data structure that will make
     * it convenient to find words.
     *
     * @param letterArray This array of length N^2 stores the contents of the
     *     game board in row-major order. Thus, index 0 stores the contents of board
     *     position (0,0) and index length-1 stores the contents of board position
     *     (N-1,N-1). Note that the board must be square and that the strings inside
     *     may be longer than one character.
     * @throws IllegalArgumentException if letterArray is null, or is  not
     *     square.
     */
   @Override
    public void setBoard(String[] letterArray) {
      if (letterArray == null) {
         throw new IllegalArgumentException();
      }
      int n = (int) Math.sqrt(letterArray.length);
      if (n * n != letterArray.length) {
         throw new IllegalArgumentException();
      }
   
      board = new String[n][n];
      width = n;
      height = n;
      int index = 0;
      for (int i = 0; i < height; i++) {
         for (int k = 0; k < width; k++) {
            board[i][k] = letterArray[index];
            index++;
         }
      }
      markAllUnvisited();
   }

    /**
     * Creates a String representation of the board, suitable for printing to
     *   standard out. Note that this method can always be called since
     *   implementing classes should have a default board.
     */
   @Override
    public String getBoard() {
      String stringBoard = "";
      for (int i = 0; i < height; i++) {
         if (i > 0) {
            stringBoard += "\n";
         }
         for (int k = 0; k < width; k++) {
            stringBoard += board[i][k] + " ";
         }
      }
      return stringBoard;
   }

    /**
     * Retrieves all scorable words on the game board, according to the stated game
     * rules.
     *
     * @param minimumWordLength The minimum allowed length (i.e., number of
     *     characters) for any word found on the board.
     * @return java.util.SortedSet which contains all the words of minimum length
     *     found on the game board and in the lexicon.
     * @throws IllegalArgumentException if minimumWordLength < 1
     * @throws IllegalStateException if loadLexicon has not been called.
     */
   @Override
    public SortedSet<String> getAllScorableWords(int minimumWordLength) {
      if (minimumWordLength < 1) {
         throw new IllegalArgumentException();
      }
      if (lexicon == null) {
         throw new IllegalArgumentException();
      }
   
      thePath = new ArrayList<Position>();
      allWords = new TreeSet<String>();
      wordSoFar = "";
      for (int i = 0; i < height; i++) {
         for (int n = 0; n < width; n++) {
            wordSoFar = board[i][n];
            if (isValidWord(wordSoFar) && wordSoFar.length() >= minimumWordLength) {
               allWords.add(wordSoFar);
            }
            if (isValidPrefix(wordSoFar)) {
               Position p = new Position(i, n);
               thePath.add(p);
               dfs_1(i, n, minimumWordLength);
               // removes last portion from the position when failure occurs.
               thePath.remove(p);
            }
         }
      }
      return allWords;
   }

    /**
     * Computes the cummulative score for the scorable words in the given set.
     * To be scorable, a word must (1) have at least the minimum number of characters,
     * (2) be in the lexicon, and (3) be on the board. Each scorable word is
     * awarded one point for the minimum number of characters, and one point for
     * each character beyond the minimum number.
     *
     * @param words The set of words that are to be scored.
     * @param minimumWordLength The minimum number of characters required per word
     * @return the cummulative score of all scorable words in the set
     * @throws IllegalArgumentException if minimumWordLength < 1
     * @throws IllegalStateException if loadLexicon has not been called.
     */
   @Override
    public int getScoreForWords(SortedSet<String> words, int minimumWordLength) {
      if (minimumWordLength < 1) {
         throw new IllegalArgumentException();
      }
      if (lexicon == null) {
         throw new IllegalStateException();
      }
      int score = 0;
      Iterator<String> itr = words.iterator();
      while (itr.hasNext()) {
         String word = itr.next();
         // if the word is of min length, within the lexicon, and is on board
         if (word.length() >= minimumWordLength && isValidWord(word)
                  && !isOnBoard(word).isEmpty()) {
            score += (word.length() - minimumWordLength) + 1;
         }
      }
      return score;
   }

    /**
     * Determines if the given word is in the lexicon.
     *
     * @param wordToCheck The word to validate
     * @return true if wordToCheck appears in lexicon, false otherwise.
     * @throws IllegalArgumentException if wordToCheck is null.
     * @throws IllegalStateException if loadLexicon has not been called.
     */
   @Override
    public boolean isValidWord(String wordToCheck) {
      if (lexicon == null) {
         throw new IllegalStateException();
      }
      if (wordToCheck == null) {
         throw new IllegalArgumentException();
      }
   
      // determined if the given word is in the lexicon
      wordToCheck = wordToCheck.toUpperCase();
      return lexicon.contains(wordToCheck);
   }

    /**
     * Determines if there is at least one word in the lexicon with the
     * given prefix.
     *
     * @param prefixToCheck The prefix to validate
     * @return true if prefixToCheck appears in lexicon, false otherwise.
     * @throws IllegalArgumentException if prefixToCheck is null.
     * @throws IllegalStateException if loadLexicon has not been called.
     */
   @Override
    public boolean isValidPrefix(String prefixToCheck) {
      if (lexicon == null) {
         throw new IllegalStateException();
      }
      if (prefixToCheck == null) {
         throw new IllegalArgumentException();
      }
      prefixToCheck = prefixToCheck.toUpperCase();
        // determines if there is at least one word in the lexicon
      String word = lexicon.ceiling(prefixToCheck);
      if (word != null) {
         return word.startsWith(prefixToCheck);
      }
      return false;
   }

    /**
     * Determines if the given word is in on the game board. If so, it returns
     * the path that makes up the word.
     * @param wordToCheck The word to validate
     * @return java.util.List containing java.lang.Integer objects with  the path
     *     that makes up the word on the game board. If word is not on the game
     *     board, return an empty list. Positions on the board are numbered from zero
     *     top to bottom, left to right (i.e., in row-major order). Thus, on an NxN
     *     board, the upper left position is numbered 0 and the lower right position
     *     is numbered N^2 - 1.
     * @throws IllegalArgumentException if wordToCheck is null.
     * @throws IllegalStateException if loadLexicon has not been called.
     */
   @Override
    public List<Integer> isOnBoard(String wordToCheck) {
      if (wordToCheck == null) {
         throw new IllegalArgumentException();
      }
      if (lexicon == null) {
         throw new IllegalStateException();
      }
      thePath = new ArrayList<Position>();
      wordToCheck = wordToCheck.toUpperCase();
      wordSoFar = "";
      path = new ArrayList<Integer>();
       // finds the starting position
      for (int i = 0; i < height; i++) {
         for (int j = 0; j < width; j ++) {
               // if first spot is whole word, add position to list and return.
            if (wordToCheck.equals(board[i][j])) {
               path.add(i * width + j); // adds row-major position
               return path;
            }
            if (wordToCheck.startsWith(board[i][j])) {
               Position pos = new Position(i, j);
               thePath.add(pos); // adds regular position
               wordSoFar = board[i][j]; // adds to wordSoFar
               dfs_0(i, j, wordToCheck); // start search
                // if search fails, remove from path.
               if (!wordToCheck.equals(wordSoFar)) {
                  thePath.remove(pos);
               } else {
                   // adds row-major position
                  for (Position p : thePath) {
                     path.add((p.x * width) + p.y);
                  }
                  return path;
               }
            }
         }
      }
      return path;
   }

    //////////////////////////////
    // Private utility methods. //
    //////////////////////////////

    /**
     * Represents an (x,y) position in the grid.
     */
   private class Position {
      int x;
      int y;
   
        /**
         * Construct a new Position object initialized
         * with a default (x,y) position in the grid.
         */
      public Position(int x, int y) {
         this.x = x;
         this.y = y;
      }
   
        /**
         * Returns a String representing the Position.
         */
      @Override
        public String toString() {
         return "(" + x + ", " + y + ")";
      }
   
        /**
         * Returns the neighbouring Positions.
         */
      public Position[] neighbors() {
         Position[] nbrs = new Position[MAX_NEIGHBOURS];
         int count = 0;
         Position p;
            // generates neighbouring positions
         for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
               if (!((i == 0) && (j == 0))) {
                  p = new Position(x + i, y + j);
                  // if valid, add to the return value
                  if (isValid(p)) {
                     nbrs[count++] = p;
                  }
               }
            }
         }
         return Arrays.copyOf(nbrs, count);
      }
   }

        /**
         * Checks to see if the position is valid.
         *
         * @param p the position
         */
   private boolean isValid(Position p) {
      return (p.x >= 0) && (p.x < width) && (p.y >= 0) && (p.y < height);
   }

        /**
         * Checks to see if a position has been visited.
         *
         * @param p the position
         */
   private boolean isVisited(Position p) {
      return visited[p.x][p.y];
   }

        /**
         * Marks this position as valid if it has been visited.
         */
   private void visit(Position p) {
      visited[p.x][p.y] = true;
   }

        /**
         * Depth-First Search
         *
         * @param x           - x value
         * @param y           - y value
         * @param wordToCheck the word to check for.
         */
   private void dfs_0(int x, int y, String wordToCheck) {
      Position start = new Position(x, y);
      markAllUnvisited();
      markPathVisited();
      for (Position p : start.neighbors()) {
         if (!isVisited(p)) {
            visit(p);
            if (wordToCheck.startsWith(wordSoFar + board[p.x][p.y])) {
                // add string to what we have so far
               wordSoFar += board[p.x][p.y];
               thePath.add(p);
               dfs_0(p.x, p.y, wordToCheck);
               if (wordToCheck.equals(wordSoFar)) {
                  return;
               } else {
                  thePath.remove(p);
                  int endIndex = wordSoFar.length() - board[p.x][p.y].length();
                  wordSoFar = wordSoFar.substring(0, endIndex);
               }
            }
         }
      }
      markAllUnvisited();
      markPathVisited();
   }

    /**
     * Depth-First Search
     *
     * @param x           - x value
     * @param y           - y value
     * @param min         - the word to check for.
     */
   private void dfs_1(int x, int y, int min) {
      Position start = new Position(x, y);
      markAllUnvisited();
      markPathVisited();
      for (Position p : start.neighbors()) {
         if (!isVisited(p)) {
            visit(p);
            if (isValidPrefix(wordSoFar + board[p.x][p.y])) {
               wordSoFar += board[p.x][p.y];
               thePath.add(p);
               if (isValidWord(wordSoFar) && wordSoFar.length() >= min) {
                  allWords.add(wordSoFar);
               }
               dfs_1(p.x, p.y, min);
               thePath.remove(p);
               int endIndex = wordSoFar.length() - board[p.x][p.y].length();
               wordSoFar = wordSoFar.substring(0, endIndex);
            }
         }
      }
      markAllUnvisited();
      markPathVisited();
   }

        /**
         * Marks path as visited.
         */
   private void markPathVisited() {
      for (int i = 0; i < thePath.size(); i++) {
         visit(thePath.get(i));
      }
   }

        /**
         * Marks all positions unvisited.
         */
   private void markAllUnvisited() {
      visited = new boolean[width][height];
      for (boolean[] row : visited) Arrays.fill(row, false);
   }
}