class Solution2 {
    public void reverseString(char[] s) {
        int len = s.length;
        reverse(0,s.length,s);
    }

    public void reverse(int index, int length, char[] c){
       if (index >= length/2){
            return;
        }

        char temp = c[index];
        c[index] = c[length-index-1];
        c[length-index-1] = temp;

        reverse(index+1, length, c);
    }
}
