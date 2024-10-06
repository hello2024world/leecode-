public class leecode160 {
    /**
     * 寻找两个链表相交的节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode one = headA;
        ListNode two = headB;
        //使用两个索引，遍历完自己的链表后，遍历另一个链表
        while (one != two){
            //如果a链表遍历结束，转到b链表进行遍历
            if (one == null){
                one = headB;
            }else {
                one = one.next;
            }
            //如果b链表遍历结束，转到a链表进行遍历
            if (two == null){
                two = headA;
            }else {
                two = two.next;
            }

        }
        return one;
    }
}
