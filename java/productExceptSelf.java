/*
You have an array nums. We determine two functions to perform on nums. In both cases, n is the length of nums:

fi(nums) = nums[0] · nums[1] · ... · nums[i - 1] · nums[i + 1] · ... · nums[n - 1]. (In other words, fi(nums) is the product of all array elements except the ithf.)
g(nums) = f0(nums) + f1(nums) + ... + fn-1(nums).
Using these two functions, calculate all values of f modulo the given m. Take these new values and add them together to get g. You should return the value of g modulo the given m.
*/
int productExceptSelf(int[] nums, int m) {
    int sum = 0;
    int product = 1;
    int[] numbers = new int[nums.length];
    HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
    for (int i = 0; i < numbers.length; i++) {
        product = 1;
        if(hash.containsKey(nums[i])){
            numbers[i] = hash.get(nums[i]);
        }else{
            for (int j = 0; j < numbers.length; j++) {
                if(j != i){
                    product *= nums[j];
                    product = product%m;
                }
            }
            numbers[i] = product;
            hash.put(nums[i], product);
        }

    }
    for (int i : numbers) {
        sum += i;
        sum = sum%m;
    }
    return sum;
}