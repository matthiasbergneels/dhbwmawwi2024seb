package lecture.chapter12;

public class BinarySearchTreeRun {
  public static void main(String[] args) {
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();

    // Insert elements
    bst.add(50);
    bst.add(30);
    bst.add(20);
    bst.add(40);
    bst.add(70);
    bst.add(60);
    bst.add(80);

    // Search for elements
    System.out.println("\nSearching for 40: " + bst.contains(40));
    System.out.println("Searching for 90: " + bst.contains(90));

    // Print in-order traversal
    System.out.println("In-order traversal:");
    bst.printTree();

    System.out.println("Pre-order traversal:");
    bst.printPreOrder();

    System.out.println("Post-order traversal:");
    bst.printPostOrder();
  }
}
