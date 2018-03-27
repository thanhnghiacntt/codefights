/*
You are planning to rob houses on a specific street, and you know that every house on the street has a certain amount of money hidden. The only thing stopping you from robbing all of them in one night is that adjacent houses on the street have a connected security system. The system will automatically trigger an alarm if two adjacent houses are broken into on the same night.

Given a list of non-negative integers nums representing the amount of money hidden in each house, determine the maximum amount of money you can rob in one night without triggering an alarm.
*/
int houseRobber(int[] nums) {
	int result = 0;
	switch (nums.length) {
	case 0:
		result = 0;
		break;
	case 1:
		result = nums[0];
		;
		break;
	case 2:
		result = max(nums[0], nums[1]);
		break;
	case 3:
		result = max(nums[0] + nums[2], nums[1]);
		break;
	default:
		int[] f = new int[nums.length];
		f[0] = nums[0];
		f[1] = max(nums[0], nums[1]);
		f[2] = max(nums[0] + nums[2], nums[1]);
		for (int i = 3; i < nums.length; i++) {
			int s1 = f[i - 2] + nums[i];
			int s2 = f[i - 3] + nums[i - 1];
			f[i] = max(s1, s2);
		}
		result = f[nums.length - 1];
		break;
	}

	return result;
}

int max(int a, int b) {
	return a > b ? a : b;
}