package homework4;

public class Track implements Obstacle{

  private final double length;

  public Track(double length) {
    this.length = length;
  }

  public double getLength() {
    return length;
  }

  @Override
  public boolean done(int value) {
    if (value >= getLength())
      return true;
    return false;
  }
}
