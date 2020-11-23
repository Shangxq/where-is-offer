package chapter2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 尚晓琼
 * @version V1.0
 * @since 2020/11/23
 */
class Queue {
    private Deque<Integer> stackIn = new LinkedList<>();
    private Deque<Integer> stackOut = new LinkedList<>();
    private int defaultValue = -1;

    public void offer(int value) {
        stackIn.push(value);
    }

    public int poll() {
        if (stackOut.isEmpty()) {
            if (stackIn.isEmpty()) {
                return defaultValue;
            } else {
                while (!stackIn.isEmpty()) {
                    stackOut.push(stackIn.pop());
                }
            }
        }
        return stackOut.pop();
    }
}

class Stack {
    private Deque<Integer>[] queues = new Deque[]{new LinkedList<Integer>(), new LinkedList<Integer>()};
    private int status = 0;
    private int defaultValue = -1;

    public void push(int value) {
        queues[status % 2].offer(value);
    }

    public int pop() {
        while (true) {
            int index = status % 2;
            int next = (status + 1) % 2;
            if (queues[index].size() < 1) return defaultValue;
            while (queues[index].size() > 1)
                queues[next].offer(queues[index].poll());
            status=(status+1)%2;
            return queues[index].poll();
        }
    }
}

public class Problem09 {


    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(3);
        s.push(5);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        s.push(12);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
