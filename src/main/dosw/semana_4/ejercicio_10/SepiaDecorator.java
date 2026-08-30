package main.dosw.semana_4.ejercicio_10;

public class SepiaDecorator extends ImageDecorator {

    public SepiaDecorator(Image wrappee) {
        super(wrappee);
    }
    
    @Override
    public BufferedImage render() {
        System.out.println("Aplicando sepia.");
        return super.wrappee.render();
    }
}
