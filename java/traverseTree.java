/*
Note: Try to solve this task without using recursion, since this is what you'll be asked to do during an interview.

Given a binary tree of integers t, return its node values in the following format:

The first element should be the value of the tree root;
The next elements should be the values of the nodes at height 1 (i.e. the root children), ordered from the leftmost to the rightmost one;
The elements after that should be the values of the nodes at height 2 (i.e. the children of the nodes at height 1) ordered in the same way;
Etc.
*/

int[] traverseTree(Tree<Integer> t) {
    if (t == null) {
        return new int[0];
    }
    Queue<Tree<Integer>> queue = new LinkedList<Tree<Integer>>();
    List<Integer> list = new ArrayList<Integer>();
    queue.add(t);
    while (queue.size() > 0) {
        Tree<Integer> item = queue.remove();
        list.add(item.value);
        Tree<Integer> left = item.left;
        Tree<Integer> right = item.right;
        if (left != null) {
            queue.add(left);
        }
        if (right != null) {
            queue.add(right);
        }
    }
    return convertToArray(list);
}

int[] convertToArray(List<Integer> list) {
    int[] values = new int[list.size()];
    for (int i = 0; i < values.length; i++) {
        values[i] = list.get(i);
    }
    return values;
}
