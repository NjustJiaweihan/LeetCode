//766 简单元素比较
class Solution
{
    public boolean isToeplitzMatrix(int[][] matrix)
    {
        int rowLength = matrix.length;
        //二维数组一行是一个数组 代表一个元素
        int columnLength = matrix[0].length;
        //第零列
        int ii = 0,jj = 0;
        for(int i=0,j=0; i<rowLength; i++)
        {
            ii = i;
            jj = j;
            while (ii<rowLength-1 && jj<columnLength-1)
            {
                if(matrix[ii][jj] != matrix[ii+1][jj+1])
                {
                    return false;
                }
                ii++;
                jj++;
            }
        }
        //第零行
        ii = 0; jj = 0;
        for(int j=0,i=0; j<columnLength; j++)
        {
            ii = i;
            jj = j;
            while (ii<rowLength-1 && jj<columnLength-1)
            {
                if(matrix[ii][jj] != matrix[ii+1][jj+1])
                {
                    return false;
                }
                ii++;
                jj++;
            }
        }
        return true;
    }
}
public class LeetCode
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int[][] nums1 = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        boolean o = solution.isToeplitzMatrix(nums1);
        System.out.println(o);

    }
}

//766 构造序列方法

class Solution
{
    public boolean isToeplitzMatrix(int[][] matrix)
    {
        int rowLength = matrix.length;
        //二维数组一行是一个数组 代表一个元素
        int columnLength = matrix[0].length;
        //构造序列
        if(rowLength == 1 || columnLength ==1)
        {
            return true;
        }
        int[] sequence = new int[rowLength+columnLength-1];
        int row = rowLength-1;
        int column = 1;
        for(int i=0; i<rowLength; i++)
        {
            if(row < 0)
            {
                break;
            }
            sequence[i] = matrix[row][0];
            row--;
        }
        for(int j=0; j<columnLength; j++)
        {
            if(column > columnLength-1)
            {
                break;
            }
            sequence[rowLength+j] = matrix[0][column];
            column++;
        }
        //开始检测
        int index = 0;
        for(int i=rowLength-1; i>0; i--)
        {
            for(int j=0; j<columnLength; j++)
            {
                if(matrix[i][j] != sequence[index])
                {
                    return false;
                }
                index++;
            }
            //
            index = index - (columnLength-1);
        }
        return true;
    }
}
public class LeetCode
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int[][] nums1 = {{97,97},{80,97},{10,80}};
        boolean o = solution.isToeplitzMatrix(nums1);
        System.out.println(o);
    }
}
