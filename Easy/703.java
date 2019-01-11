class KthLargest
{
    private int k;
    private Queue<Integer> pq;
    public KthLargest(int k, int[] nums)
    {
        this.k = k;
        pq = new PriorityQueue<>(k);
        for(int elem : nums)
        {
            //这个add是KthLargest类的add方法 它有size的判断
            this.add(elem);
            //pq.add(elem) 调用的是PriorityQueue的add方法 它没有size判断
        }
    }

    public int add(int val)
    {
        if(pq.size() < k)
        {
            pq.add(val);
        }
        else
        {
            if(pq.peek() < val)
            {
                pq.poll();
                pq.add(val);
            }
        }
        return pq.peek();
    }
}
