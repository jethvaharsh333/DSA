/*

Pattern:
1
2  6
3  7  10
4  8  11 13
5  9  12 14 15

1
2 9 
3 8 10
4 7 11 14
5 6 12 13 15

*/

import java.util.*;

public class P13{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number: ");
		int n = sc.nextInt();

		for(int i=1 ; i<=n ; i++){
			int diff = n-1; //4
			int val = i; //1,2,3,4,5

			for(int j=1 ; j<=i ; j++){
				System.out.print(val+"\t");

				val += diff;
				diff -= 1; 
			}

			System.out.println();
		}
	}
}