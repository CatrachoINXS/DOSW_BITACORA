package main.dosw.semana_2.pokemon;

import java.util.Comparator;
import java.util.List;

public class Ejercicio17 {
    
    public static void main(String[] args) {
        
        List<Pokemon> equipoAsh = List.of(
            new Pokemon(1L, "Pikachu", "Eléctrico", 35, 320, "Kanto", false),
            new Pokemon(2L, "Charizard", "Fuego/Volador", 65, 610, "Kanto", false),
            new Pokemon(3L, "Squirtle", "Agua", 20, 210, "Kanto", false),
            new Pokemon(4L, "Charmander", "Fuego", 20, 215, "Kanto", false),
            new Pokemon(5L, "Gengar", "Fantasma/Veneno", 50, 495, "Kanto", false)
        );

        List<Pokemon> equipoGary = List.of(
            new Pokemon(6L, "Mewtwo", "Psíquico", 70, 680, "Kanto", true),
            new Pokemon(7L, "Dragonite", "Dragón/Volador", 55, 530, "Kanto", false),
            new Pokemon(8L, "Charizard", "Fuego/Volador", 65, 610, "Kanto", false),
            new Pokemon(9L, "Blastoise", "Agua", 52, 520, "Kanto", false)
        );

        List<Pokemon> equipoBrock = List.of(
            new Pokemon(10L, "Dragonite", "Dragón/Volador", 55, 530, "Kanto", false),
            new Pokemon(11L, "Gengar", "Fantasma/Veneno", 50, 495, "Kanto", false),
            new Pokemon(12L, "Squirtle", "Agua", 20, 210, "Kanto", false),
            new Pokemon(13L, "Onix", "Roca/Tierra", 22, 235, "Kanto", false),
            new Pokemon(14L, "Geodude", "Roca/Tierra", 19, 200, "Kanto", false)
        );

        List<Entrenador> entrenadores = List.of(
            new Entrenador(equipoAsh, 1L, 8, "Ash"),
            new Entrenador(equipoGary, 2L, 10, "Gary"),
            new Entrenador(equipoBrock, 3L, 6, "Brock")
        );

        Entrenador entrenadorMasPoderoso = entrenadores.stream()
            .max(Comparator.comparingDouble(e -> e.getEquipo()
                .stream()
                .mapToDouble(Pokemon::getPoderCombate)
                .sum()))
            .orElse(null);

        System.out.println("Entrenador mas poderoso: " + entrenadorMasPoderoso.getNombre());
        System.out.println("Poder acumulado del equipo: " + entrenadorMasPoderoso.getEquipo()
            .stream().mapToDouble(Pokemon::getPoderCombate).sum());
    }
}
