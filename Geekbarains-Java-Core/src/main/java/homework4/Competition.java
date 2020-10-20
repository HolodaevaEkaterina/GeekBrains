package homework4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Competition {
  public static void main(String[] args) {
    Obstacle[] obstacles = new Obstacle[]{new Wall(0.1), new Track(10), new Wall(20)};
    Entity[] entities = new Entity[]{new Person("Джек"), new Cat("Мурзик"), new Robot("Робот")};
    List<Entity> winners = passCompetition(entities, obstacles);
    System.out.println("Победители:");
    for(Entity winner : winners) {
      winner.print();
    }
  }
  public static List<Entity> passCompetition(Entity[] entities, Obstacle[] obstacles) {
    for(Entity i : entities) {
      int j = 0;
      while (j < obstacles.length && i.isRunning()) {
        if (obstacles[j] instanceof Wall && !obstacles[j].done(i.maxHeight()) ||
            obstacles[j] instanceof Track && !obstacles[j].done(i.maxLength())) {
          i.setRunning(false);
          i.unSuccess();
        }
        j++;
      }
    }
    return Arrays.stream(entities).filter(Entity::isRunning).collect(Collectors.toList());
  }
}
