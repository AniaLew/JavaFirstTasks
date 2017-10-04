package fibonacci.iterationmethod;

public class FibonacciIterationMethod {

  public static long fibonacci(int n) throws IllegalArgumentException{
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



