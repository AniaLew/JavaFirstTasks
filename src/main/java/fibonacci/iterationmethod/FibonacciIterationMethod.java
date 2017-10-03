package fibonacci.iterationmethod;

import java.util.Scanner;

public class FibonacciIterationMethod {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Program counts n_th number of Fibonacci sequence using iteration method.");
    System.out.print("Give n number: ");
    int n = -1;
    do {
      n = scan.nextInt();
      if ((n < 1) || (n > Integer.MAX_VALUE)) {
        System.out.print("Invalid number. Give n again: ");
      }
    } while ((n < 1) || (n > Integer.MAX_VALUE));
    scan.close();

    System.out.println(n + "th number in Fibonacci sequence equals: " + fibonacci(n));

    System.out.println("Ten first elements of Fibonacci sequence:");
    for (int i = 1; i <= 10; i++) {
      System.out.println("a" + i + " = " + fibonacci(i));
    }
  }

  public static long fibonacci(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("Negative number n");
    }
    if (n > 98) {
      throw new IllegalArgumentException("Too large number n");
    }
    long fibonacciTable[] = new long[n];
    for (int i = 0; i < n; i++) {
      if ((i == 0) || (i == 1)) {
        fibonacciTable[i] = 1;
      } else {
        fibonacciTable[i] = fibonacciTable[i - 1] + fibonacciTable[i - 2];
      }
    }
    return fibonacciTable[n - 1];
  }
}



