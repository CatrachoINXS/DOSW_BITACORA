package main.dosw.semana_4.ejercicio_7;

public class RejectedState implements DocumentState {

    @Override
    public void approve(Document doc) {
        System.out.println("No se puede aprovar un documento rechazado.");
    }

    @Override
    public void reject(Document doc) {
        System.out.println("El documento ya fue rechazado");
    }
    
}
