/*

Pattern:
1
11
101
1001
11111

*/

import java.util.*;

public class P7{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number: ");
		int n = sc.nextInt();

		for(int i=1 ; i<=n ; i++){
			for(int j=1 ; j<=i ; j++){
				if(i==1 || i==n || j==1 || j==i){
	                System.out.print(1);
	            }else{
	                System.out.print(0);
	            }
			}
			System.out.println();
		}
	}
}