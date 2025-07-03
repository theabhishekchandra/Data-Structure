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
        // Contains
        if (hashMap.containsKey("B")){
            System.out.println("Done");
        }else {
            System.out.println("No");
        }

//        hashMap.remove("B");
        System.out.println(hashMap.size());

        int[] nums =  { 1,3,2,5,1,3,1,5,1};

        System.out.println(
                isAnagram(
                        "nums","snum"
                )
        );

    }
    /// Majority Elements -> Given an integer array of size n, find all elements that appear more than ["n"/3] times. nums[] = { 1,3,2,5,1,3,1,5,1};
    static void MajorElem(int[] nums){
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
//            if (freq.containsKey(nums[i])){
//                freq.put(nums[i], freq.get(nums[i]) + 1 );
//            }else {
//                freq.put(nums[i], 1 );
//            }
            freq.put(nums[i],freq.getOrDefault(nums[i],0) + 1 );
        }
//        Set<Integer> set = freq.keySet();
//        for (int n : set){
//           if (freq.get(n) > nums.length/3){
//               System.out.println(n);
//           }
//        }

        for (int n : freq.keySet()){
           if (freq.get(n) > nums.length/3){
               System.out.println(n);
           }
        }
    }

    ///  Valid Anagram ->
    static Boolean isAnagram(String s, String t){
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            if (hashMap.containsKey(s.charAt(i))){
                hashMap.put(s.charAt(i),hashMap.get(s.charAt(i)) + 1 );
            }else {
                hashMap.put(s.charAt(i),1);
            }

        }
        for (int i = 0; i < t.length(); i++){
            if (hashMap.containsKey(t.charAt(i))){
                hashMap.put(s.charAt(i),hashMap.get(t.charAt(i)) - 1);
            }else {
                return false;
            }
        }
        return true;
    }
}
