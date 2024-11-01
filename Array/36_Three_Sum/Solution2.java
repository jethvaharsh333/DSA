// O(n^2)
class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        HashSet<List<Integer>> uniqueTriplets = new HashSet<>();

        for(int i=0 ; i<len ; i++){
            HashSet<Integer> hs = new HashSet<>();
            for(int j=i+1 ; j<len ; j++){
                int x = (-(nums[i]+nums[j]));
                if(hs.contains(x)){
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], x);
                    triplet.sort(null);
                    uniqueTriplets.add(triplet);
                }
                hs.add(nums[j]);
            }
        }
        result.addAll(uniqueTriplets);
        return result;
    }
}
