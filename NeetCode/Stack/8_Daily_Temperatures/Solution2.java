// Time complexity: O(n); Space Complexity: O(n)
class Solution2 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] arr = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0 ; i<temperatures.length ; i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int prevDay = stack.pop();
                arr[prevDay] = i-prevDay;
            }

            stack.push(i);
        }

        return arr;
    }
}
