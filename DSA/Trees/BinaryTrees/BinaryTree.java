import java.util.*;

public class BinaryTree {

    private Node root;

    public BinaryTree() {

    }

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    // insert elements
    public void populate(Scanner scanner) {
        System.out.println("Enter Val of Node:");
        int val = scanner.nextInt();
        root = new Node(val);
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {
        System.out.println("Do you want to to enter left of:" + node.val);
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter the value for insert at left of :" + node.val);
            int val = scanner.nextInt();
            node.left = new Node(val);
            populate(scanner, node.left);
        }
        System.out.println("Do you want to to enter right of:" + node.val);
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter the value for insert at right of :" + node.val);
            int val = scanner.nextInt();
            node.right = new Node(val);
            populate(scanner, node.right);

        }
    }

    public void display() {
        display(root, "");
    }

    public void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.val);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");

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
        Scanner scanner = new Scanner(System.in);
        BinaryTree bs = new BinaryTree();
        bs.populate(scanner);
        bs.prettyDisplay();

    }
}
