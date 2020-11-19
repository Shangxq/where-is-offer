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
        //方便我们O1时间找到root 中序下标
        map = new HashMap<>(inorder.length);
        for (int i=0;i<inorder.length;i++) map.put(inorder[i],i);
        return buildTree(0,0,preorder.length-1);
    }

    /**
     *
     * @param rootIndexForPre 前序遍历根节点下标
     * @param startIndexForIn 先序遍历左边界
     * @param endIndexForIn 先序遍历右边界
     * @return 根节点
     */
    private TreeNode buildTree(int rootIndexForPre,int startIndexForIn,int endIndexForIn){
        //递归终止
        if(startIndexForIn>endIndexForIn) return null;
        //构建根节点
        TreeNode root = new TreeNode(preorder[rootIndexForPre]);
        //找到根节点的中序下标
        int rootIndexForIn = map.get(preorder[rootIndexForPre]);
        //构建左子树 左侧新根=root+1;左侧先序边界=[原左边界,root先序-1]
        root.setLeft(buildTree(rootIndexForPre+1,startIndexForIn,rootIndexForIn-1));
        //构建右子树 右侧新根=root+左个数+1;左个数=root先序-原左边界;右侧先序边界=[root先序+1,原右边界]
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
