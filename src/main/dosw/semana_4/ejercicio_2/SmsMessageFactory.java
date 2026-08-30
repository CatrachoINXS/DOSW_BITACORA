package main.dosw.semana_4.ejercicio_2;

public class SmsMessageFactory implements MessageFactory {

    @Override
    public Message build(OrderEvent event) {
        return new SmsMessage(event.getState());
    }
}