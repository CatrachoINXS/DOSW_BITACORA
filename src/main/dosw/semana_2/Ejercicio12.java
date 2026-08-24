package main.dosw.semana_2;

import java.util.List;

public class Ejercicio12 {
    
    public static void main(String[] args) {
        
        List<Pokemon> pokemones = List.of(
            new Pokemon(1L, "Pikachu", "Eléctrico", 35, 320, "Kanto", false),
            new Pokemon(2L, "Mewtwo", "Psíquico", 70, 680, "Kanto", true),
            new Pokemon(3L, "Dragonite", "Dragón/Volador", 55, 530, "Kanto", false),
            new Pokemon(6L, "Charizard", "Fuego/Volador", 65, 610, "Kanto", false)
        );

        String campeon = pokemones.stream()
            .max((a, b) -> Double.compare(a.getPoderCombate(), b.getPoderCombate()))
            .map(p -> "Campeón: " + p.getNombre() + " con PC: " + p.getPoderCombate())
            .orElse(null);
        
        System.out.println(campeon);
    }
}
