import java.util.*;

// FACTORIAL
public class FourB{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter number: ");
		int num = sc.nextInt();

		int ans = factorial(num);

		System.out.println(ans);
	}

	public static int factorial(int num){
		if(num == 1){
			return 1;
		}

		return num*factorial(num-1);
	}
}