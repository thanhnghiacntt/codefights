/*
Note: Write a solution that only iterates over the string once and uses O(1) additional memory, since this is what you would be asked to do during a real interview.

Given a string s, find and return the first instance of a non-repeating character in it. If there is no such character, return '_'.
*/
func firstNotRepeatingCharacter(s string) string {
    var m = make(map[int]bool);
	i:= 0;
	for i < len(s){
		var c int = int(s[i])
		i++;
		_, ok := m[c]
		if(!ok){
			m[c] = false;
		}else{
			m[c] = true;
		}
	}
	i = 0;
	for i < len(s){
		var c int = int(s[i])
		_, ok := m[c];
		if(!ok || !m[c]){
			return string(s[i]);
		}
		i++;
	}
	return "_";
}
