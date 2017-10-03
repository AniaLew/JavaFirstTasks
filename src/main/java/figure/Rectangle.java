package figure;

public class Rectangle implements FigureArea, FigurePerimeter {

  private final double side1;
  private final double side2;


  public Rectangle(double side1, double side2) {
    validateParameters(side1, side2);
    this.side1 = side1;
    this.side2 = side2;
  }

  public double getSide1() {
    return side1;
  }

  public double getSide2() {
    return side2;
  }

  private void validateParameters(double side1, double side2) {
    if ((side1 < 0.0) || (side2 < 0.0)) {
      throw new WrongFigureParametersException();
    }
  }

  @Override
  public double calculateArea() {
    return side1 * side2;
  }

  @Override
  public double calculatePerimeter() {
    return 2 * (side1 + side2);
  }
}
