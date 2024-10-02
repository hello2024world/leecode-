public class LeecodeTest142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode left = head;
        ListNode right = head;
        boolean isCirle = false;
        while(right.next != null && right.next.next!=null){
            left = left.next;
            right = right.next.next;
            if (left == right){
                isCirle = true;
                break;
            }
        }
        if (!isCirle){
            return null;
        }
        right = head;
        while (left != right){
            left = left.next;
            right = right.next;
        }
        return right;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
     }
}
