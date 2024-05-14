   class Solution {
    private int[][] grid; // Holds the grid with gold amounts
    private int rows;     // Number of rows in the grid
    private int cols;     // Number of columns in the grid

    // Computes the maximum gold that can be collected
    public int getMaximumGold(int[][] grid) {
        // Initialize rows and cols based on the input grid size
        rows = grid.length;
        cols = grid[0].length;
        this.grid = grid; // Assign the grid
        int maxGold = 0;  // Initialize maximum gold collected

        // Iterate over all cells of the grid
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                // Update maxGold with the maximum of the current maxGold or the gold collected by DFS from this cell
                maxGold = Math.max(maxGold, dfs(i, j));
            }
        }
        return maxGold; // Return the maximum gold collected
    }

    // Helper method for depth-first search
    private int dfs(int row, int col) {
        // Base case: If the cell is out of the grid bounds or has 0 gold, return 0
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0) {
            return 0;
        }
        // Store gold value of the current cell
        int gold = grid[row][col];
        // Mark the current cell as visited by setting gold to 0
        grid[row][col] = 0;

        // Array to facilitate iteration over the adjacent cells (up, right, down, left)
        int[] directions = {-1, 0, 1, 0, -1};
        int maxGold = 0; // Initialize max gold collected from this cell

        // Iterate over all adjacent cells
        for (int k = 0; k < 4; ++k) {
            // Calculate the gold collected by DFS of the adjacent cells and update maxGold accordingly
            maxGold = Math.max(maxGold, gold + dfs(row + directions[k], col + directions[k + 1]));
        }
        // Backtrack: reset the value of the cell to the original gold amount
        grid[row][col] = gold;

        // Return the maximum gold that can be collected from this cell
        return maxGold;
    }
}
