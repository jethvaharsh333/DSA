// Time complexity: O(n); Space Complexity: O(n); OPTIMAL SOLUTION
class Solution3 {
    public int carFleet(int target, int[] position, int[] speed) {
        float[] time = new float[target + 1];
        
        for(int i=0 ; i<speed.length ; i++){
            time[position[i]] = (float)(target - position[i]) / speed[i];
        }
        
        int count = 0;
        float maxi = 0;
        for (int i=time.length-1 ; i>=0 ; i--){
            if(time[i] > maxi){
                count++;
                maxi = time[i];
            }
        }
      
        return count;
    }
}
