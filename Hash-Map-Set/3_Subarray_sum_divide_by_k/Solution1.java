// 26ms, Beats 27.25%
class Solution1 {
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0, rem = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        map.put(0,1);

        for(int i=0 ; i<nums.length ; i++){
            sum += nums[i];
            rem = sum%k;

            if (rem < 0) {
                rem += k;
            }

            if(map.containsKey(rem)){
                count += map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem, 0)+1);
        }

        return count;
    }
}
