import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 5;
        int roundsWon = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("\nI have generated a number between " + minRange + " and " + maxRange + ".");
            System.out.println("You have " + attemptsLimit + " attempts to guess it.");

            int attempts = 0;
            boolean guessedCorrectly = false;
            while (attempts < attemptsLimit && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the correct number: " + generatedNumber);
                    guessedCorrectly = true;
                    roundsWon++;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + generatedNumber);
            }

            System.out.println("Your score: " + roundsWon + " round(s) won.");

            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            playAgain = playAgainResponse.equals("yes");
        }

        System.out.println("Thank you for playing the Number Guessing Game!");
        scanner.close();
    }
}
