package main.dosw.semana_4.ejercicio_10;

public class RemoveFilterCommand implements ImageCommand {

    private Image image;
    private String filter;

    public RemoveFilterCommand(Image image, String filter) {
        this.image = image;
        this.filter = filter;
    }

    @Override
    public void execute() {
        if (filter.equalsIgnoreCase("sepia")) {
            image = new SepiaDecorator(image);
        } else if (filter.equalsIgnoreCase("grayscale")) {
            image = new GrayscaleDecorator(image);
        } else if (filter.equalsIgnoreCase("brightness")) {
            image = new BrightnessDecorator(image);
        } else {
            throw new IllegalArgumentException("filtro no reconocido");
        }
    }

    @Override
    public void undo() {
        if (image instanceof ImageDecorator) {
            image = ((ImageDecorator)image).getWrappee();
        } else {
            System.out.println("nada que deshacer");
        }
    }
    
}
