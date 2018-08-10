import java.util.Stack;
public class TestClass {
    public static void main(String[] args) {
      Stack<Integer> stack = new Stack<Integer>();
      stack.push(1);
      stack.push(2);
      stack.push(3);
      stack.push(4);
      stack.push(5);
      System.out.println("stack.peek() = " + stack.peek());
      System.out.println("stack = " + stack.toString());
      System.out.println("stack size = " + stack.size());
      System.out.println("stack isEmpty = " + stack.isEmpty());
    }
}