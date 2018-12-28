//时间比较长 但思路比较容易理解

public class Solution
{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        if(headA == null || headB == null)
        {
            return null;
        }
        ListNode NodeA = headA;
        ListNode NodeB = headB;
        Set<ListNode> NodeSet = new HashSet<>();

        while (NodeA != null)
        {
            NodeSet.add(NodeA);
            NodeA = NodeA.next;
        }
        while (NodeB != null)
        {
            if(NodeSet.contains(NodeB))
            {
                return NodeB;
            }
            NodeB = NodeB.next;
        }
        return null;
    }
}
