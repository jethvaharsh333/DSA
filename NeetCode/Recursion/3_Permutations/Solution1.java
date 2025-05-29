// 3ms, 44.9MB

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> processed = new ArrayList<>();
        List<Integer> unprocessed = Arrays.stream(nums)  // Convert int[] to IntStream
                                          .boxed()       // Box each int to Integer
                                          .collect(Collectors.toList()); // Collect to List<Integer>

        List<List<Integer>> result = permutationList(processed, unprocessed);
        return result;
    }

    public List<List<Integer>> permutationList(List<Integer> processed, List<Integer> unprocessed) {
        if (unprocessed.isEmpty()) {
            List<List<Integer>> list = new ArrayList<List<Integer>>();
            list.add(processed);
            return list;
        }

        int number = unprocessed.get(0);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        for (int i = 0; i <= processed.size(); i++) {

            // 1st approach
            // List<Integer> newProcessed = new ArrayList<>(processed.subList(0, i));
            // newProcessed.add(number);
            // newProcessed.addAll(new ArrayList<Integer>(processed.subList(i, processed.size())));
            
            // optimised approach
            List<Integer> newProcessed = new ArrayList<>(processed);
            newProcessed.add(i, number);
            
            List<Integer> newUnprocessed = new ArrayList<>(unprocessed.subList(1, unprocessed.size()));
            ans.addAll(permutationList(newProcessed, newUnprocessed));
        }

        return ans;
    }
}
