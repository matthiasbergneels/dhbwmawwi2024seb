package lecture.chapter12;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class DoubleLinkedList<T> implements List<T> {

  private Node firstNode;
  private Node lastNode;

  public void addLast(T data){
    Node newNode = new Node(data);
    if(firstNode == null && lastNode == null){
      firstNode = newNode;
      lastNode = newNode;
    }else{
      lastNode.setNextNode(newNode);
      newNode.setPrevNode(lastNode);
      lastNode = newNode;
    }
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public boolean contains(Object o) {
    return false;
  }

  @Override
  public Iterator<T> iterator() {
    return new DoubleLinkedListIterator(firstNode);
  }

  @Override
  public Object[] toArray() {
    return new Object[0];
  }

  @Override
  public <T1> T1[] toArray(T1[] a) {
    return null;
  }

  @Override
  public boolean add(T t) {
    return false;
  }

  @Override
  public boolean remove(Object o) {
    return false;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    return false;
  }

  @Override
  public boolean addAll(Collection<? extends T> c) {
    return false;
  }

  @Override
  public boolean addAll(int index, Collection<? extends T> c) {
    return false;
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    return false;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    return false;
  }

  @Override
  public void clear() {

  }

  @Override
  public T get(int index) {
    return null;
  }

  @Override
  public T set(int index, T element) {
    return null;
  }

  @Override
  public void add(int index, T element) {

  }

  @Override
  public T remove(int index) {
    return null;
  }

  @Override
  public int indexOf(Object o) {
    return 0;
  }

  @Override
  public int lastIndexOf(Object o) {
    return 0;
  }

  @Override
  public ListIterator<T> listIterator() {
    return null;
  }

  @Override
  public ListIterator<T> listIterator(int index) {
    return null;
  }

  @Override
  public List<T> subList(int fromIndex, int toIndex) {
    return List.of();
  }

  public void addFirst(T data){
    Node newNode = new Node(data);
    if(firstNode == null && lastNode == null){
      firstNode = newNode;
      lastNode = newNode;
    }else{
      firstNode.setPrevNode(newNode);
      newNode.setNextNode(firstNode);
      firstNode = newNode;
    }
  }

  public void delete(T s){
    Node n = findNode(s);
    if(n != null){
      if(n == lastNode){
        n.getPrevNode().setNextNode(null);
        return;
      }
      if(n == firstNode){
        n.getNextNode().setPrevNode(null);
        return;
      }

      n.getPrevNode().setNextNode(n.getNextNode());
      n.getNextNode().setPrevNode(n.getPrevNode());
    }
  }

  public void insertAfter(T prev, T data){
    Node n = findNode(prev);
    if(n != null){
      Node newNode = new Node(data);
      newNode.setNextNode(n.nextNode);
      n.setNextNode(newNode);
      newNode.setPrevNode(n);
      if(n == lastNode){
        lastNode = newNode;
      }
    }
  }


  private Node findNode(T data){

    Node currentNode = firstNode;
    do{
      if(currentNode.getData().equals(data)){
        return currentNode;
      }
      currentNode = currentNode.getNextNode();
    }while(currentNode.getNextNode() != null);

    return null;
  }



  @Override
  public String toString() {
    if(firstNode == null && lastNode == null){
      return "Empty list";
    }else{
      return toString(firstNode);
    }
  }

  private String toString(Node node){
    String s = "";
    s += node.getData() + "\n";
    if(node.getNextNode() != null){
      s += toString(node.getNextNode());
    }
    return s;
  }

  private class Node {

    private T data;
    private Node prevNode;
    private Node nextNode;

    public Node(T data) {
      this.data = data;
      this.prevNode = null;
      this.nextNode = null;
    }

    public T getData() {
      return this.data;
    }

    public Node getPrevNode() {
      return prevNode;
    }

    public void setPrevNode(Node prevNode) {
      this.prevNode = prevNode;
    }

    public Node getNextNode() {
      return nextNode;
    }

    public void setNextNode(Node nextNode) {
      this.nextNode = nextNode;
    }
  }

  private class DoubleLinkedListIterator implements Iterator<T> {

    private Node currentNode;

    DoubleLinkedListIterator(Node startNode) {
      this.currentNode = startNode;
    }

    @Override
    public boolean hasNext() {
      return currentNode.nextNode != null;
    }

    @Override
    public T next() {
      if (hasNext()) {
        T data = currentNode.getData();
        currentNode = currentNode.getNextNode();
        return data;
      }
      return null;
    }

    @Override
    public void remove() {
      Iterator.super.remove();
    }
  }
}