试试 HashMap

import java.util.ArrayList;
import java.util.Iterator;

class Solution
{
    public int[] shortestToChar(String S, char C)
    {
        int[] dist = new int[S.length()];
        ArrayList<Integer> location = new ArrayList<>();
        for(int i=0; i<S.length(); i++)
        {
            if(S.charAt(i) == C)
            {
                location.add(i);
            }

        }
        for(int j=0; j<S.length(); j++)
        {
            dist[j] = Math.abs(location.get(0)-j);
        }
        int distTmp = 0;
        for(int j=0; j<S.length(); j++)
        {
            for (int k=0; k<location.size(); k++)
            {
                distTmp = Math.abs(location.get(k)-j);
                if(dist[j]>distTmp)
                {
                    dist[j] = distTmp;
                }
            }

        }
        return dist;
    }
}
