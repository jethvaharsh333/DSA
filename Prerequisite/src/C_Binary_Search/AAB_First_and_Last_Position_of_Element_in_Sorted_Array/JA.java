package C_Binary_Search.AAB_First_and_Last_Position_of_Element_in_Sorted_Array;

public class JA {
    public int[] searchRange(int[] nums, int target) {
        int firstOccurrence = findFirstOccurrence(nums, target);
        int lastOccurrence = findLastOccurrence(nums, target);

        return new int[]{firstOccurrence, lastOccurrence};
    }

    private int findFirstOccurrence(int[] nums, int target){
        int firstOccurrence = -1;
        int left=0, right=nums.length-1;

        while(left <= right){
            int mid = left + (right-left)/2;

            if(nums[mid] < target){
                left = mid+1;
            }
            else if(nums[mid] > target){
                right = mid-1;
            }
            else{
                firstOccurrence = mid;
                right = mid-1;
            }
        }

        return firstOccurrence;
    }

    private int findLastOccurrence(int[] nums, int target){
        int lastOccurrence = -1;
        int left=0, right=nums.length-1;

        while(left <= right){
            int mid = left + (right-left)/2;

            if(nums[mid] < target){
                left = mid+1;
            }
            else if(nums[mid] > target){
                right = mid-1;
            }
            else{
                lastOccurrence = mid;
                left = mid+1;
            }
        }

        return lastOccurrence;
    }
}
