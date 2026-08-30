package main.dosw.semana_4.ejercicio_2;

public class EmailMessageFactory implements MessageFactory {

    @Override
    public Message build(OrderEvent event) {
        return new EmailMessage(event.getState());
    }
}