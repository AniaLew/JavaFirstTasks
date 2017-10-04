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
public class RectangleTest {

  @Test
  public void shouldReturnRectangle() throws Exception {
    //when
    Rectangle rectangle = new Rectangle(2.0, 4.0);
    //then
    assertNotNull(rectangle);
  }

  @Test
  public void shouldReturnSide1() throws Exception {
    //given
    Double expected = 5.0;
    Rectangle rectangle = new Rectangle(expected, 4.0);
    //when
    Double actual = rectangle.getSide1();
    //then
    assertEquals(expected, actual);
  }

  @Test
  public void shouldReturnSide2() throws Exception {
    //given
    Double expected = 5.0;
    Rectangle rectangle = new Rectangle(4.0, expected);
    //when
    Double actual = rectangle.getSide2();
    //then
    assertEquals(expected, actual);
  }

  @Test
  @Parameters(method = "getParametersForRectangleArea")
  public void shouldReturnAreaForRectangle(List<Double> parameters, Double expected)
      throws Exception {

    //when
    Double actual = new Rectangle(parameters.get(0), parameters.get(1)).calculateArea();
    //then
    assertEquals(expected, actual, 0.001);
  }

  private Object getParametersForRectangleArea() {
    return new Object[]{
        new Object[]{Arrays.asList(0.0, 0.0), 0.0},
        new Object[]{Arrays.asList(6.0, 4.0), 24.0},
        new Object[]{Arrays.asList(3.0, 5.0), 15.0},
        new Object[]{Arrays.asList(10.0, 12.5), 125.0},
    };
  }

  @Test
  @Parameters(method = "getParametersForRectanglePerimeter")
  public void shouldReturnPerimeterForRectangle(List<Double> parameters, Double expected)
      throws Exception {
    //when
    Double actual = new Rectangle(parameters.get(0), parameters.get(1)).calculatePerimeter();
    //then
    assertEquals(expected, actual, 0.001);
  }

  private Object getParametersForRectanglePerimeter() {
    return new Object[]{
        new Object[]{Arrays.asList(0.0, 0.0), 0.0},
        new Object[]{Arrays.asList(6.0, 4.0), 20.0},
        new Object[]{Arrays.asList(3.0, 5.0), 16.0},
        new Object[]{Arrays.asList(10.0, 12.5), 45.0},
    };
  }

  @Test(expected = WrongFigureParametersException.class)
  @Parameters(method = "getWrongParametersForRectangle")
  public void shouldThrowWrongFigureParametersWhenNegativeParameter(List<Double> parameters)
      throws Exception {
    //when
    new Rectangle(parameters.get(0), parameters.get(1));
    //then
    fail("Should throw WrongFigureParametersException.");
  }

  private Object getWrongParametersForRectangle() {
    return new Object[]{
        new Object[]{Arrays.asList(-1.0, 1.0)},
        new Object[]{Arrays.asList(1.0, -1.0)},
    };
  }

}