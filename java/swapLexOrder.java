/*
Given a string str and array of pairs that indicates which indices in the string can be swapped, return the lexicographically largest string that results from doing the allowed swaps. You can swap indices any number of times.
*/

int partition(char arr[], int left, int right) {
	int i = left, j = right;
	char temp;
	int pivot = arr[(left + right) / 2];
	while (i <= j) {
		while (arr[i] > pivot)
			i++;
		while (arr[j] < pivot)
			j--;
		if (i <= j) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}
	return i;
}

void quickSort(char arr[], int left, int right) {
	int index = partition(arr, left, right);
	if (left < index - 1)
		quickSort(arr, left, index - 1);
	if (index < right)
		quickSort(arr, index, right);
}

void quickSort(char arr[]) {
	quickSort(arr, 0, arr.length - 1);
}

String swapLexOrder(String str, int[][] pairs) {
	boolean[][] graph = createGraph(pairs);
	char[] first = str.toCharArray();
	char[] strFirst = str.toCharArray();
	boolean[] tracking = new boolean[graph.length];
	for (int i = 0; i < graph.length; i++) {
		if (tracking[i]) {
			continue;
		}
		String temp = "";
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int j = 0; j < graph.length; j++) {
			if (graph[i][j] && !tracking[i]) {
				queue.add(j);
				temp += strFirst[j];
				tracking[j] = true;
			}
		}
		char[] array = temp.toCharArray();
		quickSort(array);
		int j = 0;
		while (queue.size() > 0) {
			int q = queue.poll();
			first[q] = array[j];
			j++;
		}
	}
	return new String(first);
}

boolean[][] createGraph(int[][] pairs) {
	int len = 0;
	for (int[] is : pairs) {
		if (is[0] > len) {
			len = is[0];
		}
		if (is[1] > len) {
			len = is[1];
		}
	}
	boolean[][] g = new boolean[len][len];
	for (int[] is : pairs) {
		g[is[0] - 1][is[1] - 1] = true;
		g[is[1] - 1][is[0] - 1] = true;
	}
	for (int i = 0; i < len; i++) {
		g[i][i] = true;
	}
	for (int i = 0; i < len; i++) {
		for (int j = 0; j < len; j++) {
			if (i == j || !g[i][j]) {
				continue;
			}
			for (int k = 0; k < len; k++) {
				if (k == j || k == i) {
					continue;
				}
				if (g[i][j]&& g[j][k]) {
					g[i][k] = true;
				}
			}
		}
	}
	return g;
}