package homework3;

public class Group {
  private String Name;
  private Employee[] members = new Employee[3];

  public static void main(String[] args) {
    Group group = new Group();
    group.AddEmployee(new Employee("1","2","3","3"));
    group.AddEmployee(new Employee("2","2","3","3"));
    group.AddEmployee(new Employee("3","2","3","3"));
    group.PrintAll();
    group.DeleteEmployee(3);
    group.PrintAll();
    group.DeleteALL();
    group.PrintAll();
  }
  public void AddEmployee(Employee employee) {
    int count = 0;
    for(int i = 0; i < members.length; i++)
      if(members[i] == null) {
        members[i] = employee;
        count++;
        break;
      }
    if(count == 0)
      System.out.println("Мест нет");
  }

  public void DeleteEmployee(int index) {
    String result = "";
    if(index > members.length) {
      result = "В группе всего 10 сотрудников :)";
    }
    for(int i = 0; i < members.length; i++) {
      if (i == (index - 1) && members[i] != null) {
        members[i] = null;
      }
      else if (i == (index - 1) && members[i] == null) {
        result = "Такого сотрудника нет";
      }
    }
    System.out.println(result);
  }

  public void DeleteALL() {
    for(int i = 0; i < members.length; i++) {
      members[i] = null;
    }
  }

  public void PrintAll() {
    int count = 0;
    for(int i = 0; i < members.length; i++)
      if(members[i] != null) {
        members[i].PrintInformation();
        count++;
      }
    if(count == 0)
      System.out.println("Группа пуста");
  }
}
