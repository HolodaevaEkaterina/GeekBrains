package homework4;

public abstract class Entity {
  private String name;
  private boolean isRunning = true;

  public Entity(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public boolean isRunning() {
    return isRunning;
  }

  public void setRunning(boolean running) {
    isRunning = running;
  }

  public void unSuccess() {
    System.out.println(getName() + " препятствие не прошел");
  }

  public void print() {
    System.out.println(getName());
  }
  public abstract int maxHeight();
  public abstract int maxLength();
}
