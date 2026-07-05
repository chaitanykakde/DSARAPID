import java.util.*;

public class FullPractice {
    public static void main(String args[]) {
        // find hihsest degree of a node
        // take input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashSet<Integer>[] adj = new HashSet[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new HashSet<>();
        }

        // build graph

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj[u].add(v);
            adj[v].add(u);
        }

        // now count the no of connected components
        // apply th dfs for that
        // or bfs
        int vis[] = new int[n];
        int count = 0;
        int largest = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {

                count++;
                System.out.println("Connected Componet No: " + count);
                vis[i] = 1;
                largest = Math.max(bfs(adj, vis, i), largest);
                System.out.println();
            }
        }

        System.out.println("No of connected componests" + count);
        System.out.println("largest Coneected componets :" + largest);

    }

    public static int dfs(HashSet<Integer>[] adj, int[] vis, int node) {
        vis[node] = 1;
        int lent = 1;
        System.out.println("Node Vis:" + node);
        for (int x : adj[node]) {
            if (vis[x] == 0) {
                lent += dfs(adj, vis, x);
            }
        }
        return lent;
    }

    public static int bfs(HashSet<Integer> adj[], int vis[], int node) {
        vis[node] = 1;

        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        int size = 1;
        while (!q.isEmpty()) {
            int currNode = q.peek();
            System.out.print(currNode + " , ");
            q.poll();
            for (int x : adj[currNode]) {
                if (vis[x] == 0) {
                    size += 1;
                    q.add(x);
                    vis[x] = 1;
                }
            }
        }
        return size;

    }

    public void degree() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashSet<Integer>[] adj = new HashSet[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new HashSet<>();
        }

        // build graph

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            if (u >= 0 && u < n && v >= 0 && v < n && u != v) {
                adj[u].add(v);
                adj[v].add(u);
            }
        }
        // find the degrress of all nodes
        for (HashSet<Integer> set : adj) {

            System.out.println(set);
        }

        // calculate max
        int maxDegree = Integer.MIN_VALUE;
        int maxDegreeNode = -1;
        for (int i = 0; i < adj.length; i++) {

            System.out.println("Degree of node" + i + " :" + adj[i].size());
            if (adj[i].size() > maxDegree) {
                maxDegree = adj[i].size();
                maxDegreeNode = i;
            }
            // maxDegree=Math.max(maxDegree,adj[i].size());
        }

        System.out.println("Max Degree Node is : " + maxDegreeNode + " its Degree is :" + maxDegree);

    }
}
