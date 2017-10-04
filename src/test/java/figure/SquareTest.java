package figure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SquareTest {

  @Test
  @Parameters(method = "getParametersForSquareArea")
  public void shouldReturnAreaForSquare(Double parameter, Double expected) throws Exception {
    //when
    Double actual = new Square(parameter).calculateArea();
    //then
    assertEquals(expected, actual, 0.001);
  }

  private Object getParametersForSquareArea() {
    return new Object[]{
        new Object[]{0.0, 0.0},
        new Object[]{6.0, 36.0},
        new Object[]{3.0, 9.0},
        new Object[]{10.0, 100.0},
    };
  }

  @Test
  @Parameters(method = "getParametersForSquarePerimeter")
  public void shouldReturnPerimeterForSquare(Double parameter, Double expected) throws Exception {
    //when
    Double actual = new Square(parameter).calculatePerimeter();
    //then
    assertEquals(expected, actual, 0.001);
  }

  private Object getParametersForSquarePerimeter() {
    return new Object[]{
        new Object[]{0.0, 0.0},
        new Object[]{6.0, 24.0},
        new Object[]{3.0, 12.0},
        new Object[]{10.0, 40.0},
    };
  }

  @Test(expected = WrongFigureParametersException.class)
  public void shouldThrowWrongFigureParametersExceptionWhenNegativeParameter() throws Exception {
    //given
    final int length = -1;
    //when
    new Square(length);
    //then
    fail("Should throw WrongFigureParametersException.");
  }

}