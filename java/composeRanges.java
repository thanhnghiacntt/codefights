/*
Given a sorted integer array that does not contain any duplicates, return a summary of the number ranges it contains.
*/

String[] composeRanges(int[] nums) {
    List<String> result = new ArrayList<String>();
    switch (nums.length) {
    case 0:
        break;
    case 1:
        result.add(nums[0] + "");
        break;
    case 2:
        if (nums[1] - nums[0] == 1) {
            result.add(nums[0] + "->" + nums[1]);
        } else {
            result.add(nums[0] + "");
            result.add(nums[1] + "");
        }
        break;
    default:
        int before = nums[0];
        int after = nums[1];
        for (int i = 1; i < nums.length; i++) {
            after = nums[i - 1];
            if (nums[i - 1] == nums[i] - 1) {
                if (i == nums.length - 1) {
                    result.add(before + "->" + nums[i]);
                }
                continue;
            } else {
                String str = before + "";
                if (before != after) {
                    str += "->" + after;
                }
                result.add(str);
                before = nums[i];
                if (i == nums.length - 1) {
                    result.add(before + "");
                }
            }
        }
        break;
    }
    return result.toArray(new String[result.size()]);
}