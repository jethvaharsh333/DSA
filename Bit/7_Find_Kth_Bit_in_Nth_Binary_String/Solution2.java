// Time Complexity: O(n), Space Complexity: O(1)

class Solution2 {
    public char findKthBit(int n, int k) {
        return findKth(n, k);
    }

    private char findKth(int n, int k) {
        if(n == 1) return '0';
        
        int mid = (1<<(n-1));
        
        if(k == mid) return '1';
        if(k < mid) return findKth(n - 1, k);
        
        return invert(findKth(n-1, 2*mid-k)); 
    }

    private char invert(char c) {
        return (c == '0') ? '1' : '0';
    }
}
