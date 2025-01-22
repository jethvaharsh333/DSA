// Time complexity: O(n), Space complexity: O(1)

class Solution4 {
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n+1];

        for(int i=1 ; i<m+1 ; i++){
            int[] curr = new int[n+1];

            for(int j=0 ; j<n+1 ; j++){
                if(i==0 || j==0){
                    curr[j] = 0;
                }else if(i==1 && j==1){
                    curr[j] = 1;
                }else{
                    curr[j] = prev[j] + curr[j-1];
                }
            }    

            prev = curr;
        }

        return prev[n];
    }
}
