import java.nio.file.Paths;
import java.util.*;
import javax.swing.Scrollable;

public class Lcpoftheday {

    // date 2nd july 2026
    // 3286. Find a Safe Walk Through a Grid. APPROACH 1 : USING DFS AND 3D DP
    // Medium
    // Topics
    // premium lock icon
    // Companies
    // Hint
    // You are given an m x n binary matrix grid and an integer health.

    // You start on the upper-left corner (0, 0) and would like to get to the
    // lower-right corner (m - 1, n - 1).

    // You can move up, down, left, or right from one cell to another adjacent cell
    // as long as your health remains positive.

    // Cells (i, j) with grid[i][j] = 1 are considered unsafe and reduce your health
    // by 1.

    // Return true if you can reach the final cell with a health value of 1 or more,
    // and false otherwise.

    // Example 1:

    // Input: grid = [[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]], health = 1

    // Output: true

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();

        int vis[][] = new int[n][m];
        int dp[][][] = new int[n][m][health + 1];
        for (int x[][] : dp) {
            for (int y[] : x) {
                Arrays.fill(y, -1);
            }
        }
        return findSafeWalkHelper(grid, health, vis, n - 1, m - 1, dp);
    }

    public boolean findSafeWalkHelper(List<List<Integer>> grid, int health, int[][] vis, int n, int m, int[][][] dp) {
        // health reduction in case of unsafe move
        health = health - grid.get(n).get(m);
        if (health < 1) {
            return false;
        }
        // check if its already computed
        if (dp[n][m][health] != -1) {
            return dp[n][m][health] == 1;
        }
        // make vis 1 for current cell
        vis[n][m] = 1;

        // base case
        if (n == 0 && m == 0) {
            vis[n][m] = 0;
            if (health >= 1) {
                return true;
            } else {
                return false;
            }
        }
        // now move to all directions
        // move up
        if (isValid(n - 1, m, grid.size(), grid.get(0).size()) && vis[n - 1][m] == 0) {
            if (findSafeWalkHelper(grid, health, vis, n - 1, m, dp)) {
                dp[n][m][health] = 1;
                return true;
            }
        }
        // move down
        if (isValid(n + 1, m, grid.size(), grid.get(0).size()) && vis[n + 1][m] == 0) {
            if (findSafeWalkHelper(grid, health, vis, n + 1, m, dp)) {
                dp[n][m][health] = 1;
                return true;
            }
        }
        // move left
        if (isValid(n, m - 1, grid.size(), grid.get(0).size()) && vis[n][m - 1] == 0) {
            if (findSafeWalkHelper(grid, health, vis, n, m - 1, dp)) {
                dp[n][m][health] = 1;
                return true;
            }
        }
        // move right
        if (isValid(n, m + 1, grid.size(), grid.get(0).size()) && vis[n][m + 1] == 0) {
            if (findSafeWalkHelper(grid, health, vis, n, m + 1, dp)) {
                dp[n][m][health] = 1;
                return true;
            }
        }

        // make vis 0 for current cell should not affect on other cells
        vis[n][m] = 0;
        dp[n][m][health] = 0;
        return false;
    }

    public boolean isValid(int currN, int currM, int n, int m) {
        if (currN >= 0 && currN < n && currM >= 0 && currM < m) {
            return true;
        }
        return false;
    }

    // day 2 date : 3 jul 2026. - dissappointed by me i have copied this solution
    // 3620. Network Recovery Pathways
    // Hard
    // Topics
    // premium lock icon
    // Companies
    // Hint
    // You are given a directed acyclic graph of n nodes numbered from 0 to n − 1.
    // This is represented by a 2D array edges of length m, where edges[i] = [ui,
    // vi, costi] indicates a one‑way communication from node ui to node vi with a
    // recovery cost of costi.

    // Some nodes may be offline. You are given a boolean array online where
    // online[i] = true means node i is online. Nodes 0 and n − 1 are always online.

    // A path from 0 to n − 1 is valid if:

    // All intermediate nodes on the path are online.
    // The total recovery cost of all edges on the path does not exceed k.
    // For each valid path, define its score as the minimum edge‑cost along that
    // path.

    // Return the maximum path score (i.e., the largest minimum-edge cost) among all
    // valid paths. If no valid path exists, return -1
    static class Edge {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static class State {
        int node;
        long dist;

        State(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    List<Edge>[] graph;
    boolean[] online;
    long k;
    int n;

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        this.online = online;
        this.k = k;
        this.n = online.length;

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int maxCost = 0;

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];

            graph[u].add(new Edge(v, cost));

            maxCost = Math.max(maxCost, cost);
        }

        int low = 1;
        int high = maxCost;

        int answer = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canReach(mid)) {

                answer = mid;

                // Try to get a better minimum edge
                low = mid + 1;

            } else {

                high = mid - 1;
            }
        }

        return answer;
    }

    private boolean canReach(int minScore) {

        long[] dist = new long[n];

        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));

        dist[0] = 0;

        pq.offer(new State(0, 0));

        while (!pq.isEmpty()) {

            State current = pq.poll();

            int node = current.node;
            long currentDist = current.dist;

            if (currentDist != dist[node]) {
                continue;
            }

            if (currentDist > k) {
                continue;
            }

            if (node == n - 1) {
                return true;
            }

            for (Edge edge : graph[node]) {

                // Edge is too weak
                if (edge.cost < minScore) {
                    continue;
                }

                // Intermediate node must be online
                if (edge.to != n - 1 && !online[edge.to]) {
                    continue;
                }

                long newDist = currentDist + edge.cost;

                if (newDist <= k && newDist < dist[edge.to]) {

                    dist[edge.to] = newDist;

                    pq.offer(new State(edge.to, newDist));
                }
            }
        }

        return false;
    }

    // Day 4 jul 2026
    // 2492. Minimum Score of a Path Between Two Cities
    // Medium
    // Topics
    // premium lock icon
    // Companies
    // Hint
    // You are given a positive integer n representing n cities numbered from 1 to
    // n. You are also given a 2D array roads where roads[i] = [ai, bi, distancei]
    // indicates that there is a bidirectional road between cities ai and bi with a
    // distance equal to distancei. The cities graph is not necessarily connected.

    // The score of a path between two cities is defined as the minimum distance of
    // a road in this path.

    // Return the minimum possible score of a path between cities 1 and n.

    // Note:

    // A path is a sequence of roads between two cities.
    // It is allowed for a path to contain the same road multiple times, and you can
    // visit cities 1 and n multiple times along the path.
    // The test cases are generated such that there is at least one path between 1
    // and n.

    static class Pair {
        int node;
        int distance;

        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public int minScore(int n, int[][] roads) {
        // build the adjecency list
        List<List<Pair>> adj = new ArrayList();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Pair>());
        }
        // adjecentcy list from the given edges and distance

        for (int[] x : roads) {
            int u = x[0];
            int v = x[1];
            int distance = x[2];
            adj.get(u).add(new Pair(v, distance));
            adj.get(v).add(new Pair(u, distance));
        }

        // make one reference var arr sized one to keep track of answer with no return
        // type in dfs
        int[] ans = new int[1];
        ans[0] = Integer.MAX_VALUE;

        // make a vis array to do not allow dfa to visit same node again
        int[] vis = new int[n + 1];

        // start the dfs from 1
        dfsForFindingMinRoadLength(adj, vis, 1, ans);

        return ans[0];
    }

    private void dfsForFindingMinRoadLength(List<List<Pair>> adj, int[] vis, int node, int[] ans) {
        vis[node] = 1;

        // explore its adjecents
        for (Pair pair : adj.get(node)) {
            int city = pair.node;
            int distance = pair.distance;
            ans[0] = Math.min(ans[0], distance);
            if (vis[city] == 0) {
                dfsForFindingMinRoadLength(adj, vis, city, ans);
            }
        }

    }

    // day 5 jul 2026
    // 1301. Number of Paths with Max Score
    // Hard
    // Topics
    // premium lock icon
    // Companies
    // Hint
    // You are given a square board of characters. You can move on the board
    // starting at the bottom right square marked with the character 'S'.

    // You need to reach the top left square marked with the character 'E'. The rest
    // of the squares are labeled either with a numeric character 1, 2, ..., 9 or
    // with an obstacle 'X'. In one move you can go up, left or up-left (diagonally)
    // only if there is no obstacle there.

    // Return a list of two integers: the first integer is the maximum sum of
    // numeric characters you can collect, and the second is the number of such
    // paths that you can take to get that maximum sum, taken modulo 10^9 + 7.

    // In case there is no path, return [0, 0].

    static class MaxPath {
        int score;
        int paths;

        public MaxPath(int score, int paths) {
            this.score = score;
            this.paths = paths;
        }

    }

    public int[] pathsWithMaxScore(List<String> boardS) {

        // convert list of strings to the char board
        int n = boardS.size();
        int m = boardS.get(0).length();

        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = boardS.get(i);
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        // create hashmap to store the answers
        // HashMap<Integer, Integer> map = new HashMap<>();

        // declare dp as it tle hit because of repeated paths
        int dp[][] = new int[n + 1][m + 1];
        int dpPaths[][] = new int[n + 1][m + 1];
        // fill with -1
        for (int[] x : dp) {
            Arrays.fill(x, -1);
        }
        for (int[] x : dpPaths) {
            Arrays.fill(x, -1);
        }
        int mod = (int) 1e9 + 7;

        MaxPath maxpath = getMaxScore(board, dpPaths, n - 1, m - 1, n, m, mod, dp);

        return new int[] { (maxpath.score == -1) ? 0 : maxpath.score, maxpath.paths };

    }

    private MaxPath getMaxScore(char[][] board, int[][] dpPaths, int i, int j, int n, int m,
            int mod, int[][] dp) {
        if (i == 0 && j == 0) {
            return new MaxPath(0, 1);
        }
        if (board[i][j] == 'X') {
            return new MaxPath(-1, 0);
        }
        if (dpPaths[i][j] != -1) {
            return new MaxPath(dp[i][j], dpPaths[i][j]);
        }
        int currScore = (board[i][j] == 'S') ? 0 : board[i][j] - '0';

        // calcualte the scrore till now + current board score
        // int nextScore = (currScore + score) % mod;
        // move up

        int scoreFromThisPath = -1;
        int pathCount = 0;

        MaxPath maxPath;
        if (checkIsValid(i - 1, j, n, m)) {
            maxPath = getMaxScore(board, dpPaths, i - 1, j, n, m, mod, dp);
            if (maxPath.score != -1) {
                if (scoreFromThisPath <= maxPath.score) {

                    if (scoreFromThisPath == maxPath.score) {
                        pathCount = (pathCount + maxPath.paths) % mod;
                    } else {
                        pathCount = maxPath.paths;
                    }
                    scoreFromThisPath = maxPath.score;

                }
            }
        }

        // move up left (diagonally )
        if (checkIsValid(i - 1, j - 1, n, m)) {
            maxPath = getMaxScore(board, dpPaths, i - 1, j - 1, n, m, mod, dp);
            if (maxPath.score != -1) {
                if (scoreFromThisPath <= maxPath.score) {

                    if (scoreFromThisPath == maxPath.score) {
                        pathCount = (pathCount + maxPath.paths) % mod;
                    } else {
                        pathCount = maxPath.paths;
                    }
                    scoreFromThisPath = maxPath.score;
                }
            }
        }

        // move left
        if (checkIsValid(i, j - 1, n, m)) {
            maxPath = getMaxScore(board, dpPaths, i, j - 1, n, m, mod, dp);
            if (maxPath.score != -1) {
                if (scoreFromThisPath <= maxPath.score) {

                    if (scoreFromThisPath == maxPath.score) {
                        pathCount = (pathCount + maxPath.paths) % mod;
                    } else {
                        pathCount = maxPath.paths;
                    }
                    scoreFromThisPath = maxPath.score;
                }
            }
        }

        if (scoreFromThisPath == -1) {
            dp[i][j] = -1;
            dpPaths[i][j] = 0;
        } else {
            dp[i][j] = (scoreFromThisPath + currScore) % mod;
            dpPaths[i][j] = pathCount;
        }

        return new MaxPath(dp[i][j], dpPaths[i][j]);
    }

    public boolean checkIsValid(int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
