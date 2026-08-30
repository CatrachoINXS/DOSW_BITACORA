package main.dosw.semana_4.ejercicio_3;

public class PdfReport extends ReportGenerator {

    @Override
    public void applyFormat() {
        System.out.println("Aplicando formato de PDF");
    }

    @Override
    public void exportFile() {
        System.out.println("Exportando archivo como PDF");
    }

}