package homework4;

public class Pool implements Obstacle{

  private final double length;

  public Pool(double length) {
    this.length = length;
  }

  public double getLength() {
    return length;
  }

  @Override
  public void done(Entity entity) {
    if (entity instanceof Swimmable) {
      Swimmable swimmable = (Swimmable) entity;
      if (swimmable.maxLengthPool() >= getLength()) {
        System.out.println(entity.getName() + " преодолел бассейн");
        return;
      }
    }
    entity.setRunning(false);
    System.out.println(entity.getName() + " не преодолел бассейн");
  }
}
