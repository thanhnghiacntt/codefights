/*
Given an array of integers, write a function that determines whether the array contains any duplicates. Your function should return true if any element appears at least twice in the array, and it should return false if every element is distinct.
*/

boolean containsDuplicates(int[] a) {
    boolean result = false;
    HashSet<Integer>hash = new HashSet<Integer>();
    for (int integer : a) {
        if(hash.contains(integer)){
            result = true;
            break;
        }else
        {
            hash.add(integer);
        }
    }
    return result;
}