import java.util.*;

// ODD OR EVEN WITH MODULO
public class Nine{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter number: ");
		int num = sc.nextInt();

		int ans = num & 1;

		if(ans == 0){
			System.out.println("EVEN");
		}
		else{
			System.out.println("ODD");
		}
	}
}