package main.dosw.semana_4.ejercicio_4;

public abstract class BoostDecorator implements Character {

    protected Character wrappedCharacter;
    
    public BoostDecorator(Character wrapped) {
        this.wrappedCharacter = wrapped;
    }
}
