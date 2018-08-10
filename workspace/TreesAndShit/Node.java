public class Node {
//   public Node left;
//   public Node right;
//   public int value;
  
//   public Node (int value) {
//     left = null;
//     right = null;
//     this.value = value;
//   }
  
  public final static int SIZE_OF_CHILDREN = 3;
  int value;
  public Node left;
  public Node right;
  public Node next;
  public Node[] children;
  public boolean visited;
  public int size;
  public int height;

  public Node (int value) {
      this.value = value;
      left = null;
      right = null;
      //children = new ArrayList<Node>();
      //children = new Node[SIZE_OF_CHILDREN];
  }
  
  public void addLeft (Node leftNode) {
    this.left = leftNode;
  }
  
  public void addRight (Node rightNode) {
    this.right = rightNode;
  }
  
  public int getValue() {
    return this.value;
  }
  
  public void setValue(int value) {
    this.value = value;
  } 
  
}