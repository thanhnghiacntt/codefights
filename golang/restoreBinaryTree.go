/*
Note: Your solution should have O(inorder.length) time complexity, since this is what you will be asked to accomplish in an interview.

Let's define inorder and preorder traversals of a binary tree as follows:

Inorder traversal first visits the left subtree, then the root, then its right subtree;
Preorder traversal first visits the root, then its left subtree, then its right subtree.
For example, if tree looks like this:

    1
   / \
  2   3
 /   / \
4   5   6
then the traversals will be as follows:

Inorder traversal: [4, 2, 1, 5, 3, 6]
Preorder traversal: [1, 2, 4, 3, 5, 6]
Given the inorder and preorder traversals of a binary tree t, but not t itself, restore t and return it.
*/
func restoreBinaryTree(inorder []int, preorder []int) *Tree {
  if(len(preorder) > 0){
    var node = &Tree{
      Value: preorder[0],
      Left: nil,
      Right: nil,
    }
    var index = indexOf(inorder, preorder[0]);
    if(index > -1){
      var leftIn = createArray(inorder, 0, index);
      var rightIn = createArray(inorder, index + 1, len(inorder));
      var leftPr = createArray(preorder, 1, 1 + index);
      var rightPr = createArray(preorder, 1 + index, len(preorder));
      node.Left = restoreBinaryTree(leftIn, leftPr);
      node.Right = restoreBinaryTree(rightIn, rightPr);
    }
    return node;
  }
  return nil;
}

func createArray(in []int, start int, end int) ([]int){
  if(len(in) == 0){
    return in;
  }
  var len = end - start;
  var array = make([]int, len);
  for i:= 0; i < len; i++{
      array[i] = in[i + start];
  }
  return array;
}

func indexOf(array []int, value int)(int){
  for i, v := range array{
    if(v == value){
      return i;
    }
  }
  return -1;
}
