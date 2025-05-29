/*

Pattern:
1       1
 2     2
  3   3
   4 4
    5
   4 4			=> 1 (n-i)=1
  3   3			=> 3 (n-i)=2 + 2
 2     2 		=> 5 (n-i)=3
1       1

*/

import java.util.*;

public class P12{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number: ");
		int n = sc.nextInt();

		for(int i=1 ; i<=n ; i++){
			for(int j=1 ; j<i ; j++){
				System.out.print(' ');
			}

			System.out.print(i);

			int sp = (n-i)*2 - 1;
			for(int k=1 ; k<=sp ; k++){
				System.out.print(' ');
			}

			if(i!=n){
				System.out.print(i);
			}

			System.out.println();
		}

		for(int i=n-1 ; i>0 ; i--){
			for(int j=1 ; j<i ; j++){
				System.out.print(' ');
			}

			System.out.print(i);

			int sp =(n-i)*2-1;
			for(int k=1 ; k<=sp ; k++){
				System.out.print(' ');
			}

			System.out.print(i);

			System.out.println();
		}

		
	}
}