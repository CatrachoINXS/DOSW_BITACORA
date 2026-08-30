package main.dosw.semana_4.ejercicio_7;

public class FinancieroHandler extends DocumentHandler {

    @Override
    public boolean canHandle(Document doc) {
        System.out.println("Documento pasando por FinancieroHandler");
        System.out.println("Redirigido a el siguiente handler..\n");
        return false;
    }

    @Override
    public void process(Document doc) {
        doc.approve();
    }
    
}
