package main.dosw.semana_4.ejercicio_2;

public class PushMessage implements Message {

    private String event;

    public PushMessage(String event) {
        this.event = event;
    }

    @Override
    public void print() {
        System.out.println("Push: El pedido cambio de estado a " + event);
    }
}