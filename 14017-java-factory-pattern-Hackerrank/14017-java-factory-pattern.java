class FoodFactory {

    public Food getFood(String order) {

        if (order.equals("pizza")) {
            return new Pizza();
        } else if (order.equals("cake")) {
            return new Cake();
        }

        return null;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna