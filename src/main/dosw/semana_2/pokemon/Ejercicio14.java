package main.dosw.semana_2.pokemon;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio14 {

    public static void main(String[] args) {
        
        List<Pokemon> pokemones = List.of(
            new Pokemon(1L, "Pikachu", "Eléctrico", 35, 320, "Kanto", false),
            new Pokemon(2L, "Chikorita", "Planta", 18, 190, "Johto", false),
            new Pokemon(3L, "Torchic", "Fuego", 20, 210, "Hoenn", false),
            new Pokemon(4L, "Piplup", "Agua", 19, 205, "Sinnoh", false),
            new Pokemon(5L, "Charmander", "Fuego", 20, 215, "Kanto", false),
            new Pokemon(6L, "Totodile", "Agua", 19, 200, "Johto", false)
        );

        pokemones.stream()
            .collect(Collectors.groupingBy(Pokemon::getRegion))
            .forEach((a, b) -> {
                System.out.println(a + ":  " + b.stream().map(Pokemon::getNombre).toList());
            });
    }
}
