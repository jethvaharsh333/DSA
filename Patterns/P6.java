/*

Pattern:
12345
23451
34521
45321
54321

*/

import java.util.*;

public class P6{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number: ");
		int n = sc.nextInt();

		for(int i=1 ; i<=n ; i++){
			for(int j=i ; j<=n ; j++){
				System.out.print(j);
			}
			for(int k=i-1 ; k>=1 ; k--){
				System.out.print(k);
			}
			System.out.println();
		}
	}
}