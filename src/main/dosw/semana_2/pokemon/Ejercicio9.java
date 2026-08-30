package main.dosw.semana_2.pokemon;

import java.util.List;

public class Ejercicio9 {
    
    public static void main(String[] args) {
        
        List<Pokemon> pokemones = List.of(
            new Pokemon(null, "Pikachu", null, 0, 320, null, false),
            new Pokemon(null, "Mewtwo", null, 0, 680, null, false),
            new Pokemon(null, "Dragonite", null, 0, 530, null, false),
            new Pokemon(null, "Squirtle", null, 0, 210, null, false),
            new Pokemon(null, "Gengar", null, 0, 495, null, false),
            new Pokemon(null, "Charizard", null, 0, 610, null, false)
        );

        List<String> pokemonesElite = pokemones.stream()
            .filter(p -> p.getPoderCombate() > 500)
            .map(p -> p.getNombre() + "(" + (int) p.getPoderCombate() + ")")
            .toList();
        
        System.out.println("Equipo Élite (PC > 500): ");
        System.out.println(pokemonesElite);
    }
}
