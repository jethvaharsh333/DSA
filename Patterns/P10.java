/*

Pattern:
Output

1    1
12   21
123  321
1234 4321
1234554321

*/

import java.util.*;

public class P10{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number: ");
		int n = sc.nextInt();

		for(int i=1 ; i<=n ; i++){
			for(int j=1 ; j<=i ; j++){
				System.out.print(j);
			}
			for(int k=n-i ; k>0 ; k--){
				System.out.print(' ');
			}
			for(int l=i ; l>0 ; l--){
				System.out.print(l);
			}
			System.out.println();
		}
	}
}