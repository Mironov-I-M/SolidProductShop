interface DiscountPolicy {
    int applyDiscount(int basePrice, int quantity);
}

class NoDiscountPolicy implements DiscountPolicy {
    @Override
    public int applyDiscount(int basePrice, int quantity) {
        return basePrice * quantity;
    }
}

class BulkDiscountPolicy implements DiscountPolicy {
    private int threshold;
    private double discount;

    public BulkDiscountPolicy(int threshold, double discount) {
        this.threshold = threshold;
        this.discount = discount;
    }

    @Override
    public int applyDiscount(int basePrice, int quantity) {
        if (quantity > threshold) {
            return (int) (basePrice * quantity * (1 - discount));
        }
        return basePrice * quantity;
    }
}