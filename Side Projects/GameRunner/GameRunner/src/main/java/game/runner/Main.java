package game.runner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to play a game?? Yes or No??");
        String response = scan.nextLine().toLowerCase();
        if(response.equals("yes")){
            selectGame();
        } else {
            System.out.println("Your loss!!");
            System.exit(0);
        }

    }
        public static void selectGame(){
                System.out.println("Select the number before each game below!");
                System.out.println("1.) Tic-Tac-Toe");
                System.out.println("2.) Pokerito");
                System.out.println("3.) Guess The Number");
                System.out.println("4.) Hangman");

            Scanner scan = new Scanner(System.in);
            if(!scan.hasNextInt()){
                System.out.println("Select the number associated with your game of choice!");
                selectGame();
            }
            int gameToPlay = scan.nextInt();

            switch (gameToPlay){
                case 1: TicTacToe ticTacToe = new TicTacToe();
                    ticTacToe.playGame();
                    break;
                case 2: Pokerito pokerito = new Pokerito();
                    pokerito.explainRules();
                    break;
                case 3: GuessTheNumberGame guessGame = new GuessTheNumberGame();
                    guessGame.selectDifficulty();
                    break;
                case 4: Hangman hangman = new Hangman();
                hangman.playGame();
                break;

                default:
                    System.out.println("Pick a valid option!");
                    selectGame();
            }
        }

    }

