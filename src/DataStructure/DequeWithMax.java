package DataStructure;



import java.util.Deque;
import java.util.LinkedList;

public class DequeWithMax<T extends Comparable> {
    private Deque<T> dataQ;
    private Deque<T> maxQ;

    public DequeWithMax() {
        this.dataQ = new LinkedList<T>();
        this.maxQ  = new LinkedList<T>();
    }


    public void pushBack(T v) {
        while ((!maxQ.isEmpty()) && maxQ.getLast().compareTo(v) < 0 ) {
            maxQ.pollLast();
        }

        dataQ.offerLast(v);
        maxQ.offerLast(v);

    }

    public void popFront() {
        if (maxQ.isEmpty()) {
            try {
                throw new Exception("Deque is empty.");
            } catch (Exception e) { e.printStackTrace(); }
        }

        if (maxQ.getFirst() == dataQ.getFirst()) {
            maxQ.pollFirst();
        }
        dataQ.pollFirst();
    }

    public T getMax(){
        if (maxQ.isEmpty()) {
            try {
                throw new Exception("Deque is empty.");
            } catch (Exception e) { e.printStackTrace(); }
        }

        return maxQ.getFirst();
    }

    public static void main(String[] args) {
        DequeWithMax<Integer> d = new DequeWithMax<>();
        d.pushBack(7);
        d.pushBack(3);
        d.pushBack(5);
        System.out.println(d.getMax()); //7
        d.popFront();
        System.out.println(d.getMax()); //5
        d.popFront();
        System.out.println(d.getMax()); //5
    }

}
