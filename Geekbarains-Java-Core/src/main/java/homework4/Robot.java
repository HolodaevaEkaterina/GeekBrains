package homework4;

public class Robot extends Entity implements Runnable, Jumpuble{

  public Robot(String name) {
    super(name);
  }

  @Override
  public double maxHeightWall() {
    return 3;
  }

  @Override
  public double MaxLengthTrack() {
    return 1000;
  }
}
