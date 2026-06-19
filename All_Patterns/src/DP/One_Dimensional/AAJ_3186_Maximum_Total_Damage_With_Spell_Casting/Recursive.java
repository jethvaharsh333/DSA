package DP.One_Dimensional.AAJ_3186_Maximum_Total_Damage_With_Spell_Casting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recursive {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> map = new HashMap<>();
        for(int x: power) map.put(x, map.getOrDefault(x, 0L) + 1L);

        List<Integer> keys = new ArrayList<>(map.keySet());

        return recurse(map, keys, 0);
    }

    private long recurse(Map<Integer, Long> map, List<Integer> keys, int index){
        if(index == keys.size()) return 0;

        int key = keys.get(index);
        if(!map.containsKey(key)) return recurse(map, keys, index+1);
        long value = map.get(key);

        long noPick = recurse(map, keys, index+1);

        Map<Integer, Long> newMap = new HashMap<>(map);
        newMap.remove(key);
        newMap.remove(key-1);
        newMap.remove(key-2);
        newMap.remove(key+1);
        newMap.remove(key+2);
        long pick = recurse(newMap, keys, index+1) + key*value;

        return Math.max(pick, noPick);
    }
}
