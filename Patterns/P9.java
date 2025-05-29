/*

Pattern:
1
121
12321
1234321
123454321

*/

import java.util.*;

public class P9{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number: ");
		int n = sc.nextInt();

		for(int i=1 ; i<=n ; i++){
			for(int j=1 ; j<i ; j++){
				System.out.print(j);
			}
			System.out.print(i);
			for(int k=i-1 ; k>0 ; k--){
				System.out.print(k);
			}
			System.out.println();
		}
	}
}