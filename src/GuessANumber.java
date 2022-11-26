import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class GuessANumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random randomNumber = new Random();
        int countWins = 0;
        boolean continueGame = true;
        while (continueGame) {
            System.out.println("WELCOME TO GUESS A NUMBER GAME");
            System.out.println("You can choose difficulty EASY, MEDIUM, HARD");
            String difficulty = scanner.nextLine().toLowerCase(Locale.ROOT);
            int n = 0;  // max number
            int g = 0; //games

            while (n == 0) {
                switch (difficulty) {
                    case "easy":
                        n = 11;
                        g = 5;
                        break;
                    case "medium":
                        n = 51;
                        g = 10;
                        break;
                    case "hard":
                        n = 101;
                        g = 15;
                        break;
                    default:
                        System.out.println("You should choose from: EASY, MEDIUM and HARD to start the game");
                        difficulty = scanner.nextLine().toLowerCase(Locale.ROOT);

                }

            }
            System.out.println("Good Job!");
            System.out.printf("Now you need to guess a number between 1 an %d.%n", (n - 1));
            System.out.printf("You have %d attempts to guess.%n", g);
            int computerNumber = randomNumber.nextInt(n);

            int numberOfTries = 0;
            while (numberOfTries < g) {

                System.out.printf("Guess a number (0-%d): ", n - 1);
                String playerInput = scanner.nextLine();
                numberOfTries++;
                int playerNumber;
                boolean isValid = true;
                for (int i = 0; i < playerInput.length(); i++) {
                    if (playerInput.charAt(i) < 48 || playerInput.charAt(i) > 57) {
                        isValid = false;
                        break;
                    }
                }

                if (isValid) {
                    playerNumber = Integer.parseInt(playerInput);
                    if (playerNumber == computerNumber) {
                        System.out.println("You guessed it!");
                        countWins++;
                        numberOfTries = 0;
                        System.out.printf("You have guessed %d times.%n", countWins);
                        break;
                    } else if (playerNumber > computerNumber) {
                        RandomMassage.tooHigh();
                    } else {
                        RandomMassage.tooLow();
                    }
                } else {
                    System.out.println("Invalid input!");
                }
            }
            if (numberOfTries >= g) {
                System.out.println("You lose!");
                countWins = 0;
            }

            System.out.println("Do you want to continue: write [y]es");
            String toContinueGame = scanner.nextLine().toLowerCase(Locale.ROOT);
            if (!toContinueGame.equals("y")) {
                continueGame = false;

            }
        }
    }
}