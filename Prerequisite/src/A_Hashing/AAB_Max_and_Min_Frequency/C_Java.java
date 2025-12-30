package A_Hashing.AAB_Max_and_Min_Frequency;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C_Java {
    public static void main(String[] args) {

        // IN
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Logic
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxiFreq = Integer.MIN_VALUE, maxiElement = arr[0];
        int miniFreq = Integer.MAX_VALUE, miniElement = arr[0];

        for(int i=0 ; i<n ; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        for(Map.Entry<Integer, Integer> num: map.entrySet()){
            if(num.getValue() >= maxiFreq){
                maxiFreq = num.getValue();
                maxiElement = num.getKey();
            }
            if (num.getValue() <= miniFreq){
                miniFreq = num.getValue();
                miniElement = num.getKey();
            }
        }

        System.out.println("Max frequency element: " + maxiElement + " with frequency: " + maxiFreq);
        System.out.println("Min frequency element: " + miniElement + " with frequency: " + miniFreq);

        // TC: O(n), SC: O(n)
    }
}
