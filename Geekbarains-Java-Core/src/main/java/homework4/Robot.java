package homework4;

public class Robot extends Entity {

  public Robot(String name) {
    super(name);
  }

  @Override
  public int maxHeight() {
    return 5;
  }

  @Override
  public int maxLength() {
    return 150;
  }
}
