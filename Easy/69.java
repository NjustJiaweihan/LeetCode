class Solution 
{
    public int mySqrt(int x) 
    {
        double t = x;
        while (Math.abs(t - x / t) > 0.000001)
        {
            t = (x / t + t) / 2.0;
        }
        return (int) t;
    }
}
