package main.dosw.semana_4.ejercicio_8;

public class KitchenService implements Observer {

    @Override
    public void onOrderConfirmed() {
        System.out.println("[KitchenService] orden recibida");
    }
    
}
