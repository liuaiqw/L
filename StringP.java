/**
 * 我们要给每个字母配一个1-26之间的整数，具体怎么分配由你决定，但不同字母的完美度不同，
 *而一个字符串的完美度等于它里面所有字母的完美度之和，且不在乎字母大小写，也就是说字母F
 *和f的完美度是一样的。现在给定一个字符串，输出它的最大可能的完美度。 例如：dad，你可以
 *将26分配给d，25分配给a，这样整个字符串最大可能的完美度为77。
 */
package com;

import java.util.*;

/**
 * @author 2w
 * 
 */
public class StringP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
	}

	public static int perfect(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		Set<Character> set = new HashSet<Character>();
		s = s.toLowerCase();
		for (int i = 0; i < s.length(); i++) {
			if (set.add(s.charAt(i))) {
				if (s.charAt(i) <= 'z' && s.charAt(i) >= 'a')
					map.put(s.charAt(i), 1);
				else
					set.remove(s.charAt(i));
			} else {
				if (s.charAt(i) <= 'z' && s.charAt(i) >= 'a')
					map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			}
		}
		int[] a = new int[map.size()];
		Object[] b = set.toArray();
		for (int i = 0; i < b.length; i++) {
			a[i] = map.get(b[i]);
		}
		Arrays.sort(a);
		int rtn = 0;
		for (int i = 0; i < a.length; i++) {
			rtn += a[a.length - 1 - i] * (26 - i);
		}
		return rtn;
	}

}
