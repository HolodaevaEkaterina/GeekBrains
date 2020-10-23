package homework4;

public class Cat extends Entity{

  public Cat(String name) {
    super(name);
  }

  @Override
  public int maxHeight() {
    return 1;
  }

  @Override
  public int maxLength() {
    return 20;
  }
}
