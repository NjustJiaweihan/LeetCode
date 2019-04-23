//向root带领的空链表中插入
class Solution
{
    public ListNode insertionSortList(ListNode head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }
        
        ListNode root = new ListNode(-1);
        
        //游标, 待插入元素, 待插入元素后继元素
        ListNode node, insertNode, insertNextNode;

        insertNode = head;

        while (insertNode != null)
        {
            //重置后继元素与游标
            insertNextNode = insertNode.next;
            node = root;

            //寻找插入点
            while (node.next!=null && node.next.val < insertNode.val)
            {
                node = node.next;
            }

            insertNode.next = node.next;
            node.next = insertNode;
            insertNode = insertNextNode;
        }

        return root.next;
    }
}
