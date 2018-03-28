/*
You have two arrays of strings, words and parts. Return an array that contains the strings from words, modified so that any occurrences of the substrings from parts are surrounded by square brackets [], following these guidelines:

If several parts substrings occur in one string in words, choose the longest one. If there is still more than one such part, then choose the one that appears first in the string.
*/

String[] findSubstrings(String[] words, String[] parts) {
	HashMap<String, Boolean> hash = new HashMap<String, Boolean>();
	for (String string : parts) {
		hash.put(string, true);
	}
	for (int i = 0; i < words.length; i++) {
		String word = words[i];
		int len = word.length();
		for (int j = 5; j > 0; j--) {
			for (int k = 0; k <= len - j; k++) {
				String sub = word.substring(k, k + j);
				if (hash.containsKey(sub)) {
					words[i] = word.replaceFirst(sub, "[" + sub + "]");
					j = -1;// Break loop out
					break;
				}
			}
		}
	}
	return words;
}