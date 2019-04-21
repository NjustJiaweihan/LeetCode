//算完数独后要把board保存起来 
//否则会被后续回溯覆盖

class Solution
{

    public void solveSudoku(char[][] board)
    {
        if(board == null || board.length == 0)
        {

        }
        else{
            char[][] board2 = new char[board.length][board[0].length];
            dfs(board, 0, 0, board2);
            copy(board2, board);
        }
    }

    public void dfs(char[][] board, int x, int y, char[][] board2)
    {
        if(x == 8 && y == 9)
        {
            copy(board, board2);
            return;
        }
        if(y == 9)
        {
            x++;
            y = 0;
        }

        if(board[x][y] == '.')
        {
            for(char c='1'; c<='9'; c++)
            {
                if(isValid(board, c, x, y))
                {
                    board[x][y] = c;
                    dfs(board, x, y+1, board2);
                    board[x][y] = '.';
                }
            }
        }
        else {
            dfs(board, x, y+1, board2);
        }

    }

    public boolean isValid(char[][] board, char c, int x, int y)
    {
        //行检验
        for(int i=0; i<board[0].length; i++)
        {
            if(board[x][i] == c)
            {
                return false;
            }
        }
        //列检验
        for(int i=0; i<board.length; i++)
        {
            if(board[i][y] == c)
            {
                return false;
            }
        }
        //方块检验
        for(int i=0; i<board.length; i++)
        {
            if(board[3 * (x/3) + i/3][3 * (y/3) + i%3] == c)
            {
                return false;
            }
        }
        return true;
    }

    public void copy(char[][] board, char[][] board2)
    {
        for(int i=0; i<9; i++)
        {
            for(int j=0; j<9; j++)
            {
                board2[i][j] = board[i][j];
            }
        }
    }
}
