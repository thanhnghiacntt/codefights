/*
You have two arrays of strings, words and parts. Return an array that contains the strings from words, modified so that any occurrences of the substrings from parts are surrounded by square brackets [], following these guidelines:

If several parts substrings occur in one string in words, choose the longest one. If there is still more than one such part, then choose the one that appears first in the string.
*/
String[] findSubstrings(String[] words, String[] parts) {
    HashMap<String, Boolean> hash = new HashMap<String, Boolean>();
    String[] newParts = new String[parts.length];
    for (String string : parts) {
        hash.put(string, true);
    }
    int count = 0;
    for (int i = 5; i > 0; i--) {
        for (String part : parts) {
            if (part.length() == i && hash.containsKey(part)) {
                newParts[count] = part;
                count++;
            }
        }
    }

    for (int i = 0; i < words.length; i++) {
        String word = words[i];
        int position = 100;
        String match = "";
        int length = -1;
        for (String part : newParts) {
            if (length > 0 && part.length() != length) {
                break;
            }
            int index = word.indexOf(part);
            if(index == -1){
                continue;
            }
            if (index < position && part.length() == length) {
                position = index;
                match = part;
            }
            if (length == -1) {
                position = index;
                length = part.length();
                match = part;
            }
        }
        if (length != -1) {
            words[i] = word.replaceFirst(match, "[" + match + "]");
        }
    }
    return words;
}