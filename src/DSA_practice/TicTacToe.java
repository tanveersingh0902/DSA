package DSA_practice;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {

        char[][] board = new char[3][3];
        for(int row = 0; row < board.length; row++){
            for(int cols = 0; cols <board[row].length; cols++){
                board[row][cols] = ' ';
            }
        }
        char player = 'X';
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);

        while (!gameOver){
            printBoard(board);
            System.out.println("Player " + player + " enter: ");
            int row = sc.nextInt();
            int cols = sc.nextInt();

            if(board[row][cols] == ' '){
                // place the element
                board[row][cols] = player;
                gameOver = havewon(board , player);
                if(gameOver){
                    System.out.println("Player " + player + " has won: ");
                }else {
                    player = (player == 'X') ? 'O' : 'X';
                }
            }else {
                System.out.println("Invalid Move. Try Again!");
            }
        }
        printBoard(board);
    }

    public static boolean havewon(char[][] board , char player){
        // check the rows
        for(int row = 0; row < board.length; row++){
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }
        //check the cols
        for(int cols = 0; cols < board.length; cols++){
            if(board[0][cols] == player && board[1][cols] == player && board[2][cols] == player){
                return true;
            }
        }

        // check the diagonal
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }

    return false;

    }

    public static void printBoard(char[][] board){
        for(int row = 0; row < board.length; row++){
            for(int cols = 0; cols <board[row].length; cols++){
                System.out.print(board[row][cols] + " | ");
            }
            System.out.println();
        }

    }
}
