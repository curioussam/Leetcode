import java.util.HashMap;

public class leetcode03_sample {
    /**
     * 3. Longest Substring Without Repeating Characters
     * Examples:
     Given "abcabcbb", the answer is "abc", which the length is 3.
     Given "bbbbb", the answer is "b", with the length of 1.
     Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
     "pwke" is a subsequence and not a substring.
     time : O(n)
     space : O(n)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
            	//!!!No NEED TO REMOVE, JUST GET J VALUE
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
// HashMap vs Hashtable vs HashSet:
    
/*  Hashtable

    Hashtable is basically a datastructure to retain values of key-value pair.

    It didn’t allow null for both key and value. You will get NullPointerException if you add null value.
    It is synchronized. So it comes with its cost. Only one thread can access in one time
    
    HashMap@@@

    Like Hashtable it also accepts key value pair.

    It allows null for both key and value
    It is unsynchronized. So come up with better performance*/
    
/*    HashSet

    HashSet does not allow duplicate values. 
    It provides add method rather put method. 
    You also use its contain method to check whether the object is already available in HashSet. 
    HashSet can be used where you want to maintain a unique list.

    HashSet<String> stateSet = new HashSet<String>();*/
