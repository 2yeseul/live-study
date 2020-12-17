package week5;

//int 값을 가지고 있는 이진 트리를 나타내는 Node 라는 클래스를 정의하세요.
// int value, Node left, right를 가지고 있어야 합니다.
public class Node {
    public Node root;

    private int value;
    private Node left;
    private Node right;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
