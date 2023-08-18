import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];          //to create board
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';            //to set the spaces empty
            }
        }
        char player = 'X';
        boolean gameover = false;
        Scanner sc = new Scanner(System.in);

        while (!gameover) {
            printboard(board);
            System.out.println("Player " + player + " enter:");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if (board[row][col] == ' ') {
                board[row][col] = player;    //place the element
                gameover = havewon(board, player);
                if (gameover) {
                    System.out.println("Player " + player + " has won");
                } else {
                    player = (player == 'X') ? 'O' : 'X';
                }
            } else  {
                System.out.println("Invalid Move.Try Again!");
            }
        }
    }

        public static void printboard ( char[][] board){

            for (int row = 0; row <board.length; row++) {
                for (int col = 0; col <board[row].length; col++) {

                    System.out.print(board[row][col] + "|");
                }
                System.out.println();
            }
        }

        public static boolean havewon ( char[][] board, char player){
            //to check row
            for (int row = 0; row < board.length; row++) {
                if (board[0][row] == player && board[1][row] == player && board[2][row] == player) {
                    return true;
                }
            }
            //to check col
            for (int col = 0; col < board.length; col++) {
                if (board[col][0] == player && board[col][1] == player && board[col][2] == player) {
                    return true;
                }
            }
            //to check diagonal
            if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
                return true;
            }
            if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
                return true;
            }
            return false;
        }
    }
