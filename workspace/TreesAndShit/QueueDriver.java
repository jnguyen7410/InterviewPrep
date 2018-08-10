public class QueueDriver {
  public static void main(String[] args) {
    Queue queue = new Queue();
    queue.push(1);
    queue.push(2);
    queue.push(3);
    queue.push(4);
    queue.push(5);
    queue.push(6);
    queue.push(7);
    System.out.println("Queue: " + queue.toString()); 
    queue.pop();
    queue.pop();
    queue.push(1);
    System.out.println("Queue: " + queue.toString()); 
  }
}