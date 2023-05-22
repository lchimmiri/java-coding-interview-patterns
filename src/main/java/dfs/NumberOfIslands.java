package dfs;

public class NumberOfIslands {
    public static void main(String[] args) {
        int[][] grid1 = new int[][]{{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};
        int[][] grid2 = new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}};

        System.out.println(findNumOfIslands(grid1)); //1
        System.out.println(findNumOfIslands(grid2)); // 3
    }

    private static int findNumOfIslands(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int islandCount = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == 1){
                    islandCount += findIslandsRec(grid, i,j);
                }
            }
        }

        return islandCount;
    }

    private static int findIslandsRec(int[][] grid, int i, int j) {
        if(i <0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] == 0){
            return 0;
        }

        grid[i][j] = 0;

        findIslandsRec(grid, i-1,j);
        findIslandsRec(grid, i+1,j);
        findIslandsRec(grid, i, j-1);
        findIslandsRec(grid, i, j+1);

        return 1;
    }
}
