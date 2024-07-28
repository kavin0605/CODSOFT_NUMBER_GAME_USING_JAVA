package number_game;

import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        boolean playAgain = true;
        int totalAttempts = 0;
        int rounds = 0;
        int score =0;
      
        
        while (playAgain) {
            rounds++;
            int secretNumber = random.nextInt(100) + 1; // Generate random number between 1 and 100
           // System.out.println(secretNumber);
            int attempts = playGame(scanner, secretNumber);
            totalAttempts += attempts;
            if ( attempts ==1) {
            	score +=100;
            }else if  (attempts ==2) {
            	score +=80;
            }else if  (attempts ==3) {
            	score +=60;
            }else if  (attempts ==4) {
            	score +=40;
            }else if  (attempts ==5) {
            	score +=20;
            }
            
            System.out.println("You took " + attempts + " attempts to guess the number.");
            System.out.println("your score is :"+ score);
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            
            if (!playAgainInput.equals("yes")) {
                playAgain = false;
            }
        }
        
        System.out.println("\nGame over! You played " + rounds + " rounds and took " + totalAttempts + " total attempts.");
        System.out.println("Your Total Score is "+ score);
        System.out.println("Thanks for playing!");
        
        scanner.close();
    }
    
    public static int playGame(Scanner scanner, int secretNumber) {
        int attempts = 0;
        boolean guessedCorrectly = false;
        
        while (!guessedCorrectly) {
        	if ( attempts >= 6) {
            	System.out.println("Too many attempts... Failed");
            	return attempts;
            }
        	System.out.println("Guess the number between 1 and 100!");
            System.out.print("Enter your guess: ");
            
            try {
                int guess = scanner.nextInt();
                attempts++;
                
                if (guess < secretNumber ) {
                    System.out.println("Too low! Try again.");
                } else if (guess > secretNumber ) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number " + secretNumber + " correctly!");
                    guessedCorrectly = true;
                }
                
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input from the scanner
            }
            
        }
        
        return attempts;
    }
}
