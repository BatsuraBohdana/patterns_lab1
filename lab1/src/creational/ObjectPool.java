package creational;
import java.util.*;
public class ObjectPool {
 private List<String> pool = new ArrayList<>(Arrays.asList("Ресурс_1", "Ресурс_2"));
    public String acquire() { return pool.isEmpty() ? null : pool.remove(0); }
    public void release(String res) { pool.add(res); System.out.println("--- Object Pool: " + res + " повернуто в пул ---"); }
}   

