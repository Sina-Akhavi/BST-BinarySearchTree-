package ir.ac.kntu.logic;

public class Node {
    private int data;

    private Node right;

    private Node left;

    private Node parent;

    public Node(int data) {
        this.data = data;
        this.right = null;
        this.left = null;
        this.parent = null;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void deleteMyChild(int data) {
        if (getRight() != null) {
            if (getRight().getData() == data) {
                setRight(null);
            }
        }
        if (getLeft() != null) {
            if (getLeft().getData() == data) {
                setLeft(null);
            }
        }
    }

    public Node getMyOnlyChild() {
        if (getRight() != null && getLeft() != null) {
            System.out.println("It has two children!!!");
            return null;
        }
        if (getRight() == null && getLeft() == null) {
            System.out.println("It has no children!!!");
            return null;
        }
        if (getRight() != null) {
            return this.right;
        }
        return this.left;
    }

    public boolean isLeftChild() {
        return this == parent.left;
    }

    public boolean isRightChild() {
        return this == parent.right;
    }

    public String toString() {
        try {
            return "Node Info:\n-data: " + data  + "\n-parent: " + parent.data + "\n-left child: "
                    + getLeft().data + "\n-right child: " + getRight().data;
        } catch (NullPointerException ex) {
            return "Node Info:\n-data: " + data + "\n-parent: " + parent.data;
        }

    }
}
