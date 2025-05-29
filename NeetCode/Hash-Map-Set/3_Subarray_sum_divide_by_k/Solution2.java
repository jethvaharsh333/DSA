// 4 ms , Beats 89.30%
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int res = 0;
        int prefix = 0;
        int[] map = new int[k];
        map[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i] % k + k) % k;
            res += map[prefix];
            map[prefix]++;
        }
        return res;
    }
}
