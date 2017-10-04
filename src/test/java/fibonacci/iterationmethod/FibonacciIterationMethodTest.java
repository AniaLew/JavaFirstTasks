package fibonacci.iterationmethod;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class FibonacciIterationMethodTest {

    FibonacciIterationMethod fibonacciIterationMethod = new FibonacciIterationMethod();

  @Test
  public void shouldReturnFibonacciNumber() {
    //given
    int sequenceElement = 6;
    //when
    long result = fibonacciIterationMethod.fibonacci(sequenceElement);
    //then
    assertEquals(8, result);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldThrowExceptionWhenNegativeSequenceElement() {
    //given
    int sequenceElement = -1;
    //when
    long result = fibonacciIterationMethod.fibonacci(sequenceElement);
    //then
    fail("Negative number n. Expected negative element for seqenceElement");
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldThrowExceptionWhenTooLargeSequenceElement() {
    //given
    int sequenceElement = 99;
    //when
    long result = fibonacciIterationMethod.fibonacci(sequenceElement);
    //then
    fail("Too large number n.");
  }

  @Test
  public void shouldReturnTimeOfCountingFibonacci() {
    long timeAtStart = System.nanoTime();
    fibonacciIterationMethod.fibonacci(9);
    long timeAtEnd = System.nanoTime();
    long diffrenceTime = timeAtEnd - timeAtStart;
    System.out.println("Time span between starting and finishing the method: " + diffrenceTime);
  }
}
