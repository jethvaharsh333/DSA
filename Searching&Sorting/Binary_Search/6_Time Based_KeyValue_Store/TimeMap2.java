class TimeMap2 {
    private HashMap<String, TreeMap<Integer, String>> map;

    public TimeMap2() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> innerMap = map.getOrDefault(key, new TreeMap<>());
        innerMap.put(timestamp, value);  
        map.put(key, innerMap);         
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> innerMap = map.get(key);
        
        if (innerMap == null) {
            return "";  
        }
        
        Integer closestTimestamp = innerMap.floorKey(timestamp);
        
        return closestTimestamp == null ? "" : innerMap.get(closestTimestamp);
    }
}
