package main.dosw.semana_4.ejercicio_7;

public abstract class DocumentHandler {
    
    private DocumentHandler next;

    public DocumentHandler setNext(DocumentHandler handler) {
        this.next = handler;
        return handler;
    }

    public void handle(Document doc) {
        if (canHandle(doc)) {
            process(doc);
        } else if (next != null) {
            next.handle(doc);
        }
    }

    public abstract boolean canHandle(Document doc);
    public abstract void process(Document doc);
}
