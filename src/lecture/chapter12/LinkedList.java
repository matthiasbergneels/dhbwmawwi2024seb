package lecture.chapter12;

public class LinkedList<D> {

  private Node firstNode;
  private Node lastNode;

  private int count = 0;

  public void add(D data) {
    Node newNode = new Node(data);
    count++;

    if (firstNode == null) {
      firstNode = newNode;
      lastNode = newNode;
    } else {
      lastNode.setNext(newNode);
      lastNode = newNode;
    }
  }

  public D remove(D data) {
    if (firstNode == null) {
      return null;
    }

    if (firstNode.getData().equals(data)) {
      D removedData = firstNode.getData();
      count--;
      firstNode = firstNode.getNext();
      if (firstNode == null){
        lastNode = null;
      }
      return removedData;
    }

    Node currentNode = firstNode;
    while (currentNode.getNext() != null) {
      if (currentNode.getNext().getData().equals(data)) {
        D removedData = currentNode.getNext().getData();
        count--;
        if (currentNode.getNext() == lastNode) {
          lastNode = currentNode;
        }
        currentNode.setNext(currentNode.getNext().getNext());
        return removedData;
      }
      currentNode = currentNode.getNext();
    }
    return null;
  }

  public int size() {
    /*
    int count = 0;
    Node current = firstNode;
    while (current != null) {
      count++;
      current = current.getNext();
    }
    return count;
     */
    return count;
  }

  public void printList() {
    Node current = firstNode;
    while (current != null) {
      System.out.println(current.getData());
      current = current.getNext();
    }
  }


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
