// a^b^b = a^0 = a
// b^b = 0

//i 是 [0 n-1]
//res 是 n
//nums是[0 n]缺一个

//所以异或表达式长度是2n-1 res就是缺的数字

class Solution
{
    public int missingNumber(int[] nums){

        int res = nums.length;
        int n = nums.length;

        for(int i=0; i<n; ++i){

            res ^= nums[i];
            res ^= i;
        }

        return res;
    }
}
