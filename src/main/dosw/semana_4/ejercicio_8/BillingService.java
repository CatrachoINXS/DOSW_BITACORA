package main.dosw.semana_4.ejercicio_8;

public class BillingService implements Observer {

    @Override
    public void onOrderConfirmed() {
        System.out.println("[BillingService] orden recibida");
    }
    
}
