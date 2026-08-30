package main.dosw.semana_4.ejercicio_7;

public class Main {
    public static void main(String[] args) {
        
        DocumentHandler handler = new AutorHandler();
        handler.setNext(new LiderHandler())
               .setNext(new FinancieroHandler())
               .setNext(new JuridicoHandler());

        Document doc = new Document();

        handler.handle(doc);
    }
}
