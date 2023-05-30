import java.util.*;

// https://leetcode.com/problems/insert-delete-getrandom-o1/description/?envType=study-plan-v2&id=top-interview-150
public class RandomisedSet {
    private Map<Integer,Integer> map;
    List<Integer> list;
    Random random = new Random();

    public RandomisedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val,list.size());
        list.add(list.size(),val);
        return true;
    }

    public boolean remove(int val) {
        boolean isPresent = map.containsKey(val);
        if(isPresent){
            int lastElem = list.get(list.size()-1);
            int removalIdx = map.get(val);
            list.set(removalIdx,lastElem);
            map.put(lastElem,removalIdx);
            list.remove(list.size()-1);
            map.remove(val);
        }
        return isPresent;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

}
