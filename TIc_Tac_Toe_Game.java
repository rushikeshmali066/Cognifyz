package Task_02;

import java.util.Scanner;

public class TIc_Tac_Toe_Game 
{
	 private static final int BOARD_SIZE = 3;
	    private static final char EMPTY = '-';
	    private static char[][] board = new char[BOARD_SIZE][BOARD_SIZE];

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Tic-Tac-Toe Game");
	        System.out.println("----------------");

	        // Initialize the game board
	        initializeBoard();

	        // Game loop
	        while (true) {
	            // Display the current game board
	            displayBoard();

	            // Player X's turn
	            playerMove('X');

	            // Check for a win or draw
	            if (checkGameResult('X')) {
	                break;
	            }

	            // Display the current game board
	            displayBoard();

	            // Player O's turn
	            playerMove('O');

	            // Check for a win or draw
	            if (checkGameResult('O')) {
	                break;
	            }
	        }

	        scanner.close();
	    }

	    private static void initializeBoard() {
	        for (int i = 0; i < BOARD_SIZE; i++) {
	            for (int j = 0; j < BOARD_SIZE; j++) {
	                board[i][j] = EMPTY;
	            }
	        }
	    }

	    private static void displayBoard() {
	        System.out.println("\nCurrent Board:");
	        for (int i = 0; i < BOARD_SIZE; i++) {
	            for (int j = 0; j < BOARD_SIZE; j++) {
	                System.out.print(board[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }

	    private static void playerMove(char playerSymbol) {
	        Scanner scanner = new Scanner(System.in);

	        int row, col;

	        while (true) {
	            System.out.print("\nPlayer " + playerSymbol + ", enter your move (row and column, separated by space): ");
	            row = scanner.nextInt() - 1;
	            col = scanner.nextInt() - 1;

	            if (isValidMove(row, col)) {
	                board[row][col] = playerSymbol;
	                break;
	            } else {
	                System.out.println("Invalid move. Please try again.");
	            }
	        }
	    }

	    private static boolean isValidMove(int row, int col) {
	        return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE && board[row][col] == EMPTY;
	    }

	    private static boolean checkGameResult(char playerSymbol) {
	        if (checkRows(playerSymbol) || checkColumns(playerSymbol) || checkDiagonals(playerSymbol)) {
	            displayBoard();
	            System.out.println("Player " + playerSymbol + " wins!");
	            return true;
	        } else if (isBoardFull()) {
	            displayBoard();
	            System.out.println("It's a draw!");
	            return true;
	        }

	        return false;
	    }

	    private static boolean checkRows(char playerSymbol) {
	        for (int i = 0; i < BOARD_SIZE; i++) {
	            if (board[i][0] == playerSymbol && board[i][1] == playerSymbol && board[i][2] == playerSymbol) {
	                return true;
	            }
	        }
	        return false;
	    }

	    private static boolean checkColumns(char playerSymbol) {
	        for (int j = 0; j < BOARD_SIZE; j++) {
	            if (board[0][j] == playerSymbol && board[1][j] == playerSymbol && board[2][j] == playerSymbol) {
	                return true;
	            }
	        }
	        return false;
	    }

	    private static boolean checkDiagonals(char playerSymbol) {
	        return (board[0][0] == playerSymbol && board[1][1] == playerSymbol && board[2][2] == playerSymbol) ||
	               (board[0][2] == playerSymbol && board[1][1] == playerSymbol && board[2][0] == playerSymbol);
	    }

	    private static boolean isBoardFull() {
	        for (int i = 0; i < BOARD_SIZE; i++) {
	            for (int j = 0; j < BOARD_SIZE; j++) {
	                if (board[i][j] == EMPTY) {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }
}
