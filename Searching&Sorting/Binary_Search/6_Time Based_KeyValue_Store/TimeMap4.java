class Tripple{
    String key;
    String value;
    int timestamp;

    public Tripple(String key, String value, int timestamp){
        this.key = key;
        this.value = value;
        this.timestamp = timestamp;
    }
}

class TimeMap4 {
    private List<Tripple> li;

    public TimeMap4() {
        li = new ArrayList<>();
    }
    
    public void set(String key, String value, int timestamp) {
        li.add(new Tripple(key, value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        for(int i=li.size()-1 ; i>=0 ; i--){
            Tripple tripple = li.get(i);

            if(tripple.timestamp<=timestamp && tripple.key.equals(key)){
                return tripple.value;
            }
        }

        return "";
    }
}
