package main.dosw.semana_4.ejercicio_7;

public class ApprovedState implements DocumentState {

    @Override
    public void approve(Document doc) {
        System.out.println("El documento ya fue aprovado");
    }

    @Override
    public void reject(Document doc) {
        System.out.println("No se puede rechazar un documento aprovado");
    }
    
}
