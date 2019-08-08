package CodingRush._59_Queue_MaxInWindows;

import DataStructure.DequeWithMax;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MaxInWindowsV2 {
    public List<Integer> maxInWindows(List<Integer> n, int winSize) {
        List<Integer> maxInWindows = new LinkedList<>();
        if (winSize < 1 || n.size() < winSize) { return maxInWindows; }

        DequeWithMax<Integer> dequeWithMax = new DequeWithMax<>();
        for (int i = 0; i < winSize; i++) {
            dequeWithMax.pushBack(n.get(i));
        }

        maxInWindows.add( dequeWithMax.getMax() );
        for (int i = winSize; i < n.size(); i++) {
            dequeWithMax.pushBack(n.get(i));
            dequeWithMax.popFront();
            maxInWindows.add( dequeWithMax.getMax() );
        }

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
        MaxInWindowsV2 m = new MaxInWindowsV2();
        m.unitTest1();
    }
}
