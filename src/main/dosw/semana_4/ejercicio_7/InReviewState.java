package main.dosw.semana_4.ejercicio_7;

public class InReviewState implements DocumentState {

    @Override
    public void approve(Document doc) {
        System.out.println("Documento aprovado");
        doc.changeState(new ApprovedState());
    }

    @Override
    public void reject(Document doc) {
        System.out.println("Documento rechazado");
        doc.changeState(new RejectedState());
    }

}
