class SearchInRotatedSortedArr {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,3};
		int targetint = 7;

        int ans = search(arr, targetint);

        System.out.println(ans);
    }

    static int search(int[] nums, int target) {
        int size = nums.length;
        int left = 0, right = size - 1;

        while (left <= right) {
            int mid = left + (right-left)/2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (nums[left]<=target && target<nums[mid]) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            } else {
                if (nums[mid]<target && target<=nums[right]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
        }

        return -1;
    }
}
