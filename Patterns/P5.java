/*

Pattern:
12345
23455
34555
45555
55555

*/

import java.util.*;

public class P5{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number: ");
		int n = sc.nextInt();

		int x = 0;

		for(int i=0 ; i<n ; i++){
			for(int j=0 ; j<n ; j++){
				if(j+x+1 > n){
					System.out.print(n);
				}else{
					System.out.print(j+x+1);
				}
			}
			x++;
			System.out.println();
		}
	}
}