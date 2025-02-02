class Solution2 {
    int maxDistance(String s, int k) {
        int ans = 0;
        char[][] dir = new char[][]{{'N', 'E'}, {'N', 'W'}, {'S', 'E'}, {'S', 'W'}};

        for (char[] d : dir) {  // Iterate over each directional pair
            for (int i = 0; i < s.length(); i++) {  // Start from every index
                int curr = 0, t = k;

                for (int j = i; j < s.length(); j++) {  // Expand from index i
                    if (s.charAt(j) == d[0] || s.charAt(j) == d[1]) {
                        if (t > 0) {
                            t--;  // Use a replacement
                        } else {
                            break;  // No replacements left, stop
                        }
                    }
                    curr++;  // Increment distance
                    ans = Math.max(ans, curr);  // Update max distance
                }
            }
        }

        return ans;
    }
}
