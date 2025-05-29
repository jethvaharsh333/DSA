// O(n), 2ms [OPTIMAL SOLUTION]
class Solution1 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len];

        arr[0] = 1;
        for(int i=1 ; i<len ; i++){
            arr[i] = arr[i-1]*nums[i-1];
        }

        int temp = 1;
        for(int i=len-1 ; i>=0 ; i--){
            arr[i] *= temp;
            temp *= nums[i];
        }

        return arr;
    }
}
