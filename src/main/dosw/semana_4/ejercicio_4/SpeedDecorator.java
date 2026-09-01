package main.dosw.semana_4.ejercicio_4;

public class SpeedDecorator extends BoostDecorator {

    public SpeedDecorator(Character wrapped) {
        super(wrapped);
    }

    @Override
    public void attack() {
        System.out.print("velocidad extra + ");
        super.wrappedCharacter.attack();
    }
}