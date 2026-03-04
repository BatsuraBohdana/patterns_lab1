package creational;

public class PizzaBuilder {
    private Pizza p = new Pizza();
    public PizzaBuilder addDough(String d) { p.setDough(d); return this; }
    public PizzaBuilder addSauce(String s) { p.setSauce(s); return this; }
    public PizzaBuilder addTopping(String t) { p.setTopping(t); return this; }
    public Pizza build() { return p; }
}
