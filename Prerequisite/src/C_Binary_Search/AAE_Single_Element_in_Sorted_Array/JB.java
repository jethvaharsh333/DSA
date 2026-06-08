package C_Binary_Search.AAE_Single_Element_in_Sorted_Array;

public class JB {
    public int singleNonDuplicate(int[] nums) {
        int ans = 0;

        for(int x: nums){
            ans ^= x;
        }

        return ans;
    }
}
