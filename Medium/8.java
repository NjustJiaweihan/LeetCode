class Solution
{
    public int myAtoi(String str)
    {
        if(str == null || str.length() == 0)
        {
            return 0;
        }

        //丢弃开头空格
        int index = 0;
        while (str.charAt(index) == ' ')
        {
            if(index < str.length()-1)
            {
                index++;
            }
            else
            {
                return 0;
            }
        }

        //非数字开头
        char c = str.charAt(index);
        if(c < '0' || c > '9')
        {
            if(c != '+' && c != '-')
            {
                return 0;
            }
            else if(index < str.length()-1)
            {
                char c1 = str.charAt(index + 1);
                if(c1 < '0' || c1 > '9')
                {
                    return 0;
                }
            }
            else
            {
                return 0;
            }
        }


        //正负数开头
        //0 正 -1 负
        int flag = 0;
        if(str.charAt(index) == '-')
        {
            flag = -1;
            index++;
        }
        if(str.charAt(index) == '+')
        {
            index++;
        }

        //从第一个数字开始 拿到第一个连续数字
        int i = index, j = index;
        for(i=index; i<str.length(); i++)
        {
            if(str.charAt(i)<'0' || str.charAt(i)>'9')
            {
                break;
            }
        }
        //除开头的0
        while (j<str.length() && str.charAt(j) == '0')
        {
            j++;
        }
        //只有0
        if(j == i)
        {
            return 0;
        }
        
        if(str.substring(j, i).length() < (Integer.MAX_VALUE + "").length())
        {
            int result = Integer.parseInt(str.substring(j, i));
            return flag == 0 ? result : -result;
        }
        else if(str.substring(j, i).length() == (Integer.MAX_VALUE + "").length()
                && str.substring(j, i).compareTo(Integer.MAX_VALUE + "") <= 0)
        {
            int result = Integer.parseInt(str.substring(j, i));
            return flag == 0 ? result : -result;
        }
        //溢出
        else
        {
            return flag == 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
    }
}
