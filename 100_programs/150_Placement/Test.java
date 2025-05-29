import java.util.*;

public class Test {
    public static int minLengthToRemove(List<Integer> arr) {
        int n = arr.size();
        Set<Integer> set = new HashSet<>();
        int ans = n;

        for (int i = 0; i < n; i++) {
            set.clear();
            boolean valid = true;

            // Check prefix (0 to i-1) for uniqueness
            for (int k = 0; k < i; k++) {
                if (!set.add(arr.get(k))) {
                    valid = false;
                    break;
                }
            }

            if (!valid) continue;

            int r = n;
            for (int j = n - 1; j >= i; j--) {
                if (set.contains(arr.get(j))) break;
                set.add(arr.get(j));
                r = j;
            }

            ans = Math.min(ans, r - i);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        System.out.println(minLengthToRemove(arr));
    }
}
