class Solution {
    public String getPermutation(int n, int k){
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        k = k-1;

        StringBuilder result = new StringBuilder();

        for (int i=0; i<n ; i++){
            int fact = factorial(n-1-i);
            int index = k/fact;
            result.append(numbers.get(index));
            numbers.remove(index);
            k %= fact;
        }

        return result.toString();
    }

    private int factorial(int num){
        if (num == 0) return 1;
        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }
}
