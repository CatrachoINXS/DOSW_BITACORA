package main.dosw.semana_4.ejercicio_10;

public class ImageDecorator implements Image {

    protected Image wrappee;

    public ImageDecorator(Image wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public BufferedImage render() {
        return wrappee.render();
    }

    public Image getWrappee() {
        return wrappee;
    }
}
