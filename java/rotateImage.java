/*
Note: Try to solve this task in-place (with O(1) additional memory), since this is what you'll be asked to do during an interview.

You are given an n x n 2D matrix that represents an image. Rotate the image by 90 degrees (clockwise).
*/

func rotateImage(a [][]int) [][]int {
    var result := new int[a.length][a.length];
	int n = a.length-1;
	for (int i = 0; i <= n; i++) {
		for (int j = 0; j <= n; j++) {
			result[j][n-i] = a[i][j];
		}
	}
	return result;
}
