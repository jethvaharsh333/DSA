// time complexity : O(n), space complexity : O(n)
class Solution1 {
    public int trap(int[] height) {
        int len = height.length;
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < len; i++) {
            // Process bars to calculate trapped water
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                
                // If stack is empty after popping, break as no left boundary exists
                if (stack.isEmpty()) break;
                
                int distance = i - stack.peek() - 1;  // Calculate width of water area
                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[top];  // Height of water
                result += distance * boundedHeight;  // Add trapped water
            }
            
            // Push current index to stack
            stack.push(i);
        }

        return result;
    }
}
