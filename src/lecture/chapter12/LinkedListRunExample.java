package lecture.chapter12;

public class LinkedListRunExample {

  public static void main(String[] args) {
    LinkedList<String> list = new LinkedList<>();

    list.add("Element 1");
    list.add("Element 2");
    list.add("Element 3");
    list.add("Element 4");
    list.add("Element 5");

    System.out.println("Size of the list: " + list.size());
    System.out.println("Elements in the list:");
    list.printList();

    System.out.println("Removed: " + list.remove("Element 2"));
    System.out.println("After removing Element 2:");
    System.out.println("Size of the list: " + list.size());
    list.printList();

    System.out.println("Removed: " + list.remove("Element 1"));
    System.out.println("After removing Element 1:");
    System.out.println("Size of the list: " + list.size());
    list.printList();
  }
}
