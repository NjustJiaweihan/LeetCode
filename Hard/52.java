class Solution
{
    private int cnt;
    public Solution()
    {
        this.cnt = 0;
    }
    public int totalNQueens(int n)
    {
        //数组一个元素queenPositions[i]=j代表：第i行的第j列是Q
        int[] queenPositions = new int[n];
        placeQueen(queenPositions, n, 0);
        return cnt;
    }

    public void placeQueen(int[] queenPositions, int n, int row)
    {
        if(row == n)
        {
            cnt++;
        }
        else
        {
            for(int col=0; col<n; col++)
            {
                if(isValid(queenPositions, row, col))
                {
                    queenPositions[row] = col;
                    placeQueen(queenPositions, n, row+1);
                }
            }
        }
    }

    public boolean isValid(int[] queenPositions, int row, int col)
    {
        //row col 是新Q
        //i pos 是老Q
        for(int i=0; i<row; i++)
        {
            int pos = queenPositions[i];
            //同列
            if(pos == col)
            {
                return false;
            }
            //同右对角线
            if(col == pos - row + i)
            {
                return false;
            }
            //同左对角线
            if(col == pos + row - i)
            {
                return false;
            }
        }
        return true;
    }
}
