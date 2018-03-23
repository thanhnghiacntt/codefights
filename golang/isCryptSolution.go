/*
A cryptarithm is a mathematical puzzle for which the goal is to find the correspondence between letters and digits, such that the given arithmetic equation consisting of letters holds true when the letters are converted to digits.

You have an array of strings crypt, the cryptarithm, and an an array containing the mapping of letters and digits, solution. The array crypt will contain three non-empty strings that follow the structure: [word1, word2, word3], which should be interpreted as the word1 + word2 = word3 cryptarithm.

If crypt, when it is decoded by replacing all of the letters in the cryptarithm with digits using the mapping in solution, becomes a valid arithmetic equation containing no numbers with leading zeroes, the answer is true. If it does not become a valid arithmetic solution, the answer is false.
*/
func isCryptSolution(crypt []string, solution [][]string) bool {
    var hashMap = make(map[byte]int)
    for _,b := range solution{
				var str = b[0];
        hashMap[str[0]],_ = strconv.Atoi(b[1]);
    }

    var sum = 0;
    for i:= 0; i < len(crypt); i++ {
        var str = crypt[i];
        value,_ := hashMap[str[0]];
        if(len(str) > 1 && value == 0){
            return false;
        }
        var num = converStringToNumber(str, hashMap);
        if(i == len(crypt) - 1){
            if(sum == num){
                return true;
            }else{
                return false;
            }
        }
        sum += num;
    }
    return false;
}

func converStringToNumber(str string, hash map[byte]int)(int){
	var result = 0;
	for i := 0; i < len(str); i++ {
		var temp,_ = hash[str[i]];
		result = result * 10 + temp;
	}
	return result;
}
