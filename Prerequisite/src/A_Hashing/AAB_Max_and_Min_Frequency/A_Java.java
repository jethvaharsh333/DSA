package A_Hashing.AAB_Max_and_Min_Frequency;

import java.util.Scanner;

public class A_Java {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int maxElement = 0, maxCount = 0, minElement = 0, minCount = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    cnt++;
                }
            }

            if (maxCount < cnt) {
                maxCount = cnt;
                maxElement = arr[i];
            }

            if (minCount > cnt) {
                minCount = cnt;
                minElement = arr[i];
            }
        }

        System.out.println("Max Element: " + maxElement + ", Max Count: " + maxCount);
        System.out.println("Min Element: " + minElement + ", Min Count: " + minCount);

        // TC: O(n^2), SC: O(1)
    }
}
