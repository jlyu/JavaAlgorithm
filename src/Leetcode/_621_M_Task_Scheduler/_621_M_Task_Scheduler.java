package Leetcode._621_M_Task_Scheduler;

import java.util.Arrays;

/*
Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters
represent different tasks. Tasks could be done without original order. Each task could be done in one interval.
For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least
n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

 

Example:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 

Note:

The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].


https://leetcode-cn.com/problems/task-scheduler
 */
public class _621_M_Task_Scheduler {
    public int leastInterval(char[] tasks, int n) {
        if (tasks.length <= 1 || n < 1) { return tasks.length; }
        int[] counts = new int[26];
        for (char task: tasks) {
            counts[task - 'A']++;
        }

        Arrays.sort(counts);
        int maxCount = counts[25];
        int retCount = (maxCount - 1) * (n + 1) + 1;
        for (int i = 24; i >= 0 && counts[i] == maxCount; i--) {
            retCount++;
        }
        return Math.max(retCount, tasks.length);
    }
}
