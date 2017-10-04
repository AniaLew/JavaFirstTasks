package figure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class CircleTest {

  @Test
  public void shouldReturnCircle() throws Exception {
    //when
    Circle circle = new Circle(0);
    //then
    assertNotNull(circle);
  }

  @Test(expected = WrongFigureParametersException.class)
  public void shouldThrowWrongFigureParametersExceptionWhenNegativeRadius() throws Exception {
    //given
    final int radius = -1;
    //when
    new Circle(radius);
    //then
    fail("Should throw WrongFigureParametersException.");
  }

  @Test
  public void shouldReturnRadius() throws Exception {
    //given
    Double expected = 5.0;
    Circle circle = new Circle(expected);
    //when
    Double actual = circle.getRadius();
    //then
    assertEquals(expected, actual);
  }

  @Test
  @Parameters(method = "getParametersForCircleArea")
  public void shouldReturnAreaForCircle(Double parameter, Double expected) throws Exception {
    //when
    Double actual = new Circle(parameter).calculateArea();
    //then
    assertEquals(expected, actual, 0.001);
  }

  private Object getParametersForCircleArea() {
    return new Object[]{
        new Object[]{0.0, 0.0},
        new Object[]{6.0, 113.097},
        new Object[]{3.0, 28.274},
        new Object[]{10.0, 314.159},
    };
  }

  @Test
  @Parameters(method = "getParametersForCirclePerimeter")
  public void shouldReturnPerimeterForCircle(Double parameter, Double expected) throws Exception {
    //when
    Double actual = new Circle(parameter).calculatePerimeter();
    //then
    assertEquals(expected, actual, 0.001);
  }

  private Object getParametersForCirclePerimeter() {
    return new Object[]{
        new Object[]{0.0, 0.0},
        new Object[]{6.0, 37.699},
        new Object[]{3.0, 18.849},
        new Object[]{10.0, 62.831},
    };
  }

}