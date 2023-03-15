package game.runner;

import java.util.Scanner;

public class GuessTheNumberGame {
    int difficulty;

    public GuessTheNumberGame() {
    }




    Scanner scan = new Scanner(System.in);

    public void selectDifficulty() {
        System.out.println("Select a difficulty: 1 0r 2");
        int response = scan.nextInt();
        if (response > 2 || response < 1) {
            selectDifficulty();
        } else if (response == 1) {
            playGame(response);
        } else {
            playGame(response);
        }
    }

    public void playGame(int response) {
        int counter = 1;
        if (response == 1) {
            int numberToGuess = (int) (Math.random() * 100 + 1);
            System.out.println("You have chosen the easy level! Guess a random number between 1 and 100! You have six tries!");
            while (counter < 7) {
                System.out.println("Guess: " + counter);
                int guess = scan.nextInt();
                if (guess == numberToGuess) {
                    System.out.println("Goood Guess! Restart the aplication to start again!");
                    System.exit(0);
                } else if (guess < numberToGuess) {
                    System.out.println("Guess Higher!!");
                    counter++;
                } else if (guess > numberToGuess) {
                    System.out.println("Guess Lower!");
                    counter++;
                }
            }
            System.out.println("You are out of guesses! Restart the application to start again:)");
        } else if (response == 2) {
            int numberToGuess = (int) (Math.random() * 1000) + 1;
            System.out.println("You have chosen the difficult level! Guess a random number between 1 and 1000! You have six tries!");
            while (counter < 7) {
                System.out.println("Guess: " + counter);
                int guess = scan.nextInt();

                if (guess == numberToGuess) {
                    System.out.println("Goood Guess! Restart the aplication to start again!");
                    System.exit(0);
                } else if (guess < numberToGuess) {
                    System.out.println("Guess Higher!!");
                    counter++;
                } else if (guess > numberToGuess) {
                    System.out.println("Guess Lower!");
                    counter++;
                }
            }
            System.out.println("You are out of guesses! Restart the application to start again:)");

        }

    }
}
