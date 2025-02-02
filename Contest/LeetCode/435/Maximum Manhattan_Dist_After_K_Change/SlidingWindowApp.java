class SlidingWindowApp {
    int maxDistance(String s, int k) {
        int ans = 0;
        char[][] dir = new char[][]{{'N', 'E'}, {'N', 'W'}, {'S', 'E'}, {'S', 'W'}};

        for (char[] d : dir) {
            int left = 0, right = 0, changes = 0;

            while (right < s.length()) {
                // If character doesn't match direction pair, count it as a replacement
                if (s.charAt(right) != d[0] && s.charAt(right) != d[1]) {
                    changes++;
                }

                // If changes exceed k, shrink the window from the left
                while (changes > k) {
                    if (s.charAt(left) != d[0] && s.charAt(left) != d[1]) {
                        changes--;
                    }
                    left++;
                }

                // Update the max distance (window size)
                ans = Math.max(ans, right - left + 1);
                right++;
            }
        }

        return ans;
    }
}
