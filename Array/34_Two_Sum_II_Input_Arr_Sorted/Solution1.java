// TIME COMPLEXITY: O(n), SPACE COMPLEXITY: O(1)
class Solution1 {
    public int[] twoSum(int[] numbers, int target) {
        int lp=0, rp=numbers.length-1;
        int curr;

        while(lp<rp){
            curr=numbers[lp]+numbers[rp];
            if(curr==target){
                return new int[]{lp+1,rp+1};
            }
            if(curr>target){
                rp--;
            }
            else{
                lp++;
            }
        }

        return new int[]{-1,-1};
    }
}
