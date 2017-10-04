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
public class TriangleTest {

  @Test
  public void shouldReturnTriangle() {
    //when
    Triangle triangle = new Triangle(4, 5);
    //then
    assertNotNull(triangle);
  }

  @Test
  public void shouldReturnTriangleWithOneParameter() {
    //when
    Triangle triangle = new Triangle(4);
    //then
    assertNotNull(triangle);
  }

  @Test
  public void shouldReturnBase() {
    //given
    Double expected = 4.0;
    Triangle triangle = new Triangle(expected, 5);
    //when
    Double actual = triangle.getBase();
    //then
    assertEquals(expected, actual);
  }

  @Test
  public void shouldReturnHeight() {
    //given
    Double expected = 5.0;
    Triangle triangle = new Triangle(4.0, expected);
    //when
    Double actual = triangle.getHeight();
    //then
    assertEquals(expected, actual);
  }

  @Test
  public void shouldReturnSide() {
    //given
    Double expected = Math.sqrt(41);
    Triangle triangle = new Triangle(4.0, 5.0);
    //when
    Double actual = triangle.getSide();
    //then
    assertEquals(expected, actual);
  }


  @Test
  @Parameters(method = "getParametersForTriangleArea")
  public void shouldReturnAreaForTriangle(List<Double> parameters, Double expected)
      throws Exception {
    //when
    Double actual = new Triangle(parameters.get(0), parameters.get(1)).calculateArea();
    //then
    assertEquals(expected, actual, 0.001);
  }

  private Object getParametersForTriangleArea() {
    return new Object[]{
        new Object[]{Arrays.asList(0.0, 0.0), 0.0},
        new Object[]{Arrays.asList(6.0, 4.0), 12.0},
        new Object[]{Arrays.asList(3.0, 5.0), 7.5},
        new Object[]{Arrays.asList(10.0, 10.0), 50.0},
        new Object[]{Arrays.asList(5.5, 7.5), 20.625}
    };
  }

  @Test
  @Parameters(method = "getParametersForTrianglePerimeter")
  public void shouldReturnPerimeterForTriangle(List<Double> parameters, Double expected)
      throws Exception {
    //when
    double actual = new Triangle(parameters.get(0), parameters.get(1)).calculatePerimeter();
    //then
    assertEquals(expected, actual, 0.001);
  }

  private Object getParametersForTrianglePerimeter() {
    return new Object[]{
        new Object[]{Arrays.asList(0.0, 0.0), 0.0},
        new Object[]{Arrays.asList(6.0, 4.0), 17.211},
        new Object[]{Arrays.asList(3.0, 5.0), 13.830},
        new Object[]{Arrays.asList(10.0, 10.0), 34.142},
    };
  }

  @Test(expected = WrongFigureParametersException.class)
  @Parameters(method = "getNegativeParametersForTriangle")
  public void shouldThrowWrongFigureParametersExceptionIfNegativeParameters(List<Double> parameters)
      throws Exception {
    //when
    new Triangle(parameters.get(0), parameters.get(1));
    //then
    fail("Should throw WrongFigureParametersException.");
  }

  private Object getNegativeParametersForTriangle() {
    return new Object[]{
        new Object[]{Arrays.asList(-1.0, 2.0)},
        new Object[]{Arrays.asList(1.0, -1.0)},
    };
  }

  @Test(expected = WrongFigureParametersException.class)

  public void shouldThrowWrongFigureParametersExceptionIfNegativeParameter() throws Exception {
    //when
    new Triangle(-1);
    //then
    fail("Should throw WrongFigureParametersException.");
  }

}