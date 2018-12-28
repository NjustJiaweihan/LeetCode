class Solution
{
    public ListNode deleteDuplicates(ListNode head)
    {
        if(head == null)
        {
            return null;
        }
        ListNode listNode = head;
        while (listNode.next!=null)
        {
            //测试用例：{1, 1, 1}
            //所以下行用while而不是if
            
            //测试用例{1, 1, 2, 3, 3}
            //所以先判断listNode.next != null
            //否则在删除第二个3后,listNode.next == null,listNode.next.val会报无指向异常
            
            while(listNode.next != null && listNode.val == listNode.next.val)
            {
                listNode.next = listNode.next.next;
            }
            if(listNode.next == null)
            {
                return head;
            }
            listNode = listNode.next;
        }
        return head;
    }
}
