/*
You have two integer arrays, a and b, and an integer target value v. Determine whether there is a pair of numbers, where one number is taken from a and the other from b, that can be added together to get a sum of v. Return true if such a pair exists, otherwise return false.
*/
func sumOfTwo(a []int, b []int, v int) bool {
    var hashMap = make(map[int]bool);
    for _,i := range a{
        hashMap[i] = true;
    }
    for _,i := range b{
        var temp = v - i;
        _,ok := hashMap[temp];
        if(ok){
            return true;
        }
    }
    return false;
}
