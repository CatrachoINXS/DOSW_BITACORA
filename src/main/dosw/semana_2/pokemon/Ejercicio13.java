package main.dosw.semana_2.pokemon;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio13 {

    public static void main(String[] args) {
        
        List<Pokemon> pokemones = List.of(
            new Pokemon(1L, "Squirtle", "Agua", 20, 210, "Kanto", false),
            new Pokemon(2L, "Psyduck", "Agua", 22, 245, "Kanto", false),
            new Pokemon(3L, "Charmander", "Fuego", 20, 215, "Kanto", false),
            new Pokemon(4L, "Vulpix", "Fuego", 21, 230, "Kanto", false),
            new Pokemon(5L, "Bulbasaur", "Planta/Veneno", 20, 218, "Kanto", false)
        );

        pokemones.stream()
            .collect(Collectors.groupingBy(Pokemon::getTipo))
            .forEach((a, b) -> {
                System.out.println(a + ":  " + b.stream().map(Pokemon::getNombre).toList());
            });
    }
}
