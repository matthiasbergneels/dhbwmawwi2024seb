package lecture.chapter9;

import java.util.Objects;

public class Student implements Comparable<Student>{

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


  @Override
  public int compareTo(Student o) {

    if(this.id != o.id){
      return this.id - o.id;
    }

    if(!this.familyName.equalsIgnoreCase(o.familyName)){ // --> Müller != MÜLLER
      return this.familyName.compareToIgnoreCase(o.familyName);
    }

    return this.name.compareToIgnoreCase(o.name);
  }

  public int hashCode(){
    return id ^ familyName.hashCode() ^ name.hashCode();
  }


/*
  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + Objects.hashCode(name);
    result = 31 * result + Objects.hashCode(familyName);
    return result;
  }

 */


  @Override
  public boolean equals(Object o){
    // Alias Vergleich
    if(this == o){
      return true;
    }

    // null Vergleich
    if(o == null){
      return false;
    }

    // Typ Vergleich
    if(!(this.getClass().equals(o.getClass()))){
      return false;
    }

    // Attribut Vergleich
    Student student = (Student)o;

    if(this.id != student.id){
      return false;
    }

    if(this.familyName.equals(student.familyName)){
      return false;
    }

    return this.name.equals(student.name);
  }

  /*
  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;

    Student student = (Student) o;
    return id == student.id && Objects.equals(name, student.name) && Objects.equals(familyName, student.familyName);
  }
   */

  /*
  @Override
  public boolean equals(Object obj) {

    if(obj instanceof Student toCompare){
      return this.compareTo(toCompare) == 0;
    }

    return false;
  }
   */
}
