package DP.One_Dimensional.AAG_96_Unique_Binary_Search_Trees;

public class Recursive {
    public int numTrees(int n) {
        if(n==0 || n==1) return 1;

        int sum = 0;
        for(int i=1 ; i<=n ; i++){
            sum += numTrees(i-1) * numTrees(n-i);
        }

        return sum;
    }
}
