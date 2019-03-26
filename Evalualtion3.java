package eecs1022.lab6;

/**
 * Created by sunny on 2018-03-31.
 */

public class Evalualtion3 {
    public static void main(String[] args) {


        char[][] board = {
                {'.', 'X', 'O'},
                {'X', 'O', 'O'},
                {'O', 'O', 'X'}

        };

        //char check_win(board[row][col],int row, int col)
       char check_win = ' ';

        {
           // char result;
            int row = board.length;
            int col = board[0].length;

            int i = 0;
            for (i = 0; i < row; i++)
            {
                if ((board[i][0] == board[i][1])
                        && (board[i][1] == board[i][2])
                        && (board[i][1] != ' ')){
              check_win = board[i][1];
                }
                    //
            }
            for (i = 0; i < col; i++)
            {
                if ((board[0][i] == board[1][i])
                        && (board[1][i] == board[2][i])
                        && (board[1][i] != ' ')){
                    check_win =  board[1][i];
                }
           //         return
            }
            if ((board[0][0] == board[1][1])
                    && (board[1][1] == board[2][2])
                    && (board[1][1] != ' ')){
                check_win =  board[1][1];
            }
          //      return board[1][1];
            if ((board[0][2] == board[1][1])
                    && (board[1][1] == board[2][0])
                    && (board[1][1] != ' ')){
                check_win =  board[1][1];
            }

        }
        System.out.println("The winner is " + check_win);

}
}
