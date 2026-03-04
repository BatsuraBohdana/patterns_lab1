package creational;

public class Car implements Prototype {
    private String model;
    public Car(String model) { this.model = model; }
    @Override
    public Prototype doClone() { return new Car(model); }
    public void drive() { System.out.println("Машина " + model + " їде."); }
}