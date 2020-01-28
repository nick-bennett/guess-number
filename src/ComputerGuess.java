import java.util.Scanner;

public class ComputerGuess {

  private static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    boolean playAgain;
    do {
      play();
      System.out.println("Would you like to play again? (y/n)");
      input.skip("\\s+");
      String playAgainInput = input.nextLine().toLowerCase();
      playAgain = playAgainInput.charAt(0) == 'y';
    } while (playAgain);
    System.out.println("Game over!");
  }

  public static void play() {
    int low = 1;
    int high = 100;
    boolean correct = false;
    System.out.println(
        "Think of a number from 1 to 100 (inclusive). Press <Enter> when you're ready for the computer to try to guess your number.");
    input.nextLine();
    do {
      int guess = (low + high) / 2;
      System.out.println("The computer guesses " + guess
          + ". Enter 0 if the guess is correct, 1 if the guess is low, and -1 if the guess is high.");
      int sign = input.nextInt();
      if (sign == 0) {
        correct = true;
        System.out.println("The computer correctly guessed your secret number, " + guess + ".");
      } else if (sign < 0) {
        high = guess - 1;
      } else {
        low = guess + 1;
      }
    } while (!correct);
  }

}
