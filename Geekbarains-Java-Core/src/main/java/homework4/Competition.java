package homework4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Competition {
  private final  Obstacle[] obstacles;
  private final Entity[] entities;

  public Competition(Obstacle[] obstacles, Entity[] entities)
  {
    this.entities = entities;
    this.obstacles = obstacles;
  }
  public static void main(String[] args) {
    Competition competition = new Competition(
      new Obstacle[]
        { new Wall(0.9),
          new Track(50),
          new Abyss(20),
          new Pool(10)},
      new Entity[]
        { new Person("Джек"),
          new Cat("Мурзик"),
          new Robot("Робот"),
          new Fish("Немо"),
          new Bird("Кеша")});
    List<Entity> winners = competition.passCompetition();
    System.out.println("Победители:");
    for(Entity winner : winners) {
      winner.print();
    }
  }
  public List<Entity> passCompetition() {
    for(Entity i : entities) {
      int j = 0;
      while (j < obstacles.length && i.isRunning()) {
        obstacles[j].done(i);
        j++;
        }
      }
    return Arrays.stream(entities).filter(Entity::isRunning).collect(Collectors.toList());
  }
}
