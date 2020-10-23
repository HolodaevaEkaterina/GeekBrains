package homework4;

public class Wall implements Obstacle{

  private final double height;

  public Wall(double height) {
    this.height = height;
  }

  public double getHeight() {
    return height;
  }

  @Override
  public void done(Entity entity) {
    if (entity instanceof Jumpuble) {
      Jumpuble jumpuble = (Jumpuble) entity;
      if(jumpuble.maxHeightWall() >= getHeight()) {
        System.out.println(entity.getName() + " преодолел стену");
        return;
      }
    }
    entity.setRunning(false);
    System.out.println(entity.getName() + " не преодолел стену");
  }
}
