package C_Binary_Search.AAF_Nth_root_of_number;

public class JA {
    public int nthRoot(int n, int m) {
        int left=0, right=m;

        // O(log2(m))
        while(left <= right){
            int mid = left + (right-left)/2;
            double res = Math.pow(mid, n);

            if(res == m) return mid;
            else if(res > m) right = mid-1;
            else left = mid+1;
        }

        return -1;
    }
}
