package creational;

public class Pizza {
    private String info = "Піца з: ";
    public void setDough(String d) { info += d + ", "; }
    public void setSauce(String s) { info += s + ", "; }
    public void setTopping(String t) { info += t; }
    public void show() { System.out.println("--- Builder: " + info + " ---"); }
}
