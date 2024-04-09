import java.util.*;
 public class RockPaperScissors {
     public static String getUserChoice(Scanner scan, String userName) {
         String userChoice;
         do {
             System.out.print(userName + " Enter Rock or Paper or Scissors (or type 'exit' to quit): ");
             userChoice = scan.nextLine().toLowerCase();
             if(!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors") && !userChoice.equals(
                     "exit"
             )) {
                 System.out.println("Invalid Choice. Try again!");
             }
         } while(!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors") && !userChoice.equals("exit"));
         return userChoice;
     }

     public static String getComputerChoice() {
         String[] choices = {"rock", "paper", "scissors"};
         Random random = new Random();
         return choices[random.nextInt(choices.length)];
     }

     public static String determineWinner(String userChoice, String opponentChoice, String user1Name, String user2Name) {
         if (userChoice.equals(opponentChoice)) {
             return "It's a tie.";
         } else if ((userChoice.equals("rock") && opponentChoice.equals("scissors")) || (userChoice.equals("paper") && opponentChoice.equals("rock")) || (userChoice.equals("scissors") && opponentChoice.equals("paper"))) {
             return user1Name + " Wins!";
         } else {
             return user2Name + " Wins!";
         }
     }

     public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);
         System.out.print("Enter user1 name: ");
         String user1Name = scan.nextLine();
         String user2Name = "";

         System.out.println("Let's start the game...");

         System.out.println("Enter '1' to play with computer or '2' to play against a friend: ");
         int mode = scan.nextInt();
         scan.nextLine();
         int user1Score = 0;
         int user2Score = 0;
         int computerScore = 0;

         if (mode == 2) {
             System.out.print("Enter user2 name: ");
             user2Name = scan.nextLine();
         }

         while (true) {
             String userChoice;
             String opponentChoice;

             if (mode != 1 && mode != 2) {
                 System.out.println("Invalid mode. Please select '1' or '2'.");
                 break;
             }

             if (mode == 1) {
                 userChoice = getUserChoice(scan, user1Name);
                 if (userChoice.equals("exit")) {
                     break;
                 }
                 opponentChoice = getComputerChoice();
             } else {
                 userChoice = getUserChoice(scan, user1Name);
                 if (userChoice.equals("exit")) {
                     break;
                 }
                 opponentChoice = getUserChoice(scan, user2Name);
                 if (opponentChoice.equals("exit")) {
                     break;
                 }
             }

             if (mode == 1) {
                 System.out.println(user1Name + " Choice: " + userChoice);
                 System.out.println("Computer's Choice: " + opponentChoice);
             } else {
                 System.out.println(user1Name + " Choice: " + userChoice);
                 System.out.println(user2Name + " Choice: " + opponentChoice);
             }

             String result = determineWinner(userChoice, opponentChoice, user1Name, user2Name);
             System.out.println(result);

             if (result.contains(user1Name)) {
                 user1Score++;
             } else if (result.contains(user2Name)) {
                 user2Score++;
             } else {
                 computerScore++;
             }

             if (mode == 1) {
                 System.out.println("Score - " + user1Name + ": " + user1Score + ", Computer: " + computerScore);
             } else {
                 System.out.println("Score - " + user1Name + ": " + user1Score + ", " + user2Name + ": " + user2Score);
             }
         }

         if (mode == 1) {
             System.out.println("Final Score - " + user1Name + ": " + user1Score + ", Computer: " + computerScore);
         } else {
             System.out.println("Final Score - " + user1Name + ": " + user1Score + ", " + user2Name + ": " + user2Score );
         }

         if (mode == 1) {
             System.out.println("See you next time, " + user1Name);
         } else {
             System.out.println("See you next time, " + user1Name + " and " + user2Name);
         }
         System.out.println("Exiting...");
     }
}