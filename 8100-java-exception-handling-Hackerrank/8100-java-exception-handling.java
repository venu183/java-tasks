class MyCalculator {

    public long power(int n, int p) throws Exception {

        if (n < 0 || p < 0) {
            throw new Exception("n or p should not be negative.");
        }

        if (n == 0 && p == 0) {
            throw new Exception("n and p should not be zero.");
        }

        return (long) Math.pow(n, p);
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna