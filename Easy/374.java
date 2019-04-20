class Solution  extends GuessGame{
    public int guessNumber(int n) {
        if(n < 1)
        {
            return -1;
        }
        int lo = 1;
        int hi = n;

        while(lo <= hi)
        {
            int myGuess = lo + (hi - lo) / 2;

            if(guess(myGuess) == 1)
            {
                lo = myGuess + 1;
            }
            else if(guess(myGuess) == -1)
            {
                hi = myGuess - 1;
            }
            else
            {
                return myGuess;
            }
        }
        return -1;
    }
    // public int guess(int nums)
    // {
    //     if(nums == 7)
    //     {
    //         return 0;
    //     }
    //     else if(nums > 7)
    //     {
    //         return 1;
    //     }
    //     else
    //     {
    //         return -1;
    //     }
    // }
}
