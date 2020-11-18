package util;

/**
 * @author 尚晓琼
 * @version V1.0
 * @since 2020/11/18
 */
public class ListNode {
    private int value;
    private ListNode next;

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
