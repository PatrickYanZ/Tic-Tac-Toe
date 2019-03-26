package eecs1022.lab6;

/**
 * Created by user on 3/28/18.
 */
public class Game
{
    String player1Name;
    String player2Name;

    char player1;
    char player2;

    char player1Select;
    //char player2;

    int r;
    int c;
    int round;

    String Xname;
    String Oname;

    boolean exit;

    boolean error;
    String errorMSg;

    void setError(String errorMSg) {
        this.error = true;
        this.errorMSg = errorMSg;
    }

    void ResetError(){
        this.error = false;
    }

    Game(String player1Name, String player2Name, char player1Select){
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.player1Select = player1Select;
    }

    char[][] board = {
            {'.', '.', '.'},
            {'.', '.', '.'},
            {'.', '.', '.'}

    };

    public void InitialGame(){
        board = new char[][]{
                {'.', '.', '.'},
                {'.', '.', '.'},
                {'.', '.', '.'}

        };

        ResetError();
        exit = false;
        round = 0;
    }

    public void firstPlay(char FirstPlayerSelect) {
        if (FirstPlayerSelect == ('X')) {
            player1 = 'X';
            player2 = 'O';
            Xname = player1Name;
            Oname = player2Name;
        } else if (FirstPlayerSelect == ('O')) {
            player1 = 'O';
            player2 = 'X';
            Oname = player1Name;
            Xname = player2Name;
        } else {
            setError("no exist, testing only.");
        }
    }

    public void addPoint(int r, int c, char s) {
        if (board[r][c] == '.') {
            board[r][c] = s;
        } else {
            setError("The point is occupied.");
        }
    }


    public void Play(int r, int c) {
        this.r = r;
        this.c = c;
        //this.player1Select = player1Select;
        getWinner(r,c);


//        } else if (error) {
//            setError("error");
        if (!exit) {
            //ResetGame();
            char First = player1Select;
            firstPlay(First);
            if (round % 2 == 0) {
                addPoint(r, c, player1);
                round++;
            } else if (round % 2 == 1) {
                addPoint(r, c, player2);
                round++;

            }

        } else {

        }

    }

     /*
    Below this is testing the winner in the game
     */

    boolean WinnerisXr = true;
    boolean WinnerisOr = true;
    boolean WinnerisXc = true;
    boolean WinnerisOc = true;
    boolean WinnerisXs = true;
    boolean WinnerisOs = true;
    boolean WinnerisXs1 = true;
    boolean WinnerisOs1 = true;


    public void getWinner(int r, int c){
         {
             int row = r;
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
            int col = c ;
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

        {// universal quantifier to find the point on the diagonal.
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
    }

    public void ResetGame() {
        round = 0;

        exit = false;
        error = false;
    }

    @Override
    public String toString() {
        String s = "";
        getWinner(r,c);

        for (int row = 0; row < board.length ; row++) {
            // System.out.println("Row" + row);
            for (int col = 0; col < board[row].length ; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
        s += "The round is " + round + "" + "\n";

        if (exit) {
            if (WinnerisXr || WinnerisXc || WinnerisXs) {
                System.out.println("Game is over. The winner is: " + Xname);
            } else if (WinnerisOr || WinnerisOc || WinnerisOs) {
                System.out.println("Game is over. The winner is: " + Oname);
            } else if (this.round >= 8) {
                System.out.println("Game is over. Get a tie.");
            }
        } else if (error) {
            System.out.println(errorMSg);
            ResetGame();
        } else {
            System.out.println("The game could continue.");
        }
        //  System.out.println();
        return s;
    }
}



