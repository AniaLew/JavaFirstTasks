package figure;

public class Triangle implements FigureArea, FigurePerimeter {

  private final double base;
  private final double side;
  private final double height;

  public Triangle(double base, double height) throws WrongFigureParametersException {
    validateParameters(base, height);
    this.base = base;
    this.height = height;
    this.side = Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2));
  }

  public Triangle(double side) throws WrongFigureParametersException {
    if (side < 0) {
      throw new WrongFigureParametersException();
    }
    this.base = side;
    this.side = side;
    this.height = Math.sqrt(3 )*side/2;
  }

  public double getBase() {
    return base;
  }

  public double getSide() {
    return side;
  }

  public double getHeight() {
    return height;
  }

  private void validateParameters(double parameterA, double parameterB)
      throws WrongFigureParametersException {
    if ((parameterA < 0.0) || (parameterB < 0.0)) {
      throw new WrongFigureParametersException();
    }
  }

  @Override
  public double calculateArea() {
    return ((base * height) / 2);
  }

  @Override
  public double calculatePerimeter() {
    if (base == side) {
      return 3 * side;
    }
    return (base + side + height);
  }
}