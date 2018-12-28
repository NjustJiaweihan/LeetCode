//迭代思路
class Solution
{
    public ListNode reverseList(ListNode head)
    {
        ListNode newHeadFirst = null;
        ListNode listNode = head;

        while (listNode!=null)
        {
            ListNode oldfirst = newHeadFirst;
            newHeadFirst = listNode;
            //错误示例：
            //newHeadFirst.next = oldfirst;
            //listNode=listNode.next;
            //这两行不能颠倒 newHeadFirst,listNode指向同一块内存
            //若先newHeadFirst.next = oldfirst = null,则listNode = null
            listNode=listNode.next;
            newHeadFirst.next = oldfirst;
        }
        return newHeadFirst;
    }
}
