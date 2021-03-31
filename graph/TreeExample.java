package graph;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TreeExample {
    static int n = 15;
    public static void main(String[] args) {

        Node[] tree = new Node[n + 1];

        for (int i = 1; i <=n ; i++) {
            Node node = new Node(i);
            tree[i] = node;
        }

        for (int i = 2; i <=n ; i++) {
            if (i % 2 == 0) {
                tree[i/2].left = tree[i];
            }else
                tree[i / 2].right = tree[i];
        }
        System.out.println("전위 순회");
        preOrder(tree[1]);
        System.out.println("중위 순회");
        inOrder(tree[1]);
        System.out.println("후위 순회");
        postOrder(tree[1]);

    }

    private static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
    }

    private static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }

    private static void preOrder(Node root) {
        if(root!=null){
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    private static void makeTree(Tree tree, List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {

        }
    }


    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
