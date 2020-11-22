package chapter2;

import util.DetailTreeNode;
import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 尚晓琼
 * @version V1.0
 * @since 2020/11/22
 */
public class Problem08 {
    public DetailTreeNode findNextInOrder(DetailTreeNode root, DetailTreeNode node) {
        if (node == null || root == null) return null;
        DetailTreeNode data;
        if (node.getRight() != null) {
            data = node.getRight();
            while (data.getLeft() != null) {
                data = data.getLeft();
            }
            return data;
        }
        data = node.getParent();
        while (data != null && node != data.getLeft()) {
            node = data;
            data = data.getParent();
        }
        return data;
    }

    private static Map<Integer, Integer> inOrder = new HashMap<>();
    private static int pre = 0;

    public static void main(String[] args) {
        Problem08 p8 = new Problem08();
        DetailTreeNode node31 = new DetailTreeNode(8);
        DetailTreeNode node32 = new DetailTreeNode(9);
        DetailTreeNode node21 = new DetailTreeNode(4);
        DetailTreeNode node22 = new DetailTreeNode(5, node31, node32);
        DetailTreeNode node23 = new DetailTreeNode(6);
        DetailTreeNode node24 = new DetailTreeNode(7);
        DetailTreeNode node11 = new DetailTreeNode(2, node21, node22);
        DetailTreeNode node12 = new DetailTreeNode(3, node23, node24);
        DetailTreeNode root = new DetailTreeNode(1, node11, node12);

        node11.setParent(root);
        node12.setParent(root);
        node21.setParent(node11);
        node22.setParent(node11);
        node23.setParent(node12);
        node24.setParent(node12);
        node31.setParent(node22);
        node32.setParent(node22);

        inOrder(root);

        DetailTreeNode node = node21;
        System.out.println("node is:" + node.getValue());
        System.out.println("expire node is:" + inOrder.get(node.getValue()));
        DetailTreeNode res = p8.findNextInOrder(root, node);
        System.out.println("next is:" + (res == null ? null : res.getValue()));
    }

    private static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.getLeft());
        inOrder.put(pre, root.getValue());
        pre = root.getValue();
        inOrder(root.getRight());
    }
}
