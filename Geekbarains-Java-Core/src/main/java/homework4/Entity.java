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

  public void unSuccess(String name) {
    System.out.println(getName() + " не преодолел препятствие " + name);
  }

  public void print() {
    System.out.println(getName());
  }
}
