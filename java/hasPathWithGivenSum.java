/*
Given a binary tree t and an integer s, determine whether there is a root to leaf path in t such that the sum of vertex values equals s.
*/

boolean hasPathWithGivenSum(Tree<Integer> t, int s) {
    if(t == null && s == 0){
        return true;
    }
    if(t == null){
        return false;
    }
    if(hasPathWithGivenSum(t.left, s - t.value)){
        return true;
    }
    if(hasPathWithGivenSum(t.right, s - t.value)){
        return true;
    }
    return false;
}
