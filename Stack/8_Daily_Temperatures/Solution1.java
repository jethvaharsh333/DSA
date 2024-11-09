// Time complexity: O(n^2); Space Complexity: O(n)
class Solution1 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] arr = new int[temperatures.length];

        for(int i=0 ; i<temperatures.length ; i++){
            for(int j=i+1 ; j<temperatures.length ; j++){
                if(temperatures[i] < temperatures[j]){
                    arr[i] = j-i; break;
                }
            }
        }

        return arr;
    }
}
