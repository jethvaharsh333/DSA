// https://leetcode.com/problems/single-number/
class DayTen {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int x: nums){
            ans ^= x;
        }
        return ans;
    }
}