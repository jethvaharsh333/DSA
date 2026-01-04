package A_Hashing.AAO_Min_Steps_to_All_Elements_Equal;

import java.util.Scanner;

public class JA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] boxInPiles = new int[n];
        for(int i=0 ; i<n ; i++){
            boxInPiles[i] = sc.nextInt();
        }

        int steps = stepsToRemovePiles(boxInPiles);
        System.out.println(steps);
    }

    private static int stepsToRemovePiles(int[] boxInPiles){
        int n = boxInPiles.length;
        int steps = 0;

        while(true){
            int largest = Integer.MIN_VALUE;
            int secondLargest = Integer.MIN_VALUE;
            int largestIndex = -1;

            for(int i=0 ; i<n ; i++){
                if(boxInPiles[i] > largest){
                    secondLargest = largest;
                    largest = boxInPiles[i];
                    largestIndex = i;
                } else if(boxInPiles[i] > secondLargest){
                    secondLargest = boxInPiles[i];
                }
            }

            if(largest == secondLargest) break;

            boxInPiles[largestIndex] = secondLargest;
            steps += 1;
        }

        return steps;
    }
}
