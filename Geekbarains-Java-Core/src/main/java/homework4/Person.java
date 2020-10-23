package homework4;

public class Person extends Entity implements Swimmable, Runnable, Jumpuble{

  public Person(String name) {
    super(name);
  }

  @Override
  public double maxLengthPool() {
    return 100;
  }

  @Override
  public double maxHeightWall() {
    return 2;
  }

  @Override
  public double MaxLengthTrack() {
    return 500;
  }
}
