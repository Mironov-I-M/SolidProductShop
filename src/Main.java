import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Молоко", 50));
        productList.add(new Product("Хлеб", 14));
        productList.add(new Product("Греча", 80));

        ProductCatalogue catalogue = new InMemoryProductCatalogue(productList);

        Scanner scanner = new Scanner(System.in);
        Basket basket = new Basket(new BulkDiscountPolicy(3, 0.1), new SimpleBasketItemDisplay());// скидка 10% при покупке от 3 штук
        System.out.println("Выберите товар (номер) и количество.\n " +
                "При покупке от 3 штук продукции - скидка 10% \n " +
                "Для завершения введите 'end'.");
        List<Product> products = catalogue.getAllProducts();
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }

        while (true) {
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            String[] parts = input.split(" ");
            int productIndex = Integer.parseInt(parts[0]) - 1;
            int quantity = Integer.parseInt(parts[1]);
            basket.addItem(products.get(productIndex), quantity);
            basket.printBasket();
        }

        basket.printBasket();
    }
}
