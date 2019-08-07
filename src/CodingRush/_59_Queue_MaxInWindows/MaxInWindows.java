package CodingRush._59_Queue_MaxInWindows;


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class MaxInWindows {

    public List<Integer> maxInWindows(List<Integer> n, int winSize) {
        List<Integer> maxInWindows = new LinkedList<>();

        if (winSize < 1 || n.size() < winSize) { return maxInWindows; }

        // initial the deque of window
        Deque<Integer> dequeIndex = new LinkedList<>();
        for (int i = 0; i < winSize; i++) {
            while ( (!dequeIndex.isEmpty()) && n.get(i) > n.get(dequeIndex.peekLast()) ) {
                dequeIndex.pollLast();
            }
            dequeIndex.offerLast(i);
        }

        for (int i = winSize; i < n.size(); i++) {
            maxInWindows.add(n.get(dequeIndex.getFirst()));

            while ((!dequeIndex.isEmpty()) && n.get(i) >= n.get(dequeIndex.getLast())) {
                dequeIndex.pollLast();
            }

            if ((!dequeIndex.isEmpty()) && dequeIndex.getFirst() <= (i - winSize)) {
                dequeIndex.pollFirst();
            }

            dequeIndex.offerLast(i);
        }
        maxInWindows.add(n.get(dequeIndex.getFirst()));
        return maxInWindows;
    }

    void unitTest1() {
        List<Integer> n = Arrays.asList(new Integer[]{2, 3, 4, 2, 6, 2, 5, 1});
        List<Integer> maxInWindows = maxInWindows(n, 3);
        for (Integer i:maxInWindows) {
            System.out.print(i + ",");
        }
    }

    public static void main(String[] args) {
        MaxInWindows m = new MaxInWindows();
        m.unitTest1();
    }
}
