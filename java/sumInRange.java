/*
You have an array of integers nums and an array queries, where queries[i] is a pair of indices (0-based). Find the sum of the elements in nums from the indices at queries[i][0] to queries[i][1] (inclusive) for each query, then add all of the sums for all the queries together. Return that number modulo 109 + 7.
*/

int sumInRange(int[] nums, int[][] queries) {
    int result = 0;
    for (int i = 1; i < nums.length; i++) {
        nums[i] = nums[i - 1] + nums[i];
        nums[i] = modulo(nums[i]);
        
    }
    for (int[] is : queries) {
        result += nums[is[1]];
        if (is[0] > 0) {
            result -= nums[is[0] - 1];
        }
        result = modulo(result);
    }
    result = modulo(result);
    return result;
}

int modulo(int num){
    if(num < 0){
        num += 1000000007;
    }
    num = num%1000000007;
    return num;
}