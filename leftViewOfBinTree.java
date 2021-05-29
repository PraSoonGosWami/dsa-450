package dsa;


class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class leftViewOfBinTree {
    /**
     * Left View of Binary Tree
     * https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1
     * O(N) | O(1)
     */

    //recursive approach
    static int maxIndex = 0;

    public static void solution(Node root, int index) {
        if (root == null)
            return;

        if (maxIndex < index) {
            index = maxIndex;
            System.out.print(root.data + " ");
        }

        solution(root.left, index + 1);
        solution(root.right, index + 1);
    }


}
