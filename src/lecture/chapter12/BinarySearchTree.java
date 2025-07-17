package lecture.chapter12;

public class BinarySearchTree<D extends Comparable<D>> {

  private Node root;
  private int size = 0;

  public boolean add(D data){
    if(root == null){
      root = new Node(data);
      size++;
      return true;
    }

    return add(data, root);
  }

  private boolean add(D data, Node currentNode) {

    return false;
  }


  class Node{
    private D data;
    private Node leftChild;
    private Node rightChild;

    public Node(D data) {
      this.data = data;
    }

    public D getData() {
      return data;
    }

    public Node getLeftChild() {
      return leftChild;
    }

    public void setLeftChild(Node leftChild) {
      this.leftChild = leftChild;
    }

    public Node getRightChild() {
      return rightChild;
    }

    public void setRightChild(Node rightChild) {
      this.rightChild = rightChild;
    }
  }

}
