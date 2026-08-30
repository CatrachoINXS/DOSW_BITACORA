package main.dosw.semana_4.ejercicio_2;

public class SmsNotifier implements NotificationObserver {

    @Override
    public void notify(OrderEvent event) {
        MessageFactory factory = new SmsMessageFactory();
        Message message = factory.build(event);
        message.print();
    }
}