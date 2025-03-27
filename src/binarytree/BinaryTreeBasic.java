package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeBasic {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1,2, 4, -1, -1, 5, -1, -1, 3, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree(nodes);
//        System.out.println(root.data);
        binaryTree.postOrder(root);
    }

    static class BinaryTree {
        static int ixd = -1;

        public static Node buildTree(int[] nodes){
            ixd++;
            if (nodes[ixd] == -1){
                return null;
            }
            Node newNode = new Node(nodes[ixd]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;

        }
         ///Tree Traversal: PreOrder-> Root, Left Subtree, Right SubTree.  Print Tree by this sequence. Root -> left -> root -> right. (DFS)
        static void preOrder(Node root){
            if (root == null){
                return;
            }
            System.out.println(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
        ///  Tree Traversal: InOrder -> Left Subtree, root, Right Subtree. (DFS)

        static void inOrder(Node root){
            if (root == null){
                return;
            }
            inOrder(root.left);
            System.out.println(root.data + " ");
            inOrder(root.right);
        }

        ///  Tree Traversal: InOrder -> Left Subtree, Right Subtree, root. (DFS)
        static void postOrder(Node root){
            if (root == null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data + " ");
        }

        ///  LEVEL OF TRAVERSAL: (BFS)

        static void levelOrder(Node root){
            if (root == null){
                return;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            queue.add(null);

            while (!queue.isEmpty()){
                Node curr = queue.remove();
                if (curr == null){
                    System.out.println();
                    if (queue.isEmpty()){
                        break;
                    }else {
                        queue.add(null);
                    }
                }else {
                    System.out.print(curr.data+ " ");
                    if (curr.left != null){
                        queue.add(curr.left);
                    }
                    if (curr.right != null){
                        queue.add(curr.right);
                    }
                }
            }
        }
    }
    /// Height of Tree.



}
