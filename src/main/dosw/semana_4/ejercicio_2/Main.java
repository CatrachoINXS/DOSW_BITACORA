package main.dosw.semana_4.ejercicio_2;

public class Main {
    
    public static void main(String[] args) {
        
        Order order = new Order("EN ESPERA");
        NotificationObserver smsNotifier = new SmsNotifier();
        NotificationObserver emailNotifier = new EmailNotifier();
        NotificationObserver pushNotifier = new PushNotifier();

        order.subscribe(smsNotifier);
        order.subscribe(pushNotifier);
        order.changeState("EN PREPARACION");
        order.changeState("ENVIADO");
        order.unsubscribe(smsNotifier);
        order.subscribe(emailNotifier);
        order.changeState("ENTREGADO");
    }
}
