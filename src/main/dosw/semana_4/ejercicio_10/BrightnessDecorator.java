package main.dosw.semana_4.ejercicio_10;

public class BrightnessDecorator extends ImageDecorator {

    public BrightnessDecorator(Image wrappee) {
        super(wrappee);
    }
    
    @Override
    public BufferedImage render() {
        System.out.println("Aplicando brillo.");
        return super.wrappee.render();
    }
}
