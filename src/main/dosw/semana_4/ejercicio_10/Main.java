package main.dosw.semana_4.ejercicio_10;

public class Main {
    public static void main(String[] args) {
        
        Image image = new BaseImage();

        ApplyFilterCommand applySepia = new ApplyFilterCommand(image, "sepia");
        ApplyFilterCommand applyBrightness = new ApplyFilterCommand(applySepia.getImage(), "brightness");
        applySepia.execute();
        applyBrightness.execute();

        applyBrightness.undo();
        
    }
}
