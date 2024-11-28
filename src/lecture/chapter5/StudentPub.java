package lecture.chapter5;

public class StudentPub {

  public static void main(String[] args) {
    Student klaus = new Student(4711, "Klaus");
    Student gabi = new Student(4911, "Gabi");

    // Vorlesung --> alle trinken Wasser
    klaus.drink(5);
    gabi.drink(2);

    // Programmieren Vorlesung
    klaus.drink(0.5, 40.0f);
    gabi.drink(0.33, 35.0f);

    // Ab in den Pub
    klaus.drink(0.5, 4);
    gabi.drink(0.33, 8);

  }
}
