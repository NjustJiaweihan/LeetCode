class Solution
{
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        if(head == null)
        {
            return null;
        }
        
        ListNode fast = head;
        for(int i=0; i<n; i++)
        {
            //用于防止n==list.length时，fast==null
            if(fast.next == null)
            {
                head = head.next;
                return head;
            }
            fast = fast.next;
        }
        ListNode slow = head;

        while (fast.next != null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        return head;
    }
}
