package restart.dsa.binaryTree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    class TreeNode{
        int val;
        public TreeNode left, right;

        public TreeNode(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }

    public void inorder(TreeNode node){
        if(node==null) return;
        inorder(node);
        System.out.println(node.val);
        inorder(node);
    }

    public void preorder(TreeNode node){
        if(node==null) return;
        System.out.println(node.val);
        preorder(node.left);
        preorder(node.right);
    }

    public void postorder(TreeNode node){
        if(node==null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.println(node.val);
    }

    public void levelorder(TreeNode node){
        if(node==null) return;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            TreeNode current=queue.poll();
            System.out.println(current.val);
            if(current.left!=null) queue.offer(current.left);
            if(current.right!=null) queue.offer(current.right);
        }
    }
}
