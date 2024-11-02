// time complexity : O(n), space complexity : O(1)
class Solution1 {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;  // Initialize two pointers
        int leftMax = 0, rightMax = 0;  // Track max height from both ends
        int result = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                // If left height is less, water is trapped based on leftMax
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    result += leftMax - height[left];
                }
                left++;
            } else {
                // If right height is less, water is trapped based on rightMax
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    result += rightMax - height[right];
                }
                right--;
            }
        }

        return result;
    }
}
