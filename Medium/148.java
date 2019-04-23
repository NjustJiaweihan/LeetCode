class Solution
{
    public ListNode sortList(ListNode head)
    {
        return head == null ? null : mergeSort(head);
    }

    public ListNode mergeSort(ListNode head)
    {
        if(head.next == null)
        {
            return head;
        }
        //两倍速的快慢指针用于查找中间结点 形成：head 和 slow两个链表
        //prev紧跟slow 用于断开head和slow链表的连接
        ListNode fast = head, slow = head, prev = null;
        while (fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        
        ListNode l1 = mergeSort(head);
        ListNode l2 = mergeSort(slow);
        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2)
    {
        ListNode root = new ListNode(-1);
        ListNode cur = root;
        while (l1 != null && l2 != null)
        {
            if(l1.val > l2.val)
            {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
            else
            {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }
        }
        if(l1 == null)
        {
            cur.next = l2;
        }
        if(l2 == null)
        {
            cur.next = l1;
        }
        return root.next;
    }
}
