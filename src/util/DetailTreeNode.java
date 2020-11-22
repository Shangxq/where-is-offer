package util;

/**
 * @author 尚晓琼
 * @version V1.0
 * @since 2020/11/22
 */
public class DetailTreeNode extends TreeNode<DetailTreeNode> {
    private DetailTreeNode parent ;

    public DetailTreeNode() {
    }

    public DetailTreeNode(int value) {
        super(value);
    }

    public DetailTreeNode(int value, DetailTreeNode left, DetailTreeNode right) {
        super(value, left, right);
    }

    public DetailTreeNode getParent() {
        return parent;
    }

    public void setParent(DetailTreeNode parent) {
        this.parent = parent;
    }
}
