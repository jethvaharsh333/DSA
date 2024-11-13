class TimeMap3 {
   static class Pair {
        int timestamp;
        String value;

        public Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
  
    private Map<String, List<Pair>> histories;

    public TimeMap3() {
        histories = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        histories.putIfAbsent(key, new ArrayList<>());
        histories.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!histories.containsKey(key)) return "";

        List<Pair> history = histories.get(key);
        int left = 0, right = history.size() - 1;
        int pos = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (history.get(mid).timestamp <= timestamp) {
                pos = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return pos == -1 ? "" : history.get(pos).value;
    }
}
