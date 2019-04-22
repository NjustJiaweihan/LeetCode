class Solution
{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        //游标ptr 新表头Head
        ListNode ptr = new ListNode(0);
        ListNode Head = ptr;
        //链表的归并和数组有区别 直接链接结点就行 不要用在表尾插入的方法
        while (l1!=null && l2!=null)
        {
            if(l1.val <= l2.val)
            {
                ptr.next = l1;
                l1 = l1.next;
            }
            else
            {
                ptr.next = l2;
                l2 = l2.next;
            }
            ptr = ptr.next;
        }
        //接上剩下的尾巴
        if(l2 != null)
        {
            ptr.next = l2;
        }
        else if(l1 != null)
        {
            ptr.next = l1;
        }
        return Head.next;
    }
}

//21 递归思路

class Solution
{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode Head;

        //递归返回条件写在前头
        if(l1 == null)
        {
            return l2;
        }
        if(l2 == null)
        {
            return l1;
        }

        if(l1.val <= l2.val)
        {
            Head = l1;
            Head.next = mergeTwoLists(l1.next,l2);
        }
        else
        {
            Head = l2;
            Head.next = mergeTwoLists(l1,l2.next);
        }
        return Head;
    }
}

//2ms
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
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
