/*
You have an unsorted array arr of non-negative integers and a number s. Find a longest contiguous subarray in arr that has a sum equal to s. Return two integers that represent its inclusive bounds. If there are several possible answers, return the one with the smallest left bound. If there are no answers, return [-1].

Your answer should be 1-based, meaning that the first position of the array is 1 instead of 0
*/
int[] findLongestSubarrayBySum(int s, int[] arr) {
    int[] result = { -1 };
    HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
    hash.put(0, 0);
    int a[] = new int[arr.length + 1];
    for (int i = 1; i <= arr.length; i++) {
        a[i] = arr[i-1]+a[i-1];
        hash.put(a[i], i);
    }
    int i1 = 0;
    int i2 = 0;
    for (int i = 0; i < a.length; i++) {
        int temp = a[i] + s;
        if (hash.containsKey(temp)) {
            int index = hash.get(temp);
            if (index - i > i2 - i1) {
                i1 = i + 1;
                i2 = index;
            }
        }
    }
    if (i1 > 0 || i2 > 0) {
        result = new int[2];
        result[0] = i1;
        result[1] = i2;
    }
    return result;
}