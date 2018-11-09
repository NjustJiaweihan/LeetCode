class MyLinkedList {
    private int[] list ;
    private int N;
    /** Initialize your data structure here. */
    public MyLinkedList()
    {
        N = 0;
        list = new int[1000];
        for(int i=0; i<1000; i++)
        {
            list[i] = -1;
        }
    }
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index)
    {
        if(list == null || index >= N)
        {
            return -1;
        }
        else
        {
            return list[index];
        }
    }

    /** Add a node of value val before the first element of the linked list.
     * After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val)
    {
        N++;
        if(N == 0)
        {
            list[0] = val;
        }
        else
        {
            for(int i=N; i>0; i--)
            {
                list[i] = list[i-1];
            }
            list[0] = val;
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val)
    {
        list[N] = val;
        N++;
    }

    /** Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val)
    {
        if(index > N)
        {
            return;
        }
        else if(index == N)
        {
            addAtTail(val);
        }
        else
        {
            N++;
            for(int i=N; i>index; i--)
            {
                list[i] = list[i-1];
            }
            list[index] = val;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index)
    {
        if(index < N)
        {
            N--;
            for(int i=index; i<N; i++)
            {
                list[i] = list[i+1];
            }
            //注意游离态
            list[N] = -1;
        }
    }
    public void show()
    {
        for(int i=0; i<N; i++)
        {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }
}

/**
 * @author njusthanjiawei
 */
public class LeetCode
{
    public static void main(String[] args)
    {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(7);
        linkedList.show();
        linkedList.addAtHead(2);
        linkedList.addAtHead(1);
        linkedList.show();
        linkedList.addAtIndex(3,0);
        linkedList.show();
        linkedList.deleteAtIndex(2);
        linkedList.addAtHead(6);
        linkedList.addAtTail(4);
        linkedList.show();
        linkedList.get(4);
        linkedList.addAtHead(4);
        linkedList.addAtIndex(5,0);
        linkedList.addAtHead(6);
    }
}
