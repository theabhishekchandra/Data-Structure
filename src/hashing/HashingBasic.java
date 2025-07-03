package hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HashingBasic {
    /**
     * <b>Hashing</b> - It has 2 categories: Hashing is a technique used in data structures that efficiently stores and retrieves data in a way that allows for quick access<br><br>
     *
     * <b>1. Map:</b><br>
     * &emsp;• HashMap<br>
     * &emsp;• LinkedHashMap<br>
     * &emsp;• TreeMap<br><br>
     *
     * <b>2. Set:</b><br>
     * &emsp;• HashSet<br>
     * &emsp;• LinkedHashSet<br>
     * &emsp;• TreeSet<br><br>
     *
     * <b>HashMap </b> - It has 2 categories:<br>
     * &emsp;• Store data in Key and Value format.<br>
     * &emsp;• Key is Unique<br>
     * &emsp;• LinkedHashMap<br>
     * &emsp;• TreeMap<br><br>
     */

    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("A",1);
        hashMap.put("B",2);
        hashMap.put("C",3);
        hashMap.put("D",4);

        System.out.println(hashMap);
//        System.out.println(hashMap.get("A"));

        // Iteration
        Set<String> set = hashMap.keySet();
        System.out.println(set);
        for(String k : set){
            System.out.println(k);

        };

    }
}
