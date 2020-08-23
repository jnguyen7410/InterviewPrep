public class AddTwoNumberDriver {
    public static void main(String[] args) {
        // int[] list1Nums = {2,4,3};
        int[] list1Nums = {1};
        ListNode list1 = createList(list1Nums);
        // int[] list2Nums = {5,6,4};
        int[] list2Nums = {2};
        ListNode list2 = createList(list2Nums);
        // int[] expectedNums = {7,0,8};
        int[] expectedNums = {3};
        ListNode expected = createList(expectedNums);

        Solution solution = new Solution();
        ListNode actual = solution.addTwoNumbers(list1, list2);

        System.out.println("EXPECTED: ");
        printList(expected);
        System.out.println("ACTUAL: ");
        printList(actual);
    }


    public static void printList(ListNode node) {
        while (node != null) {
            System.out.println("=================");
            System.out.println(node.val);
            node = node.next;
            System.out.println("=================");
        }
    }

    public static ListNode createList(int[] nums) {
        ListNode head = null;
        ListNode next = null;
        for (int num : nums) {
            if (head == null) {
                head = new ListNode(num);
                next = head;
            } else {
                next.next = new ListNode(num);
                next = next.next;
            }
        }
        return head;
    }
}