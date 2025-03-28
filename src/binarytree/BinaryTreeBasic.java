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
    static int heightOfTree(Node root){
        if (root == null){
            return 0;
        }

        int lh = heightOfTree(root.left);
        int rh = heightOfTree(root.right);

        return (int)Math.max(lh, rh) + 1;
    }

    ///  Count the number of nodes in the tree.

    static int countTreeNode(Node root){
        if (root == null){
            return 0;
        }

        int lc = countTreeNode(root.left);
        int rc = countTreeNode(root.right);

        return lc + rc + 1;
    }

    ///  Sum of node.
    static int sumOfNode(Node root){
        if (root == null){
            return 0;
        }

        int ls = sumOfNode(root.left);
        int rs = sumOfNode(root.right);

        return ls + rs + root.data;
    }

    ///  Diameter of a tree -> No of nodes in the longest path between any two leaves.

    static int diameter(Node root){
        if (root == null){
            return 0;
        }

        int lD = diameter(root.left);
        int lH = heightOfTree(root.left);
        int rD = diameter(root.right);
        int rH = heightOfTree(root.right);

        int selfDia = lH + rH + 1;

        return Math.max(selfDia, Math.max(lD,rD));
    }

    ///  Subtree of another Tree -> Given the root of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subTree and false otherwise.
    static Boolean subtreeOfTree(Node root, Node subNode){
        if (root == null){
            return false;
        }

        if (root.data == subNode.data){
            if (isIdentical(root,subNode)){
                return true;
            }
        }

        return subtreeOfTree(root.left, subNode) || subtreeOfTree(root.right,subNode);
    }
    static Boolean isIdentical(Node root, Node subTree){
        if (root == null && subTree == null){
            return true;
        }else if(root == null || subTree == null || subTree.data != root.data){
            return false;
        }
        if (!isIdentical(root.left, subTree.left)){
            return false;
        }
        if (!isIdentical(root.right, subTree.right)){
            return false;
        }
        
        return true;
    }

    /// K-Level of tree.

    static void KLevel(Node root, int level, int k){
        if (root == null){
            return;
        }

        if (root.data == k){
            System.out.print(root.data + " ");
            return;
        }

        KLevel(root.left, level + 1,k);
        KLevel(root.right, level + 1,k);

    }

    ///  Lowest common ancestor.


}
