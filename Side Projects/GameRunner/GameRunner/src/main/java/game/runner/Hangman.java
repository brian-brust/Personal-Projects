package game.runner;

import java.util.Arrays;
import java.util.Scanner;

public class Hangman {

    public static String[] words = { "ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
            "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
            "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
            "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
            "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon",
            "python", "rabbit", "ram", "rat", "raven", "rhino", "salmon", "seal",
            "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
            "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
            "wombat", "zebra" };

    public static String[] gallows = { "+---+\n" +
            "|   |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "|   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|   |\n" +
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" + // if you were wondering, the only way to print '\' is with a trailing escape
                    // character, which also happens to be '\'
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/    |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/ \\  |\n" +
                    "     |\n" +
                    " =========\n" };

        public void playGame() {
            Scanner scan = new Scanner(System.in);
            int guesses = 0;


            System.out.println("It's time to play Hangman. GUESS CORRECTLY OR FEEL YOUR NECK BREAK FROM THE ROPE.");

            System.out.println("You can guess one letter at a time or you can go for gold and guess the whole word. Don't let the gallows add pressure. ITS ONLY YOUR LIFE AT STAKE :^)");
            String wordToGuess = randomWordSelector();
            char[] wordToGuessAsArray = wordToGuess.toCharArray();
            String wordPresented = "";
            for (int i = 0; i < wordToGuess.length(); i++) {
                wordPresented += "_";
            }
            char[] wordDisplayedPlaceholders = wordPresented.toCharArray();
            String missedLetters = "";
            for (int i = 0; i < wordToGuess.length() + 1; i++) {
                missedLetters += "_";
            }
            char[] missedLettersPlaceholders = missedLetters.toCharArray();

            int incorrect = 0;
            while (incorrect <= wordToGuess.length()) {
                System.out.println(gallows[incorrect]);
                System.out.print("Word:     ");
                printPlaceholders(wordDisplayedPlaceholders);
                System.out.print("\n");

                System.out.print("Misses:     ");
                updateMissedLetters(missedLettersPlaceholders);
                System.out.print("\n");

                System.out.print("Guess:     ");

                String guessLetter = scan.nextLine();
                char guess = guessLetter.charAt(0);
                if (guessLetter.length() > 1) {
                    if (guessLetter.equalsIgnoreCase(wordToGuess)) {
                        System.out.println("Goodness how lovely that you have escaped the sickle for now.");
                        System.exit(0);
                    } else {
                        System.out.println("YIKES. The reaper awaits. 8^O");
                        System.out.println("The word we were looking for was..." + wordToGuess);
                        System.exit(0);
                    }
                } else {
                    guesses++;
                    boolean helperBoolean = checkGuess(guess, wordToGuess);
                    if (!helperBoolean) {
                        missedLettersPlaceholders[incorrect] = guess;
                        incorrect++;
                        updateMissedLetters(missedLettersPlaceholders);

                    } else {
                        updatePlaceholders(wordDisplayedPlaceholders, wordToGuess, guess);

                    }
                }
                if (Arrays.equals(wordDisplayedPlaceholders, wordToGuessAsArray)) {
                    System.out.println(wordToGuess + "\nWOOHOO YOU DID GREAT:) RESTART TO PLAY AGAIN!!");
                    System.exit(0);
                }

            }
            System.out.println("\n" + "we were hoping for..." + wordToGuess);
            System.out.println("\nDEATH AWAITS.");
            System.out.println("Restart to play again:)");
            scan.close();

        }

    public static String randomWordSelector() {
        int number = ((int) (Math.random() * 65));
        return words[number];
    }

    public static boolean checkGuess(char guess, String wordToGuess) {
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess) {
                return true;
            }
        }
        return false;
    }

    public static void updatePlaceholders(char[] placeholders, String wordToGuess, char guess) {
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess) {
                placeholders[i] = guess;

            }
        }

    }

    public static void printPlaceholders(char[] placeholders) {
        for (int i = 0; i < placeholders.length; i++) {
            System.out.print(" " + placeholders[i]);
        }
        System.out.print("\n");
    }

    public static void updateMissedLetters(char[] misses) {
        for (int i = 0; i < misses.length; i++) {
            System.out.print(misses[i]);
        }
    }
}

