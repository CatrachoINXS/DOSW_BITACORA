package main.dosw.semana_4.ejercicio_3;

public class ReportFactory {

    public static ReportGenerator create(String format) {
        if (format.equalsIgnoreCase("PDF")) {
            return new PdfReport();
        } else if (format.equalsIgnoreCase("Excel")) {
            return new ExcelReport();
        } else if (format.equalsIgnoreCase("Cav")) {
            return new CavReport();
        } else {
            throw new IllegalArgumentException("Formato no disponible");
        }
    }
}
