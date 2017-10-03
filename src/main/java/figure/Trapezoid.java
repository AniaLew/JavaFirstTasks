package figure;

public class Trapezoid implements FigureArea, FigurePerimeter {

  private final double base1;
  private final double base2;
  private final double leg;

  private final double height;

  public Trapezoid(double base1, double base2, double height) {
    validateParameters(base1, base2, height);
    this.base1 = base1;
    this.base2 = base2;
    this.leg = Math.sqrt(Math.pow(Math.abs(base1 - base2) / 2, 2) + Math.pow(height, 2));
    this.height = height;
  }

  public double getBase1() {
    return base1;
  }

  public double getBase2() {
    return base2;
  }

  public double getHeight() {
    return height;
  }

  public double getLeg() {
    return leg;
  }


  private void validateParameters
      (double base1, double base2, double height) {
    if ((base1 < 0.0) || (base2 < 0.0) || (height < 0.0)) {
      throw new WrongFigureParametersException();
    }
  }

  @Override
  public double calculateArea() {
    return (height * (base1 + base2) / 2);
  }

  @Override
  public double calculatePerimeter() {
    return base1 + base2 + 2 * leg;
  }

}

