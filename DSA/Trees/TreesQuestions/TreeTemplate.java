import java.util.*;

public class TreeTemplate {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;

        }
    }

    TreeNode root;

    public void buildTree(Integer[] arr) {
        this.root = buildTree(arr, 0);
    }

    private TreeNode buildTree(Integer arr[], int index) {
        if (arr.length == 0) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = null;
        if (arr[index] != null) {
            root = new TreeNode(arr[index++]);
            q.offer(root);
        }

        while (!q.isEmpty() && index < arr.length) {
            TreeNode t = q.poll();
            if (index < arr.length && arr[index] != null) {
                TreeNode temp = new TreeNode(arr[index]);
                t.left = temp;
                q.offer(temp);
            }
            index++;
            if (index < arr.length && arr[index] != null) {
                TreeNode temp = new TreeNode(arr[index]);
                t.right = temp;
                q.offer(temp);
            }
            index++;
        }
        return root;
    }

    public void levelOrderBFS() {
        levelOrderBFS(this.root);
    }

    private void levelOrderBFS(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                System.out.print(curr.val + " ");
                if (curr.left != null) {
                    q.offer(curr.left);
                }

                if (curr.right != null) {
                    q.offer(curr.right);
                }

            }
            System.out.println();

        }
    }

    public void display() {
        display(this.root);
    }

    public void display(TreeNode root) {
        if (root == null) {
            return;
        }
        display(root.left);
        System.out.println(root.val);
        display(root.right);
    }

    // 102. Binary Tree Level Order Traversal
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode curr = q.poll();
                list.add(curr.val);
                if (curr.left != null) {
                    q.offer(curr.left);
                }

                if (curr.right != null) {
                    q.offer(curr.right);
                }

            }
            ans.add(list);
            System.out.println();

        }
        return ans;

    }
    // 637. Average of Levels in Binary Tree

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            double sizeOfLevel = 0;
            double d = 0;
            for (int i = 0; i < size; i++) {

                TreeNode curr = q.poll();
                d += curr.val;
                sizeOfLevel++;
                if (curr.left != null) {
                    q.offer(curr.left);
                }

                if (curr.right != null) {
                    q.offer(curr.right);
                }

            }
            ans.add(d / sizeOfLevel);

        }
        return ans;
    }

    // level order successor of a node in a tree - Google
    public int levelOrderSuccessor(TreeNode root, int target) {

        if (root == null) {
            return -1;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean stop = true;
        while (!q.isEmpty() && stop) {
            int size = q.size();

            for (int i = 0; i < size; i++) {

                TreeNode curr = q.poll();
                if (curr.left != null) {
                    q.offer(curr.left);
                }

                if (curr.right != null) {
                    q.offer(curr.right);
                }
                if (curr.val == target) {
                    stop = false;
                    break;
                }

            }

        }
        return q.poll().val;

    }

    // 103. Binary Tree Zigzag Level Order Traversal

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean rev = false;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                if (!rev) {
                    TreeNode curr = q.pollFirst();
                    if (curr.left != null) {
                        q.addLast(curr.left);
                    }

                    if (curr.right != null) {
                        q.addLast(curr.right);
                    }
                    list.add(curr.val);

                } else {
                    TreeNode curr = q.pollLast();
                    if (curr.right != null) {
                        q.addFirst(curr.right);
                    }
                    if (curr.left != null) {
                        q.addFirst(curr.left);
                    }
                    list.add(curr.val);
                }

            }
            rev = !rev;
            ans.add(list);

        }
        return ans;

    }

    // 107. Binary Tree Level Order Traversal II
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode curr = q.poll();
                list.add(curr.val);
                if (curr.left != null) {
                    q.offer(curr.left);
                }

                if (curr.right != null) {
                    q.offer(curr.right);
                }

            }
            ans.add(list);
            System.out.println();

        }
        Collections.reverse(ans);
        return ans;
    }

    public TreeNode connect1(TreeNode root) {
        if (root == null) {
            root.next = null;
            return root;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {

                TreeNode curr = q.poll();
                if (i < size - 1) {
                    curr.next = q.peek();
                } else {
                    curr.next = null;
                }
                if (curr.left != null) {
                    q.offer(curr.left);
                }

                if (curr.right != null) {
                    q.offer(curr.right);
                }

            }

            // System.out.println();

        }
        return root;
    }

    public TreeNode connect(TreeNode root) {

        if (root == null) {
            return root;
        }
        TreeNode leftMost = root;
        while (leftMost.left != null) {
            TreeNode current = leftMost;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftMost = leftMost.left;
        }

        return root;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.left, q.left);

    }

    public boolean isSameTree1(TreeNode p, TreeNode q) {
        List<Integer> pin = new ArrayList<>();
        getInorder(p, pin);
        List<Integer> qin = new ArrayList<>();
        getInorder(q, qin);

        if (pin.size() != qin.size()) {
            return false;
        }

        for (Integer i = 0; i < pin.size(); i++) {
            if (pin.get(i) != qin.get(i)) {
                return false;
            }
        }

        return true;
    }

    public void getInorder(TreeNode p, List<Integer> inorder) {
        if (p == null) {
            inorder.add(null);
            return;
        }

        getInorder(p.left, inorder);
        inorder.add(p.val);
        getInorder(p.right, inorder);

    }

    // 199. Binary Tree Right Side View

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode curr = q.poll();
                list.add(curr.val);
                if (curr.left != null) {
                    q.offer(curr.left);
                }

                if (curr.right != null) {
                    q.offer(curr.right);
                }

            }
            ans.add(list.get(list.size() - 1));

        }
        return ans;

    }

    // 993. Cousins in Binary Tree

    static class Pair {
        int depth;
        TreeNode parent;

        public Pair(int depth, TreeNode node) {
            this.depth = depth;
            this.parent = node;
        }

    }

    public boolean isCousins(TreeNode root, int x, int y) {
        Pair left = getParentAndDepth(root, x, 0);
        Pair right = getParentAndDepth(root, y, 0);
        if (left == null || right == null) {
            return false;
        }
        if (left.depth != right.depth) {
            return false;
        }
        if (left.parent == right.parent) {
            return false;
        }
        return true;
    }

    public Pair getParentAndDepth(TreeNode root, int target, int depth) {
        if (root == null) {
            return null;
        }
        if (root.left != null && root.left.val == target) {
            return new Pair(depth, root);
        }
        if (root.right != null && root.right.val == target) {
            return new Pair(depth, root);
        }

        Pair left = getParentAndDepth(root.left, target, depth + 1);
        if (left != null) {
            return left;
        }

        return getParentAndDepth(root.right, target, depth + 1);

    }

    // 101. Symmetric Tree
    public boolean isSymmetric(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return false;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode curr = q.poll();
                list.add(curr.val);
                if (curr.left != null) {
                    q.offer(curr.left);
                }

                if (curr.right != null) {
                    q.offer(curr.right);
                }

            }
            ans.add(list);
            System.out.println();

        }
        return ans;
    }

    public static void main(String[] args) {
        TreeTemplate tree = new TreeTemplate();
        TreeTemplate tree1 = new TreeTemplate();
        Integer[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
        Integer[] arr1 = { 3, 3 };
        tree.buildTree(arr);
        tree1.buildTree(arr1);
        // tree.display();
        // tree.levelOrderBFS();

        // List<List<Integer>> ans = tree.levelOrder(tree.root);
        // for (List<Integer> x : ans) {
        // System.out.println(x);
        // }

        // List<Double> ans = tree.averageOfLevels(tree.root);
        // System.out.println(ans);

        // System.out.println(tree.levelOrderSuccessor(tree.root, 3));

        // List<List<Integer>> ans = tree.zigzagLevelOrder(tree.root);
        // for (List<Integer> x : ans) {
        // System.out.println(x);
        // }

        // System.out.println(tree.isSameTree(tree.root, tree1.root));
        tree.levelOrderBFS();

        // System.out.println(tree.rightSideView(tree.root));
        System.out.println(tree.isCousins(tree.root, 8, 9));

    }
}