/*

Pattern:
11111
11111
11011
11111
11111

*/

import java.util.*;

public class P2{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number: ");
		int n = sc.nextInt();

		int middle = n/2;

		for(int i=0 ; i<n ; i++){
			for(int j=0 ; j<n ; j++){
				if(i==middle && j==middle){
					System.out.print(0);
				}else{
					System.out.print(1);
				}
			}
			System.out.println();
		}
	}
}