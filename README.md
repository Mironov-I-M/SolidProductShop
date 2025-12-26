### DRY: 
В текущем коде отсутствует повторяющийся код.


### SOLID:

***Single Responsibility Principle (SRP):*** Каждый класс выполняет одну задачу. Product отвечает за хранение данных о продукте, *InMemoryProductCatalogue* - за хранение списка продуктов, *Basket* - за управление корзиной, *DiscountPolicy* - за применение скидок, *BasketItemDisplay*-  за отображение элементов.


***Open/Closed Principle (OCP):*** Система легко расширяема. Добавление новых типов скидок или вариантов отображения элементов корзины не требует изменения существующих классов.


***Liskov Substitution Principle (LSP):*** Любой класс, реализующий интерфейс *DiscountPolicy* или *BasketItemDisplay*, может быть использован вместо базового интерфейса.


***Interface Segregation Principle (ISP):*** Есть отдельные интерфейсы, например *DiscountPolicy*, а не единый интерфейс выполняющий все операции над скидками. Так же и для отображения *BasketItemDisplay*.


***Dependency Inversion Principle (DIP):*** Basket зависит от абстракций (*DiscountPolicy*, *BasketItemDisplay*), а не от конкретных реализаций.

