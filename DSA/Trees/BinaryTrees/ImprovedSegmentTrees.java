
public class ImprovedSegmentTrees {

    public static class Node {
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }

    }

    Node root;

    public ImprovedSegmentTrees(int[] arr) {
        this.root = constructTree(arr, 0, arr.length - 1);

    }

    public Node constructTree(int[] arr, int start, int end) {
        if (start == end) {
            // leaf Node
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }
        // create a new node with index we are currently at
        Node node = new Node(start, end);
        int mid = (start + end) / 2;
        // contruct the left and right
        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid + 1, end);
        // set the node data to addition of its both children
        node.data = node.left.data + node.right.data;
        return node;

    }

    public void display() {
        display(this.root);
    }

    public void display(Node node) {
        String str = "";
        // for left node
        if (node.left != null) {
            str = str + "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data:"
                    + node.left.data + "+ ->";
        } else {
            str = str + "No left Child";
        }
        // for current node
        str = str + "Interval=[" + node.startInterval + "-" + node.endInterval + "] and data:" + node.data + "+ ->";

        // for right node
        if (node.right != null) {
            str = str + "Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data:"
                    + node.right.data + " \n ";
        } else {
            str = str + "No right Child";
        }
        System.out.println(str);

        // call recursion
        if (node.left != null) {
            display(node.left);
        }
        if (node.right != null) {
            display(node.right);
        }

    }

    // query
    public int query(int qsi, int qei) {
        return this.query(this.root, qsi, qei);
    }

    public int query(Node node, int qsi, int qei) {
        if (node.startInterval >= qsi && node.endInterval <= qei) {
            // node is comptetedly lying inside the query
            return node.data;
        } else if (node.startInterval > qei || node.endInterval < qsi) {
            // completedly outside
            return 0;

        } else {
            return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
        }

    }

    public int update(int index, int val) {
        return update(this.root, index, val);
    }

    // update
    private int update(Node node, int index, int val) {
        if (index >= node.startInterval && index <= node.endInterval) {
            if (index == node.startInterval && index == node.endInterval) {
                node.data = val;
                return node.data;
            } else {
                int leftAns = update(node.left, index, val);
                int rightAns = update(node.right, index, val);

                node.data = leftAns + rightAns;
                return node.data;
            }
        }
        return node.data;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 8, 6, 7, -2, -8, 4, 9 };
        ImprovedSegmentTrees tree = new ImprovedSegmentTrees(arr);
        // tree.display();
        System.out.println(tree.query(0, 8));

    }

}
