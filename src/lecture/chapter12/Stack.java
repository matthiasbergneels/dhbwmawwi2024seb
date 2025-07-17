package lecture.chapter12;

public class Stack<D> {

  private Node topNode;
  private int count = 0;

  public void push(D data) {
    Node newNode = new Node(data, topNode);
    topNode = newNode;
    count++;
  }

  public D pop() {
    if (topNode == null) {
      return null; // Stack is empty
    }
    D data = topNode.getData();
    topNode = topNode.getNext();
    count--;
    return data;
  }

  public D peek() {
    if (topNode == null) {
      return null; // Stack is empty
    }
    return topNode.getData();
  }

  public boolean isEmpty() {
    return count == 0;
  }

  public int size() {
    return count;
  }


  private class Node{
    private D data;
    private Node next;

    public Node(D data, Node next) {
      this.data = data;
      this.next = next;
    }

    public D getData() {
      return data;
    }

    public Node getNext() {
      return next;
    }
  }
}
