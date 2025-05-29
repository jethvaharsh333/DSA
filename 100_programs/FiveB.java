import java.util.*;

// SUMMATION
public class FiveB{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter number: ");
		int num = sc.nextInt();

		int ans = summationOfDigits(num);

		System.out.println(ans);
	}

	public static int summationOfDigits(int num){
		if(num<=0){
			return num;
		}

		return (num%10)+summationOfDigits(num/10);
	}
}