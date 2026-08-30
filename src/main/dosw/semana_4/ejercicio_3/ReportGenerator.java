package main.dosw.semana_4.ejercicio_3;

public abstract class ReportGenerator {
    
    public final void generate() {
        fetchData();
        processData();
        applyFormat();
        exportFile();
    }

    public void fetchData() {
        System.out.println("Obteniendo Datos");
    }

    public void processData() {
        System.out.println("Procesando Informacion");
    }

    public abstract void applyFormat();
    public abstract void exportFile();
}