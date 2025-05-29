class Solution {
    public int nextGreaterElement(int n) {
        char[] c = Integer.toString(n).toCharArray();
        
        int i = c.length-2;
        while(i>=0 && c[i] >= c[i+1]){
            i--;
        }

        if(i == -1){
            return -1;
        }

        int j = c.length-1;
        while(c[i] >= c[j]){
            j--;
        }

        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;

        reverse(c, i + 1, c.length - 1);
        // for(int x = i+1; x<((i+1)+c.length)/2; x++) {
        //     char y = c[x];
        //     c[x] = c[c.length-x-1];
        //     c[c.length-x-1] = y;
        // }

        long result = Long.parseLong(new String(c));
        return (result <= Integer.MAX_VALUE) ? (int) result : -1;
    }

    private void reverse(char[] c, int start, int end) {
        while (start < end) {
            char temp = c[start];
            c[start] = c[end];
            c[end] = temp;
            start++;
            end--;
        }
    }
}

/**
 * class Solution {
 * public int nextGreaterElement(int n) {
 * char[] s = Integer.toString(n).toCharArray();
 * int len = s.length;
 * char first = s[0];
 * if(len == 1){
 * return -1;
 * }
 * else if(len == 2){
 * int temp = n%10;
 * if(n%10 > n/10){
 * return ((n%10)*10)+(n/10);
 * }
 * else{
 * return -1;
 * }
 * }
 * for (int i=1; i<len-1; i++) {
 * char curr = s[i];
 * char next = s[i+1];
 * if(s[i] > first){
 * char temp = s[i];
 * s[i] = first;
 * s[0] = temp;
 * break;
 * }
 * else if(s[i] < next){
 * char temp = s[i];
 * s[i] = s[i+1];
 * s[i+1] = temp;
 * break;
 * }
 * }
 * long result = Long.parseLong(new String(s));
 * return (result > Integer.MAX_VALUE) ? -1 : (int) result;
 * }
 * }
 */