public class leecode24 {
    public ListNode swapPairs(ListNode head) {
        //每次交换指针位置后面两个元素
        //注意交换次序
        //注意结束条件判断
        if (head == null) {
            return head;
        }
        ListNode res = new ListNode(0);
        ListNode current = res;
        res.next = head;
        //当前节点的后两个节点都不能为空，不然就不需要再次进行交换了
        while (current.next != null && current.next.next != null){
            ListNode n1 = current.next;
            ListNode n2 = current.next.next;
            //进行交换
            current.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            current = n1;
        }
        return res.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
