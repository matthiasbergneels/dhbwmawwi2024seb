package lecture.chapter9;

public class Student {

  private int id;
  private String name;
  private String familyName;
  private int age;


  public Student(int id, String name, String familyName, int age) {
    this.id = id;
    this.name = name;
    this.familyName = familyName;
    this.age = age;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFamilyName() {
    return familyName;
  }

  public void setFamilyName(String familyName) {
    this.familyName = familyName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Student{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", familyName='" + familyName + '\'' +
      ", age=" + age +
      '}';
  }
}
