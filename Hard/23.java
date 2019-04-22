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

//归并排序

class Solution
{
    public ListNode mergeKLists(ListNode[] lists)
    {
        if(lists == null || lists.length == 0)
        {
            return null;
        }

        int lo = 0, hi = lists.length-1;
        while (lo < hi)
        {
            int mid = (hi + lo - 1) / 2;
            for(int i=0; i<=mid; i++)
            {
                lists[i] = merge2Lists(lists[i], lists[hi - i]);
            }
            hi = (lo + hi) / 2;
        }
        return lists[0];
    }

    public ListNode merge2Lists(ListNode l1, ListNode l2)
    {
        if(l1 == null && l2 == null)
        {
            return null;
        }
        ListNode first = new ListNode(0);
        ListNode last = first;

        while (l1 != null || l2 != null)
        {
            if(l1 == null)
            {
                ListNode oldlast = last;
                last = l2;
                oldlast.next = last;

                l2 = l2.next;
            }
            else if(l2 == null)
            {
                ListNode oldlast = last;
                last = l1;
                oldlast.next = last;

                l1 = l1.next;
            }
            else if(l1.val > l2.val)
            {
                ListNode oldlast = last;
                last = l2;
                oldlast.next = last;

                l2 = l2.next;
            }
            else
            {
                ListNode oldlast = last;
                last = l1;
                oldlast.next = last;

                l1 = l1.next;
            }
        }
        return first.next;
    }
}
