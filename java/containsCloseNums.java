/*
Given an array of integers nums and an integer k, determine whether there are two distinct indices i and j in the array where nums[i] = nums[j] and the absolute difference between i and j is less than or equal to k.
*/

boolean containsCloseNums(long[] nums, int k) {
	HashMap<Long, Integer> hash = new HashMap<Long, Integer>();
	HashSet<Long> hashSet = new HashSet<Long>();
	List<Integer> list = new ArrayList<Integer>();
	for (int i = 0; i < nums.length; i++) {
		if (!hash.containsKey(nums[i])) {
			hash.put(nums[i], i);
		} else {
			if (!hashSet.contains(nums[i])) {
				list.add(hash.get(nums[i]));
				hashSet.add(nums[i]);
			}
			list.add(i);
		}
	}
	for (Integer i : list) {
		for (Integer j : list) {
			if (i != j && nums[i] == nums[j]) {
				if (Math.abs(i - j) <= k) {
					return true;
				}
			}
		}
	}
	return false;
}