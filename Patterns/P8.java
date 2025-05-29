/*

Pattern:
56789
4567
345
23
1

*/

import java.util.*;

public class P8{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number: ");
		int n = sc.nextInt();

		for(int i=0 ; i<n ; i++){
			int count = n-i;
			for(int j=i ; j<n ; j++){
				System.out.print(count);
				count++;
			}
			System.out.println();
		}
	}
}