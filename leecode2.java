public class leecode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int x = 0;
        int y = 0;
        int carry = 0;

        while(l1 != null || l2 != null){
            x = l1 == null ? 0 : l1.val;
            y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;

        }
        if(carry == 1){
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}
