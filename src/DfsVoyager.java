public class DfsVoyager implements Voyager {
    public int lookupIslands(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int islandCount = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    exploreIsland(grid, row, col);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }
    private void exploreIsland(int[][] grid, int row, int col) {

        if (row < 0 || col < 0 || row >= grid.length ||
                col >= grid[0].length || grid[row][col] != 1) {
            return;
        }

        grid[row][col] = 0;
        exploreIsland(grid, row + 1, col);
        exploreIsland(grid, row - 1, col);
        exploreIsland(grid, row, col + 1);
        exploreIsland(grid, row, col - 1);
    }
}
