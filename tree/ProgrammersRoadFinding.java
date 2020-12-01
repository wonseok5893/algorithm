package tree;

import java.util.*;

public class ProgrammersRoadFinding {
    public static void main(String[] args) {
        int[][] solution = new ProgrammersRoadFinding().solution(new int[][]{{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}
        ,{1,3},{8,6},{7,2},{2,2}});
        for (int[] e : solution) {
            for (int i : e) {
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }
    public int[][] solution(int[][] nodeinfo) {
        //이진트리 만들기
        Node[] nodeList = new Node[nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            nodeList[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1);
        }
        Arrays.sort(nodeList, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.y == o2.y) {
                    if (o1.x > o2.y) return 1;
                } else {
                    if (o1.y < o2.y) return 1;
                }
                return -1;
            }
        });

        Node root = nodeList[0];
        for (int i = 1; i < nodeList.length; i++) {
            makeBinaryTree(root, nodeList[i]);
        }
        //전위 순회
        List<Integer> list = new LinkedList<>();
        beforeSearch(root, list);
        int[][] answer = new int[2][list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[0][i] = list.get(i);
        }
        list.clear();
        afterSearch(root, list);
        for (int i = 0; i < list.size(); i++) {
            answer[1][i] = list.get(i);
        }
        return answer;
    }

    private void afterSearch(Node root, List<Integer> list) {
        if (root.left != null) {
            afterSearch(root.left, list);
        }
        if (root.right != null) {
            afterSearch(root.right, list);
        }
        list.add(root.idx);
    }

    private void beforeSearch(Node root, List<Integer> list) {
        list.add(root.idx);
        if (root.left != null) {
            beforeSearch(root.left, list);
        }
        if (root.right != null) {
            beforeSearch(root.right, list);
        }
    }

    private void makeBinaryTree(Node root, Node insertNode) {
        if (root.x > insertNode.x) {
            if (root.left != null) {
                makeBinaryTree(root.left, insertNode);
            } else root.left = insertNode;
        } else {
            if (root.right != null) {
                makeBinaryTree(root.right, insertNode);
            } else root.right = insertNode;
        }
    }

    private static class Node {
        int x;
        int y;
        int idx;
        Node left = null;
        Node right = null;

        public Node(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }

    }
}
