package DP.One_Dimensional.AAF_91_Decode_Ways;

public class Recursive {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0') return 0;

        return recurse(0, s);
    }

    private int recurse(int index, String s){
        int n = s.length();

        if(index == n) return 1;

        if(s.charAt(index) == '0') return 0;

        int ways = recurse(index+1, s);

        if(index+1 < n){
            int twoDigitNum = (s.charAt(index)-'0')*10 + s.charAt(index+1)-'0';
            if(twoDigitNum >= 10 && twoDigitNum <= 26) ways += recurse(index+2, s);
        }

        return ways;
    }
}
