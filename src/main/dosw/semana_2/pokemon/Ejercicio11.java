package main.dosw.semana_2.pokemon;

import java.util.List;

public class Ejercicio11 {

    public static void main(String[] args) {

        List<Pokemon> pokemones = List.of(
            new Pokemon(1L, "Pikachu", "Eléctrico", 35, 320, "Kanto", false),
            new Pokemon(2L, "Mewtwo", "Psíquico", 70, 680, "Kanto", true),
            new Pokemon(3L, "Dragonite", "Dragón/Volador", 55, 530, "Kanto", false),
            new Pokemon(4L, "Squirtle", "Agua", 20, 210, "Kanto", false),
            new Pokemon(5L, "Gengar", "Fantasma/Veneno", 50, 495, "Kanto", false),
            new Pokemon(6L, "Charizard", "Fuego/Volador", 65, 610, "Kanto", false)
        );

        double poderPromedio = pokemones.stream()
            .mapToDouble(Pokemon::getPoderCombate)
            .average()
            .orElse(0);

        System.out.printf("Poder de combate promedio: %f", poderPromedio);
    }
}
