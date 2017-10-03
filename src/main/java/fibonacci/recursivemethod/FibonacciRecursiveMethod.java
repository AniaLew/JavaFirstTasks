package fibonacci.recursivemethod;

import java.util.Scanner;

public class FibonacciRecursiveMethod {

  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {

    System.out.println("Program counts n_th number of Fibonacci sequence using recursive method.");
    System.out.print("Give a number n: ");
    int n = givenIntNumberValidation();
    System.out.println("n_th number in Fibonacci sequence equals: " + fibonacci(n));

    System.out.println("Ten first elements of Fibonacci sequence:");
    tenFirstElementsOfFibonacciSequence();
  }

  public static int givenIntNumberValidation() {
    int n = -1;
    do {
      n = scan.nextInt();
      if ((n < 1) || (n > Integer.MAX_VALUE)) {
        System.out.print("Invalid number. Give the number again: ");
      }
    } while ((n < 1) || (n > Integer.MAX_VALUE));
    return n;
  }

  public static void tenFirstElementsOfFibonacciSequence() {
    for (int i = 1; i <= 10; i++) {
      System.out.println("a" + i + " = " + fibonacci(i));
    }
  }

  public static long fibonacci(int n) {
    if ((n == 1) || (n == 2)) {
      return 1;
    } else {
      return fibonacci(n - 1) + fibonacci(n - 2);
    }
  }
}



