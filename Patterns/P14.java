/*

Pattern: PASCAL'S TRIANGLE
    1
   1 1
  1 2 1
 1 3 3 1
1 4 6 4 1

*/

import java.util.*;

public class P14{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number: ");
		int n = sc.nextInt();

        for (int i=0 ; i<n ; i++){
            
            for(int j=0 ; j<n-i-1 ; j++){
                System.out.print(" ");
            }

            int number = 1;
            for (int k=0 ; k<=i ; k++){
                System.out.print(number + " ");
                number = number * (i-k)/(k+1);
            }

            System.out.println();
        }

	}
}