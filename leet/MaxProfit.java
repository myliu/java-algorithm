package leet;

public class MaxProfit {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] prices1 = { 3, 2, 6, 5, 0, 3 };
        int[] prices2 = { 1, 2, 4 };
        int[] prices3 = { 3, 3, 5, 0, 0, 3, 1, 4 };
        int[] prices4 = { 2, 1 };

        System.out.println(maxProfitI(prices1));
        System.out.println(maxProfitI(prices2));
        System.out.println(maxProfitI(prices3));
        System.out.println(maxProfitI(prices4));

        System.out.println(maxProfitIII(prices1));
        System.out.println(maxProfitIII(prices2));
        System.out.println(maxProfitIII(prices3));
        System.out.println(maxProfitIII(prices4));
    }

    public static int maxProfitI(int[] prices) {
        if (prices == null)
            return 0;

        int len = prices.length;
        if (len <= 1)
            return 0;

        int[] a = new int[len];
        a[len - 1] = prices[len - 1];

        for (int i = len - 2; i >= 0; i--) {
            if (prices[i] > a[i + 1]) {
                a[i] = prices[i];
            } else {
                a[i] = a[i + 1];
            }
        }

        int b = 0;
        for (int i = 0; i < len; i++) {
            if ((a[i] - prices[i]) > b) {
                b = a[i] - prices[i];
            }
        }

        return b;
    }

    public int maxProfitII(int[] prices) {
        if (prices == null)
            return 0;

        int len = prices.length;
        if (len <= 1)
            return 0;

        int profit = 0;
        for (int i = 0; i < len - 1; i++) {
            if (prices[i] < prices[i + 1])
                profit += prices[i + 1] - prices[i];
        }

        return profit;
    }

    public static int maxProfitIII(int[] prices) {
        if (prices == null)
            return 0;

        int len = prices.length;
        if (len <= 1)
            return 0;

        int minPrice = prices[0];
        // Rolling max profit in [0, i]
        int[] left = new int[len];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(prices[i] - minPrice, left[i - 1]);
            minPrice = Math.min(prices[i], minPrice);
        }

        int maxPrice = prices[len - 1];
        // Rolling max profit in [i, len - 1]
        int[] right = new int[len];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(maxPrice - prices[i], right[i + 1]);
            maxPrice = Math.max(prices[i], maxPrice);
        }

        int maxProfit = 0;
        for (int i = 0; i < len; i++) {
            maxProfit = Math.max(maxProfit, left[i] + right[i]);
        }

        return maxProfit;
    }
}
