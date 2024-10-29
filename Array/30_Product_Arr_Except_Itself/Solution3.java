// O(n), 2ms
// Through division
class Solution3 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int totalProduct = 1;
        int zeroCount = 0;

        for (int num : nums) {
            if (num != 0) {
                totalProduct *= num;
            } else {
                zeroCount++;
            }
        }

        if (zeroCount > 1) {
            return answer;
        }


        for (int i = 0; i < n; i++) {
            if (zeroCount == 1) {
                answer[i] = (nums[i] == 0) ? totalProduct : 0;
            } else {
                answer[i] = totalProduct / nums[i];
            }
        }

        return answer;
    }
}
