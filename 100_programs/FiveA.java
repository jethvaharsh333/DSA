import java.util.*;

// SUMMATION
public class FiveA{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter number: ");
		int num = sc.nextInt();

		int sum = 0;

		while(num>0){
			int lastDigit = num%10;
			sum += lastDigit;
			num /= 10;
		}

		System.out.println(sum);
	}
}