class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode root = new ListNode(-1);
        root.next = head;

        //统计长度
        ListNode temp = head;
        int i = 0;
        while (temp != null)
        {
            i++;
            temp = temp.next;
        }

        //index 游标
        ListNode index = root;
        while (i >= k)
        {
            //k个元素反序只要交换k-1次
            for (int j = 0; j < k - 1; j++)
            {
                ListNode node = index.next;
                //root -> 2
                index.next = head.next;
                //1 -> 3
                head.next = index.next.next;
                //2 -> 1
                index.next.next = node;
                
                //以i=5,k=3 root->1->2->3->4->5为例
                //j=0: index->2  1->3  2->1
                //j=1: index->3  2->1->4  3->2
            }
            //head指向下一个要逆序的首元素
            //index指向head
            index = head;
            head = head.next;
            i -= k;
        }
        return root.next;
    }
}
