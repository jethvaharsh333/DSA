import java.util.*;

public class ANonRepeatingChar{
	static final int MAX_SIZE = 26;

	public static char nonRep(String s){
		int[] arr = new int[MAX_SIZE];

		for(int i=0 ; i<s.length() ; i++){
			arr[s.charAt(i)-'a']++;
		}

		for(int i=0 ; i<s.length() ; i++){
			if(arr[i]==1){
				return s.charAt(i);
			}
		}		

		return '$';
	}

	public static char nonRep1(String s){
		Map<Character, Integer> map = new HashMap<Character, Integer>();


		for(int i=0 ; i<s.length() ; i++){
			char ch = s.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}

		for (Map.Entry<Character, Integer> e : map.entrySet()){
			if(e.getValue() == 1){	
				return e.getKey();
			}
		}

		return '#';
	}


	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter string: ");
		String str = sc.nextLine();

		char ans = nonRep1(str);

		System.out.println(ans);
	}
}