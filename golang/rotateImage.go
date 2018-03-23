/*
Note: Try to solve this task in-place (with O(1) additional memory), since this is what you'll be asked to do during an interview.

You are given an n x n 2D matrix that represents an image. Rotate the image by 90 degrees (clockwise).
*/
func rotateImage(a [][]int) [][]int {
    l := len(a)
    result := make([][]int, l)
    for i :=0 ; i < l; i++{
        result[i] = make([]int, l)
    }
    for i := 0; i < l; i++ {
        for j := 0; j < l; j++ {
            result[j][l-1-i] = a[i][j];
        }
    }
    return result;
}
