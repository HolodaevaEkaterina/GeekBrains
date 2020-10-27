package homework7;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

  private final List<T> fruits;
  private final T obj;

  public Box(ArrayList<T> fruits, T obj) {
    this.fruits = fruits;
    this.obj = obj;
  }

  public double getWeight() {
    return obj.getWeight() * fruits.size();
  }

  public List<T> getFruits() {
    return fruits;
  }

  public boolean compare(Box<?> box) {
    return getWeight() == box.getWeight();
  }

  public void pushAllFruitsTo(Box<? super T> to) {
    to.getFruits().addAll(getFruits());
    fruits.clear();
  }

  public void addFruit(T fruit) {
    fruits.add(fruit);
  }

  public static void main(String[] args) {
    Box<Apple> appleBox = new Box<>(new ArrayList<>(List.of(new Apple(), new Apple())), new Apple());
    Box<Apple> appleBox1 = new Box<>(new ArrayList<>(List.of(new Apple(), new Apple(), new Apple())), new Apple());
    Box<Orange> orangeBox = new Box<>(new ArrayList<>(List.of(new Orange(), new Orange())), new Orange());

    System.out.println(appleBox.getWeight());
    System.out.println(orangeBox.getWeight());
    System.out.println(appleBox.compare(orangeBox));
    System.out.println(appleBox1.compare(orangeBox));
    appleBox.pushAllFruitsTo(appleBox1);
    System.out.println(appleBox1.getWeight());
    appleBox.addFruit(new Apple());
    System.out.println(appleBox.getWeight());
  }
}
