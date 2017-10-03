package figure;

public class Circle implements FigureArea, FigurePerimeter {

  private final double radius;

  public Circle(double radius) {
    validateParameters(radius);
    this.radius = radius;
  }

  public double getRadius() {
    return radius;
  }

  private void validateParameters(double parameter) {
    if (parameter < 0.0) {
      throw new WrongFigureParametersException();
    }
  }

  @Override
  public double calculateArea() {
    return Math.PI * Math.pow(radius, 2);
  }

  @Override
  public double calculatePerimeter() {
    return 2 * Math.PI * radius;
  }
}