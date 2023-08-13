// TASK 1

import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int totalAttempts = 0;
        int totalRounds = 0;

        boolean playAgain = true;

        while (playAgain) {
            int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            boolean roundWon = false;

            System.out.println("Round " + (totalRounds + 1) + ":");

            while (attempts < maxAttempts) {
                System.out.print("Guess the number between " + lowerBound + " and " + upperBound + ": ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < secretNumber) {
                    System.out.println("Too low!");
                } else if (userGuess > secretNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the number " + secretNumber + " in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    totalRounds++;
                    roundWon = true;
                    break;
                }
            }

            if (!roundWon) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The secret number was " + secretNumber + ".");
                totalRounds++;
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainStr = scanner.next().toLowerCase();
            playAgain = playAgainStr.equals("yes");
        }

        double averageAttempts = totalAttempts / (double) totalRounds;
        System.out.println("Thanks for playing! You completed " + totalRounds + " rounds.");
        System.out.printf("Your average attempts per round: %.2f%n", averageAttempts);

        scanner.close();
    }
}
