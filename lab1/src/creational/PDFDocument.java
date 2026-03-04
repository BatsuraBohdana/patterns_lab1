package creational;

public class PDFDocument implements Document {
    @Override
    public void open() {
        System.out.println("--- Factory Method: PDF документ відкрито ---");
    }
}