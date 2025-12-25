package TreeDs;

import java.util.LinkedList;
import java.util.Queue;

public class PreorderBT {
    public static int diam = 0;
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }
    static class BuildTree{
        static int idx = -1;
        public static Node buildTree(int[] nodes){
            ++idx;
            if(nodes[idx] == -1) return null;

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
       public static void preorder(Node root){
            if(root == null) return;
           System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
       }
       public static void inorder(Node root){
            if(root == null) return;
            inorder(root.left);
           System.out.print(root.data + " ");
           inorder(root.right);
       }
       public static void postorder(Node root){
            if (root == null) return;
            postorder(root.left);
            postorder(root.right);
           System.out.print(root.data + " ");
       }
       public static void levelOrder(Node root){
           Queue<Node> queue = new LinkedList<>();
           if(root != null) queue.offer(root);
           queue.offer(null);
           while (!queue.isEmpty()){
               Node temp = queue.poll();
               if(temp == null){
                   System.out.println();
                   if(queue.isEmpty()) break;
                   else queue.offer(null);
               }
               else {
                   System.out.print(temp.data + " ");
                   if (temp.left != null) queue.offer(temp.left);
                   if (temp.right != null) queue.offer(temp.right);
               }
           }
       }
       public static int countNodes(Node root){
            if(root == null) return 0;
            int leftCount = countNodes(root.left);
            int rightCount = countNodes(root.right);
            return 1 + leftCount + rightCount;
       }
       public static int sumOfNodes(Node root){
            if(root == null) return 0;
            return sumOfNodes(root.left) + sumOfNodes(root.right) + root.data;
       }
       public static int heightOfTree(Node root){
            if(root == null) return 0;
            int lh = heightOfTree(root.left);
            int rh = heightOfTree(root.right);
            diam = Math.max(diam, lh+rh+1);
            return 1 + Math.max(lh,rh);
       }
       public static int diameterOfTree(Node root){
            if(root == null) return 0;
            int lh = diameterOfTree(root.left);
            int rh = diameterOfTree(root.right);
            int curr = heightOfTree(root.left) + heightOfTree(root.right) + 1;
            return Math.max(Math.max(lh,rh),curr);
       }
    }
    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        if(nodes.length == 0) System.out.println("No root exists!");
        BuildTree tree = new BuildTree();
        Node root = tree.buildTree(nodes);
        System.out.println("PREORDER");
        tree.preorder(root);
        System.out.println();
        System.out.println("INORDER");
        tree.inorder(root);
        System.out.println();
        System.out.println("POSTORDER");
        tree.postorder(root);
        System.out.println();
        System.out.println("LEVEL ORDER");
        tree.levelOrder(root);
        System.out.println(tree.countNodes(root));
        System.out.println(tree.sumOfNodes(root));
        System.out.println(tree.heightOfTree(root));
        System.out.println(diam);
    }
}
