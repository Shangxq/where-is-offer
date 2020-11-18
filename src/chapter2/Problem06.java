package chapter2;

import util.ListNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 尚晓琼
 * @version V1.0
 * @since 2020/11/18
 */
public class Problem06 {
    /**
     * 递归
     *
     * @param root
     * @return
     */
    private int size = 0;
    private int index = 0;
    private int [] data;
    public int[] printDesc(ListNode root) {
        visit(root);
        return data;
    }
    private void visit(ListNode root){
        if(root==null){
            data = new int[size];
            return;
        }
        size++;
        visit(root.getNext());
        data[index++] = root.getValue();
    }

    /**
     * 非递归
     *
     * @param root
     */
    public int[] printDescByStack(ListNode root) {
        Deque<Integer> stack = new LinkedList<>();

        while (root != null) {
            stack.push(root.getValue());
            root = root.getNext();
        }
        int []res = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()){
            res[index++]=stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        Problem06 p6=new Problem06();
        System.out.println(Arrays.toString(p6.printDesc(node1)));
        System.out.println("==========");
        System.out.println(Arrays.toString(p6.printDescByStack(node1)));
    }
}
