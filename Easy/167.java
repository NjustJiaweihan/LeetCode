//O(nlogn)  167

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int index1 = -1;
        int index2 = -1;
        int[] index = new int[2];
        l:for(int i=0; i<numbers.length; i++)
        {
            int lo = i+1;
            int hi = numbers.length - 1;
            int mid = -1;
            while(lo <= hi)
            {
                mid = lo + (hi - lo) / 2;
                if((target-numbers[i]) < numbers[mid])
                {
                    hi = mid - 1;
                }
                else if((target-numbers[i]) > numbers[mid])
                {
                    lo = mid + 1;
                }
                else
                {
                    index2 = mid;
                    index1 = i;
                    break l;
                }
            }
        }
        index[0] = index1 + 1;
        index[1] = index2 + 1;

        return index;
    }
}

//O(n)  167

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] index = new int[2];
        int r = numbers.length - 1;
        int l = 0;

        while(l < r)
        {
            if(target < numbers[l]+numbers[r])
            {
                r--;
            }
            else if(target >numbers[l]+numbers[r])
            {
                l++;
            }
            else
            {
                index[0] = l + 1;
                index[1] = r + 1;
                break;
            }
        }
        return index;
    }
}
