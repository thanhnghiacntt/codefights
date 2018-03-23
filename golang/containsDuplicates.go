/*
Given an array of integers, write a function that determines whether the array contains any duplicates. Your function should return true if any element appears at least twice in the array, and it should return false if every element is distinct.
*/
func containsDuplicates(a []int) bool {
    var hashMap = make(map[int]bool);
    for _,value := range a{
        _,ok := hashMap[value];
        if(ok){
            return true;
        }
        hashMap[value] = true;
    }
    return false;
}
