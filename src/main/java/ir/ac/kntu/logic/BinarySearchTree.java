package ir.ac.kntu.logic;

public class BinarySearchTree {

    private Node root;

    private int numberOfNodes;

    public BinarySearchTree() {
        root = null;
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    public void insert(int key) {
        numberOfNodes += 1;
        if (this.root == null) {
            this.root = new Node(key);
            return;
        }

        Node curNode = this.root;
        Node leafNode = null;
        while (curNode != null) {
            if (curNode.getData() <= key) {
                leafNode = curNode;
                curNode = curNode.getRight();
            } else {
                leafNode = curNode;
                curNode = curNode.getLeft();
            }
        }

        Node newNode = new Node(key);
        newNode.setParent(leafNode);
        if (leafNode.getData() <= key) {
            leafNode.setRight(newNode);
        } else {
            leafNode.setLeft(newNode);
        }
    }

    public Node find(int key) {
        return find(key, this.root);
    }

    private Node find(int key, Node root) {
        Node curNode = root;

        while (curNode != null) {
            if (curNode.getData() == key) {
                return curNode;
            } else if (key > curNode.getData()) {
                curNode = curNode.getRight();
            } else {
                curNode = curNode.getLeft();
            }
        }
        return null;
    }

    public void printPathFromRoot(int key) {
        String path = "";
        Node curNode = root;
        while (curNode != null) {
            path += curNode.getData() + " --> ";
            if (curNode.getData() == key) {
                path = path.substring(0, path.length() - 5);
                System.out.println("Path: " + path);
                return;
            } else if (key > curNode.getData()) {
                curNode = curNode.getRight();
            } else {
                curNode = curNode.getLeft();
            }
        }
        System.out.println("key does not exist!!!\n");
    }


    private boolean hasNoChildren(Node node) {
        return node.getLeft() == null && node.getRight() == null;
    }

    private boolean hasOnlyOneChild(Node node) {
        return (node.getLeft() == null && node.getRight() != null) ||
                (node.getLeft() != null && node.getRight() == null);
    }

    private void deleteUtil(int key, Node root) {
        Node myNode = find(key, root);

        if (hasNoChildren(myNode)) {
            myNode.getParent().deleteMyChild(myNode.getData());
            System.out.println("successfully deleted!!!\n");
        } else if (hasOnlyOneChild(myNode)) {
            Node parent = myNode.getParent();
            if (this.root == myNode) {
                this.root = myNode.getMyOnlyChild();
                this.root.setParent(null);
            } else if (myNode.isLeftChild()) {
                parent.setLeft(myNode.getMyOnlyChild());
                parent.getLeft().setParent(parent);
            } else {
                parent.setRight(myNode.getMyOnlyChild());
                parent.getRight().setParent(parent);
            }
            System.out.println("successfully deleted!!!\n");
        } else {
            Node leftRightMost = findRightMostInLeftSubtree(myNode);
            myNode.setData(leftRightMost.getData());
            deleteUtil(leftRightMost.getData(), myNode.getLeft());
        }
    }

    public void delete(int key) {
        if (key == this.root.getData() && hasNoChildren(this.root)) {
            this.root = null;
            this.numberOfNodes--;
            return;
        }
        if (find(key) == null) {
            System.out.println("node with that key does not exist!!\n");
            return;
        }
        this.numberOfNodes--;
        deleteUtil(key, this.root);
    }

    private Node[] findNodeAndParent(int key, Node root) {
        Node[] nodeAndParent = new Node[2];

        Node curNode = root;
        Node parent = null;
        while (curNode != null) {
            if (curNode.getData() == key) {
                break;
            } else if (curNode.getData() < key) {
                parent = curNode;
                curNode = curNode.getRight();
            } else {
                parent = curNode;
                curNode = curNode.getLeft();
            }
        }

        nodeAndParent[0] = curNode;
        nodeAndParent[1] = parent;

        return nodeAndParent;
    }

    private void printPreorderUtil(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getData() + " ");
        printPreorderUtil(root.getLeft());
        printPreorderUtil(root.getRight());
    }

    public void printPreorder() {
        if (this.root == null) {
            System.out.println("The tree is empty !!!");
        }
        printPreorderUtil(this.root);
    }

    public Node findRightMostInLeftSubtree(Node node) {
        if (node == null) {
            System.out.println("This node is null itself !!!");
            return null;
        }
        if (node.getLeft() == null) {
            System.out.println("This node does not have left subtree at all!!!");
            return null;
        }

        Node curNode = node.getLeft();

        Node output = null;
        while (curNode != null) {
            output = curNode;
            curNode = curNode.getRight();
        }
        return output;
    }

    public void addNumbers(int[] integerNumbers) {
        for (Integer integer : integerNumbers) {
            insert(integer);
        }
    }
}
