import java.util.*;

import DSARAPID.DSA.Graphs.Basic.GraphPractice.Pair;
import java.awt.Paint;

public class GraphPractice {

    public boolean isCycle(int V, int[][] edges) {
        // Code here
        /// build grpah from edges
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] list : edges) {
            int u = list[0];
            int v = list[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // now aply bfs or dfs alogritham

        int provincesCount = 0;
        int vis[] = new int[V + 1];
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (bfs(adj, vis, i, -1) == true) {
                    return true;
                }
            }

        }
        return false;
    }

    public boolean bfs(ArrayList<ArrayList<Integer>> adj, int[] vis, int start, int parent) {
        Queue<Pair> q = new LinkedList<>();
        vis[start] = 1;
        q.add(new Pair(start, parent));

        while (!q.isEmpty()) {
            int node = q.peek().node;
            int parentNode = q.peek().parent;
            q.poll();

            for (int x : adj.get(node)) {
                if (vis[x] == 0) {
                    vis[x] = 1;
                    q.add(new Pair(x, node));
                } else if (parentNode != x) {
                    return true;
                }
            }

        }
        return false;
    }

    public static boolean dsf(ArrayList<ArrayList<Integer>> adj, int[] vis, int start, int parent) {

        vis[start] = 1;
        for (int x : adj.get(start)) {
            if (vis[x] == 0) {
                vis[x] = 1;
                if (dsf(adj, vis, x, start) == true) {
                    return true;
                }
            } else if (parent != x) {
                return true;
            }
        }
        return false;
    }

    static class Pair {
        int node;
        int parent;

        public Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }

    }

    // 200. Number of Islands
    // Medium
    // Topics
    // premium lock icon
    // Companies
    // Given an m x n 2D binary grid grid which represents a map of '1's (land) and
    // '0's (water), return the number of islands.

    // An island is surrounded by water and is formed by connecting adjacent lands
    // horizontally or vertically. You may assume all four edges of the grid are all
    // surrounded by water.

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];

        int[] rowGrid = { -1, 0, 1, 0 };
        int[] colGrid = { 0, 1, 0, -1 };
        int countOfIslands = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && vis[i][j] == 0) {
                    vis[i][j] = 1;
                    bfsIslands(grid, vis, i, j, rowGrid, colGrid);
                    countOfIslands++;
                }
            }
        }
        return countOfIslands;

    }

    public static void bfsIslands(char[][] grid, int[][] vis, int row, int col, int[] rowGrid, int[] colGrid) {
        vis[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));

        while (!q.isEmpty()) {
            int i = q.peek().node;
            int j = q.peek().parent;
            q.poll();
            for (int x = 0; x < 4; x++) {
                int newRow = i + rowGrid[x];
                int newCol = j + colGrid[x];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == '1'
                        && vis[newRow][newCol] == 0) {
                    vis[newRow][newCol] = 1;
                    q.add(new Pair(newRow, newCol));
                }
            }
        }
    }

    // 733. Flood Fill
    // Easy
    // Topics
    // premium lock icon
    // Companies
    // Hint
    // You are given an image represented by an m x n grid of integers image, where
    // image[i][j] represents the pixel value of the image. You are also given three
    // integers sr, sc, and color. Your task is to perform a flood fill on the image
    // starting from the pixel image[sr][sc

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int n = image.length;
        int m = image[0].length;
        int vis[][] = new int[n][m];
        int ansImage[][] = new int[n][m];
        ansImage = image.clone();
        for (int i = 0; i < n; i++) {
            ansImage[i] = image[i].clone();
        }
        int[] rowGrid = { -1, 0, 1, 0 };
        int[] colGrid = { 0, 1, 0, -1 };

        bfsForFloodFill(image, vis, ansImage, sr, sc, color, rowGrid, colGrid);

        return ansImage;
    }

    public static void bfsForFloodFill(int[][] image, int[][] vis, int[][] ansImage, int sr, int sc, int color,
            int[] rowGrid, int[] colGrid) {
        int initialColor = image[sr][sc];
        int n = image.length;
        int m = image[0].length;
        vis[sr][sc] = 1;
        ansImage[sr][sc] = color;
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(sr, sc));

        while (!q.isEmpty()) {
            int row = q.peek().node;
            int col = q.peek().parent;
            q.poll();

            for (int x = 0; x < 4; x++) {
                int newRow = row + rowGrid[x];
                int newCol = col + colGrid[x];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && image[newRow][newCol] == initialColor
                        && vis[newRow][newCol] == 0) {
                    vis[newRow][newCol] = 1;
                    q.add(new Pair(newRow, newCol));
                    ansImage[newRow][newCol] = color;
                }

            }

        }
    }

    // 994. Rotting Oranges
    // Medium
    // Topics
    // premium lock icon
    // Companies
    // You are given an m x n grid where each cell can have one of three values:

    // 0 representing an empty cell,
    // 1 representing a fresh orange, or
    // 2 representing a rotten orange.
    // Every minute, any fresh orange that is 4-directionally adjacent to a rotten
    // orange becomes rotten.

    // Return the minimum number of minutes that must elapse until no cell has a
    // fresh orange. If this is impossible, return -1.

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        Queue<PairOrange> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    vis[i][j] = 1;
                    q.add(new PairOrange(i, j,0));
                }
            }
        }

        int[] rowGrid = { -1, 0, 1, 0 };
        int[] colGrid = { 0, 1, 0, -1 };

        int time=bfsorangeRotting(grid, vis, q, rowGrid, colGrid,n,m);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    time=-1;
                    break;
                }
            }
        }
        return time;

    }

    static class PairOrange{
        int row;
        int col;
        int time;

        public PairOrange(int row,int col,int time) {
            this.row=row;
            this.col=col;
            this.time=time;
        }
        
    }

    public static int bfsorangeRotting(int[][] grid, int[][] vis, Queue<PairOrange> q, int[] rowGrid, int[] colGrid,int n,int m) {
        int maxTime = 0;
        while (!q.isEmpty()) {
            int row = q.peek().row;
            int col = q.peek().col;
            int time=q.peek().time;
            q.poll();

            for (int x = 0; x < 4; x++) {
                int newRow = row + rowGrid[x];
                int newCol = col + colGrid[x];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1
                        && vis[newRow][newCol] == 0) {
                    vis[newRow][newCol] = 1;
                    grid[newRow][newCol]=2;
                    q.add(new PairOrange(newRow, newCol,time+1));
                    maxTime=Math.max(maxTime, time+1);
                }

            }

        }
        return maxTime;
    }

    public static void main(String[] args) {

    }
}
