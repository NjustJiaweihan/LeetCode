//蓄水池抽样

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private ListNode head;
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode result = head;
        int value = result.val;
        //创建随机数生成器
        Random r = new Random();
        int i = 1;
        //链表遍历是 x!= null 而不是 x.next != null
        for(ListNode x=head; x!=null; x=x.next)
        {
            //r.nextInt(i)返回[0,i)的随机数,一共i种可能，那随便选一个就是1/i的概率
            if(r.nextInt(i) == 0)
            {
                value = x.val;
            }
            i++;
        }
        return value;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
