public class SegmentTREES {

    static class Node {
        int val;
        int start;
        int end;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

    }

    Node root;

    public SegmentTREES() {
    }

    public void insert(int arr[]) {
        root = insertSegment(arr, 0, arr.length - 1);
    }

    private Node insertSegment(int[] arr, int start, int end) {
        if (start == end) {
            Node temp = new Node(arr[start]);
            temp.start = start;
            temp.end = end;
            temp.left = null;
            temp.right = null;
            return temp;
        }
        int mid = (start + end) / 2;
        Node left = insertSegment(arr, start, mid);
        Node right = insertSegment(arr, mid + 1, mid);

        int sum = left.val + right.val;
        Node p = new Node(sum);
        p.start = start;
        p.end = end;
        p.left = left;
        p.right = right;
        return p;
    }

    public void display() {
        display(root, "Root Node: ");
    }

    public void display(Node node, String info) {
        if (node == null) {
            return;
        }
        System.out.println(info + node.val);
        display(node.left, "Left Child of " + node.val + " : ");
        display(node.right, "Right child of " + node.val + " :");
    }

    public static void main(String[] args) {
        SegmentTREES st = new SegmentTREES();
        int[] arr = { 5, 4, 3, 2, 1, 0 };
        st.insert(arr);
        st.display();
    }

}
