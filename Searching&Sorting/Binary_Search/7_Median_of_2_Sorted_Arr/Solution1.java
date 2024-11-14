// Time complexity: O(n+m); Space complexity: O(n+m);
class Solution1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        
        int[] arr = new int[len];
        
        int p1=0, p2=0;
        int i=0;
        
        while(p1<nums1.length && p2<nums2.length){
            if(nums1[p1] >= nums2[p2]){
                arr[i++] = nums2[p2++];
            }
            else{
                arr[i++] = nums1[p1++];
            }
        }

        while(p1<nums1.length){
            arr[i++] = nums1[p1++];
        }

        while(p2<nums2.length){
            arr[i++] = nums2[p2++];
        }
        
        if(len%2 != 0){
            return arr[len/2];
        }
        else {
            return (arr[len/2-1] + arr[len/2])/2.0;
        }
    }
}
