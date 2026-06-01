public class AVL {
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

    public AVL() {
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

        return rotate(node);
    }

    public Node rotate(Node node) {
        if (height(node.left) - height(node.right) > 1) {
            // left skiwed
            if (height(node.left.left) - height(node.left.right) > 0) {
                // left left
                return rotateRight(node);
            } else {
                // left right
                node.left = rotateLeft(node.left);
                return rotateRight(node);

            }

        } else if (height(node.left) - height(node.right) < -1) {
            // right skewed
            if (height(node.right.left) - height(node.right.right) < 0) {
                // right right
                return rotateLeft(node);
            } else {
                // right left
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }

        }

        return node;
    }

    public Node rotateRight(Node node) {

        Node child = node.left;
        Node temp = child.right;
        child.right = node;
        node.left = temp;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        child.height = Math.max(height(child.left), height(child.right)) + 1;
        return child;
    }

    public Node rotateLeft(Node node) {
        Node child = node.right;
        Node temp = child.left;
        child.left = node;
        node.right = temp;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        child.height = Math.max(height(child.left), height(child.right)) + 1;
        return child;
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

    public void prettyDisplay() {
        prettyDisplay(root, 0);
    }

    public void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }
        prettyDisplay(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|-------->" + node.val);

        } else {
            System.out.println(node.val);
        }
        prettyDisplay(node.left, level + 1);
    }

    public static void main(String[] args) {

        AVL avl = new AVL();
        // avl.insert(10);
        // avl.insert(11);
        // avl.insert(7);
        // avl.insert(6);
        // avl.insert(4);
        // avl.display();
        // int[] a = { 1, 2, 3, 4, 5, 6 };
        // avl.insertSortedArray(a);
        // avl.display();
        // avl.insert(value);
        // System.out.println("Preorder:");
        // avl.preorderTraversal();
        // System.out.println("INorder:");
        // avl.inorderTraversal();
        // System.out.println("Postorder:");
        // avl.postorderTraversal();

        // avl.insert(10);
        // avl.display();
        // avl.insert(11);
        // avl.insert(12);
        // avl.display();
        // avl.insert(13);
        // avl.insert(14);
        // avl.prettyDisplay();
        // avl.insert(15);
        // avl.insert(16);
        // avl.prettyDisplay();

        for (int i = 0; i < 1000; i++) {
            avl.insert(i);
        }

        System.out.println(avl.height(avl.root));

    }

}
