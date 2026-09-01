package main.dosw.semana_4.ejercicio_7;

public class JuridicoHandler extends DocumentHandler {

    @Override
    public boolean canHandle(Document doc) {
        return true;
    }

    @Override
    public void process(Document doc) {
        System.out.println("Documento siendo procesado por JuridicoHandler");
        doc.approve();
    }
    
}
