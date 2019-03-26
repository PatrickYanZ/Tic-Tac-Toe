package eecs1022.lab6;

/**
 * Created by user on 3/28/18.
 */
public class Evaluation
{
    public static void main(String[] args){
        char point ='.';
        //char point2 = "s";
        char[][] board = {
                {'O','O','O'},
                {'.','X','.'},
                {'O','O','.'}
        };

        boolean WinnerisXr = true;
        boolean WinnerisOr = true;
        boolean WinnerisXc = true;
        boolean WinnerisOc = true;
        boolean WinnerisXs = true;
        boolean WinnerisOs = true;
        boolean exit = false;

        for (int row = 0; !exit && row < board.length; row++) {
            for(int col = 0; col <board[0].length; col++){
                WinnerisOr = WinnerisOr && (board[row][col] == 'O');
                WinnerisXr = WinnerisXr && (board[row][col] == 'X');
                if(WinnerisOr||WinnerisXr){
                    exit = true;// execute this to exit the loop
                }
            }

             if(row < board.length -1) {
                WinnerisOr = true;// initialize this variable in order to continue in the next row
                WinnerisXr = true;
            }
        }

        for(int col = 0 ; !exit && col < board[0].length; col++){
            for (int row = 0; !exit && row < board.length; row++) {
                WinnerisOc = WinnerisOc && (board[row][col] == 'O');
                WinnerisXc = WinnerisXc && (board[row][col] == 'X');
                if(WinnerisOc||WinnerisXc){
                    exit = true;// execute this to exit the loop
                }

            }

             if(col < board[0].length -1) {
                WinnerisOc = true;// initialize this variable in order to continue in the next row
                WinnerisXc = true;
            }

        }

        for (int row = 0; !exit && row < board.length; row++) {
            WinnerisXs = WinnerisXs && (board[row][row] == 'X');
            WinnerisOs = WinnerisOs && (board[row][row] == 'O');
            if(WinnerisOs||WinnerisXs){
                exit = true;
            }
        }




        for (int row = 0; row < board.length ; row++) {
            for (int col = 0; col < board[row].length ; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();

        }

        System.out.println("Winner is X " + (WinnerisXr || WinnerisXc || WinnerisXs));
        System.out.println("Winner is O " + (WinnerisOr || WinnerisOc || WinnerisOs));

        System.out.println("Winner is Xr " + (WinnerisXr));
        System.out.println("Winner is Or " + (WinnerisOr));

        System.out.println("Winner is Xc " + (WinnerisXc));
        System.out.println("Winner is Oc " + (WinnerisOc));

        System.out.println("Winner is Xs " + (WinnerisXs));
        System.out.println("Winner is Os " + (WinnerisOs));
    }
}
