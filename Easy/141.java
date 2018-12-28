//很羞耻的方法 想借助图中环检测的marked数组标记方法的
//但不知道链表size 
//想想实际场景也可以这样用 就放上来了
public class Solution
{
    public boolean hasCycle(ListNode head)
    {
        ListNode listNode = head;
        while(listNode != null)
        {
            if(listNode.val == Integer.MAX_VALUE)
            {
                return true;
            }
            listNode.val = Integer.MAX_VALUE;
            listNode = listNode.next;
        }
        return false;
    }
}

//141 哈希表法
//跟用marked数组相似
//我们将访问过的结点放入哈希表
//要是当前访问的结点存在于哈希表中 则有环
//要是访问到null,表示到达表尾
class Solution
{
    public boolean hasCycle(ListNode head)
    {
        ListNode listNode = head;
        //set中元素不可相同
        Set<ListNode> set = new HashSet<>();

        while (listNode != null)
        {
            if(set.contains(listNode))
            {
                return true;
            }
            set.add(listNode);
            listNode = listNode.next;
        }
        return false;
    }
}

//141 快慢双指针法
//若不存在环 快指针会率先到达表尾
//若存在环 快指针最终会追上慢指针
class Solution
{
    public boolean hasCycle(ListNode head)
    {
        if(head == null || head.next == null)
        {
            return false;
        }
        ListNode fastNode = head.next;
        ListNode slowNode = head;

        while (fastNode != slowNode)
        {
            if(fastNode == null || fastNode.next == null)
            {
                return false;
            }
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        return true;
    }
}
