import java.util.*;

// FACTORS
public class ThreeA{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter number: ");
		int num = sc.nextInt();

		int i=1;

		List<Integer> list = new ArrayList<Integer>();

		while(i<=num){
			if(num%i == 0)
				list.add(i);
			i++;
		}

		// System.out.println(list);

		int[] arr = list.stream().mapToInt(x -> x).toArray();

        for (int obj : arr)
            System.out.print(obj + " ");
	}
}