//写得很烂 结尾附上大神代码
class NumArray {

    private int[] num;
    private int sum;
    private int oldi;
    private int oldj;
    public NumArray(int[] nums)
    {
        num = new int[nums.length];
        for(int i=0; i<nums.length; i++)
        {
            num[i] = nums[i];
        }
    }

    public int sumRange(int i, int j)
    {

        if(oldi == i && oldj < j && oldj != 0)
        {
            for(int k=oldj+1; k<=j; k++)
            {
                sum += num[k];
            }
            oldi = i;
            oldj = j;
            return sum;
        }
        else
        {
            sum = 0;
            for(int k=i; k<=j; k++)
            {
                sum += num[k];
            }
            oldi = i;
            oldj = j;
            return sum;
        }

    }
}

class NumArray2 {

    int[] nums;
    public NumArray2(int[] nums) {
        this.nums = new int[nums.length];
        if(this.nums.length == 0)
        {
            return;
        }
        this.nums[0] = nums[0];
        for(int i=1; i<nums.length;i++) {
            this.nums[i] = this.nums[i-1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return i==0? nums[j]:nums[j]-nums[i-1];
    }
}
