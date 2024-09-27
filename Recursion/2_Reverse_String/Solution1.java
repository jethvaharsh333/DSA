// 0ms, 49.25MB

class Solution1 {
    public void reverseString(char[] s) {
        int start=0, end=s.length-1;
        char tmp = s[start];
        while(start < end){
            tmp = s[start];
            s[start] = s[end];
            s[end]=tmp;
            start++;
            end--;
        }
    }
}
