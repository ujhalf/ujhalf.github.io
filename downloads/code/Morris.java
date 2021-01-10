package common;

import pack2.pack9.pack7.Solution2;

/**
 * @Author Hui-min Lu
 * @Date 2020/9/30 20:02
 * @Version 1.0
 * @Description
 */
public class Morris {
    //Morris中序遍历
    public void morrisinorederTraversal(TreeNode root) {
        while (root != null) {
            //左子树为空
            if (root.left == null) {
                dfs(root);
                root = root.right;
                continue;
            }
            TreeNode prev = root.left;

            while (prev.right != null && prev.right != root) {
                prev = prev.right;
            }

            if (prev.right == null) {
                prev.right = root;
                root = root.left;
            } else {
                prev.right = null;
                dfs(root);
                root = root.right;
            }
        }
    }

    private void dfs(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
        } else {
            System.out.println("null");
        }

    }

    public void morrispreorderTraversal(TreeNode root) {

        while (root != null) {
            dfs(root);
            if (root.left == null) {
                //dfs(root);
                root = root.right;
                continue;
            }
            TreeNode prev = root.left;
            while (prev.right != null && prev.right != root.right) {
                prev = prev.right;
            }
            if (prev.right == null) {
               prev.right = root.right;
                root = root.left;
            } else {
                prev.right = null;
                root = root.right;
            }
        }
    }


    public void morrispreorderTraversal2(TreeNode root) {

        while (root != null) {
            //dfs(root);
            if (root.left == null) {
                dfs(root);
                root = root.right;
                continue;
            }
            TreeNode prev = root.left;
            while (prev.right != null && prev.right != root) {
                prev = prev.right;
            }
            if (prev.right == null) {
                dfs(root);
                prev.right = root;
                root = root.left;
            } else {
                prev.right = null;
                root = root.right;
            }
        }
    }

    //root = [3,5,1,6,2,0,8,null,null,7,4]
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n1.left = n2;
        n1.right = null;
        n2.left = n7;
        n2.right = null;
        n3.left = n6;
        n3.right = null;
        n4.left=n7;



        Morris solution = new Morris();
        solution.morrispreorderTraversal(n1);


    }

//    public static void main(String[] args) {
//        TreeNode n1 = new TreeNode(3);
//        TreeNode n2 = new TreeNode(5);
//        TreeNode n3 = new TreeNode(1);
//        TreeNode n4 = new TreeNode(6);
//        TreeNode n5 = new TreeNode(2);
//        TreeNode n6 = new TreeNode(0);
//        TreeNode n7 = new TreeNode(8);
//        TreeNode n8 = new TreeNode(7);
//        TreeNode n9 = new TreeNode(4);
//        n1.left = n2;
//        n1.right = null;
//        n2.left = null;
//        n2.right = null;
//        n3.left = n6;
//        n3.right = n7;
//
//        n5.left = n8;
//        n5.right = n9;
//
//        Morris solution = new Morris();
//        solution.morrispreorderTraversal(n1);
//
//
//    }
}
