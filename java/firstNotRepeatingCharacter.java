/*
Note: Write a solution that only iterates over the string once and uses O(1) additional memory, since this is what you would be asked to do during a real interview.

Given a string s, find and return the first instance of a non-repeating character in it. If there is no such character, return '_'.
*/

char firstNotRepeatingCharacter(String s) {
    char result = '_';
    char[] sc = s.toCharArray();
    HashMap<Character, Boolean> hash = new HashMap<Character, Boolean>();
    for (char c : sc) {
        if(hash.containsKey(c)){
            hash.put(c, true);
        }else{
            hash.put(c, false);
        }
    }
    for (char c : sc) {
        if(!hash.get(c)){
            result = c;
            break;
        }
    }
    return result;
}
