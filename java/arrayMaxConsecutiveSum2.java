/*
Given an array of integers, find the maximum possible sum you can get from one of its contiguous subarrays. The subarray from which this sum comes must contain at least 1 element.
*/
int arrayMaxConsecutiveSum2(int[] arr) {
    for(int i=1 ; i < arr.length ; i++){
        arr[i] = arr[i-1] > 0 ? arr[i-1] + arr[i]:arr[i];
    }
    return findMaxElement(arr);
}

int findMaxElement(int[] arr){
    int max = arr[0];
    for (int i : arr) {
        if(i > max){
            max = i;
        }
    }
    return max;
}