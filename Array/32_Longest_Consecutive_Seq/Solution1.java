// O(n)
class Solution1 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        
        // populating set
        for(int x: nums) set.add(x);

        int longest = 0;
        for(int num: nums){
            if(!set.contains(num-1)){
                int length = 1;
                int currentNum = num;
                while(set.contains(currentNum+1)){
                    currentNum++;
                    length++;
                }
                longest = Math.max(length,longest);
            }
        }

        return longest;
    }
}
