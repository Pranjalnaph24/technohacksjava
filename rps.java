import java.util.Random;
import java.util.Scanner;

public class rps {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            
            String[] rps = {"Rock", "Paper", "Scissors"};
            String computerMove;
            String userMove;
            
            while (true) {
                // Computer's move
                computerMove = rps[random.nextInt(3)];
                
                // User's move
                System.out.println("Enter move (Rock, Paper, Scissors). To exit the game, type \"exit\": ");
                userMove = scanner.nextLine();
                
                if (userMove.equalsIgnoreCase("exit")) {
                    break;
                }
                
                if (!userMove.equalsIgnoreCase("Rock") && !userMove.equalsIgnoreCase("Paper") && !userMove.equalsIgnoreCase("Scissors")) {
                    System.out.println("Invalid move, please try again.");
                    continue;
                }
                
                System.out.println("Computer move: " + computerMove);
                
                // Determine the winner
                if (userMove.equalsIgnoreCase(computerMove)) {
                    System.out.println("It's a tie!");
                } else if (userMove.equalsIgnoreCase("Rock")) {
                    if (computerMove.equalsIgnoreCase("Scissors")) {
                        System.out.println("You win!");
                    } else {
                        System.out.println("You lose!");
                    }
                } else if (userMove.equalsIgnoreCase("Paper")) {
                    if (computerMove.equalsIgnoreCase("Rock")) {
                        System.out.println("You win!");
                    } else {
                        System.out.println("You lose!");
                    }
                } else if (userMove.equalsIgnoreCase("Scissors")) {
                    if (computerMove.equalsIgnoreCase("Paper")) {
                        System.out.println("You win!");
                    } else {
                        System.out.println("You lose!");
                    }
                }
            }
        }
    }
}
