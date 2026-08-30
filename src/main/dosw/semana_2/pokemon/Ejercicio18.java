package main.dosw.semana_2.pokemon;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Ejercicio18 {
    
    public static void main(String[] args) {
        
        List<Pokemon> pokemones = List.of(
            new Pokemon(4L, "Gengar", "Fantasma/Veneno", 50, 495, "Kanto", false),
            new Pokemon(1L, "Mewtwo", "Psíquico", 70, 680, "Kanto", true),
            new Pokemon(9L, "Psyduck", "Agua", 22, 245, "Kanto", false),
            new Pokemon(3L, "Dragonite", "Dragón/Volador", 55, 530, "Kanto", false),
            new Pokemon(6L, "Lucario", "Lucha/Acero", 50, 310, "Sinnoh", false),
            new Pokemon(5L, "Pikachu", "Eléctrico", 35, 320, "Kanto", false),
            new Pokemon(2L, "Rayquaza", "Dragón/Volador", 70, 200, "Hoenn", true),
            new Pokemon(10L, "Squirtle", "Agua", 20, 210, "Kanto", false),
            new Pokemon(7L, "Charizard", "Fuego/Volador", 65, 610, "Kanto", false),
            new Pokemon(8L, "Tyranitar", "Roca/Siniestro", 60, 220, "Johto", false)
        );

        List<Pokemon> topPokemones = pokemones.stream()
            .sorted(Comparator.comparing(Pokemon::getPoderCombate).reversed())
            .limit(5)
            .toList();

        IntStream.range(0, topPokemones.size())
            .forEach(i -> {
                Pokemon pokemon = topPokemones.get(i);
                System.out.println("#" + (i + 1) + " " 
                    + pokemon.getNombre() + " - PC: " + pokemon.getPoderCombate());
            });
    }
}
