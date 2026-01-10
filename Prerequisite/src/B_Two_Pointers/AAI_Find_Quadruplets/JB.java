package B_Two_Pointers.AAI_Find_Quadruplets;

public class JB {
    private static int findQuadruplets(int[] nums, int k1, int k2) {
        int n = nums.length;
        int count = 0;

        for(int i=0 ; i<n-3 ; i++){
            for(int j=i+1 ; j<n-2 ; j++){
                if(nums[i]+nums[j] <= k1) continue;

                int k = j+1;
                int l = n-1;

                while(k < l){
                    if(nums[k]+nums[l] > k2){
                        count += (l - k); // all pairs (k, k+1...l-1)
                        l--;
                    }
                    else{
                        k++;
                    }
                }
            }
        }

        return count;
    }
}
