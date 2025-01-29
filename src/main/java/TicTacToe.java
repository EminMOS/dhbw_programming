import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame {

    private static final int SIZE = 3;
    private JButton[][] buttons = new JButton[SIZE][SIZE];
    private char[][] board = new char[SIZE][SIZE];
    private char currentPlayer = 'X';

    public static void main(String[] args) {
        // Start the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            new TicTacToe().setVisible(true);
        });
    }

    public TicTacToe() {
        super("TicTacToe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        // Create a panel with a 3x3 GridLayout for the buttons
        JPanel panel = new JPanel(new GridLayout(SIZE, SIZE));

        // Initialize our internal board array with spaces
        initializeBoard();

        // Create and add the buttons
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                JButton button = new JButton("");
                button.setFont(new Font("Arial", Font.BOLD, 48));
                button.setFocusPainted(false);

                // We pass in final references for row/col into the listener
                final int r = row;
                final int c = col;
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        handleButtonClick(r, c, button);
                    }
                });

                buttons[row][col] = button;
                panel.add(button);
            }
        }

        add(panel);
    }

    /**
     * Initialize the board array with ' ' (space) in each cell.
     */
    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = ' ';
            }
        }
    }

    /**
     * Handle a button click at (row, col).
     */
    private void handleButtonClick(int row, int col, JButton button) {
        // If this cell is already taken, do nothing
        if (board[row][col] != ' ') {
            return;
        }

        // Place the current player's mark
        board[row][col] = currentPlayer;
        button.setText(String.valueOf(currentPlayer));

        // Check for a win
        if (checkWin(currentPlayer)) {
            JOptionPane.showMessageDialog(
                    this,
                    "Player " + currentPlayer + " wins!",
                    "Game Over",
                    JOptionPane.INFORMATION_MESSAGE
            );
            resetGame();
            return;
        }

        // Check for a draw
        if (isBoardFull()) {
            JOptionPane.showMessageDialog(
                    this,
                    "It's a draw!",
                    "Game Over",
                    JOptionPane.INFORMATION_MESSAGE
            );
            resetGame();
            return;
        }

        // Switch player
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    /**
     * Checks whether all cells on the board are filled (no more moves).
     */
    private boolean isBoardFull() {
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
     * Checks if the given player (X or O) has a winning row, column, or diagonal.
     */
    private boolean checkWin(char player) {
        // Rows
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] == player &&
                    board[i][1] == player &&
                    board[i][2] == player) {
                return true;
            }
        }
        // Columns
        for (int j = 0; j < SIZE; j++) {
            if (board[0][j] == player &&
                    board[1][j] == player &&
                    board[2][j] == player) {
                return true;
            }
        }
        // Diagonals
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

    /**
     * Resets the game board and clears all buttons.
     */
    private void resetGame() {
        initializeBoard();
        currentPlayer = 'X';
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j].setText("");
            }
        }
    }
}
