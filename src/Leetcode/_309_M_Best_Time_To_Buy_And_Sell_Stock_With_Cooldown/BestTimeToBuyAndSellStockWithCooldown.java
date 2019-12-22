package Leetcode._309_M_Best_Time_To_Buy_And_Sell_Stock_With_Cooldown;
/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

Input: [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]


https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown

 */
public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int hold = Integer.MIN_VALUE, cd = 0, rest = 0;
        for (int price: prices) {
            int preCd = cd;
            cd = hold + price;
            hold = Math.max(hold, rest - price);
            rest = Math.max(rest, preCd);
        }
        return Math.max(cd, rest);
    }
}
