package leet;

public class Sqrt {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int y = sqrt(2147483647);
        System.out.println(y);
    }

    // long is necessary here since integer multiplication may result in silent overflow in java
    // http://stackoverflow.com/questions/12861893/casting-result-of-multiplication-two-positive-integers-to-long-is-negative-value
    public static int sqrt(int x) {
        long lo = 0;
        long hi = x;

        while (lo <= hi) {
            long mid = lo+(hi-lo)/2;
            // (hi + 1) is greater than the sqrt(x)
            // This is because we need to handle the case where there's no perfect square root
            // e.g. sqrt(6) = 2
            // In this case, 3 is greater than sqrt(6) == 2
            if (x < mid * mid) {
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }
        return (int)hi;
    }
}
