class TimeMap1 {
    private HashMap<String, HashMap<Integer, String>> map;

    public TimeMap1() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        HashMap<Integer, String> innerMap = map.getOrDefault(key, new HashMap<>());
        // HashMap<Integer, String> innerMap = map.get(key);
        // if(innerMap == null) innerMap = new HashMap<>();
        innerMap.put(timestamp, value);
        map.put(key, innerMap);
    }
    
    public String get(String key, int timestamp) {
        HashMap<Integer, String> innerMap = map.get(key);

        if (innerMap == null) {
            return "";
        }
        
        for(int i=timestamp ; i>=0 ; i--){
            if(innerMap.containsKey(i)){
                return innerMap.get(i);
            }
        }

        return "";
    }
}
