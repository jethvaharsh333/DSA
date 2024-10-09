// 2 ms, Beats 100.00% 
class Solution3 {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length, x =0, s= 0, count = 0;
        int [] arr = new int[k];
        for(int i : nums) {
        s += i;
            x = s % k;
            if (x<0) x += k;
            arr[x]++;
        }
        for (int i=0;i<k; i++)
        if (arr[i]> 1) count += (arr [i] * (arr [i]-1)) >> 1;
        count +=arr[0];
        return count;
    }
}
