package tictactoe;

interface Overload {
   static void buildFrame(char[][] field) {
      /**
       * to build frame in separate method
       */
      
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
}
