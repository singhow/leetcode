
class Solution {
    public int lengthOfLongestSubstring(String s) {
		int sz = s.length();
		if (sz == 0)
			return 0;
		else if (sz == 1)
			return 1;
		
		char[] str = new char[sz];
		for (int i = 0; i < sz; i++) {
			str[i] = s.charAt(i);
		}
		
		int cur = 1;
		int start = 0;
		int next = 0;
		int res = 0;
		int tmp = 0;
		
		for (; cur < sz; cur++) {
			next = cur;
			
			for (int i = start; i < next; i++) {
				if (str[i] == str[next]) {
					// "abca"
					if (i == start) {
						tmp = next - start;
						if (res < tmp)
							res = tmp;
						
						start = start + 1;
						cur = start;
					// "abcc"
					} else if (i + 1 == next) {
						tmp = next - start;
						if (res < tmp)
							res = tmp;
						
						// ignore some substrings
						start = next;
						cur = start;
						
						if (next + 1== cur)
							if (res < 1)
								res = 1;
					// "abcb"
					} else {
						tmp = next - start;
						if (res < tmp)
							res = tmp;
						
						start = start + 1;
						cur = start;
					}
				}
			}
			
			// "abca" repeat execute
			if (next + 1 == sz) {
				tmp = next - start + 1;
				if (res < tmp)
					res = tmp;
			}
		}
		
		return res;
    }
}

public class Problem003a {
	public static void main(String args[]) {
		Solution solution = new Solution();
		String s = "dvdf"; // 3
		String s1 = "abcabcbb"; // 3
		String s2 = "abcd"; // 4
		String s3 = "abcda"; // 4
		String s4 = "abb"; // 2
		String s5 = "ab"; // 2
		String s6 = "a"; // 1
		String s7 = ""; // 0
		String s8 = "bbbbb"; // 1
		String s9 = "ohvhjdml"; // 6
		
		
		int result = solution.lengthOfLongestSubstring(s9);
		System.out.println("result = " + result);
	}
}
