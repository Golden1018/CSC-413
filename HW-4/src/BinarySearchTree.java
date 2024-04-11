class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    // (a) Insertion
    public void insert(int val) {
        root = insertRec(root, val);
    }

    private TreeNode insertRec(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        if (val < root.val)
            root.left = insertRec(root.left, val);
        else if (val > root.val)
            root.right = insertRec(root.right, val);

        return root;
    }

    // (b) Deletion
    public void delete(int val) {
        root = deleteRec(root, val);
    }

    private TreeNode deleteRec(TreeNode root, int val) {
        if (root == null)
            return root;

        if (val < root.val)
            root.left = deleteRec(root.left, val);
        else if (val > root.val)
            root.right = deleteRec(root.right, val);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.val = minValue(root.right);

            root.right = deleteRec(root.right, root.val);
        }
        return root;
    }

    private int minValue(TreeNode root) {
        int minv = root.val;
        while (root.left != null) {
            minv = root.left.val;
            root = root.left;
        }
        return minv;
    }

    // (c) Search
    public boolean search(int val) {
        return searchRec(root, val);
    }

    private boolean searchRec(TreeNode root, int val) {
        if (root == null)
            return false;

        if (root.val == val)
            return true;

        if (val < root.val)
            return searchRec(root.left, val);
        else
            return searchRec(root.right, val);
    }

    // (d) In-order traversal
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.val + " ");
            inorderRec(root.right);
        }
    }

    // (e) Pre-order traversal
    public void preorder() {
        preorderRec(root);
    }

    private void preorderRec(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // (f) Post-order traversal
    public void postorder() {
        postorderRec(root);
    }

    private void postorderRec(TreeNode root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.val + " ");
        }
    }

    // (2) Driver program
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Insert elements
        tree.insert(50);
        System.out.println("Insert value: 50");
        tree.insert(30);
        System.out.println("Insert value: 30");
        tree.insert(20);
        System.out.println("Insert value: 20");
        tree.insert(40);
        System.out.println("Insert value: 40");
        tree.insert(70);
        System.out.println("Insert value: 70");
        tree.insert(60);
        System.out.println("Insert value: 60");
        tree.insert(80);
        System.out.println("Insert value: 80");

        System.out.println("Inorder traversal:");
        tree.inorder();
        System.out.println();

        System.out.println("Preorder traversal:");
        tree.preorder();
        System.out.println();

        System.out.println("Postorder traversal:");
        tree.postorder();
        System.out.println();

        // Search for an element
        int key = 40;
        System.out.println("Find value: 40");
        if (tree.search(key))
            System.out.println(key + " found");
        else
            System.out.println(key + " not found");

        // Delete an element
        System.out.println("Delete value: 50");
        tree.delete(50);
        System.out.println("Inorder traversal after deletion:");
        tree.inorder();
    }
}
