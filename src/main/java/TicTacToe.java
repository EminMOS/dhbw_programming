import java.util.Scanner;

public class TicTacToe {

    private static final int SIZE = 3;       // 3×3 board
    private static char[][] board = new char[SIZE][SIZE];
    private static char currentPlayer = 'X'; // 'X' starts the game

    public static void main(String[] args) {
        initializeBoard();
        boolean gameRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (gameRunning) {
            printBoard();
            System.out.println("Player " + currentPlayer + ", it's your turn.");
            System.out.print("Enter row and column (0-2): ");

            int row, col;
            try {
                row = scanner.nextInt();
                col = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter two numbers (0, 1, or 2)!");
                scanner.nextLine(); // clear input buffer
                continue;
            }

            // Validate the range of row and column
            if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
                System.out.println("Coordinates out of range (0-2). Try again.");
                continue;
            }

            // Check if the cell is already occupied
            if (board[row][col] != ' ') {
                System.out.println("That cell is already taken! Try again.");
                continue;
            }

            // Place the move
            board[row][col] = currentPlayer;

            // Check if this move wins the game
            if (checkWin(currentPlayer)) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                gameRunning = false;
            }
            // Check if the board is full (draw)
            else if (isBoardFull()) {
                printBoard();
                System.out.println("It's a draw! The board is full.");
                gameRunning = false;
            }
            // Otherwise, switch the player and continue
            else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        scanner.close();
    }

    /**
     * Initializes the 3×3 board with empty spaces.
     */
    private static void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = ' ';
            }
        }
    }

    /**
     * Prints the current board to the console.
     */
    private static void printBoard() {
        System.out.println("Current board:");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(" " + board[i][j] + " ");
                if (j < SIZE - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < SIZE - 1) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }

    /**
     * Checks if the board is completely filled.
     */
    private static boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if the specified player ('X' or 'O') has won.
     */
    private static boolean checkWin(char player) {
        // Check rows
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] == player &&
                    board[i][1] == player &&
                    board[i][2] == player) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < SIZE; j++) {
            if (board[0][j] == player &&
                    board[1][j] == player &&
                    board[2][j] == player) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == player &&
                board[1][1] == player &&
                board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player &&
                board[1][1] == player &&
                board[2][0] == player) {
            return true;
        }

        return false;
    }
}
