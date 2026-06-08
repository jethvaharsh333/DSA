package C_Binary_Search.AAE_Single_Element_in_Sorted_Array;

public class JA {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int left=0, right=nums.length-1;

        while(left < right){            // Handles the single array length test cases like: [1]
            int mid = left + (right-left)/2;

            // make mid even
            if(mid%2 != 0) mid--;

            if(nums[mid] == nums[mid+1]){
                // single element is on right
                left = mid+2;
            }else{
                // single is on the left (or mid itself)
                // We are trying to make left = right, so while condition fails and return it.
                // [1,1,2,2,3]
                right = mid;
            }
        }

        return nums[left];
    }
}
