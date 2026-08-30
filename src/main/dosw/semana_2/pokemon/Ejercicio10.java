package main.dosw.semana_2.pokemon;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio10 {
    
    public static void main(String[] args) {
        
        List<Pokemon> pokemones = List.of(
            new Pokemon(null, "Pikachu", null, 0, 320, null, false),
            new Pokemon(null, "Mewtwo", null, 0, 680, null, false),
            new Pokemon(null, "Dragonite", null, 0, 530, null, false),
            new Pokemon(null, "Squirtle", null, 0, 210, null, false),
            new Pokemon(null, "Gengar", null, 0, 495, null, false),
            new Pokemon(null, "Charizard", null, 0, 610, null, false)
        );

        List<String> pokedexCompacta = pokemones.stream()
            .map(Pokemon::getNombre)
            .collect(Collectors.toList());

        System.out.println(pokedexCompacta);
    }
}
