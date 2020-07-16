package tictactoe;

public class Battlefield {
   /**
    * Tic-tac-toe is a game played by two players on a 3x3 field.
    * 
    * One of the players plays as 'X', and the other player is 'O'. 'X' plays
    * first, then the 'O' side plays, and so on.
    * 
    * The players write 'X' and 'O' on a 3x3 field.
    * 
    * The first player that writes 3 'X' or 3 'O' in a straight line (including
    * diagonals) wins.
    * 
    * Your first task in this project is to print any state of the field in the
    * console output. Example
    * 
    * The example below shows how your output might look.
    * 
    * X O X 
    * O X O 
    * X X O
    */

   public static void main(String[] args) {
      // write your code here
      char[][] field = new char[5][5];
      char[][] symbol = new char[][] { { 'X', 'O', 'X' }, { 'O', 'X', 'O' }, { 'X', 'X', 'O' } };
      for (int i = 0; i < field.length; i++) {
         for (int j = 0; j < field[i].length; j++) {
            if (j % 2 == 0 && i % 2 == 0) {
               field[i][j] = symbol[i / 2][j / 2];
            } else {
               field[i][j] = ' ';
            }
            System.out.print(field[i][j]);
         }
         System.out.println();
      }
//      System.out.println();
//      printMatrix();
   }

   static void printMatrix() {
      char[][] ticTac = new char[3][3];
      for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 3; j++) {
            ticTac[i][j] = 'X';
            if (j % 2 == 0) {
               ticTac[i][j] = 'O';
            }
         }
      }
      for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 3; j++) {
            System.out.print(ticTac[i][j] + " ");
         }
         System.out.println();
      }
   }
}
