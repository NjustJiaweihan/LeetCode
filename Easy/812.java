class Solution
{
    public double largestTriangleArea(int[][] points)
    {
        double areamax = 0;
        double areatemp = 0;
        for(int i=0; i<points.length; i++)
        {
            for (int j=i+1; j<points.length; j++)
            {
                for(int k=j+1; k<points.length; k++)
                {
                    //S=(1/2)*(x1y2+x2y3+x3y1-x1y3-x2y1-x3y2)
                    areatemp = Math.abs(0.5*(points[i][0]*points[j][1]
                            +points[j][0]*points[k][1]
                            +points[k][0]*points[i][1]
                            -points[i][0]*points[k][1]
                            -points[j][0]*points[i][1]
                            -points[k][0]*points[j][1]));
                    if(areatemp > areamax)
                    {
                        areamax = areatemp;
                    }
                }
            }
        }
        return areamax;
    }
}
