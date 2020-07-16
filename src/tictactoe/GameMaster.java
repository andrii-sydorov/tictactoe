package tictactoe;

import java.util.Scanner;

public class GameMaster {
   /**
    * Description
    * 
    * In this stage, you should write a program that reads 9 symbols from the input
    * and writes an appropriate 3x3 field. Elements of the field can contain only
    * 'X', 'O' and '_' symbols.
    * 
    * Note, that field has a specific format and should start and end with
    * ---------, all lines in between should start and end with '|' symbol and
    * everything in the middle should be separated with a single space. Examples
    * 
    * Examples below show how your output should look.
    * 
    * Example 1:
    * 
    * Enter cells: O_OXXO_XX 
    * --------- 
    * | O _ O | 
    * | X X O | 
    * | _ X X | 
    * ---------
    * 
    * Example 2:
    * 
    * Enter cells: OXO__X_OX 
    * --------- 
    * | O X O | 
    * | _ _ X | 
    * | _ O X | 
    * ---------
    * 
    * Example 3:
    * 
    * Enter cells: _XO__X___ 
    * --------- 
    * | _ X O | 
    * | _ _ X | 
    * | _ _ _ | 
    * ---------
    * 
    * @param args
    */

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String in = sc.nextLine();
      int size = in.length();
      char[][] field = new char[(int) Math.sqrt(size) + 2][(int) Math.sqrt(size) + 6];
      buildFrame(field);
      fillMatrix(field, in);
      print(field);
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

   static void fillMatrix(char[][] field, String in) {
      int index = 0;
      for (int i = 0; i < field.length; i++) {
         for (int j = 0; j < field[i].length; j++) {
            if (i > 0 && i < field.length - 1 && j > 0 && j < field[i].length - 1) {
               if (j % 2 == 0) {
                  field[i][j] = in.charAt(index);
                  index++;
               } else {
                  field[i][j] = ' ';
               }
            } else {
               continue;
            }
         }
      }
   }
}
