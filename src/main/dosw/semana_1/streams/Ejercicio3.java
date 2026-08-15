package main.dosw.semana_1.streams;

import java.util.List;

public class Ejercicio3 {

    public static void main(String[] args) {
        
        List<User> users = List.of(new User(1, "Cristian", 18, false),
            new User(2, "Camilo", 18, true),
            new User(3, "Pathfinder", 19, true),
            new User(4, "Mirage", 21, true));

        List<String> sortedUsers = users.stream()
            .filter(u -> u.isActive())
            .map(u -> u.getName().toUpperCase())
            .sorted()
            .toList();

        System.out.println(sortedUsers.toString());
    }  
}