package homework4;

public class Fish extends Entity implements Swimmable{
  public Fish(String name) {
    super(name);
  }

  @Override
  public double maxLengthPool() {
    return 1000;
  }
}
