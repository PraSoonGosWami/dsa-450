package dsa.arrays;

public class rightViewofBinTree {

    /**
     * Right View of Binary Tree
     * https://practice.geeksforgeeks.org/problems/right-view-of-binary-tree/1
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
        solution(root.right, index + 1);
        solution(root.left, index + 1);
    }

    // DO NOT use this approach as all nodes are not considered
    // May fail for few test cases
    //iterative approach

    public static void solution2(Node root) {
        if (root == null)
            return;

        Node curr = root;
        int index = -1;
        int maxIndex = 1;
        while (curr != null) {
            System.out.print(curr.data + " ");
            if (curr.right != null) curr = curr.right;
            else curr = curr.left;
            index++;
        }
        curr = root.left;
        while(curr != null){
            if(maxIndex > index) System.out.print(curr.data + " ");
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }

    }

}
