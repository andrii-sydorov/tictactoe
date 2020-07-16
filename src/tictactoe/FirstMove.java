package tictactoe;

import java.util.Scanner;

public class FirstMove {
   /**
    * Description
    * 
    * Now you need to implement human moves.
    * 
    * Suppose the bottom left cell has the coordinates (1, 1) and the top right
    * cell has the coordinates (3, 3) like in this table:
    * 
    * (1, 3) (2, 3) (3, 3) 
    * (1, 2) (2, 2) (3, 2) 
    * (1, 1) (2, 1) (3, 1)
    * 
    * The program should work in the following way:
    * 
    * Get the 3x3 field from the input as in the previous stages, Output this 3x3
    * field with cells before the user's move, Then ask the user about his next
    * move, Then the user should input 2 numbers that represent the cell on which
    * user wants to make his X or O. (9 symbols representing the field would be on
    * the first line and these 2 numbers would be on the second line of the user
    * input), Then output the table including the user's most recent move.
    * 
    * Do not delete code that checks for table state; it will be useful in the
    * future.
    * 
    * Note that in this stage user moves as X, not O. Keep in mind that the first
    * coordinate goes from left to right and the second coordinate goes from bottom
    * to top. Also, notice that coordinates start with 1 and can be 1, 2 or 3.
    * 
    * But what if the user enters incorrect coordinates? The user could enter
    * symbols instead of numbers or enter coordinates representing occupied cells.
    * You need to prevent all of that by checking a user's input and catching
    * possible exceptions.
    * 
    * The program should also check user input. If the user input is unsuitable,
    * the program should ask him to enter coordinates again.
    * 
    * So, you need to output a field from the first line of the input and then ask
    * the user to enter a move. Keep asking until the user enters coordinate that
    * represents an empty cell on the field and after that output the field with
    * that move. You should output the field only 2 times - before the move and
    * after a legal move. Examples
    * 
    * The examples below shows how your program should work.
    * 
    * Example 1:
    * 
    * Enter cells: X_X_O____ 
    * --------- 
    * | X   X | 
    * |   O   | 
    * |       | 
    * --------- 
    * Enter the coordinates: 1 1 
    * --------- 
    * | X   X | 
    * |   O   | 
    * | X     | 
    * ---------
    * 
    * Example 2:
    * 
    * Enter cells: _XXOO_OX_ 
    * --------- 
    * |   X X | 
    * | O O   | 
    * | O X   | 
    * --------- 
    * Enter the coordinates: 1 3 
    * --------- 
    * | X X X | 
    * | O O   | 
    * | O X   | 
    * ---------
    * 
    * Example 3:
    * 
    * Enter cells: _XXOO_OX_ 
    * --------- 
    * |   X X | 
    * | O O   | 
    * | O X   | 
    * --------- 
    * Enter the coordinates: 3 1 
    * --------- 
    * |   X X | 
    * | O O   | 
    * | O X X | 
    * ---------
    * 
    * Example 4:
    * 
    * Enter cells: _XXOO_OX_ 
    * --------- 
    * |   X X | 
    * | O O   | 
    * | O X   | 
    * --------- 
    * Enter the coordinates: 3 2 
    * --------- 
    * |   X X | 
    * | O O X | 
    * | O X   | 
    * ---------
    * 
    * Example 5:
    * 
    * Enter cells: _XXOO_OX_ 
    * --------- 
    * |   X X | 
    * | O O   | 
    * | O X   | 
    * --------- 
    * Enter the coordinates: 1 1 This cell is occupied! Choose another one! 
    * Enter the coordinates: 1 3 
    * --------- 
    * | X X X | 
    * | O O   | 
    * | O X   | 
    * ---------
    * 
    * Example 6:
    * 
    * Enter cells: _XXOO_OX_ 
    * --------- 
    * |   X X | 
    * | O O   | 
    * | O X   | 
    * --------- 
    * Enter the coordinates: one 
    * You should enter numbers! 
    * Enter the coordinates: one three
    * You should enter numbers! 
    * Enter the coordinates: 1 3 
    * --------- 
    * | X X X | 
    * | O O   | 
    * | O X   | 
    * ---------
    * 
    * Example 7:
    * 
    * Enter cells: _XXOO_OX_ 
    * --------- 
    * |   X X | 
    * | O   O | 
    * | O X   | 
    * --------- 
    * Enter the coordinates: 4 1 
    * Coordinates should be from 1 to 3! 
    * Enter the coordinates: 1 4 
    * Coordinates should be from 1 to 3! 
    * Enter the coordinates: 1 3 
    * --------- 
    * | X X X | 
    * | O   O | 
    * | O X   | 
    * ---------
    */

