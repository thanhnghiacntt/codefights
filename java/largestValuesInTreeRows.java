/*
You have a binary tree t. Your task is to find the largest value in each row of this tree. In a tree, a row is a set of nodes that have equal depth. For example, a row with depth 0 is a tree root, a row with depth 1 is composed of the root's children, etc.

Return an array in which the first element is the largest value in the row with depth 0, the second element is the largest value in the row with depth 1, the third element is the largest element in the row with depth 2, etc.
*/

int[] largestValuesInTreeRows(Tree<Integer> t) {
    if (t != null) {
        List<Integer> list = new ArrayList<Integer>();
        Queue<Tree<Integer>> queue = new LinkedList<Tree<Integer>>();
        queue.add(t);
        while (queue.size() > 0) {
            Queue<Tree<Integer>> child = new LinkedList<Tree<Integer>>();
            int max = getMaxItAndAddChild(queue, child);
            list.add(max);
            queue = child;
        }
        return convertToArray(list);
    }
    return new int[0];
}

int[] convertToArray(List<Integer> list) {
    int[] values = new int[list.size()];
    for (int i = 0; i < values.length; i++) {
        values[i] = list.get(i);
    }
    return values;
}

int getMaxItAndAddChild(Queue<Tree<Integer>> it, Queue<Tree<Integer>> child) {
    int max = -10000;
    while (it.size() > 0) {
        Tree<Integer> node = it.poll();
        Tree<Integer> l = node.left;
        Tree<Integer> r = node.right;
        if (l != null) {
            child.add(l);
        }
        if (r != null) {
            child.add(r);
        }
        if (node.value > max) {
            max = node.value;
        }
    }
    return max;
}