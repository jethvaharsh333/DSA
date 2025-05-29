/*

Pattern:
11111
10001
10001
10001
11111

*/

import java.util.*;

public class P1{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number: ");
		int n = sc.nextInt();

		for(int i=0 ; i<n ; i++){
			for(int j=0 ; j<n ; j++){
				if(i==0 || i==n-1){
					System.out.print(1);
				}else{
					if(j==0 || j==n-1){
						System.out.print(1);
					}else{
						System.out.print(0);
					}
				}
			}
			System.out.println();
		}
	}
}