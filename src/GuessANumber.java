import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class GuessANumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random randomNumber = new Random();
        System.out.println("WELCOME TO GUESS A NUMBER GAME");
        System.out.println("You can choose difficulty EASY, MEDIUM, HARD");
        String difficulty = scanner.nextLine().toLowerCase(Locale.ROOT);
        int n = 0;
        while (n == 0) {
            switch (difficulty) {
                case "easy":
                    n = 11;
                    break;
                case "medium":
                    n = 51;
                    break;
                case "hard":
                    n = 101;
                    break;
                default:
                    System.out.println("You should choose from: EASY, MEDIUM and HARD to start the game");
                    difficulty = scanner.nextLine().toLowerCase(Locale.ROOT);

            }

        }
        System.out.println("Good Job!");
        System.out.printf("Now you need to guess a number between 1 an %d.%n", (n - 1));
        int computerNumber = randomNumber.nextInt(n);
        int countWins  = 0;
        while (true) {
            System.out.printf("Guess a number (0-%d): ", n - 1);
            String playerInput = scanner.nextLine();
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
                    System.out.printf("You have guessed %d times.%n",countWins);
                    System.out.println("Do you want to continue: write [y]es");
                    String continueGame = scanner.nextLine();
                    if (continueGame.equals("y")){
                        computerNumber = randomNumber.nextInt(n);
                    }else {
                        break;

                    }
                } else if (playerNumber > computerNumber) {
                    RandomMassage.tooHigh();
                } else {
                    RandomMassage.tooLow();
                }
            } else {
                System.out.println("Invalid input!");
            }
        }
    }
}