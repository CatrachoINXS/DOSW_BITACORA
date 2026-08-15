package main.dosw.semana_2;

import java.util.List;

public class Ejercicio3 {
    
    public static void main(String[] args) {
        
        List<Integer> niveles = List.of(45, 62, 38, 71, 55, 29);

        int sumaTotalNiveles = niveles.stream()
            .reduce(0, Integer::sum);

        System.out.println("Suma total de niveles: " + sumaTotalNiveles);
    }
}
