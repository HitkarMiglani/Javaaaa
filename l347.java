import java.util.*;

public class l347 {

    public static Map<Integer,Integer> sortByValue(Map<Integer,Integer> map) {
        List<Map.Entry<Integer,Integer>> list = new LinkedList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        list = list.reversed();

        

        Map<Integer,Integer> result = new LinkedHashMap<>();
        for (Map.Entry<Integer,Integer> entry : list) {
            result.put(entry.getKey(),entry.getValue());
        }
        return result;

    }

    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(2,1);
        map.put(3,2);
        map.put(4,3);
        map.put(5,4);

        map = sortByValue(map);

        System.out.println(map.values());
    }
}
