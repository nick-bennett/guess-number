package edu.cnm.deepdive;

import java.util.Random;
import java.util.Scanner;

public class HumanGuess {

  private static Random random = new Random();
  private static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    boolean playAgain;
    do {
      play();
      System.out.println("Play again? (y/n)");
      input.skip("\\s+");
      String playAgainInput = input.nextLine().toLowerCase();
      playAgain = playAgainInput.charAt(0) == 'y';
    } while (playAgain);
    System.out.println("Game over!");
  }

  public static void play() {
    boolean correct = false;
    int secret = 1 + random.nextInt(100);
    System.out.println("Type a number from 1 to 100.");
    do {
      int guess = input.nextInt();
      if (guess == secret) {
        correct = true;
        System.out.println("Good job! The secret number was " + secret);
      } else if (guess < secret) {
        System.out.println("Too low! Guess a higher number!");
      } else {
        System.out.println("Too high! Guess a lower number!");
      }
    } while (!correct);
  }

}
