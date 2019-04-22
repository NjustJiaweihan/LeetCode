//多项归并
//维护一个大小为lists.length的优先队列
//每有一个元素出队了 就补上该元素所属list的下一个元素 (和索引优先队列功能类似)

class Solution
{
    public ListNode mergeKLists(ListNode[] lists)
    {
        if(lists == null || lists.length == 0)
        {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for(int i=0; i<lists.length; i++)
        {
            if(lists[i] != null)
            {
                queue.add(lists[i]);
            }
        }
        ListNode head = new ListNode(-1), cur = head;
        while (!queue.isEmpty())
        {
            ListNode temp = queue.poll();
            cur.next = temp;
            cur = temp;

            if(temp.next != null)
            {
                queue.add(temp.next);
            }
        }
        return head.next;
    }
}
