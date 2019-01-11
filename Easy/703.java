class KthLargest
{
    private int k;
    private PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums)
    {
        this.k = k;
        pq = new PriorityQueue<>(k);
        for(int elem : nums)
        {
            if(pq.size() < k)
            {
                pq.add(elem);
            }
            else
            {
                if(pq.peek() < elem)
                {
                    pq.poll();
                    pq.add(elem);
                }
            }
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
