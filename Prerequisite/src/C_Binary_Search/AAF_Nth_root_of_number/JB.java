package C_Binary_Search.AAF_Nth_root_of_number;

public class JB {
    public int nthRoot(int n, int m) {
        int left = 1, right = m;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(lessThanEqualToMidPowerN(mid, n, m)) left = mid;
            else right = mid;
        }

        return left;
    }

    private boolean lessThanEqualToMidPowerN(int mid, int n, int m) {
        long result = 1;

        for(int i=0 ; i<n ; i++){
            result *= mid;

            if(result > m){
                return false;   // mid^n already exceeded m & now we know the mid is on the right before ful computation
            }
        }

        return true; // mid^n ≤ m
    }
}