import java.util.ArrayList;
public class Stack {
  public ArrayList<Integer> list;
  
  public Queue() {
    list = new ArrayList<Integer>();
  }
  
  public void push(int num) {
    list.add(num);
  }
  
  public int pop() {
    return list.remove(list.size - 1);
  }
  
  public int peek() {
    return list.get(list.size - 1);
  }
  
  public boolean isEmpty() {
    return list.size() == 0;
  }
  
  public int size() {
    return list.size();
  }
  
  public String toString() {
    String result = "";
    for (int i = list.size() - 1; i >= 0; i--) {
      result += list.get(i) + " ";
    }
    return result;
  }
}