// Time complexity: O(n^2); Space complexity: O(n); OPTIMAL SOLUTION
class Solution2 {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        for(int i=1 ; i<=n ; i++){
            numbers.add(i);
        }

        int[] fact = new int[n];
        fact[0] = 1;
        for(int i=1 ; i<n ; i++){
            fact[i] = fact[i-1] * i;
        }

        k--;

        StringBuilder result = new StringBuilder();
        for(int i=n ; i>0 ; i--){
            int idx = k/fact[i-1];
            result.append(numbers.get(idx));
            numbers.remove(idx);
            k %= fact[i-1];
        }

        return result.toString();
    }
}
