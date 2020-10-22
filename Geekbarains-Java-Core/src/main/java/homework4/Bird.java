package homework4;

public class Bird extends Entity implements Flyable{
  public Bird(String name) {
    super(name);
  }

  @Override
  public double maxLengthAbyss() {
    return 500;
  }
}
