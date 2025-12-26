interface BasketItemDisplay {
    String displayItem(Product product, int quantity, int discountedPrice);
}

class SimpleBasketItemDisplay implements BasketItemDisplay {
    @Override
    public String displayItem(Product product, int quantity, int discountedPrice) {
        return String.format("%s %d шт. %d руб.", product.getName(), quantity, discountedPrice);
    }
}