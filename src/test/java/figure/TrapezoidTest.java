package figure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

@RunWith(JUnitParamsRunner.class)
public class TrapezoidTest {

  @Test
  public void shouldReturnTrapezoid() throws Exception {
    //when
    Trapezoid trapezoid = new Trapezoid(2.0, 4.0, 3.0);
    //then
    assertNotNull(trapezoid);
  }

  @Test
  public void shouldReturnBase1() throws Exception {
    //given
    Double expected = 5.0;
    Trapezoid trapezoid = new Trapezoid(expected, 4.0, 3.0);
    //when
    Double actual = trapezoid.getBase1();
    //then
    assertEquals(expected, actual);
  }

  @Test
  public void shouldReturnBase2() throws Exception {
    //given
    Double expected = 4.0;
    Trapezoid trapezoid = new Trapezoid(5.0, expected, 3.0);
    //when
    Double actual = trapezoid.getBase2();
    //then
    assertEquals(expected, actual);
  }

  @Test
  public void shouldReturnHeight() throws Exception {
    //given
    Double expected = 3.0;
    Trapezoid trapezoid = new Trapezoid(5.0, 4.0, expected);
    //when
    Double actual = trapezoid.getHeight();
    //then
    assertEquals(expected, actual);
  }

  @Test
  public void shouldReturnLeg() throws Exception {
    //given
    Double expected = 3.0 * Math.sqrt(2);
    Trapezoid trapezoid = new Trapezoid(10.0, 4.0, 3.0);
    //when
    Double actual = trapezoid.getLeg();
    //then
    assertEquals(expected, actual, 0.00001);
  }

  @Test
  @Parameters(method = "getParametersForTrapezoidArea")
  public void shouldReturnAreaForTrapezoid(List<Double> parameters, Double expected)
      throws Exception {

    //when
    Double actual = new Trapezoid
        (parameters.get(0), parameters.get(1), parameters.get(2))
        .calculateArea();
    //then
    assertEquals(expected, actual, 0.001);
  }

  private Object getParametersForTrapezoidArea() {
    return new Object[]{
        new Object[]{Arrays.asList(0.0, 0.0, 0.0), 0.0},
        new Object[]{Arrays.asList(6.0, 4.0, 4.0), 20.0},
        new Object[]{Arrays.asList(3.0, 5.0, 1.0), 4.0},
        new Object[]{Arrays.asList(10.5, 12.5, 1.0), 11.5},
    };
  }

  @Test
  @Parameters(method = "getParametersForTrapezoidPerimeter")
  public void shouldReturnPerimeterForTrapezoid(List<Double> parameters, Double expected)
      throws Exception {
    //when
    Double actual = new Trapezoid(parameters.get(0), parameters.get(1), parameters.get(2))
        .calculatePerimeter();
    //then
    assertEquals(expected, actual, 0.001);
  }

  private Object getParametersForTrapezoidPerimeter() {
    return new Object[]{
        new Object[]{Arrays.asList(0.0, 0.0, 0.0), 0.0},
        new Object[]{Arrays.asList(6.0, 4.0, 2.0), 2 * Math.sqrt(5) + 10.0},
        new Object[]{Arrays.asList(8.0, 4.0, 2.0), 2 * Math.sqrt(8) + 12.0},
        new Object[]{Arrays.asList(10.0, 12.0, 4.0), 2 * Math.sqrt(17) + 22},
    };
  }

  @Test(expected = WrongFigureParametersException.class)
  @Parameters(method = "getWrongParametersForTrapezoid")
  public void shouldThrowWrongFigureParametersWhenNegativeParameter(List<Double> parameters)
      throws Exception {
    //when
    new Trapezoid(parameters.get(0), parameters.get(1), parameters.get(2));
    //then
    fail("Should throw WrongFigureParametersException.");
  }

  private Object getWrongParametersForTrapezoid() {
    return new Object[]{
        new Object[]{Arrays.asList(-1.0, 1.0, 1.0)},
        new Object[]{Arrays.asList(1.0, -1.0, 1.0)},
        new Object[]{Arrays.asList(1.0, 1.0, -1.0)},
    };
  }
}