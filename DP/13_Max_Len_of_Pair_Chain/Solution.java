// Time complexity: O(n²), Space complexity: O(n)

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0]-b[0]);

        int len = pairs.length;

        int[] li = new int[len];
        Arrays.fill(li, 1);

        int maxLen = 1;

        for(int i=1 ; i<len ; i++){
            for(int prev=0 ; prev<i ; prev++){
                if(pairs[prev][1] < pairs[i][0]){
                    li[i] = Math.max(li[i], 1+li[prev]);
                }
            }
            if(li[i] > maxLen){
                maxLen = li[i];
            }
        }

        return maxLen;
    }
}
