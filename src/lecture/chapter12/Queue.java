package lecture.chapter12;

public class Queue<D> {

  private Node headNode;
  private Node tailNode;
  private int size = 0;

  public void enqueue(D data) {
    Node newNode = new Node(data);

    if(isEmpty()){
      // empty queue
      headNode = newNode;
    } else {
      tailNode.setPrevNode(newNode);
    }

    size++;
    tailNode = newNode;
  }

  public D dequeue(){
    if (isEmpty()) {
      return null;
    }

    D data = headNode.getData();
    if(headNode == tailNode){
      headNode = null;
      tailNode = null;
    } else {
      // more than one element in the queue
      headNode = headNode.getPrevNode();
    }

    size--;
    return data;
  }

  public boolean isEmpty() {
    return headNode == null && tailNode == null;
  }

  public int size() {
    return size;
  }

  class Node {
    private D data;
    private Node prevNode;

    Node(D data) {
      this.data = data;
    }

    public D getData() {
      return data;
    }

    public Node getPrevNode() {
      return prevNode;
    }

    public void setPrevNode(Node prevNode) {
      this.prevNode = prevNode;
    }

  }
}
