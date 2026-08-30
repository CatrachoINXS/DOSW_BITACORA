package main.dosw.semana_4.ejercicio_3;

public class Main {
    
    public static void main(String[] args) {
        
        ReportGenerator report = ReportFactory.create("PDF");
        report.generate();
    }
}
