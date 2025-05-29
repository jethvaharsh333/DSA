// Time complexity: O(n! * nlogn); Space complexity: O(n!)
class Solution1 {
    public String getPermutation(int n, int k){
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = i+1;
        }

        List<List<Integer>> result = new ArrayList<>();
        perm(arr, 0, result);
        
        Collections.sort(result, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                for (int i = 0; i < o1.size(); i++) {
                    if (!o1.get(i).equals(o2.get(i))) {
                        return o1.get(i) - o2.get(i);
                    }
                }
                return 0;
            }
        });

        List<Integer> li = result.get(k-1);
        StringBuilder sb = new StringBuilder();
        for (int num : li) {
            sb.append(num);
        }

        return sb.toString();
    }

    private void perm(int[] arr, int start, List<List<Integer>> result){
        if(start == arr.length-1){
            List<Integer> t = new ArrayList<>();
            for(int x: arr){
                t.add(x);
            }
            result.add(t);
            return;
        }
        
        for(int i=start ; i<arr.length ; i++){
            int temp = arr[i];
            arr[i] = arr[start];
            arr[start] = temp;

            perm(arr, start+1, result);

            arr[start] = arr[i];
            arr[i] = temp;
        }

        return;
    }
}
