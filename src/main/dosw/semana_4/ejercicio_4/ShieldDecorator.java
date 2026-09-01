package main.dosw.semana_4.ejercicio_4;

public class ShieldDecorator extends BoostDecorator {

    public ShieldDecorator(Character wrapped) {
        super(wrapped);
    }

    @Override
    public void attack() {
        System.out.print("escudo + ");
        super.wrappedCharacter.attack();
    }
}