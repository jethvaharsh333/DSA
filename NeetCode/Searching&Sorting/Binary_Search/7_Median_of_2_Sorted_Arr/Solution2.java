// Time complexity: O(log(min(n,m))); Space complexity: O(1); [OPTIMAL SOLUTION]
class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure that nums1 is the smaller array to optimize binary search
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;
        
        while (low <= high) {
            int partition1 = (low + high) / 2;
            int partition2 = (m + n + 1) / 2 - partition1;
            // System.out.println("---------------");
            // System.out.println(partition1+", "+partition2+" :: "+low+", "+high);
            
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];
            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];
            // System.out.println(maxLeft1+", "+minRight1+" :: "+maxLeft2+", "+minRight2);
            
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // System.out.println("1");
                if ((m + n) % 2 != 0) {
                    // System.out.println("insider");
                    return Math.max(maxLeft1, maxLeft2);
                }
                return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
            } else if (maxLeft1 > minRight2) {
                // System.out.println("2");
                high = partition1 - 1;
            } else {
                // System.out.println("3");
                low = partition1 + 1;
            }
        }
        
        throw new IllegalArgumentException("Input arrays are not sorted");
    }
}
