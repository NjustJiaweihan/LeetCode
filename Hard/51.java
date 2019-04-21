class Solution
{
    public List<List<String>> solveNQueens(int n)
    {
        List<List<String>> reslut = new ArrayList<List<String>>();
        //数组一个元素queenPositions[i]=j代表：第i行的第j列是Q
        int[] queenPositions = new int[n];
        placeQueen(queenPositions, n, 0, reslut);
        return reslut;
    }

    public void placeQueen(int[] queenPositions, int n, int row, List result)
    {
        if(row == n)
        {
            draw(queenPositions, result, n);
        }
        else
        {
            for(int col=0; col<n; col++)
            {
                if(isValid(queenPositions, row, col))
                {
                    queenPositions[row] = col;
                    placeQueen(queenPositions, n, row+1, result);
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

    public void draw(int[] queenPositions, List result, int n)
    {
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            StringBuffer s = new StringBuffer();
            for(int col=0; col<n; col++)
            {
                if(col == queenPositions[i])
                {
                    s.append("Q");
                }
                else {
                    s.append(".");
                }
            }
            list.add(s.toString());
        }
        result.add(list);
    }
}

public class LeetCode
{
    public static void main(String[] args) {
        Solution solution = new Solution();
        List l = solution.solveNQueens(8);
        for(Object list : l)
        {
            System.out.println(list);
        }
    }
}
