package homework4;

public class Wall implements Obstacle{

  private final double height;

  public Wall(double height) {
    this.height = height;
  }

  public double getHeight() {
    return height;
  }

  @Override
  public boolean done(int value) {
    return value >= getHeight();
  }
}
