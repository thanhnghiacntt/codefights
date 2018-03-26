/*
You need to climb a staircase that has n steps, and you decide to get some extra exercise by jumping up the steps. You can cover at most k steps in a single jump. Return all the possible sequences of jumps that you could take to climb the staircase, sorted.
*/

int[][] climbingStaircase(int n, int k) {
	List<List<Integer>> list = new ArrayList<List<Integer>>();
	List<Integer> temp = new ArrayList<Integer>();
	climbingElement(n,k,temp, list);
	return convert(list);
}

void climbingElement(int n, int k , List<Integer> list,  List<List<Integer>> res){
	if(n == 0){
		res.add(list);
	}else{
		for (int i = 1; i < k+1; i++) {
			if(n-i >= 0){
				List<Integer> temp = cloneList(list);
				temp.add(i);
				climbingElement(n-i, k, temp,res);
			}
		}
	}
}
List<Integer> cloneList(List<Integer>list) {
	List<Integer>rs = new ArrayList<Integer>();
	for (Integer integer : list) {
		rs.add(integer);
	}
	return rs;
}

int[][] convert(List<List<Integer>> list){
	int[][]result = new int[list.size()][];
	for (int i = 0; i < list.size(); i++) {
		List<Integer> temp = list.get(i);
		result[i] = new int[temp.size()];
		for (int j = 0; j < temp.size(); j++) {
			result[i][j] = temp.get(j);
		}
	}
	return result;
}