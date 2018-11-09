class Solution
{
    public boolean canPlaceFlowers(int[] flowerbed, int n)
    {
        int count = 0;
        if(flowerbed.length == 1 && flowerbed[0] == 0)
        {
            return 1 >= n;
        }
        else if(flowerbed.length == 2 && flowerbed[0] == 0 && flowerbed[1] == 0)
        {
            return 1 >= n;
        }
        //length-3 则flowered长度至少为3 不能遗漏更简单情况
        else 
        {
            if (flowerbed[0] == 0 && flowerbed[1] == 0) 
            {
                count++;
            }
            for (int i = 1; i < flowerbed.length - 3; i++) 
            {
                if (flowerbed[i] == 0) 
                {
                    if (flowerbed[i + 1] == 0 && flowerbed[i + 2] == 0) 
                    {
                        count++;
                        i++;
                    }
                }
            }


            if (flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
                count++;
            }
        }
        
        return count >= n;
    }
}
