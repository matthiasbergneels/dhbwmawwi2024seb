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

    if(currentNode.getData().compareTo(data) > 0){
      // data is smaller than currentNode's data
      if(currentNode.getLeftChild() == null){
        currentNode.setLeftChild(new Node(data));
        size++;
        return true;
      } else {
        return add(data, currentNode.getLeftChild());
      }
    } else if(currentNode.getData().compareTo(data) < 0){
      // data is greater than currentNode's data
      if(currentNode.getRightChild() == null){
        currentNode.setRightChild(new Node(data));
        size++;
        return true;
      } else {
        return add(data, currentNode.getRightChild());
      }
    }

    return false;
  }

  public boolean contains(D data) {
    if (root == null) {
      return false; // Tree is empty
    }
    return contains(data, root);
  }
  private boolean contains(D data, Node currentNode) {
    if (currentNode == null) {
      return false; // Reached a leaf node
    }

    int comparison = currentNode.getData().compareTo(data);
    if (comparison > 0) {
      return contains(data, currentNode.getLeftChild());
    } else if (comparison < 0) {
      return contains(data, currentNode.getRightChild());
    } else {
      return true; // Found
    }
  }

  public int getSize() {
    return size;
  }

  public boolean isEmpty() {
    return root == null;
  }

  public void printTree() {
    if (root != null) {
      printInOrder(root);
    } else {
      System.out.println("The tree is empty.");
    }
  }

  // Print the tree in different orders
  public void printPreOrder(){
    if (root != null) {
      printPreOrder(root);
    } else {
      System.out.println("The tree is empty.");
    }
  }

  public void printPostOrder(){
    if (root != null) {
      printPostOrder(root);
    } else {
      System.out.println("The tree is empty.");
    }
  }

  // In-order traversal (Ascending) (Left, current, Right)
  private void printInOrder(Node currentNode){
    if(currentNode.getLeftChild() != null){
      printInOrder(currentNode.getLeftChild());
    }
    System.out.println(currentNode.getData());

    if(currentNode.getRightChild() != null){
      printInOrder(currentNode.getRightChild());
    }
  }

  // Pre-order traversal (current, Left, Right)
  private void printPreOrder(Node currentNode){
    System.out.println(currentNode.getData());

    if(currentNode.getLeftChild() != null){
      printInOrder(currentNode.getLeftChild());
    }

    if(currentNode.getRightChild() != null) {
      printInOrder(currentNode.getRightChild());
    }
  }

  // Post-order traversal (Left, Right, current)
  private void printPostOrder(Node currentNode){
    if(currentNode.getLeftChild() != null){
      printInOrder(currentNode.getLeftChild());
    }

    if(currentNode.getRightChild() != null) {
      printInOrder(currentNode.getRightChild());
    }

    System.out.println(currentNode.getData());
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
