class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<String>();

        int scale = 0, maxScale = S.length();
        int[] choice = new int[maxScale];
        char[] chs = S.toCharArray();
        // 终止条件：问题规模边界为负
        while (scale >= 0)
        {

            // 输出条件：问题规模边界为最大边界
            if (scale == maxScale)
            {
                result.add(new String(chs));
                scale --;
                continue;
            }

            if (chs[scale] <= '9')//是数字
            {
                if (choice[scale] == 0)
                {
                    choice[scale ++] = 1; //左右同分支 1 表示都走过了
                }
                else
                {
                    choice[scale --] = 0;//回溯就置0
                }
                continue;
            }
            //是字母
            if (choice[scale] == 0) //0 左右还未走过 回溯就置0
            {
                chs[scale] = Character.toLowerCase(chs[scale]);
                choice[scale] ++;
                scale ++;
            } else if (choice[scale] == 1)//1 表示 走过左分支
            {
                chs[scale] = Character.toUpperCase(chs[scale]);
                choice[scale] ++;
                scale ++;
            } else //2 表示走过右分支
                {
                choice[scale] = 0; //左右都走过了 就再回溯
                scale --;
            }
        }
        return result;
    }
}
