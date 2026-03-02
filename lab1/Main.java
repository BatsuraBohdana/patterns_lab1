import java.util.*;

// --- 1. SINGLETON ---
class DatabaseConnection {
    private static DatabaseConnection instance;
    private DatabaseConnection() {}

    public static DatabaseConnection getInstance() {
        if (instance == null) instance = new DatabaseConnection();
        return instance;
    }
    public void connect() { System.out.println("Connected to DB (Singleton)"); }
}

// --- 2. FACTORY METHOD ---
interface Notification { void notifyUser(); }
class EmailNotification implements Notification {
    public void notifyUser() { System.out.println("Sending Email... (Factory Method)"); }
}
abstract class NotificationFactory {
    public abstract Notification createNotification();
}
class EmailFactory extends NotificationFactory {
    public Notification createNotification() { return new EmailNotification(); }
}

// --- 3. ABSTRACT FACTORY ---
interface Button { void paint(); }
interface Checkbox { void paint(); }

class WinButton implements Button { public void paint() { System.out.println("Windows Button (Abstract Factory)"); } }
class WinCheckbox implements Checkbox { public void paint() { System.out.println("Windows Checkbox (Abstract Factory)"); } }

interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
class WinFactory implements GUIFactory {
    public Button createButton() { return new WinButton(); }
    public Checkbox createCheckbox() { return new WinCheckbox(); }
}

// --- 4. BUILDER ---
class Laptop {
    private String CPU, RAM;
    private Laptop() {}

    public static class Builder {
        private Laptop laptop = new Laptop();
        public Builder setCPU(String cpu) { laptop.CPU = cpu; return this; }
        public Builder setRAM(String ram) { laptop.RAM = ram; return this; }
        public Laptop build() { return laptop; }
    }
    public void showSpecs() { System.out.println("Laptop: " + CPU + ", " + RAM + " (Builder)"); }
}

// --- 5. PROTOTYPE ---
abstract class Shape implements Cloneable {
    public String type;
    public abstract void draw();
    public Object clone() {
        try { return super.clone(); } catch (CloneNotSupportedException e) { return null; }
    }
}
class Circle extends Shape {
    public Circle() { type = "Circle"; }
    public void draw() { System.out.println("Drawing Circle (Prototype)"); }
}

// --- 6. OBJECT POOL ---
class ObjectPool {
    private List<String> available = new ArrayList<>(Arrays.asList("Conn1", "Conn2"));
    public String acquire() { 
        if (available.isEmpty()) return null;
        return available.remove(0); 
    }
    public void release(String obj) { available.add(obj); }
}

// --- ГОЛОВНИЙ КЛАС ---
public class Main {
    public static void main(String[] args) {
        // 1. Singleton
        DatabaseConnection.getInstance().connect();

        // 2. Factory Method
        NotificationFactory nFactory = new EmailFactory();
        nFactory.createNotification().notifyUser();

        // 3. Abstract Factory
        GUIFactory guiFactory = new WinFactory();
        guiFactory.createButton().paint();

        // 4. Builder
        Laptop myMac = new Laptop.Builder().setCPU("M4 Pro").setRAM("32GB").build();
        myMac.showSpecs();

        // 5. Prototype
        Circle c1 = new Circle();
        Circle c2 = (Circle) c1.clone();
        if (c2 != null) c2.draw();

        // 6. Object Pool
        ObjectPool pool = new ObjectPool();
        String conn = pool.acquire();
        pool.release(conn);
    }
}