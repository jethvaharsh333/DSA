// Time complexity: O(n*MaxPile); Space complexity: O(1)
class Solution1 {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for(int pile : piles){
            maxPile = Math.max(maxPile, pile);
        }
        
        int ans = -1;
        for(int i=1 ; i<=maxPile ; i++){
            ans = evaluateNBPH(piles, i);
            // System.out.println("ans :: "+ans+" :: "+maxPile+","+i);
            if(ans <= h){
                return i;
            }
        }

        return ans;
    }

    private int evaluateNBPH(int[] piles, int x){
        int bananas = 0;
        for(int pile : piles){
            bananas += (pile+x-1)/x;
        }
        // System.out.println("bananas :: "+bananas);

        return bananas;
    }
}
