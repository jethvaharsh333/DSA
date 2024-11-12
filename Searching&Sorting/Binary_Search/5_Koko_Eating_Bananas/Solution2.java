// Time complexity: O(n*log(MaxPile)); Space complexity: O(1); OPTIMAL SOLUTION
class Solution2 {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for(int pile : piles){
            maxPile = Math.max(maxPile, pile);
        }
        
        int ans = maxPile;
        int left=1, right=maxPile;

        while(left <= right){
            int mid = left + (right-left)/2;
            int evaluatedHours = evaluateHours(piles, mid, h);
            
            if(evaluatedHours <= h){
                ans = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        return ans;
    }

    private int evaluateHours(int[] piles, int x, int h){
        int hours = 0;
        for(int pile : piles){
            hours += (pile+x-1)/x;  //(int)Math.ceil(pile/x);
            if(hours > h){          //Early exit if hours exceed h
                return Integer.MAX_VALUE;
            }
        }

        return hours;
    }
}
