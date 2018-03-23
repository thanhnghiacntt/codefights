/*
Given two binary trees t1 and t2, determine whether the second tree is a subtree of the first tree. A subtree for vertex v in a binary tree t is a tree consisting of v and all its descendants in t. Determine whether or not there is a vertex v (possibly none) in tree t1 such that a subtree for vertex v (possibly empty) in t1 equals t2.
*/
boolean isSubtree(Tree<Integer> t1, Tree<Integer> t2) {
    if (t2 == null) {
        return true;
    }
    if (t1 == null) {
        return false;
    }
    if (t1.value.equals(t2.value)) {
        return isEqualTree(t1, t2);
    }
    return isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
}

boolean isEqualTree(Tree<Integer> t1, Tree<Integer> t2) {
    if (t1 == null && t2 == null) {
        return true;
    }
    if (t1 == null || t2 == null) {
        return false;
    }
    if (t1.value.equals(t2.value)) {
        return isEqualTree(t1.left, t2.left)
                && isEqualTree(t1.right, t2.right);
    }
    return false;
}