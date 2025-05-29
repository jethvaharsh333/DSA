// Time complexity: O(nlogn); Space Complexity: O(n)
class Solution2 {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Stack<Double> stack = new Stack<>();
        int[][] ps = new int[n][2];

        for(int i=0;i<n;i++){
            ps[i][0] = position[i];
            ps[i][1] = speed[i];
        }        

        Arrays.sort(ps,(a,b) -> b[0] - a[0]);

        for(int i = 0;i<n;i++){
            double currentCar = (target - ps[i][0])/ (double)ps[i][1];
            if(stack.isEmpty() || stack.peek() < currentCar){
                stack.push(currentCar);
            }
        }

        return stack.size();
    }
}
