/*
Note: Write a solution that only iterates over the string once and uses O(1) additional memory, since this is what you would be asked to do during a real interview.

Given a string s, find and return the first instance of a non-repeating character in it. If there is no such character, return '_'.
*/
function firstNotRepeatingCharacter(s) {
    var map = [];
    var result = '_';
    for(var i = 0; i < s.length; i++){
        if(map[s[i]] == undefined){
            map[s[i]] = false;
        }else{
            map[s[i]] = true;
        }
    }
    for(var i = 0; i < s.length; i++){
        if(!map[s[i]]){
            result = s[i];
            break;
        }
    }
    return result;
}
