package main.dosw.semana_4.ejercicio_2;

public class SmsMessage implements Message {

    private String event;

    public SmsMessage(String event) {
        this.event = event;
    }

    @Override
    public void print() {
        System.out.println("SMS: El pedido cambio de estado a " + event);
    }
}