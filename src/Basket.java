import java.util.ArrayList;
import java.util.List;

class Basket {
    private final List<BasketItem> items = new ArrayList<>();
    private final DiscountPolicy discountPolicy;
    private final BasketItemDisplay itemDisplay;

    public Basket(DiscountPolicy discountPolicy, BasketItemDisplay itemDisplay) {
        this.discountPolicy = discountPolicy;
        this.itemDisplay = itemDisplay;
    }

    public void addItem(Product product, int quantity) {
        items.add(new BasketItem(product, quantity));
    }

    public void printBasket() {
        int total = 0;
        System.out.println("Ваша корзина:");
        for (BasketItem item : items) {
            int discountedPrice = discountPolicy.applyDiscount(item.product.getPrice(), item.quantity);
            System.out.println(itemDisplay.displayItem(item.product, item.quantity, discountedPrice));
            total += discountedPrice;
        }
        System.out.println("Итого: " + total + " руб.");
    }

    private class BasketItem {
        private Product product;
        private int quantity;

        public BasketItem(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }
    }
}