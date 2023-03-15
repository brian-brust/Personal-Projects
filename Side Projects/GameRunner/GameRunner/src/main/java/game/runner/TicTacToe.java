package game.runner;

import java.util.Scanner;


public class TicTacToe {

    public TicTacToe() {
    }

    Scanner scan = new Scanner(System.in);


    public void playGame() {
        System.out.println("\nLet's play tic tac toe");

        char[][] board = {
                {'_', '_', '_'},
                {'_', '_', '_'},
                {'_', '_', '_'},
        };

        printBoard(board);


        for (int i = 0; i < 9; i++) {
            char player = ' ';
            if (i % 2 == 0) {
                player = 'X';
                System.out.print("Turn: " + player + " ");
            } else {
                player = 'O';
                System.out.println("Turn: " + player + " ");
            }
            chooseSpot(board, player);
            checkWin(board);

        }
        System.out.println("GAME OVER! NOONE WINS! RESTART TO TRY AGAIN");
        System.exit(0);
    }



    public static void printBoard(char[][] charArray) {
        System.out.print("\n");
        for (int i = 0; i < charArray.length; i++) {

            System.out.print("\t");
            for (int j = 0; j < charArray[i].length; j++) {
                System.out.print(charArray[i][j] + " ");
            }
            System.out.println("\n\n");
        }
    }
    /*
     *
     */



    public int[] chooseSpot(char[][] board, char player) {
        System.out.println(" First pick a row: ");
        int row = scan.nextInt();
        System.out.println("Now, pick a column:");
        int column = scan.nextInt();
        int[] needlessArray = {row, column};

        while (board[row][column] != '_') {
            System.out.println("that spot is taken. Choose an unmarked spot");
            System.out.println("pick a row: ");
            row = scan.nextInt();
            System.out.println("Now, pick a column:");
            column = scan.nextInt();
        }
        board[row][column] = player;
        printBoard(board);
        return needlessArray;

    }

    public void checkWin(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X' || board[i][j] == 'x') {
                    count++;
                    if (count == 3) {
                        System.out.println("X wins!");
                        System.exit(0);
                    }
                } else if (board[i][j] == 'O' || board[i][j] == 'o') {
                    count--;
                    if (count == -3) {
                        System.out.println("O wins!");
                        System.exit(0);
                    }
                }
            }
        }
        count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[j][i] == 'X' || board[j][i] == 'x') {
                    count++;
                    if (count == 3) {
                        System.out.println("X wins!");
                        System.exit(0);
                    }
                } else if (board[j][i] == 'O' || board[j][i] == 'o') {
                    count--;
                    if (count == -3) {
                        System.out.println("O wins!");
                        System.exit(0);
                    }
                }
            }
        }
        count = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 'X' || board[i][i] == 'x') {
                count++;
                if (count == 3) {
                    System.out.println("X wins!");
                    System.exit(0);
                }
            } else if (board[i][i] == 'O' || board[i][i] == 'o') {
                count--;
                if (count == -3) {
                    System.out.println("O wins!");
                    System.exit(0);
                }
            }

        }
        count = 0;
        for (int i = 0; i < 3; i++) {
            if (board[i][2 - i] == 'X' || board[i][2 - i] == 'x') {
                count++;
                if (count == 3) {
                    System.out.println("X wins!");
                    System.exit(0);
                }
            } else if (board[i][2 - i] == 'O' || board[i][2 - i] == 'o') {
                count--;
                if (count == -3) {
                    System.out.println("O wins!");
                    System.exit(0);
                }
            }
        }

    }


}



