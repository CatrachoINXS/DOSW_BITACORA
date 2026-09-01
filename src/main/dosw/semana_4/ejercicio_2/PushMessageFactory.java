package main.dosw.semana_4.ejercicio_2;

public class PushMessageFactory implements MessageFactory {

    @Override
    public Message build(OrderEvent event) {
        return new PushMessage(event.getState());
    }
}