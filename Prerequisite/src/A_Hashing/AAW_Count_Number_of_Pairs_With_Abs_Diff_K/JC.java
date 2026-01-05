package A_Hashing.AAW_Count_Number_of_Pairs_With_Abs_Diff_K;

public class JC {
    public int countKDifference(int[] nums, int k) {
        int count = 0;
        int[] arr = new int[101];

        for(int d : nums){
            arr[d]++;
        }

        for(int i= 0; i<101 - k; i++){
            count += arr[i] * arr[k + i];
        }

        return count;
    }
}
