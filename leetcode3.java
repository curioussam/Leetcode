import java.util.HashMap;

/*Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

/*Solution: 
Using hashmap or hashset to save the characters and two index i,j to represent the longest substring.
*/

public class leetcode3 {
	
	public static void main(String[] args)  {
		int res=lengthOfLongestSubstring("abcabcbb");
		System.out.println(res);
	}
	
    static int lengthOfLongestSubstring(String s) {
    	if (s.length()==0||s==null) {
			return 0;
		}
    	
    	HashMap<Character, Integer> map=new HashMap<>();
    	int res=0,j=0;
    	for(int i=0;i<s.length();i++) 
    	{
    		if (map.containsKey(s.charAt(i))) {
    		    //delete the chars until the substring isn't repeat
    			while(map.containsKey(s.charAt(i))&&j<i) {
    				map.remove(s.charAt(j));
    				j++;
    			}
			}
    		map.put(s.charAt(i), 1);
			//save the length and compare
		    res=res>(i-j+1)?res:(i-j+1);
		    
    	}
        return res;
    }

}



















