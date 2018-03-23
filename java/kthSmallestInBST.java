/*
Note: Your solution should have only one BST traversal and O(1) extra space complexity, since this is what you will be asked to accomplish in an interview.

A tree is considered a binary search tree (BST) if for each of its nodes the following is true:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and the right subtrees must also be binary search trees.
Given a binary search tree t, find the kth smallest element in it.

Note that kth smallest element means kth element in increasing order. See examples for better understanding.
*/
int kthSmallestInBST(Tree<Integer> t, int k) {
    List<Integer> list = new ArrayList<Integer>();
    kthLargest(t, list);
    if(k <= list.size()){
        return list.get(k-1);
    }
    return 0;
}

void kthLargest(Tree<Integer> t, List<Integer> list) {
    if(t != null){
        kthLargest(t.left, list);
        list.add(t.value);
        kthLargest(t.right, list);
    }
}