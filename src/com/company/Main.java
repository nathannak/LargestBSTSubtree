package com.company;

public class Main {

    public static void main(String[] args) {

        TreeNode root    = new TreeNode(10);
        root.left        = new TreeNode(5);
        root.left.left   = new TreeNode(1);
        root.left.right  = new TreeNode(8);
        root.right       = new TreeNode(15);
        root.right.left   = null;
        root.right.right  = new TreeNode(7);

        System.out.println( largestBSTSubtree(root) );

    }

    public static int largestBSTSubtree(TreeNode root) {
        int[] ret = largestBST(root);
        return ret[2];
    }

    private static int[] largestBST(TreeNode node){

        if(node == null){
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] left = largestBST(node.left);
        int[] right = largestBST(node.right);

        if(node.val > left[1] && node.val < right[0]){
            return new int[]{Math.min(node.val, left[0]), Math.max(node.val, right[1]), left[2] + right[2] + 1};
        }else{
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left[2], right[2])};
        }
    }

    public static class TreeNode {
          int val;
          TreeNode left=null;
          TreeNode right=null;
          TreeNode(int x) { val = x; }
      }

}
