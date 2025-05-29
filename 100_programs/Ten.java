import java.util.*;

// PRIME NUMBER IN RANGE
public class Ten{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter range from: ");
		int a = sc.nextInt();
		System.out.println("Enter range to: ");
		int b = sc.nextInt();

		for(int i=a+1 ; i<b ; i++){
			if(i==0 || i==1){
				break;
			}

			int flag = 0;
			for(int j=2 ; j<i ; j++){
				if(i%j == 0){
					flag = 1;
					break;
				}
			}

			if(flag == 0){
				System.out.print(i + " ");
			}
		}
	}
}