package A_Hashing.ABA_Max_No_of_Subsequences_After_1_Inserting;

public class JA {
    public long numOfSubsequences(String s) {
        int n = s.length();

        long countLCT = 0;
        long l=0, lc=0;

        long[] preL = new long[n+1];
        long[] preLC = new long[n+1];

        for(int i=0 ; i<n ; i++){
            char curr = s.charAt(i);

            if(curr == 'L') l++;
            else if(curr == 'C') lc += l;
            else if(curr == 'T') countLCT += lc;

            preL[i+1] = l;
            preLC[i+1] = lc;
        }

        long t=0, ct=0;

        long[] sufT = new long[n+2];
        long[] sufCT = new long[n+2];

        for(int i=n-1 ; i>=0 ; i--){
            char curr = s.charAt(i);

            if(curr == 'T') t++;
            else if(curr == 'C') ct += t;

            sufT[i+1] = t;
            sufCT[i+1] = ct;
        }

        long answer1 = countLCT + sufCT[1];
        long answer2 = preLC[n] + countLCT;

        long answer3 = 0L;
        for(int i=1 ; i<=n ; i++){
            answer3 = Math.max(answer3, preL[i]*sufT[i+1]);
        }
        answer3 += countLCT;

        return Math.max(answer1, Math.max(answer2, answer3));
    }
}
