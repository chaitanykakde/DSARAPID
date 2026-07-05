import java.util.*;

public class GraphInput {

    public void graphSimpleTasks(ArrayList<ArrayList<Integer>> adj, int n, int m) {
        // // printint the edges
        // for (ArrayList<Integer> list : adj) {
        // System.out.println(list);
        // }

        // print naighbours of of every node
        for (int i = 1; i <= m; i++) {
            ArrayList<Integer> list = adj.get(i);
            System.out.println("Neighbours of " + i + " :" + list);

        }

        // print degree of each node
        for (int i = 1; i <= m; i++) {
            ArrayList<Integer> list = adj.get(i);
            System.out.println("Degree of " + i + " :" + list.size());

        }

        // find total no of edges
        int edges = 0;
        for (int i = 1; i < adj.size(); i++) {
            edges += adj.get(i).size();
        }
        System.out.println("Edges: " + edges / 2);

        // Task 4: Check Edge Exists

        int u = 1;
        int u1 = 4;
        int v = 2;
        int v1 = 7;
        boolean first = false;
        boolean second = false;
        for (int i = 1; i < adj.size(); i++) {
            for (int x : adj.get(i)) {
                if (i == u && x == 2) {
                    first = true;
                    // System.out.println("Edge present : Yes" + "U : " + u + " V:" + v);

                }
                if (i == u1 & v1 == x) {
                    second = true;
                }
            }
        }

        if (first) {
            System.out.println("Edge present : Yes " + "U : " + u + " V:" + v);
        } else {
            System.out.println("Edge Not present : NO " + "U : " + u + " V:" + v);
        }
        if (second) {
            System.out.println("Edge present : Yes " + "U : " + u1 + " V:" + v1);
        } else {
            System.out.println("Edge Not present : NO " + "U : " + u1 + " V:" + v1);
        }

        // check all naighbours of node 2
        for (int list : adj.get(2)) {
            System.out.println(list);
        }
    }

    // dfs traversal
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int[] vis, int node) {
        vis[node] = 1;
        System.out.print("Node :" + node + ",");
        for (int x : adj.get(node)) {
            if (vis[x] == 0) {
                dfs(adj, vis, x);
            }
        }
    }

    // bfs traversal
    public static void bfs(ArrayList<ArrayList<Integer>> adj, int[] vis, int start) {
        vis[start] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print("->" + node + ",");
            for (int x : adj.get(node)) {
                if (vis[x] == 0) {
                    vis[x] = 1;
                    q.add(x);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        // assigning empty list
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        // taking edges as a inpu t
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int vis[] = new int[n + 1];

        // int count = 0;
        // for (int i = 1; i <= n; i++) {

        // if (vis[i] == 0) {
        // count++;
        // dfs(adj, vis, i);
        // }

        // }
        // System.out.println("Connected Components:" + count);
        // }

        int provincesCount = 0;

        for (int i = 1; i < adj.size(); i++) {
            if (vis[i] == 0) {
                provincesCount++;
                bfs(adj, vis, i);

            }
        }
        System.out.println("Count of Components:" + provincesCount);

    }
}
