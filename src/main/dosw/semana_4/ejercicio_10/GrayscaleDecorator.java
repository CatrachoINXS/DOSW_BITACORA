package main.dosw.semana_4.ejercicio_10;

public class GrayscaleDecorator extends ImageDecorator {

    public GrayscaleDecorator(Image wrappee) {
        super(wrappee);
    }
    
    @Override
    public BufferedImage render() {
        System.out.println("Aplicando blanco y negro.");
        return super.wrappee.render();
    }
}
