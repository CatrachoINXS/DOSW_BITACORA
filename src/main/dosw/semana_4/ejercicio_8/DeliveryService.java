package main.dosw.semana_4.ejercicio_8;

public class DeliveryService implements Observer {

    @Override
    public void onOrderConfirmed() {
        System.out.println("[DeliveryService] orden recibida");
    }
    
}
