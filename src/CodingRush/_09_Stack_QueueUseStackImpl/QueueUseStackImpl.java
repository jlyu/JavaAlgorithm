package CodingRush._09_Stack_QueueUseStackImpl;


import java.util.Stack;

public class QueueUseStackImpl {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    QueueUseStackImpl() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    public void appendTail(int v) {
        s1.push(v);
    }

    public Integer deleteHead() {
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        if (s2.empty()) {
            throw new RuntimeException("Queue is empty");
        }
        return s2.pop();
    }

    void unitTest1() {
        QueueUseStackImpl q = new QueueUseStackImpl();
        q.appendTail(1);
        q.appendTail(2);
        q.appendTail(3);
        System.out.print( q.deleteHead() + ", " ); //1
        System.out.print( q.deleteHead() + ", " ); //2
        q.appendTail(4);
        System.out.print( q.deleteHead() + ", " ); //3
        System.out.print( q.deleteHead() + ", " ); //4
        System.out.print( q.deleteHead() + ", " ); //error
    }

    public static void main(String[] args) {
        QueueUseStackImpl q = new QueueUseStackImpl();
        q.unitTest1();
    }
}
