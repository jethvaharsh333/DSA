/*

Pattern:
10001
01010
00100
01010
10001

*/

import java.util.*;

public class P4{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number: ");
		int n = sc.nextInt();

		int l=0, r=n-1;

		for(int i=0 ; i<n ; i++){
			for(int j=0 ; j<n ; j++){
				if(j==l || j==r){
					System.out.print(1);
				}
				else{
					System.out.print(0);
				}
			}
			l++; r--;
			System.out.println();
		}
		
	}
}