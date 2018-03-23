/*
Given a binary tree t, determine whether it is symmetric around its center, i.e. each side mirrors the other.
*/
boolean isTreeSymmetric(Tree<Integer> t) {
    if(t == null){
        return true;
    }
    if (browser(t.left, true).equals(browser(t.right, false))) {
        return true;
    }
    return false;
}

String browser(Tree<Integer> t, boolean isNodeLeftRight) {
    if (t == null) {
        return "";
    }
    if (isNodeLeftRight) {
        return t.value + ":" + browser(t.left, isNodeLeftRight) + ":"
                + browser(t.right, isNodeLeftRight);
    } else {
        return t.value + ":" + browser(t.right, isNodeLeftRight) + ":"
                + browser(t.left, isNodeLeftRight);
    }
}