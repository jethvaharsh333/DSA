// Time Complexity: O(n), Space Complexity: O(n)
class Solution1 {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int x: nums){
            if(set.contains(x)){
                return x;
            }
            set.add(x);
        }

        return -1;
    }
}
