import java.util.*;

// SUM OF EVEN AND ODD
public class Eight{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter number: ");
		int num = sc.nextInt();

		int even_count=0, odd_count=0;

		while(num > 0){
			int rem = num%10;

			if(rem%2 == 0){
				even_count += rem;
			}else{
				odd_count += rem;
			}


			num /= 10;
		}

		System.out.println(even_count+" "+odd_count);
	}
}