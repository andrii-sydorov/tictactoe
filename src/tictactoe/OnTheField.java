package tictactoe;

import java.util.Scanner;

public class OnTheField {
   /**
    * Description
    * 
    * In this stage, you should analyze a Tic-Tac-Toe field.
    * 
    * Note. In this stage either 'X' or 'O' can start the game.
    * 
    * After printing the field, you need to find the state in which the game is at
    * the moment. Possible states:
    * 
    * "Game not finished" - when no side has a three in a row but the field has empty cells; 
    * "Draw" - when no side has a three in a row and the field has no
    * empty cells; 
    * "X wins" - when the field has three X in a row; "O wins" - when
    * the field has three O in a row; 
    * "Impossible" - when the field has three X in a row as well as three O in a row. Or the field has a lot more X's than O's
    * or vice versa (if the difference is 2 or more, should be 1 or 0).
    * 
    * Also, you can use ' ' or '_' to print empty cells - it's up to you. Examples
    * 
    * The examples below show outputs for some predefined states. Your program
    * should work in the same way.
    * 
    * Example 1:
    * 
    * Enter cells: XXXOO__O_ 
    * --------- 
    * | X X X | 
    * | O O _ | 
    * | _ O _ | 
    * --------- 
    * X wins
    * 
    * Example 2:
    * 
    * Enter cells: XOXOXOXXO 
    * --------- 
    * | X O X | 
    * | O X O | 
    * | X X O | 
    * --------- 
    * X wins
    * 
    * Example 3:
    * 
    * Enter cells: XOOOXOXXO 
    * --------- 
    * | X O O | 
    * | O X O | 
    * | X X O | 
    * --------- 
    * O wins
    * 
    * Example 4:
    * 
    * Enter cells: XOXOOXXXO 
    * --------- 
    * | X O X | 
    * | O O X | 
    * | X X O | 
    * --------- 
    * Draw
    * 
    * Example 5:
    * 
    * Enter cells: XO_OOX_X_ 
    * --------- 
    * | X O   | 
    * | O O X | 
    * | X     | 
    * --------- 
    * Game not finished
    * 
    * Example 6:
    * 
    * Enter cells: XO_XO_XOX 
    * --------- 
    * | X O _ | 
    * | X O _ | 
    * | X O X | 
    * ---------
    * Impossible
    * 
    * Example 7:
    * 
    * Enter cells: _O_X__X_X 
    * --------- 
    * |   O   | 
    * | X     | 
    * | X   X | 
    * --------- 
    * Impossible
    * 
    * Example 8:
    * 
    * Enter cells: _OOOO_X_X 
    * --------- 
    * | O O   | 
    * | O O   | 
    * | X X   | 
    * --------- 
    * Impossible
    */

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String in = sc.nextLine();
      int size = in.length();
      char[][] field = new char[(int) Math.sqrt(size) + 2][(int) Math.sqrt(size) + ((int) Math.sqrt(size) - 1) + 4];
      buildFrame(field);
      fillMatrix(field, in);
      print(field);
      System.out.println(checkMatrix(field, fillMatrix(field, in), size));
      sc.close();
   }

   static void buildFrame(char[][] field) {
      for (int i = 0; i < field.length; i++) {
         for (int j = 0; j < field[i].length; j++) {
            if ((j == 0 || j == field[i].length - 1) && (i != 0 && i != field.length - 1)) {
               field[i][j] = '|';
            } else if (i == 0 || i == field.length - 1) {
               field[i][j] = '-';
            } else {
               field[i][j] = ' ';
            }
         }
      }
   }

   static void print(char[][] field) {
      for (int i = 0; i < field.length; i++) {
         for (int j = 0; j < field[i].length; j++) {
            System.out.print(field[i][j]);
         }
         System.out.println();
      }
   }

   static int[] fillMatrix(char[][] field, String in) {
      int index = 0;
      int x = 0;
      int o = 0;
      for (int i = 0; i < field.length; i++) {
         for (int j = 0; j < field[i].length; j++) {
            if (i > 0 && i < field.length - 1 && j > 0 && j < field[i].length - 1) {
               if (j % 2 == 0) {
                  field[i][j] = in.charAt(index);
                  index++;
                  if (field[i][j] == 'X') {
                     x++;
                  }
                  if (field[i][j] == 'O') {
                     o++;
                  }
               } else {
                  field[i][j] = ' ';
               }
            } else {
               continue;
            }
         }
      }
      return new int[] { x, o };
   }

   static String checkMatrix(char[][] field, int[] arrInt, int size) {
//      to much X or O
      if (Math.abs(arrInt[0] - arrInt[1]) > 1) {
         return "Impossible";
      }
//      check row
      boolean xRowWins = false;
      boolean oRowWins = false;
      for (int i = 0; i < field.length; i++) {
         if (xRowWins && oRowWins == true) {
            return "Impossible";
         }
         int countRowX = 0;
         int countRowO = 0;
         for (int j = 0; j < field[i].length; j++) {
            if (i > 0 && i < field.length - 1 && j > 0 && j < field[i].length - 1) {
               if (j % 2 == 0) {
                  if (field[i][j] == 'X') {
                     countRowX++;
                  }
                  if (field[i][j] == 'O') {
                     countRowO++;
                  }
               }
            }
         }
         if (countRowX == Math.sqrt(size)) {
            xRowWins = true;
         }
         if (countRowO == Math.sqrt(size)) {
            oRowWins = true;
         }
      }
// check column
      boolean xColWins = false;
      boolean oColWins = false;
      for (int j = 0; j < field[0].length; j++) {
         if (xColWins && oColWins == true) {
            return "Impossible";
         }
         int countColX = 0;
         int countColO = 0;
         for (int i = 0; i < field.length; i++) {
            if (i > 0 && i < field.length - 1 && j > 0 && j < field[i].length - 1) {
               if (j % 2 == 0) {
                  if (field[i][j] == 'X') {
                     countColX++;
                  }
                  if (field[i][j] == 'O') {
                     countColO++;
                  }
               }
            }
         }
         if (countColX == Math.sqrt(size)) {
            xColWins = true;
         }
         if (countColO == Math.sqrt(size)) {
            oColWins = true;
         }
      }

      if (xColWins || xRowWins == true) {
         return "X wins";
      }

      if (oColWins || oRowWins == true) {
         return "O wins";
      }
//      check main diagonal
      int countMainDiagX = 0;
      int countMainDiagO = 0;
      for (int i = 0; i < field.length; i++) {
         for (int j = 0; j < field[i].length; j++) {
            if (i > 0 && i < field.length - 1 && j > 0 && j < field[i].length - 1) {
               if (i * 2 == j) {
                  if (field[i][j] == 'X') {
                     countMainDiagX++;
                  }
                  if (field[i][j] == 'O') {
                     countMainDiagO++;
                  }
               }
            }
         }
      }

      // check secondary diagonal
      int countSecDiagX = 0;
      int countSecDiagO = 0;
      for (int i = 0; i < field.length; i++) {
         for (int j = 0; j < field[i].length; j++) {
            if (i > 0 && i < field.length - 1 && j > 0 && j < field[i].length - 1) {
               if ((field[i].length - 1) - i * 2 == j) {
                  if (field[i][j] == 'X') {
                     countSecDiagX++;
                  }
                  if (field[i][j] == 'O') {
                     countSecDiagO++;
                  }
               }
            }
         }
      }
      if ((countMainDiagX == Math.sqrt(size) && countSecDiagO == Math.sqrt(size))
            || (countMainDiagO == Math.sqrt(size) && countSecDiagX == Math.sqrt(size))) {
         return "Imposible";
      }
      if (countMainDiagX == Math.sqrt(size)) {
         return "X wins";
      }
      if (countMainDiagO == Math.sqrt(size)) {
         return "O wins";
      }
      if (countSecDiagX == Math.sqrt(size)) {
         return "X wins";
      }
      if (countSecDiagO == Math.sqrt(size)) {
         return "O wins";
      }

      // check if the game finished is
      if (arrInt[0] + arrInt[1] != size) {
         return "Game not finished";
      }
      return "Draw";
   }
}
