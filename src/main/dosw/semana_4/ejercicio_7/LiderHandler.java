package main.dosw.semana_4.ejercicio_7;

public class LiderHandler extends DocumentHandler {

    @Override
    public boolean canHandle(Document doc) {
        System.out.println("Documento pasando por LiderHandler");
        System.out.println("Redirigido a el siguiente handler..\n");
        return false;
    }

    @Override
    public void process(Document doc) {
        doc.approve();
    }
    
}
