package B_Two_Pointers.AAH_Get_Score_Diff;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> li = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            int ele = sc.nextInt();
            li.add(ele);
        }

        System.out.println(getScoreDifference(li));
    }

    /*
    * n=5, [3,6,2,3,5]
    *
    * i=0, j=4, false, [3,6,2,3,5]
    * A: 0, B: 0
    *
    * i=1, j=4, false, [6,2,3,5]
    * A: 3, B: 0
    *
    * i=2, j=4, true, [5,3,2]
    * A: 3, B: 6
     * */

    private static int getScoreDifference(List<Integer> numSeq){
        int n = numSeq.size();

        int score_a=0, score_b=0;
        int i=0, j=n-1;

        boolean pointerSwitch = false;
        boolean playerSwitch = false;

        while(i <= j){
            if(!pointerSwitch){
                int curr = numSeq.get(i);
                if(!playerSwitch){
                    score_a += curr;
                }else{
                    score_b += curr;
                }
                if(curr%2 == 0) pointerSwitch = true;
                i++;
            }else{
                int curr = numSeq.get(j);
                if(!playerSwitch){
                    score_a += curr;
                }else{
                    score_b += curr;
                }
                if(curr%2 == 0) pointerSwitch = false;
                j--;
            }

            playerSwitch = !playerSwitch;
        }

        return score_a-score_b;
    }
}
