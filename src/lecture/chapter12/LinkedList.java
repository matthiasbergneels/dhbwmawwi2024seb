package lecture.chapter12;

public class LinkedList<D> {

  private Node firstNode;
  private Node lastNode;

  public void add(D data) {
    Node newNode = new Node(data);

    if (firstNode == null) {
      firstNode = newNode;
      lastNode = newNode;
    } else {
      lastNode.setNext(newNode);
      lastNode = newNode;
    }
  }

  // TODO: Implement remove, size and printList methods


  private class Node {
    private D data;
    private Node next;

    public Node(D data) {
      this.data = data;
      this.next = null;
    }

    public D getData() {
      return data;
    }

    public Node getNext() {
      return next;
    }

    public void setNext(Node next) {
      this.next = next;
    }
  }

}