   public static void main(String[] args) {
      System.out.print("Enter cells: ");
      Scanner sc = new Scanner(System.in);
      String in = sc.nextLine().replaceAll("_", " ");
      int size = in.length();
      char[][] field = new char[(int) Math.sqrt(size) + 2][(int) Math.sqrt(size) + ((int) Math.sqrt(size) - 1) + 4];
      buildFrame(field);
      Solution a = new Solution();
      a = fillMatrix(field, in);
      print(field);
//      System.out.println(checkMatrix(field, a, size));
      int[] inCoor = checkIn(sc, a);
      userFillMatrix(inCoor, field);
      print(field);
//      System.out.println("Occupied indexes i :");
//      print(a.indexI);
//      System.out.println();
//      System.out.println("Occupied indexes j :");
//      print(a.indexJ);
//      System.out.println();
//      print(inCoor);
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

   static void print(int[] arInt) {
      for (int i = 0; i < arInt.length; i++) {
         System.out.print(arInt[i] + " ");
      }
   }

   static Solution fillMatrix(char[][] field, String in) {
      Solution ans = new Solution();
      ans.indexI = new int[in.replaceAll(" ", "").length()];
      ans.indexJ = new int[in.replaceAll(" ", "").length()];
      int index = 0;
      int indexAns = 0;
      int x = 0;
      int o = 0;
      for (int i = 0; i < field.length; i++) {
         for (int j = 0; j < field[i].length; j++) {
            if (i > 0 && i < field.length - 1 && j > 0 && j < field[i].length - 1) {
               if (j % 2 == 0) {
                  field[i][j] = in.charAt(index);
                  if (field[i][j] == 'X') {
                     x++;
                  }
                  if (field[i][j] == 'O') {
                     o++;
                  }
                  if (field[i][j] == 'X' || field[i][j] == 'O') {
                     ans.indexI[indexAns] = i;
                     ans.indexJ[indexAns] = j;
                     indexAns++;
                  }
                  index++;
               } else {
                  field[i][j] = ' ';
               }
            } else {
               continue;
            }
         }
      }
      ans.numberOfOccupiedEl = new int[] { x, o };
      return ans;
   }

   static String checkMatrix(char[][] field, Solution arrInt, int size) {
//      to much X or O
      if (Math.abs(arrInt.numberOfOccupiedEl[0] - arrInt.numberOfOccupiedEl[1]) > 1) {
         return "Impossible";
      }
//      check row
      boolean xRowWins = false;
      boolean oRowWins = false;
      for (int i = 0; i < field.length; i++) {
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
//         results of checking rows
         if (xRowWins && oRowWins == true) {
            return "Impossible";
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
//      results of checking columns
      if (xColWins && oColWins == true) {
         return "Impossible";
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
      if (arrInt.numberOfOccupiedEl[0] + arrInt.numberOfOccupiedEl[1] != size) {
         return "Game not finished";
      }
      return "Draw";
   }

   static int[] checkIn(Scanner inSc, Solution arrInt) {
      while (true) {
         System.out.print("Enter the coordinates: ");
         String[] strIn = inSc.nextLine().trim().split(" ");
//      if (strIn.length != 2) {
//         continue;
//      }
         if (isInteger(strIn[0]) && isInteger(strIn[1]) == true) {
            int[] coordinates = new int[] { Integer.valueOf(strIn[0]), Integer.valueOf(strIn[1]) };
            boolean notInLimit = false;
            for (int i = 0; i < coordinates.length; i++) {
               if (coordinates[i] < 1 || coordinates[i] > 3) {
                  notInLimit = true;
                  break;
               }
            }
            if (notInLimit) {
               System.out.println("Coordinates should be from 1 to 3!");
               continue;
            } else {
               boolean isOccupied = false;
               for (int i = 0; i < arrInt.indexI.length; i++) {
                  if (arrInt.indexI[i] == 4 - coordinates[1] && arrInt.indexJ[i] == coordinates[0] * 2) {
                     isOccupied = true;
                     break;
                  } else {
                     continue;
                  }
               }
               if (isOccupied) {
                  System.out.println("This cell is occupied! Choose another one!");
                  continue;
               } else {
                  return new int[] { 4 - coordinates[1], coordinates[0] * 2 };
               }
            }
         } else
            System.out.println("You should enter numbers!");
         ;
      }
   }

   static boolean isInteger(String inStr) {
      if (inStr == null) {
         return false;
      }
      if (inStr.isEmpty()) {
         return false;
      }
      try {
         int temp = Integer.valueOf(inStr);
      } catch (NumberFormatException nfe) {
         return false;
      }
      return true;
   }

   static void userFillMatrix(int[] coordinates, char[][] field) {
      field[coordinates[0]][coordinates[1]] = 'X';
   }
}

//class Solution {
//   int[] numberOfOccupiedEl;
//   int[] indexI;
//   int[] indexJ;
//}
