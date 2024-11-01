// Time Complexity: O(n)
class Solution1 {
    public int maxArea(int[] height) {
        int len=height.length;
        int fp=0, lp=len-1;
        int maxFilled = 0;
        
        while(fp<lp){
            int minHeightPtr = height[fp]>=height[lp] ? lp : fp;
            int currFilled = height[minHeightPtr]*(lp-fp);
            int flag = 0;

            if(minHeightPtr == fp){
                fp++; flag = 1;
            }else{
                lp--; flag = 1;
            }

            if(maxFilled < currFilled){
                maxFilled = currFilled;
            }
        
            if(flag == 0){
                break;
            }
        }

        return maxFilled;
    }
}
