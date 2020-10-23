package homework4;

public class Track implements Obstacle{

  private final double length;

  public Track(double length) {
    this.length = length;
  }

  public double getLength() {
    return length;
  }

  @Override
  public void done(Entity entity) {
    if (entity instanceof Runnable) {
      Runnable runnable = (Runnable) entity;
      if (runnable.MaxLengthTrack() >= getLength()) {
        System.out.println(entity.getName() + " преодолел беговую дорожку");
        return;
      }
    }
    entity.setRunning(false);
    System.out.println(entity.getName() + " не преодолел беговую дорожку");
  }
}
