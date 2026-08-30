package main.dosw.semana_4.ejercicio_3;

public class ExcelReport extends ReportGenerator {

    @Override
    public void applyFormat() {
        System.out.println("Aplicando formato de Excel");
    }

    @Override
    public void exportFile() {
        System.out.println("Exportando archivo como Excel");
    }

}