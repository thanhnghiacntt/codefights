/*
We're going to store numbers in a tree. Each node in this tree will store a single digit (from 0 to 9), and each path from root to leaf encodes a non-negative integer.

Given a binary tree t, find the sum of all the numbers encoded in it.
*/

Tree<Long> cloneTree(Tree<Integer> t){
    Tree<Long> root = new Tree<Long>(0l);
    root.value = (long) t.value;
    if (t.left != null) {
        root.left = cloneTree(t.left);
    }
    if (t.right != null) {
        root.right = cloneTree(t.right);
    }
    return root;
}
long digitTreeSum(Tree<Integer> t) {
    long sum = 0;
    Tree<Long> clone = cloneTree(t);
    Stack<Tree<Long>> stack = new Stack<Tree<Long>>();
    stack.add(clone);
    while (stack.size() > 0) {
        Tree<Long> node = stack.pop();
        if (node.left == null && node.right == null) {
            sum += node.value;
        } else {
            if (node.left != null) {
                node.left.value = node.value * 10 + node.left.value;
                stack.push(node.left);
            }
            if (node.right != null) {
                node.right.value = node.value * 10 + node.right.value;
                stack.push(node.right);
            }
        }
    }
    return sum;
}