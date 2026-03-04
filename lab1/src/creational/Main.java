package creational;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== РЕЗУЛЬТАТ РОБОТИ ПАТЕРНІВ ===\n");

        // 1. Singleton
        DatabaseConnection.getInstance().query("SELECT * FROM students");

        // 2. Factory Method
        DocumentCreator docCreator = new PDFCreator();
        docCreator.createDocument().open();

        // 3. Abstract Factory
        GUIFactory gui = new WinFactory();
        gui.createButton().render();

        // 4. Builder
        new PizzaBuilder().addDough("Тонке тісто").addSauce("Кетчуп").addTopping("Сир").build().show();

        // 5. Prototype
        Car tesla = new Car("Tesla Model S");
        Car clone = (Car) tesla.doClone();
        clone.drive();

        // 6. Object Pool
        ObjectPool pool = new ObjectPool();
        String res = pool.acquire();
        System.out.println("Використовуємо: " + res);
        pool.release(res);
    }
}