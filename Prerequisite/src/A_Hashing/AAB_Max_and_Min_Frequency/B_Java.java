package A_Hashing.AAB_Max_and_Min_Frequency;

import java.util.Scanner;

public class B_Java {
    public static void main(String[] args) {

        // Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }

        // Logic
        // *F: Max will be found but not the min because in hash arr all starts with 0 even the elements which aren't in the original array
        int maxElement = arr[0];
        int max = arr[0], maxFrequency = Integer.MIN_VALUE;
        int min = arr[0], minFrequency = Integer.MAX_VALUE;

        for(int i=0 ; i<n ; i++){
            int currElement = arr[i];

            if(currElement > maxElement){
                maxElement = currElement;
            }
        }

        int[] hash = new int[maxElement+1];
        for(int i=0 ; i<n ; i++){
            hash[arr[i]] = hash[arr[i]] + 1;
        }

        for(int i=0 ; i<maxElement ; i++){
            int currFrequency = hash[i];

            if(currFrequency > maxFrequency){
                maxFrequency = currFrequency;
                max = i;
            }

            if(currFrequency < minFrequency){
                minFrequency = currFrequency;
                min = i;
            }
        }

        System.out.println("Maximum Frequency:- Element is "+ max +", Frequency is " + maxFrequency);
        System.out.println("Minimum Frequency:- Element is "+ min +", Frequency is " + minFrequency);
    }
}
