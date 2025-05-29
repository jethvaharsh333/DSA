// time complexity : O(n), space complexity : O(n)
class Solution1 {
    public int trap(int[] height) {
        int len = height.length;
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) break;
                int distance = i-stack.peek()-1; 
                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[top];
                result += distance*boundedHeight;
            }
            stack.push(i);
        }

        return result;
    }
}
