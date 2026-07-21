class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        // Continue loop if either list has nodes, OR if there's a leftover carry
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            // Calculate new carry (e.g., 14 / 10 = 1)
            carry = sum / 10;
            // Get the last digit for the new node (e.g., 14 % 10 = 4)
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        
        return dummyHead.next;
    }
}