class Solution
{
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H)
    {
        int s1 = (C - A) * (D - B);
        int s2 = (G - E) * (H - F);

        if (E >= C || G <= A || F >= D || H <= B) {
            return s1 + s2;
        }
        int x1 = Math.max(A, E);
        int x2 = Math.min(C, G);
        int y1 = Math.max(B, F);
        int y2 = Math.min(D, H);

        int s3 = (x2 - x1) * (y2 - y1);

        return s1 + s2 - s3;
    }
}
