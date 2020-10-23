package homework4;

public class Abyss implements Obstacle{

  private final double length;

  public Abyss(double length) {
    this.length = length;
  }

  public double getLength() {
    return length;
  }

  @Override
  public void done(Entity entity) {
    if (entity instanceof Flyable) {
      Flyable flyable = (Flyable) entity;
      if (flyable.maxLengthAbyss() >= getLength()) {
        System.out.println(entity.getName() + " преодолел пропасть");
        return;
      }
    }
    entity.setRunning(false);
    System.out.println(entity.getName() + " не преодолел пропасть");
  }
}
