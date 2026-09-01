package main.dosw.semana_4.ejercicio_4;

public class InvisibilityDecorator extends BoostDecorator {

    public InvisibilityDecorator(Character wrapped) {
        super(wrapped);
    }

    @Override
    public void attack() {
        System.out.print("invisibilidad + ");
        super.wrappedCharacter.attack();
    }
}