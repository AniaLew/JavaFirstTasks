package fibonacci.recursivemethod;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class FibonacciRecursiveMethodTest {

  FibonacciRecursiveMethod fibonacciRecursiveMethod = new FibonacciRecursiveMethod();

  @Test
  public void shouldReturnFibonacciNumber() {
    //given
    int sequenceElement = 6;
    //when
    long result = fibonacciRecursiveMethod.fibonacci(sequenceElement);
    //then
    assertEquals(8, result);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldThrowExceptionWhenNegativeSequenceElement() {
    //given
    int sequenceElement = -1;
    //when
    long result = fibonacciRecursiveMethod.fibonacci(sequenceElement);
    //then
    fail("Negative number n. Expected negative element for seqenceElement");
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldThrowExceptionWhenTooLargeSequenceElement() {
    //given
    int sequenceElement = 99;
    //when
    long result = fibonacciRecursiveMethod.fibonacci(sequenceElement);
    //then
    fail("Too large number n.");
  }

  @Test
  public void shouldReturnTimeDifferenceInCountingFibonacciForTwoNumbersInNanoSecond() {
    //when
    long timeAtStart = System.nanoTime();
    fibonacciRecursiveMethod.fibonacci(1);
    long timeAtEnd = System.nanoTime();
    long diffrenceTime1 = timeAtEnd - timeAtStart;
    timeAtStart = System.nanoTime();
    fibonacciRecursiveMethod.fibonacci(2);
    timeAtEnd = System.nanoTime();
    long diffrenceTime2 = timeAtEnd - timeAtStart;

    //then
    compareTimesOfCountingFibonacci(diffrenceTime1, diffrenceTime2);
  }

  private void compareTimesOfCountingFibonacci(long firstTime, long secondTime) {
    if (firstTime > secondTime) {
      System.out.println("fibonacci(1) was counted faster: " + (firstTime - secondTime));
    }
    if (firstTime < secondTime) {
      System.out.println("fibonacci(2) was counted faster: " + (secondTime - firstTime));
    }
    if (firstTime == secondTime) {
      System.out.println("Counting fibonacci(1) and fibonacci(2) took the same amount of time");
    }
  }
}


