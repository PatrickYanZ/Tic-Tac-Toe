package eecs1022.lab6;

/**
 * Created by user on 3/28/18.
 */
public class Evayaltion2
{

        public static void main(String[] args) {
            char[][] board = {
                    {'.', 'X', 'O'},
                    {'X', 'O', 'O'},
                    {'O', 'O', 'X'}

            };
            boolean WinnerisXr = true;
            boolean WinnerisOr = true;
            boolean WinnerisXc = true;
            boolean WinnerisOc = true;
            boolean WinnerisXs = true;
            boolean WinnerisOs = true;
            boolean WinnerisXs1 = true;
            boolean WinnerisOs1 = true;
            boolean exit = false;

            for (int row = 0; !exit && row < board.length; row++) {
                for(int col = 0; !exit && col <board[0].length; col++){
                    WinnerisOr = WinnerisOr && (board[row][col] == 'O');
                    WinnerisXr = WinnerisXr && (board[row][col] == 'X');
                }
                if(WinnerisOr||WinnerisXr){
                    exit = true;// execute this to exit the loop
                }
                else if(row < board.length -1) {
                    WinnerisOr = true;// initialize this variable in order to continue in the next row
                    WinnerisXr = true;
                }
            }

            {
                exit = false;
                for(int col = 0 ; !exit && col < board[0].length; col++){
                    for (int row = 0; !exit && row < board.length; row++) {
                        WinnerisOc = WinnerisOc && (board[row][col] == 'O');
                        WinnerisXc = WinnerisXc && (board[row][col] == 'X');

                    }
                    if(WinnerisOc||WinnerisXc){
                        exit = true;// execute this to exit the loop
                    }
                    else if(col < board[0].length -1) {
                        WinnerisOc = true;// initialize this variable in order to continue in the next row
                        WinnerisXc = true;
                    }

                }
            }



            {
                exit = false;
            for (int row = 0; !exit && row < board.length; row++) {
                WinnerisXs = WinnerisXs && (board[row][row] == 'X');
                WinnerisOs = WinnerisOs && (board[row][row] == 'O');
                WinnerisXs1 = WinnerisXs1 && (board[row][board[0].length -1 -row] == 'X');
                WinnerisOs1 = WinnerisOs1 && (board[row][board[0].length -1 -row] == 'O');

            }
                if(WinnerisOs||WinnerisXs||WinnerisOs1||WinnerisXs1){
                    exit = true;
                }

            }




            for (int row = 0; row < board.length ; row++) {
                for (int col = 0; col < board[row].length ; col++) {
                    System.out.print(board[row][col] + " ");
                }
                System.out.println();

            }


            System.out.println("Winner is X " + (WinnerisXr || WinnerisXc || WinnerisXs||WinnerisXs1));
            System.out.println("Winner is O " + (WinnerisOr || WinnerisOc || WinnerisOs||WinnerisOs1));

            System.out.println("Winner is Xr " + (WinnerisXr));
            System.out.println("Winner is Or " + (WinnerisOr));

            System.out.println("Winner is Xc " + (WinnerisXc));
            System.out.println("Winner is Oc " + (WinnerisOc));

            System.out.println("Winner is Xs " + (WinnerisXs));
            System.out.println("Winner is Os " + (WinnerisOs));

            System.out.println("Winner is Xs1 " + (WinnerisXs1));
            System.out.println("Winner is Os1 " + (WinnerisOs1));

        }


}

//                exit = false;
//                WinnerisXs = true;
//                WinnerisOs = true;
//                for (int row = 0; !exit && row < board.length; row++) {
//                    WinnerisXs = WinnerisXs && (board[row][board[0].length -1 -row] == 'X');
//                    WinnerisOs = WinnerisOs && (board[row][board[0].length -1 -row] == 'O');
//                }
//                if(WinnerisOs||WinnerisXs){
//                    exit = true;
//                }
