package main.dosw.semana_4.ejercicio_2;

public class EmailNotifier implements NotificationObserver {

    @Override
    public void notify(OrderEvent event) {
        MessageFactory factory = new EmailMessageFactory();
        Message message = factory.build(event);
        message.print();
    }
}