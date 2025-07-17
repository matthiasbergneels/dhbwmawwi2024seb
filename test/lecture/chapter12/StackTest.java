package lecture.chapter12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

  @Test
  public void pushTest(){
    Stack<String> stack = new Stack<>();
    assertTrue(stack.isEmpty());
    assertEquals(0, stack.size());

    stack.push("eins");
    assertFalse(stack.isEmpty());
    assertEquals(1, stack.size());
    assertEquals("eins", stack.peek());

    stack.push("zwei");
    assertFalse(stack.isEmpty());
    assertEquals(2, stack.size());
    assertEquals("zwei", stack.peek());

    stack.push("drei");
    assertFalse(stack.isEmpty());
    assertEquals(3, stack.size());
    assertEquals("drei", stack.peek());
  }

  @Test
  public void popTest(){
    Stack<String> stack = new Stack<>();
    assertTrue(stack.isEmpty());
    assertEquals(0, stack.size());

    stack.push("eins");
    stack.push("zwei");
    stack.push("drei");

    assertEquals("drei", stack.pop());
    assertFalse(stack.isEmpty());
    assertEquals(2, stack.size());
    assertEquals("zwei", stack.peek());

    assertEquals("zwei", stack.pop());
    assertFalse(stack.isEmpty());
    assertEquals(1, stack.size());
    assertEquals("eins", stack.peek());

    assertEquals("eins", stack.pop());
    assertTrue(stack.isEmpty());
    assertEquals(0, stack.size());
  }

  @Test
  public void peekTest(){
    Stack<String> stack = new Stack<>();
    assertTrue(stack.isEmpty());
    assertEquals(0, stack.size());
    assertNull(stack.peek());

    stack.push("eins");
    assertFalse(stack.isEmpty());
    assertEquals(1, stack.size());
    assertEquals("eins", stack.peek());

    stack.push("zwei");
    assertFalse(stack.isEmpty());
    assertEquals(2, stack.size());
    assertEquals("zwei", stack.peek());

    stack.pop();
    assertFalse(stack.isEmpty());
    assertEquals(1, stack.size());
    assertEquals("eins", stack.peek());

    stack.pop();
    assertTrue(stack.isEmpty());
    assertEquals(0, stack.size());
    assertNull(stack.peek());
  }

  @Test
  public void isEmptyTest() {
    Stack<String> stack = new Stack<>();
    assertTrue(stack.isEmpty());
    assertEquals(0, stack.size());

    stack.push("eins");
    assertFalse(stack.isEmpty());
    assertEquals(1, stack.size());

    stack.pop();
    assertTrue(stack.isEmpty());
    assertEquals(0, stack.size());
  }

  @Test
  public void sizeTest() {
    Stack<String> stack = new Stack<>();
    assertTrue(stack.isEmpty());
    assertEquals(0, stack.size());

    stack.push("eins");
    assertFalse(stack.isEmpty());
    assertEquals(1, stack.size());

    stack.push("zwei");
    assertFalse(stack.isEmpty());
    assertEquals(2, stack.size());

    stack.pop();
    assertFalse(stack.isEmpty());
    assertEquals(1, stack.size());

    stack.pop();
    assertTrue(stack.isEmpty());
    assertEquals(0, stack.size());
  }

}