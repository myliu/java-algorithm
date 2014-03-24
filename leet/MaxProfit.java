package leet;

public class MaxProfit {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] prices1 = { 3, 2, 6, 5, 0, 3 };
        System.out.println(maxProfit(prices1));
        
        int[] prices2 = { 1, 2, 4 };
        System.out.println(maxProfit(prices2));
    }

    public static int maxProfit(int[] prices) {
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
}
