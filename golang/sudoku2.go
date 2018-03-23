/*
Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid with numbers in such a way that each column, each row, and each of the nine 3 × 3 sub-grids that compose the grid all contain all of the numbers from 1 to 9 one time.

Implement an algorithm that will check whether the given grid of numbers represents a valid Sudoku puzzle according to the layout rules described above. Note that the puzzle represented by grid does not have to be solvable.
*/
import "math"

func sudoku2(grid [][]string) bool {
    var l = len(grid);
    var c = math.Sqrt(float64(l))
    var sqrt int = int(c);
    for i := 0; i < l; i++ {
        var row = make([]bool, l)
        var column = make([]bool, l)
        var sub = make([]bool, l)
        for j := 0; j < l; j++ {
            if grid[i][j] != "." {
                if row[grid[i][j][0] - 49] {
                    return false
                }
                row[grid[i][j][0] - 49] = true
            }
            if grid[j][i] != "." {
                if column[grid[j][i][0] - 49] {
                    return false
                }
                column[grid[j][i][0] - 49] = true
            }
            x := (i%sqrt)*sqrt + j%sqrt
            y := (i/sqrt)*sqrt + j/sqrt
            if grid[y][x] != "." {
                if sub[grid[y][x][0] - 49] {
                    return false
                }
                sub[grid[y][x][0] - 49] = true
            }
        }
    }
    return true
}
