// TIME COMPLEXITY: O(nlogn), SPACE COMPLEXITY: O(1), Beats: 100% but not optimal as compared to Solution1.java
class Solution2 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int curSum;
        while(left <= right){
            curSum = numbers[left] + numbers[right];
            if(curSum == target){
                return new int[]{left+1, right+1};
            }
            if(curSum < target){
                int index = Arrays.binarySearch(numbers, left + 1, right -1, target-numbers[right]);
                index = index > 0 ? index : Math.abs(index) - 1;
                left = index > left ? index : left + 1;
            }
            else{
                int index = Arrays.binarySearch(numbers, left + 1, right -1, target - numbers[left]);
                index = index > 0 ? index : Math.abs(index) - 1;
                right = index < right ? index : right - 1;
            }
        }
        return null;
    }
}
