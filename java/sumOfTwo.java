/*
You have two integer arrays, a and b, and an integer target value v. Determine whether there is a pair of numbers, where one number is taken from a and the other from b, that can be added together to get a sum of v. Return true if such a pair exists, otherwise return false.
*/

boolean sumOfTwo(int[] a, int[] b, int v) {
    HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
    for (int i : b) {
        if(!hash.containsKey(i)){
            hash.put(i, i);
        }
    }
    for (int i : a) {
        int temp = v - i;
        if(hash.containsKey(temp)){
            return true;
        }
    }
    return false;
}