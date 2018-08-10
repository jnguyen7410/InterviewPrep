import java.util.ArrayList;
public class Queue {
  public ArrayList<Integer> list;
  
  public Queue() {
    list = new ArrayList<Integer>();
  }
  
  public void push(int num) {
    list.add(num);
  }
  
  public int pop() {
    return list.remove(0);
  }
  
  public int peek() {
    return list.get(0);
  }
  
  public boolean isEmpty() {
    return list.size() == 0;
  }
  
  public int size() {
    return list.size();
  }
  
  public String toString() {
    String result = "";
    for (int i = 0; i < list.size(); i++) {
      result += list.get(i) + " ";
    }
    return result;
  }
}