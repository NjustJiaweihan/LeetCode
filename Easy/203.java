class Solution
{
    public ListNode removeElements(ListNode head, int val)
    {
        //构造一个前驱结点 测试用例{6, 3, 2, ...}删除6
        ListNode prehead = new ListNode(0);
        prehead.next = head;
        ListNode listNode = prehead;

        while (listNode.next!=null)
        {
            if (listNode.next.val == val)
            {
                listNode.next = listNode.next.next;
            }
            else
            {
                listNode = listNode.next;
            }
        }
        //不返回head 测试用例{1} 删除1 返回null
        return prehead.next;
    }
}
