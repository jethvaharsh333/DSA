package B_Two_Pointers.AAG_Longest_Substring_CharPairs_Diff_LessEqual_k;

import java.util.ArrayDeque;
import java.util.Deque;

public class JA {
    public int longestSubstring(String s, int k) {
        int n = s.length();

        int maxLen = 0;
        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();

        int l = 0;
        for(int r=0 ; r<n ; r++){
            while(!minDeque.isEmpty() && s.charAt(minDeque.peekLast()) > s.charAt(r)) minDeque.pollLast();
            minDeque.addLast(r);

            while(!maxDeque.isEmpty() && s.charAt(maxDeque.peekLast()) < s.charAt(r)) maxDeque.pollLast();
            maxDeque.addLast(r);

            while(s.charAt(maxDeque.peekFirst()) - s.charAt(minDeque.peekFirst()) > k){
                if(minDeque.peekFirst() == l) minDeque.pollFirst();
                if(maxDeque.peekFirst() == l) maxDeque.pollFirst();

                l++;
            }

            maxLen = Math.max(maxLen, r-l+1);
        }

        return maxLen;
    }
}
