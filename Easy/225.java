class MyStack
{

    //queue1: (tail) d c b a (head)
    //queue2:
    //how to stack.pop ?
    //queue2.push(a) queue2.push(b) queue2.push(c) => queue1.pop(d)
    
    //Caution: queue.size()在offer,poll之后是时变的
    private LinkedList<Integer> queue1;
    private LinkedList<Integer> queue2;
    /** Initialize your data structure here. */
    public MyStack()
    {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x)
    {
        queue1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop()
    {
        if(queue1.size() == 0)
        {
            int temp;
            for(int i=0,length2 = queue2.size(); i<length2-1; i++)
            {
                temp = queue2.poll();
                queue1.offer(temp);
            }
            return queue2.poll();
        }
        else
        {
            int temp;
            for(int i=0,length1 = queue1.size(); i<length1-1; i++)
            {
                temp = queue1.poll();
                queue2.offer(temp);
            }
            return queue1.poll();
        }

    }

    /** Get the top element. */
    public int top()
    {
        int output;
        if(queue1.size() == 0)
        {
            int temp;
            for(int i=0,length2 = queue2.size(); i<length2-1; i++)
            {
                temp = queue2.poll();
                queue1.offer(temp);
            }
            output = queue2.poll();
            queue1.offer(output);
        }
        else
        {
            int temp;
            for(int i=0,length1 = queue1.size(); i<length1-1; i++)
            {
                temp = queue1.poll();
                queue2.offer(temp);
            }
            output =  queue1.poll();
            queue2.offer(output);
        }
        return output;
    }

    /** Returns whether the stack is empty. */
    public boolean empty()
    {
        return queue1.size()==0 && queue2.size()==0;
    }
}
