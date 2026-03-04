package creational;

public class WinButton implements Button {
    @Override
    public void render() {
        System.out.println("--- Abstract Factory: Рендер Windows Кнопки ---");
    }
}