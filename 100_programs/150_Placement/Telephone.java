import java.util.*;

public class Telephone{
	public static final String[] t = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter size of array: ");
		int n = sc.nextInt();

		int[] arr = new int[n];
		for(int i=0 ; i<n ; i++){
			System.out.print("Enter element " + (i+1) + ": ");
			arr[i] = sc.nextInt();
		}

		if(n == 0){
			return;
		}

		List<String> result = new ArrayList<>();
		recurse(arr, 0, "", result);

		for(int i=0 ; i<result.size() ; i++){
			System.out.print(result.get(i) + " ");
		}

		return;
	}

	public static void recurse(int[] arr, int index, String s, List<String> result){
		if(index == arr.length){
			result.add(s);
			return;
		}

		for(char ch: t[arr[index]].toCharArray()){
			recurse(arr, index+1, s+ch, result);
		}
	}
}