package week5;

import java.util.*;

public class BinaryTree {
    private final Node root;
    public BinaryTree(Node root) {
        this.root = root;
    }
    public void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.print(currentNode.getValue() + " ");
            if(currentNode.getLeft()!=null) queue.add(currentNode.getLeft());
            if(currentNode.getRight()!=null) queue.add(currentNode.getRight());
        }
    }
    public void dfs() {
        Stack<Node> stack = new Stack<>();
        stack.add(this.root);
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            System.out.print(currentNode.getValue() + " ");
            if(currentNode.getLeft()!=null) stack.add(currentNode.getLeft());
            if(currentNode.getRight()!=null) stack.add(currentNode.getRight());
        }
    }

    public static void main(String... args) {
        List<Node> nodeList = new ArrayList<>();
        for(int i=0;i<7;i++) {
            nodeList.add(new Node(i));
            if(i % 2 == 1) nodeList.get(i / 2).setLeft(nodeList.get(i));
            else if((i % 2 == 0) && (i > 0)) nodeList.get((i / 2) - 1).setRight(nodeList.get(i));
        }
        BinaryTree binaryTree = new BinaryTree(nodeList.get(0));
        binaryTree.bfs();
        System.out.println();
        binaryTree.dfs();
    }
}
