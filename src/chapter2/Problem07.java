package chapter2;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 尚晓琼
 * @version V1.0
 * @since 2020/11/18
 */
public class Problem07 {
    private int [] preorder;
    private Map<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        map = new HashMap<>(inorder.length);
        for (int i=0;i<inorder.length;i++) map.put(inorder[i],i);
        return buildTree(0,0,preorder.length-1);
    }
    private TreeNode buildTree(int rootIndexForPre,int startIndexForIn,int endIndexForIn){
        if(startIndexForIn>endIndexForIn) return null;
        TreeNode root = new TreeNode(preorder[rootIndexForPre]);
        int rootIndexForIn = map.get(preorder[rootIndexForPre]);
        root.setLeft(buildTree(rootIndexForPre+1,startIndexForIn,rootIndexForIn-1));
        root.setRight(buildTree(rootIndexForIn-startIndexForIn+rootIndexForPre+1,rootIndexForIn+1,endIndexForIn));
        return root;
    }

    public static void main(String[] args) {
        Problem07 p7=new Problem07();
        int []pre = new int[]{3,9,20,15,7};
        int []in = new int[]{9,3,15,20,7};
        TreeNode root=p7.buildTree(pre,in);
        print(root);
    }
    public static void print(TreeNode root){
        if(root==null)return;
        System.out.println(root.getValue());
        print(root.getLeft());
        print(root.getRight());
    }
}
