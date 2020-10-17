package homework3;

public class Employee {
  private String name;
  private String email;
  private String age;
  private String position;

  public Employee(String name, String email, String age, String position) {
    this.name =  name;
    this.email = email;
    this.age = age;
    this.position = position;
  }

  public void PrintInformation() {
    System.out.printf("Name:%s%nEmail:%s%nAge:%s%nPosition:%s%n%n", name, email, age, position);
  }
}
