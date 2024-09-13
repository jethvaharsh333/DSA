// 1094 ms

class Solution6 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        int pse, nse; 
        for(int i=0 ; i<heights.length ; i++){
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                int curr = heights[stack.pop()];
                nse = i;
                pse = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, curr*(nse-pse-1));
                System.out.println(maxArea);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int curr = heights[stack.pop()];
            nse = heights.length;
            pse = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, curr*(nse-pse-1));
            System.out.println(maxArea);
        }
        return maxArea;
    }
}
