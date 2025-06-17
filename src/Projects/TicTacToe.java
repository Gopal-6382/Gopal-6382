package Projects;

import java.util.*;

/*
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    static String[] board;
    static String turn;

    static String checkWinner() {
        for (int a = 0; a < 8; a++) {
            String line = null;

            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            //For X winner
            if (line.equals("XXX")) {
                return "X";
            }

            // For O winner
            else if (line.equals("OOO")) {
                return "O";
            }
        }

        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains(String.valueOf(a + 1))) {
                break;
            } else if (a == 8) {
                return "draw";
            }
        }

        // To enter the X Or O at the exact place on board.
        System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
        return null;
    }

    static void printBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("|---|---|---|");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        String winner = null;

        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }

        System.out.println("Welcome to 3x3 Tic Tac Toe.");
        printBoard();

        System.out.println("X will play first. Enter a slot number to place X in:");

        while (winner == null) {
            int numInput;

            // Exception handling.
            // numInput will take input from user like from 1 to 9.
            // If it is not in range from 1 to 9.
            // then it will show you an error "Invalid input."
            try {
                numInput = in.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println("Invalid input; re-enter slot number:");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input; re-enter slot number:");
                continue;
            }

            // This game has two player x and O.
            // Here is the logic to decide the turn.
            if (board[numInput - 1].equals(String.valueOf(numInput))) {
                board[numInput - 1] = turn;

                if (turn.equals("X")) {
                    turn = "O";
                } else {
                    turn = "X";
                }

                printBoard();
                winner = checkWinner();
            } else {
                System.out.println("Slot already taken; re-enter slot number:");
            }
        }

        if (winner.equalsIgnoreCase("draw")) {
            System.out.println("It's a draw! Thanks for playing.");
        } else {
            System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
        }
    }
}

 */
/*
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}

class Game {
    private final String[] board = new String[9];
    private String currentPlayer;
    private final Scanner input = new Scanner(System.in);
    private static final int[][] WINNING_COMBINATIONS = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
            {0, 4, 8}, {2, 4, 6}             // Diagonals
    };
    private static final String PLAYER_X = "X";
    private static final String PLAYER_O = "O";

    public void start() {
        initializeGame();
        playGame();
        input.close();
    }

    private void initializeGame() {
        Arrays.setAll(board, i -> String.valueOf(i + 1));
        currentPlayer = PLAYER_X;
        System.out.println("Welcome to 3x3 Tic Tac Toe.");
        printBoard();
        System.out.println("X will play first. Enter a slot number (1-9):");
    }

    private void playGame() {
        String result = null;
        while (result == null) {
            int move = getValidMove();
            makeMove(move);
            printBoard();
            result = checkGameResult();
            switchPlayer();
        }
        displayResult(result);
    }

    private int getValidMove() {
        while (true) {
            try {
                int position = input.nextInt();
                if (position < 1 || position > 9) {
                    System.out.println("Invalid range! Enter a number 1-9:");
                } else if (!board[position - 1].equals(String.valueOf(position))) {
                    System.out.println("Slot taken! Try another:");
                } else {
                    return position;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Enter a number 1-9:");
                input.next(); // Clear invalid input
            }
        }
    }

    private void makeMove(int position) {
        board[position - 1] = currentPlayer;
    }

    private void switchPlayer() {
        currentPlayer = currentPlayer.equals(PLAYER_X) ? PLAYER_O : PLAYER_X;
    }

    private String checkGameResult() {
        // Check for win
        for (int[] combination : WINNING_COMBINATIONS) {
            if (board[combination[0]].equals(board[combination[1]]) &&
                    board[combination[0]].equals(board[combination[2]])) {
                return board[combination[0]];
            }
        }

        // Check for draw
        if (Arrays.stream(board).noneMatch(cell -> cell.matches("[1-9]"))) {
            return "draw";
        }

        return null;
    }

    private void printBoard() {
        System.out.println("\n|---|---|---|");
        for (int i = 0; i < board.length; i += 3) {
            System.out.printf("| %s | %s | %s |%n", board[i], board[i+1], board[i+2]);
            System.out.println("|-----------|");
        }
    }

    private void displayResult(String result) {
        if (result.equals("draw")) {
            System.out.println("It's a draw! Thanks for playing.");
        } else {
            System.out.printf("Congratulations! %s's have won!%n", result);
        }
    }
}

 */
import java.util.HashSet;
import java.util.Set;

class NameCounter {
    public static void main(String[] args) {
        String[] names = {"Gopal", "Ram", "Gopal", "Ram", "Sita"};
        Set<String> countedNames = new HashSet<>();

        for (int i = 0; i < names.length; i++) {
            if (countedNames.contains(names[i])) continue;

            int count = 1;
            for (int j = i + 1; j < names.length; j++) {
                if (names[i].equals(names[j])) {
                    count++;
                }
            }
            System.out.println("The student " + names[i] + " appears " + count + " times");
            countedNames.add(names[i]);
        }

        // Original array remains unchanged
        System.out.println("\nOriginal array:");
        for (String name : names) {
            System.out.print(name + " ");
        }
    }
}