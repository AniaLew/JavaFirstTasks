package fibonacci.recursivemethod;

public class FibonacciRecursiveMethod {

  public static long fibonacci(int n) throws IllegalArgumentException{
    if (n < 0){
      throw new IllegalArgumentException("Number cannot be negative.");
    }
    if (n > 98){
      throw new IllegalArgumentException("Number too large.");
    }
    return n < 2 ? n : fibonacci(n - 1) + fibonacci(n - 2);
  }

}



