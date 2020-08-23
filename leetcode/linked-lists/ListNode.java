public class PriorityNode {
   int val;
   int priority;
   PriorityNode next;
   PriorityNode() {}
   PriorityNode(int val, int priority) { 
      this.val = val;
      this.priority = priority;
   }
   PriorityNode(int val, int priority, PriorityNode next) { 
      this.val = val; 
      this.priority = priority;
      this.next = next;
   } 
   
}