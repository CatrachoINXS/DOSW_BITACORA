package main.dosw.semana_4.ejercicio_7;

public class Document {
    
    private DocumentState state;

    public void approve() {
        if (state == null) {
            System.out.println("Documento pasado a estado de revision");
            state = new InReviewState();
        }
        state.approve(this);
    }

    public void reject() {
        state.reject(this);
    }

    public void changeState(DocumentState state) {
        this.state = state;
    }

    public DocumentState getState() {
        return state;
    }
}
