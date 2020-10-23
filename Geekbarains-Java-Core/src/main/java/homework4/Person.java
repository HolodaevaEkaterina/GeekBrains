package homework4;

public class Person extends Entity {

  public Person(String name) {
    super(name);
  }

  @Override
  public int maxHeight() {
    return 2;
  }

  @Override
  public int maxLength() {
    return 100;
  }
}
