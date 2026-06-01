public class BST {
    Node root;

    static class Node {
        int val;
        int height;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }

        public int getValue() {
            return val;
        }
    }

    public BST() {
    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        } else {
            return node.height;
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void display() {
        display(root, "Root Node:");
    }

    public void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.getValue());
        display(node.left, "Left Child of " + node.getValue() + " : ");
        display(node.right, "Right Child of " + node.getValue() + " : ");
    }

    public void insert(int value) {
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;

        }
        if (value < node.val) {
            node.left = insert(value, node.left);
        }
        if (value > node.val) {
            node.right = insert(value, node.right);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;
    }

    public boolean balanced() {
        return balanced(root);
    }

    public boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void insertSortedArray(int a[]) {
        insertSorted(a, 0, a.length - 1);
    }

    public void insertSorted(int a[], int s, int e) {
        if (s > e) {
            return;
        }
        int mid = (s + e) / 2;
        insert(a[mid]);
        insertSorted(a, s, mid - 1);
        insertSorted(a, mid + 1, e);

        // 1 2 3 4 5. s=0,end=4. mid=2 inseert(0,mid-1) then 0 and 1 mid=0 thne mid+end.
        // 1 2 3 4 5 6
    }

    public void preorderTraversal() {
        preorder(root);
    }

    public void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public void inorderTraversal() {
        inorder(root);
    }

    public void inorder(Node node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }

    public void postorderTraversal() {
        postorder(root);
    }

    public void postorder(Node node) {
        if (node == null) {
            return;
        }

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.val + " ");
    }

    public static void main(String[] args) {

        BST bst = new BST();
        // bst.insert(10);
        // bst.insert(11);
        // bst.insert(7);
        // bst.insert(6);
        // bst.insert(4);
        // bst.display();
        int[] a = { 1, 2, 3, 4, 5, 6 };
        bst.insertSortedArray(a);
        bst.display();
        System.out.println("Preorder:");
        bst.preorderTraversal();
        System.out.println("INorder:");
        bst.inorderTraversal();
        System.out.println("Postorder:");
        bst.postorderTraversal();
    }

}
