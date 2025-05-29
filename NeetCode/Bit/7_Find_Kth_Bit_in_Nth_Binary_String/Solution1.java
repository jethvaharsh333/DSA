// Time Complexity: O(2^n), Space Complexity: O(2^n)

class Solution1 {
    public char findKthBit(int n, int k) {
        StringBuilder s = new StringBuilder("0");

        for(int i=1 ; i<n ; i++){
            StringBuilder rev = new StringBuilder(s).reverse();

            for(int j=0 ; j<rev.length() ; j++){
                rev.setCharAt(j, rev.charAt(j) == '0' ? '1' : '0');
            }

            s.append("1").append(rev);
        }

        return s.charAt(k-1);
    }
}
