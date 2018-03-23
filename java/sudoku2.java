/*
Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid with numbers in such a way that each column, each row, and each of the nine 3 × 3 sub-grids that compose the grid all contain all of the numbers from 1 to 9 one time.

Implement an algorithm that will check whether the given grid of numbers represents a valid Sudoku puzzle according to the layout rules described above. Note that the puzzle represented by grid does not have to be solvable.
*/

boolean sudoku2(char[][] grid) {
	int[][] newGrid = new int[grid.length][grid.length];
	for (int i = 0; i < newGrid.length; i++) {
		for (int j = 0; j < newGrid.length; j++) {
			if(grid[i][j] == '.'){
				newGrid[i][j] = -1;
			}else{
				newGrid[i][j] = grid[i][j] - '0';
			}
		}
	}
	return boxCheck(newGrid) && rowColumnCheck(newGrid);
}

boolean boxCheck(int[][] grid) {
	for (int i = 0; i < grid.length; i += 3) {
		for (int j = 0; j < grid.length; j += 3) {
			boolean[] gridMatrix = new boolean[9];
			for (int k = i; k < 3 + i; k++) {
				for (int l = j; l < 3 + j; l++) {
					int currentNumber = grid[k][l];
					if (currentNumber != -1) {
						if(!gridMatrix[currentNumber-1]){
							gridMatrix[currentNumber-1] = true;
						}else{
							return false;
						}
					}
				}
			}
		}
	}
	return true;
}

boolean rowColumnCheck(int[][] grid) {
	for (int i = 0; i < 9; i++) {
		boolean[] rowArray = new boolean[9];
		boolean[] columnArray = new boolean[9];
		for (int j = 0; j < 9; j++) {
			int currentNumberRow = grid[i][j];
			int currentNumberColumn = grid[j][i];
			if (currentNumberRow != -1) {
				if(!rowArray[currentNumberRow - 1]){
					rowArray[currentNumberRow - 1] = true;
				}else{
					return false;
				}
			}
			if(currentNumberColumn != -1){
				if(!columnArray[currentNumberColumn - 1]){
					columnArray[currentNumberColumn - 1] = true;
				}else{
					return false;
				}
			}
		}
	}
	return true;
}