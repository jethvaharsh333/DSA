// Time complexity: O(n); Space Complexity: O(n); OPTIMAL SOLUTION
class Solution3 {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        int[] mono = new int[n];
        int top = -1;

        for(int i=0 ; i<n ; i++){
            while (top >= 0 && temperatures[i] > temperatures[mono[top]]) {
                result[mono[top]] = i - mono[top];
                top--;
            }

            mono[++top] = i;
        }

        return result;
    }
}
