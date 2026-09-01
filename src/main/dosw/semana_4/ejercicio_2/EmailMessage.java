package main.dosw.semana_4.ejercicio_2;

public class EmailMessage implements Message {

    private String event;

    public EmailMessage(String event) {
        this.event = event;
    }

    @Override
    public void print() {
        System.out.println("Email: El pedido cambio de estado a " + event);
    }
}