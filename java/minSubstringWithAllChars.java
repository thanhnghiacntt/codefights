/*
You have two strings, s and t. The string t contains only unique elements. Find and return the minimum consecutive substring of s that contains all of the elements from t.

It's guaranteed that the answer exists. If there are several answers, return the one which starts from the smallest index.
*/

class BasicClass {
	char c;
	int iS;
	int iT;

	public BasicClass(char c, int iT, int iS) {
		this.c = c;
		this.iT = iT;
		this.iS = iS;
	}
}

String minSubstringWithAllChars(String s, String t) {
	if (s == null || s.length() == 0 || t == null || t.length() == 0) {
		return "";
	}
	char[] sc = s.toCharArray();
	char[] tc = t.toCharArray();
	boolean[] tracking = new boolean[tc.length];
	String min = s;
	List<BasicClass> basicList = new ArrayList<BasicClass>();
	HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
	for (int i = 0; i < tc.length; i++) {
		hash.put(tc[i], i);
	}
	for (int i = 0; i < sc.length; i++) {
		if (hash.containsKey(sc[i])) {
			BasicClass b = new BasicClass(sc[i], hash.get(sc[i]), i);
			basicList.add(b);
		}
	}
	int first = 0;
	for (int i = 0; i < basicList.size(); i++) {
		BasicClass b = basicList.get(i);
		if (hash.containsKey(b.c)) {
			tracking[b.iT] = true;
		}

		if (checkFull(tracking)) {
			if (min.length() > b.iS - basicList.get(first).iS + 1) {
				min = s.substring(basicList.get(first).iS, b.iS + 1);
			}
			i = ++first;
			i--;
			tracking = new boolean[tc.length];
		}
	}
	return min;
}

boolean checkFull(boolean[] b) {
	for (boolean c : b) {
		if (!c) {
			return false;
		}
	}
	return true;
}