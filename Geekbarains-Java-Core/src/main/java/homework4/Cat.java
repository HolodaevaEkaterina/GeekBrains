package homework4;

public class Cat extends Entity implements Runnable, Jumpuble{

  public Cat(String name) {
    super(name);
  }

  @Override
  public double maxHeightWall() {
    return 1;
  }

  @Override
  public double MaxLengthTrack() {
    return 100;
  }
}
