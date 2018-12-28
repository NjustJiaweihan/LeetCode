class Solution
{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        //游标ptr 新表头Head
        ListNode ptr = new ListNode(0);
        ListNode Head = ptr;
        //链表的归并和数组有区别 直接链接结点就行 不要用在表尾插入的方法
        while (l1!=null && l2!=null)
        {
            if(l1.val <= l2.val)
            {
                ptr.next = l1;
                l1 = l1.next;
            }
            else
            {
                ptr.next = l2;
                l2 = l2.next;
            }
            ptr = ptr.next;
        }
        //接上剩下的尾巴
        if(l2 != null)
        {
            ptr.next = l2;
        }
        else if(l1 != null)
        {
            ptr.next = l1;
        }
        return Head.next;
    }
}
