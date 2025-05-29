// Time complexity: O(n^n), Space complexity: O(n)

class Solution1 {
    public int jump(int[] nums) {
        return calcSteps(0, nums, 0);
    }

    private int calcSteps(int index, int[] nums, int steps){
        if(index>=nums.length-1){
            return steps;
        }

        int val = nums[index];
        int min = Integer.MAX_VALUE;

        for(int i=index+1 ; i<=index+val  && i < nums.length ; i++){
            min = Math.min(min, calcSteps(i, nums, steps+1));
        }

        return min;
    }
}
