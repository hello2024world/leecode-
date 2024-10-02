public class leecode83 {
    public ListNode deleteDuplicates(ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        if (head == null){
            return head;
        }
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode temp = new ListNode(0);
        temp.next = head;
        while (head != null){
            if (set.contains(head.val)){
                if (head.next == null){
                    temp.next = null;
                }else
                    temp.next = head.next;
                head = temp.next;
            }else {
                set.add(head.val);
                head = head.next;
                temp = temp.next;
            }
        }
        return res.next;
    }
}
