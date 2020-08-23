/**
 * @author DarlingDucking
 * 
 * So, let's consider a linked list consisting of n number of nodes, where each
 * node consists of an unique number, a priority number(in between 1 to 5), and 
 * pointer to next node. We need to design an algorithm to divide the nodes into 
 * different linked list where each linked consists of nodes having same priority. 
 * So, how would you do it?
 */

/*
 * Q1: Unique for the entire list or per priority? List
 * Q2: Do I need to sort this? No
 * Q3: Do I need to guard against invalid values? (duplicate numbers showing up, 
 * wrong order, etc.) Yes
 *  Assumption: if you see a duplicate value down the list, regardless of priority, remove it. Hint: Set
 * Q4: How do you intend for the answer to be returned? Specific format? List<PriorityNode> 
 * Q5: Can there be a node without priority? No
 * Q6: What happens if we see an invalid priority?
 * Assumption: Ignore it
 */

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.HashSet;

public class PriorityNodes {
    public static void main(String[] args) {
        PriorityNode node = new PriorityNode(1,1);
        PriorityNode node2 = new PriorityNode(2,2);
        PriorityNode node3 = new PriorityNode(31415926,-1);
        PriorityNode node4 = new PriorityNode(4,2);
        PriorityNode node5 = new PriorityNode(5,1);
        PriorityNode node6 = new PriorityNode(3,3);
        PriorityNode node7 = new PriorityNode(3,1);

        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ArrayList<PriorityNode> separatedNodes = separateNodesByPriority(node);
        
        System.out.println("INPUT: ");
        printNodeList(node);
        System.out.println("OUTPUT: ");
        for (PriorityNode duck: separatedNodes) {
            printNodeList(duck);
        }

    }

    static ArrayList<PriorityNode> separateNodesByPriority(PriorityNode node) {
        HashMap<Integer, PriorityNode> priorityToNodeMap = new HashMap<>();
        ArrayList<PriorityNode> result = new ArrayList<>();
        HashSet<Integer> uniqueNums = new HashSet<>();
        while (node != null) {
            PriorityNode temp = new PriorityNode(node.val, node.priority);
            if (uniqueNums.contains(temp.val) || temp.priority < 1 || temp.priority > 5) {
                node = node.next;
                continue;
            } else {
                uniqueNums.add(temp.val);
            }
            if (!priorityToNodeMap.containsKey(node.priority)) {
                priorityToNodeMap.put(node.priority, temp);
                result.add(temp);
            } else {
                priorityToNodeMap.get(node.priority).next = temp;
                priorityToNodeMap.put(node.priority, temp);
                
            }
            node = node.next;
        }
        return result;
    }

    static void printNodeList(PriorityNode node) {
        if (node == null) {
            System.out.println("");
        }
        String str = "" + node.val + "(" + node.priority + ")";
        while (node.next != null) {
           str += " => " + node.next.val + "(" + node.next.priority + ")";
           node = node.next;
        }
        System.out.println(str);
     }
    
}