package lecture.chapter9;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetExamples {

  public static void main(String[] args) {

    Set<String> nameList = new TreeSet<String>();

    nameList.add("Gabi");
    nameList.add("Gabi");
    nameList.add("Klaus");
    nameList.add("Monika");
    nameList.add("Daniel");
    nameList.add("Zeus");

    System.out.println("Anzahl Namen: " + nameList.size());

    System.out.println("Namesliste mit For-Each:");
    for(String currentName : nameList) {
      System.out.println(currentName);
    }

    nameList.remove("Zeus");
    nameList.add("Matthias");
    System.out.println("Anzahl Namen: " + nameList.size());

    Iterator<String> nameListIterator = nameList.iterator();
    while (nameListIterator.hasNext()) {
      String currentName = nameListIterator.next();
      System.out.println(currentName);
    }

    Set<Student> studentSet = new HashSet<Student>();
    Student zeus = new Student(9090, "Zeus", "Gott", 233);
    studentSet.add(new Student(4711, "Gabi", "Müller", 21));
    studentSet.add(new Student(5800, "Monika", "Schmidt", 23));
    studentSet.add(new Student(5101, "Monika", "Schmidt", 23));
    studentSet.add(zeus);
    studentSet.add(new Student(1234, "Matthias", "Haus", 25));
    studentSet.add(new Student(1234, "Lukas", "Blau", 19));
    studentSet.add(zeus);


    System.out.println("Anzahl Students: " + studentSet.size());

    for(Student currentStudent : studentSet) {
      System.out.println(currentStudent);
    }

  }
}
