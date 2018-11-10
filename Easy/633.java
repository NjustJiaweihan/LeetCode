//直角三角形 两条直角边一定都小于斜边
//三角形两边之和大于第三边
class Solution {
    public boolean judgeSquareSum(int c)
    {
        int sqrtc = (int)Math.sqrt(c);
        if(Math.sqrt(c) == sqrtc)
        {
            return true;
        }
        int i=0;
        int j=sqrtc;
        //相比于限制双重for循环长度，不如用双指针来的效率高
        //双指针可以将O(n^2) -> O(n)
        while (i<=sqrtc)
        {
            if(i*i+j*j < c)
            {
                i++;
            }
            else if(i*i+j*j > c)
            {
                j--;
            }
            else
            {
                return true;
            }
        }
        return false;
    }
}
