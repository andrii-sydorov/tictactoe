package tictactoe;

import java.util.Scanner;

public class GameMasterTest {
   /**
    * The same as GameMaster, but with spaces and squareMatrix
    * @param args
    */
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String in = sc.nextLine();
      int size = in.length();
      char[][] field = new char[size][size];
      buildFrame(field);
      fillMatrix(field, in);
      print(field);
      sc.close();
   }

   static void buildFrame(char[][] field) {
      for (int i = 0; i < field.length; i++) {
         for (int j = 0; j < field[i].length; j++) {
            if (j == 0 || j == field[i].length - 1) {
               field[i][j] = '|';
            } else if (i == 0 || i == field[i].length - 1) {
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
            if (i > 1 && i < field[i].length - 2 && j > 1 && j < field[i].length - 2) {
               if (i % 2 == 0 && j % 2 == 0) {
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
