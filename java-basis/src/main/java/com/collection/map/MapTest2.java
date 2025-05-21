package com.collection.map;

import java.util.HashMap;
import java.util.Map;

/*
    common used method

 */
public class MapTest2 {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        // 1. put()
        map.put("1", 1);
        map.put("3", 2);
        map.put("2", 2);
        map.put(null, null);
        System.out.println(map);

        // 2. size()
        System.out.println(map.size());

        // 3. clear()
//        map.clear();
//        System.out.println(map);

        // 4. isEmpty()
        System.out.println(map.isEmpty());

        // 5. public V get(Object key)
        System.out.println(map.get("1"));
        System.out.println(map.get("4")); // if there is no such a key, it returns null

        // 6. public V remove(Object key) ==> it will return the value of the key after removing
        System.out.println(map.remove("2"));
        System.out.println(map);

        // 7. public boolean containsKey(Object key)
        // 8. public boolean containsValue(Object key)

        // 9. public Set<K> keySet() : it returns Set<K>
        System.out.println(map.keySet());

        // 10. public Collection<V> values()
        System.out.println(map.values());

        // 11. putAll()
    }
}
