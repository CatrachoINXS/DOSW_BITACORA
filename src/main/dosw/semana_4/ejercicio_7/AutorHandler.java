package main.dosw.semana_4.ejercicio_7;

public class AutorHandler extends DocumentHandler {

    @Override
    public boolean canHandle(Document doc) {
        System.out.println("Documento pasando por Autor Handler");
        System.out.println("Redirigiendo al siguiente handler...\n");
        return false;
    }

    @Override
    public void process(Document doc) {
        doc.approve();
    }
    
}
