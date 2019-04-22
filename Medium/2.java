class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode last = new ListNode(0);
        ListNode first = last;
        int CF = 0;

        //链表尾部插入结点
        while (l1 != null || l2 != null)
        {
            if (l1 == null)
            {
                if(l2.val + CF < 10)
                {
                    ListNode oldLast = last;
                    last = new ListNode(l2.val + CF);
                    oldLast.next = last;
                    CF = 0;
                }
                else
                {
                    ListNode oldLast = last;
                    last = new ListNode((l2.val + CF) % 10);
                    oldLast.next = last;
                    CF = (l2.val + CF) / 10;
                }

                l2 = l2.next;
            }
            else if (l2 == null)
            {
                if(l1.val + CF < 10)
                {
                    ListNode oldLast = last;
                    last = new ListNode(l1.val + CF);
                    oldLast.next = last;
                    CF = 0;
                }
                else
                {
                    ListNode oldLast = last;
                    last = new ListNode((l1.val + CF) % 10);
                    oldLast.next = last;
                    CF = (l1.val + CF) / 10;
                }

                l1 = l1.next;
            }
            else
            {
                if(l1.val + l2.val + CF < 10)
                {
                    ListNode oldLast = last;
                    last = new ListNode(l1.val + l2.val + CF);
                    oldLast.next = last;
                    CF = 0;
                }
                else
                {
                    ListNode oldLast = last;
                    last = new ListNode((l1.val + l2.val + CF) % 10);
                    oldLast.next = last;
                    CF = (l1.val + l2.val + CF) / 10;
                }

                l1 = l1.next;
                l2 = l2.next;
            }
        }
        if(CF != 0)
        {
            ListNode oldLast = last;
            last = new ListNode(CF);
            oldLast.next = last;
        }
        return first.next;
    }
}
