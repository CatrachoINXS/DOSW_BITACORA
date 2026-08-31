# **Bitácora**

# SEMANA No 1 — DOSW Manejo de Streams 
 
## Datos personales: 
- Nombre y Apellido: Cristian Camilo Ortiz Sanchez
- Código de Estudiante: 1000105286
- Curso: DOSW-1

--- 

### Ejercicio 01 — Número Pares mayores a diez 

Dada una lista de números enteros, necesitamos obtener una nueva lista solo con los números pares mayores a 10.

| DATOS DE ENTRADA           | SALIDA ESPERADA |
| -------------------------- | --------------- |
| [3, 8, 10, 12, 15, 18, 20] | [12, 18, 20]    |

**Código implementado:**

```java
import java.util.List;

public class Ejercicio1 {
    public static void main(String[] args) {

        List<Integer> numeros = List.of(3,8,10,12,15,18,20);
        List<Integer> mayoresADiez = numeros.stream()
            .filter(n -> n > 10)
            .filter(n -> n % 2 == 0)
            .toList();

        System.out.println(mayoresADiez);
    }   
}
```
**Captura de ejecución:**

![](./src/main/dosw/semana_1/streams/captura_ejercicio_1.png)

**Explicación:** Primero se convierte la lista a un stream, usando `numeros.stream()`, despues aplicamos dos filter, uno para que los números sean mayores a 10, y otros para que sean pares. Finalmente, se convierte en una lista, con el método `toList()` y se imprime.

---

### Ejercicio 02 — Cantidad de Palabras con más de 4 caracteres

Dada una lista de palabras, se requiere: 

- Filtrar las palabras que tengan más de 4 caracteres 
- Convertirlas en Mayúsculas 
- Ordenarlas alfabéticamente 
- Obtener la cantidad total de palabras resultantes 

| DATOS DE ENTRADA                                   | SALIDA ESPERADA                     |
| -------------------------------------------------- | ----------------------------------- |
| ["java","stream","api","functional","code", “git”] | Cantidad de palabras resultantes: 2 |

**Código implementado:**

```java
import java.util.List;

public class Ejercicio2 {

    public static void main(String[] args) {
        
        List<String> palabras = List.of("java","stream","api",
            "functional","code","git");

        long cantidaPalabrasFiltradas = palabras.stream()
            .filter(p -> p.length() > 4)
            .map(String::toUpperCase)
            .sorted()
            .count();

        System.out.println("Cantidad de palabras resultantes: " 
            + cantidaPalabrasFiltradas);
    }
}
```
**Captura de ejecución:**

![](./src/main/dosw/semana_1/streams/captura_ejercicio_2.png)

**Explicación:** Se convierte la lista a un stream, aplicamos un `filter()` para las palabras con longitud mayor a 4, usamos map para convertir a mayusculas mediante el metodo `toUpperCase()` y con `count()`, devolvemos la cantidad de elementos.

---

### Ejercicio 03 — Obtener nombres de los Usuarios

Dada una lista de usuarios con los atributos: id, name, age, active 

Filtra únicamente los usuarios activos, obtén una lista con los nombres en mayúscula y ordenada alfabéticamente. 

| DATOS DE ENTRADA     | SALIDA ESPERADA              |
| -------------------- | ---------------------------- |
| `users = List<User>` | `sortedUsers = List<String>` |

**Código implementado:**

```java
public class User {

    private int id;
    private String name;
    private int age;
    private boolean active;

    public User(int id, String name, int age, boolean active) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }
}

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
```
**Captura de ejecución:**

![](./src/main/dosw/semana_1/streams/captura_ejercicio_3.png)

**Explicación:** Para ordenar los usuarios activos se convierte la lista de usuarios a un Stream, despues se filtran los activos, y mediante el método `map()` obtenemos el nombre de cada usuario y lo transformamos en mayusculas, ordenamos usando `sorted()` y lo convertimos a lista usando `toList()`.

---

### Ejercicio 04 — Personas mayores de edad 

Dado un listado de Usuarios y utilizando los mismo atributos anteriores, filtrar las personas mayores de edad y obtener sus nombres.

**Código implementado:**

```java
public class Ejercicio4 {
    
    public static void main(String[] args) {
        
        List<User> users = List.of(new User(1, "Cristian", 15, false),
            new User(2, "Camilo", 18, true),
            new User(3, "Pathfinder", 16, true),
            new User(4, "Mirage", 21, true));

        users.stream()
            .filter(u -> u.getAge() >= 18)
            .map(u -> u.getName())
            .forEach(System.out::println);
    }
}
```
**Captura de ejecución:**

![](./src/main/dosw/semana_1/streams/captura_ejercicio_4.png)

**Explicación:** Se convierte la lista a un stream, aplicamos un `filter()` para los usuarios con edad mayor o igual a 18, usamos map para obtener el nombre e imprimimos cada uno.

---

### Ejercicio 05 — Transacciones Bancarias

Dada una lista de transacciones bancarias representadas por objetos: 

`class Transaction { String id; double amount; boolean approved; }` 

Se requiere procesar la lista usando Streams para: 

- Usar peek para ver cada transacción procesada (Utilizar System.out.println para ver la transacción) 
- Verificar si existe al menos una transacción no aprobada 
- Retornar true o false indicando si el lote de transacciones es válido.

**Código implementado:**

```java
public class Transaction {
    
    private String id;
    private double amount;
    private boolean approved;

    public Transaction(String id, double amount, boolean approved) {
        this.id = id;
        this.amount = amount;
        this.approved = approved;
    }

    public boolean isApproved() {
        return approved;
    }

    public String toString() {
        return "Transacción: " + id + ", monto: " 
            + amount + ", estado aprovación: " + approved;
    }
}

public class Ejercicio5 {
    
    public static void main(String[] args) {
        
        List<Transaction> transacciones = List.of(
            new Transaction("A01", 1400 , true),
            new Transaction("A03", 2100 , true),
            new Transaction("A02", 400, true),
            new Transaction("A04", 243, false));

        boolean loteValido = transacciones.stream()
            .peek(t -> System.out.println(t.toString()))
            .allMatch(t -> t.isApproved() == true);

        System.out.println("\nValidez del lote: " + loteValido);
    }
}
```
**Captura de ejecución:**

![](./src/main/dosw/semana_1/streams/captura_ejercicio_5.png)

**Explicación:** Se transforma la lista de transacciones en un Stream, se hace peek de sus elementos para imprimirlos y al final se hace uso de `allMatch()` para retornar si todas las transacciones han sido aprovadas. 

---

# SEMANA No 2 — Bitácora Pokémon 

## Datos de Entrenador: 

- Nombre y Apellido: Cristian Camilo Ortiz Sanchez
- Código de Estudiante: 1000105286
- Curso: DOSW-1

--- 

### Ejercicio 01 — Pokemon Tipo Fuego

Dada una lista de Pokémon con nombre y tipo, obtener únicamente aquellos cuyo tipo sea Fuego.

**Código implementado:**

```java
public class Ejercicio1 {
    
    public static void main(String[] args) {
        
        List<Pokemon> pokemones = List.of(
            new Pokemon("Pikachu", "Eléctrico"),
            new Pokemon("Charmander", "Fuego"),
            new Pokemon("Squirtle", "Agua"),
            new Pokemon("Vulpix", "Fuego"),
            new Pokemon("Bulbasaur", "Planta"),
            new Pokemon("Flareon", "Fuego"));

        List<String> pokemonesTipoFuego = pokemones.stream()
            .filter(p -> p.getTipo() == "Fuego")
            .map(Pokemon::getNombre)
            .toList();
        
        System.out.println(pokemonesTipoFuego);
    }
}

public class Pokemon {
    
    private String nombre;
    private String tipo;

    public Pokemon(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    } 

    public String getTipo() {
        return tipo;
    }
}
```
**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_1.png)

**Explicación:** Se usa un `filter()` para obtener unicamente los tipo Fuego y un `map()` para obtener los nombres de los pokemones.

---

### Ejercicio 02 — Pokédex Gritona

Transformar todos los nombres de Pokémon a mayúsculas. 

**Código implementado:**

```java
public class Ejercicio2 {
    
    public static void main(String[] args) {
        
        List<Pokemon> pokemones = List.of(
            new Pokemon("Pikachu", "Eléctrico"),
            new Pokemon("Charmander", "Fuego"),
            new Pokemon("Squirtle", "Agua"),
            new Pokemon("Bulbasaur", "Planta"));

        List<String> pokemonesMayusculas = pokemones.stream()
            .map(p -> p.getNombre().toUpperCase())
            .toList();
        
        System.out.println(pokemonesMayusculas);
    }
}
```
**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_2.png)

**Explicación:** Se usa un `map()` transformar los nombres a mayusculas usando `toUpperCase()`.

---

### Ejercicio 03 — Poder Total del Equipo

Dada una lista de niveles de Pokémon, calcular la suma total de niveles del equipo.  

**Código implementado:**

```java
public class Ejercicio3 {
    
    public static void main(String[] args) {
        
        List<Integer> niveles = List.of(45, 62, 38, 71, 55, 29);

        int sumaTotalNiveles = niveles.stream()
            .reduce(0, Integer::sum);

        System.out.println("Suma total de niveles: " + sumaTotalNiveles);
    }
}
```
**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_3.png)

**Explicación:** Se usa `reduce()` junto con `Integer::sum` para sumar los elementos de la lista.

---

### Ejercicio 04 — Pokémon Alfa

Encontrar el Pokémon con el nivel más alto dentro del equipo.  

**Código implementado:**

```java
public class Ejercicio4 {
    
    public static void main(String[] args) {
        
        List<Pokemon> pokemones = List.of(
            new Pokemon(null, "Pikachu", "Eléctrico", 45, 0, null, false),
            new Pokemon(null, "Charmander", "Fuego", 62, 0, null, false),
            new Pokemon(null, "Squirtle", "Agua", 38, 0, null, false),
            new Pokemon(null, "Snorlax", "Normal", 90, 0, null, false),
            new Pokemon(null, "Mewtwo", "Psiquico", 88, 0, null, false));

        Pokemon pokemonAlfa = pokemones.stream()
            .max((a, b) -> Integer.compare(a.getNivel(), b.getNivel()))
            .orElse(null);

        System.out.println("Pokemon Alfa: " + pokemonAlfa.getNombre() + 
            " (nivel " + pokemonAlfa.getNivel() + ")");
    }
}
```
**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_4.png)

**Explicación:** Se usa la función max() y se comparan los niveles de los pokemones mediante una lambda.

---

### Ejercicio 05 — Pokémon Legendarios 

Encontrar el Pokémon con el nivel más alto dentro del equipo.  

**Código implementado:**

```java
public class Ejercicio5 {
    
    public static void main(String[] args) {
        
        List<Pokemon> pokemones = List.of(
            new Pokemon(null, "Pikachu", "Eléctrico", 45, 0, null, false),
            new Pokemon(null, "Charmander", "Fuego", 62, 0, null, false),
            new Pokemon(null, "Squirtle", "Agua", 38, 0, null, false),
            new Pokemon(null, "Dragonite", null, 82, 0, null, false),
            new Pokemon(null, "Mewtwo", "Psiquico", 88, 0, null, false),
            new Pokemon(null, "Mew", null, 85, 0, null, false));

        long cantidadPokemonesLegendarios = pokemones.stream()
            .filter(p -> p.getNivel() > 80)
            .count();

        System.out.println("Pokémon con nivel > 80: " + cantidadPokemonesLegendarios);
    }
}
```
**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_5.png)

**Explicación:** Se usa un `filter()` para escoger los pokemon con nivel mayor a 80 y despues se usa `count()`.

---

### Ejercicio 06 — Pokédex sin Duplicados

Dada una lista de Pokémon con elementos repetidos, generar una nueva colección donde cada Pokémon aparezca una sola vez.   

**Código implementado:**

```java
public class Ejercicio6 {
    
    public static void main(String[] args) {
        
        List<String> pokemones = List.of("Pikachu", "Charmander", "Pikachu", "Squirtle", "Charmander", "Mewtwo");

        System.out.println(pokemones.stream()
            .distinct()
            .toList()
        );
    }
}
```
**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_6.png)

**Explicación:** Se usa un `distinct()` en el stream para remover los elementos duplicados.

---

### Ejercicio 07 — Orden del Profesor Oak

El Profesor Oak quiere su Pokédex organizada. Ordenar alfabéticamente los nombres de los Pokémon.    

**Código implementado:**

```java
public class Ejercicio7 {
    
    public static void main(String[] args) {
        
        List<String> pokemones = List.of("Squirtle", "Pikachu", "Mewtwo",
            "Bulbasaur", "Charmander", "Abra");

        System.out.println(pokemones.stream().sorted().toList());
    }
}
```
**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_7.png)

**Explicación:** Se usa un `sorted()` en el stream para ordenar los nombres de los pokemon.

---

### Ejercicio 08 — Evoluciones Preparadas

Dada una lista de Pokémon que incluye si pueden evolucionar (boolean puedeEvolucionar), obtener únicamente los que estén listos para evolucionar.    

**Código implementado:**

```java
public class Ejercicio8 {

    public static void main(String[] args) {
        
        List<String> pokemones = List.of(
            "Pikachu(true)",
            "Raichu(false)",
            "Charmander(true)",
            "Charizard(false)",
            "Squirtle(true)",
            "Blastoise(false)"
        );

        List<String> pokemonesQuePuedenEvolucionar = pokemones.stream()
            .filter(p -> p.endsWith("true)"))
            .map(p -> p.substring(0, p.indexOf("(")))
            .toList();
        
        System.out.println(pokemonesQuePuedenEvolucionar);
    }
}
```
**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_8.png)

**Explicación:** Se usa un `filter()` en el stream para obtener únicamente los que pueden evolucionar y también un map para dejar solo el nombre.

---

### Ejercicio 09 — Equipo Élite

Mostrar únicamente los Pokémon cuyo poderCombate sea superior a 500.     

**Código implementado:**

```java
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
```
**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_9.png)

**Explicación:** Se usa un `filter()` para obtener los que tengan poder mayor a 500 y un map para guardar la informacion en la lista.

---

### Ejercicio 10 — Pokédex Compacta

Generar una lista que contenga únicamente los nombres de todos los Pokémon del equipo.     

**Código implementado:**

```java
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
```
**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_10.png)

**Explicación:** Se usa un `map()` para obtener el nombre de cada pokemon y despues se guarda en una lista.

---

### Ejercicio 11 — Poder Promedio

Calcular el promedio de poderCombate de todos los Pokémon del equipo     

**Código implementado:**

```java
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
```

**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_11.png)

**Explicación:** Se usa `mapToDouble()` para extraer el poder de combate de cada pokemon y luego con `average()` sacamos el promedio facil.

---

### Ejercicio 12 — Campeón Regional 

Obtener el Pokémon con mayor poderCombate de toda la lista.

**Código implementado:**

```java
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
```

**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_12.png)

**Explicación:** Con el metodo `max()` comparamos el poder de combate para encontrar el mas fuerte y sacamos el mensaje formateado.

---

### Ejercicio 13 — Organizar por Tipo

Agrupar todos los Pokémon por su tipo y mostrar el listado por grupo.

**Código implementado:**

```java
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
```

**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_13.png)

**Explicación:** Se agrupan los pokemones usando `groupingBy()` por su tipo y despues imprimo la lista de nombres por cada tipo.

---

### Ejercicio 14 — Organizar por Región

Insertar Agrupar los Pokémon según su región de origen.     

**Código implementado:**

```java
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
```

**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_14.png)

**Explicación:** Igual al anterior pero esta vez usando `groupingBy()` para agruparlos segun la region a la que pertenecen.

---

### Ejercicio 15 — Maestro de Gimnasios

Dado un listado de entrenadores con sus medallas, encontrar el entrenador con más medallas.

**Código implementado:**

```java
public class Ejercicio15 {
    
    public static void main(String[] args) {
        
        List<Entrenador> entrenadores = List.of(
            new Entrenador(List.of(), 1L, 8, "Ash"),
            new Entrenador(List.of(), 2L, 5, "Misty"),
            new Entrenador(List.of(), 3L, 6, "Brock"),
            new Entrenador(List.of(), 4L, 10, "Gary")
        );

        Entrenador maestroDeGimnasios = entrenadores.stream()
            .max((a, b) -> Integer.compare(a.getMedallas(), b.getMedallas()))
            .orElse(null);
        
        System.out.println("Campeón de gimnasios: " + maestroDeGimnasios.getNombre());
        System.out.println("Medallas obtenidas: " + maestroDeGimnasios.getMedallas());
    }
}
```

**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_15.png)

**Explicación:** Usamos `max()` comparando la cantidad de medallas para saber cual es el entrenador que mas tiene.

---

### Ejercicio 16 — Entrenadores Experimentados

Mostrar únicamente los entrenadores que posean más de 5 medallas.

**Código implementado:**

```java
public class Ejercicio16 {
    
    public static void main(String[] args) {
        
        List<Entrenador> entrenadores = List.of(
            new Entrenador(List.of(), 1L, 8, "Ash"),
            new Entrenador(List.of(), 2L, 5, "Misty"),
            new Entrenador(List.of(), 3L, 6, "Brock"),
            new Entrenador(List.of(), 4L, 10, "Gary"),
            new Entrenador(List.of(), 5L, 3, "May"),
            new Entrenador(List.of(), 6L, 7, "Dawn")
        );

        List<String> entrenadoresConMasMedallas = entrenadores.stream()
            .filter(e -> e.getMedallas() > 5)
            .map(e -> e.getNombre() + "(" + e.getMedallas() + ")")
            .toList();

        System.out.println("Entrenadores con > 5 medallas:");
        System.out.println(entrenadoresConMasMedallas);
    }
}
```

**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_16.png)

**Explicación:** Se filtra con un `filter()` los entrenadores con mas de 5 medallas y armamos un string con su nombre y medallas.

---

### Ejercicio 17 — Equipo Más Poderoso

Calcular cuál entrenador tiene la suma total de poderCombate más alta entre todos sus Pokémon.

**Código implementado:**

```java
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
```

**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_17.png)

**Explicación:** Se calcula la suma del poder de todo el equipo de cada entrenador y sacamos el maximo con un `Comparator.comparingDouble()`.

---

### Ejercicio 18 — Top 5 Pokémon Más Fuertes

Generar un ranking de los cinco Pokémon con mayor poderCombate de toda la Pokédex.

**Código implementado:**

```java
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
```

**Captura de ejecución:**

![](src\main\dosw\semana_2\pokemon\CapturasPantalla\captura_ejercicio_18.png)

**Explicación:** Ordenamos con `sorted()` de mayor a menor poder de combate, nos quedamos con los primeros 5 usando `limit(5)` y los mostramos en lista.

---

## Retos Especiales
- [x] Reto Legendario — Method References
- [x] Reto Shiny — Buenas prácticas de commits
- [ ] Reto Mewtwo — Ejercicio propuesto

# SEMANA No 4 — PATRONES DE DISEÑO DE SOFTWARE - MULTIVARIABLE 
 
## Datos personales: 
- Nombre y Apellido: Cristian Camilo Ortiz Sanchez
- Código de Estudiante: 1000105286
- Curso: DOSW-1

---

### Ejercicio 01 — Plataforma de Pagos Inteligentes

> Una aplicación de e-commerce permite pagar con tarjeta, PSE, Nequi, PayPal y transferencia bancaria. Cada medio tiene una lógica distinta pero el flujo de compra es el mismo. Además, según el país del usuario, el sistema construye el proveedor de pago correcto (Colombia → PSE/Nequi, USA → PayPal/Stripe).

| Strategy | Factory Method |
| --------- | --------- |
| Strategy encapsula cada algoritmo de pago en una clase independiente (TarjetaStrategy, PseStrategy, NequiStrategy). El Checkout trabaja con la interfaz PaymentStrategy sin importar cuál medio se use.   | Factory Method crea el proveedor correcto según el país del usuario. ColombiaPaymentFactory, UsaPaymentFactory. El cliente no sabe qué objeto concreto se construye.|

**Diagrama de clases:**

![](src\main\dosw\semana_4\ejercicio_1\DOSW-T4-E1.png)

**Código implementado. Clases relevantes:**

```java
public interface PaymentFactory {
    PaymentStrategy create(String type);
}
```
```java
public class ColombiaPaymentFactory implements PaymentFactory {

    @Override
    public PaymentStrategy create(String type) {
        if (type.equalsIgnoreCase("tarjeta")) {
            return new TarjetaStrategy();
        } else if (type.equalsIgnoreCase("nequi")) {
            return new NequiStrategy();
        } else if (type.equalsIgnoreCase("pse")) {
            return new PseStrategy();
        } else {
            throw new IllegalArgumentException("Método de pago no valido");
        }
    }
}
```
```java
public interface PaymentStrategy {
    void process(double amount);
}
```
```java
public class Checkout {
    
    private PaymentStrategy strategy;

    public Checkout(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void pay(double amount) {
        strategy.process(amount);
    }
}
```
**Explicación:** Sin estos patrones el Checkout terminaría lleno de ifs preguntando por el pais y por el medio de pago, lo cual iria en contra de Open Closed. Con Factory Method el Checkout se desacopla del Gateway, y con Strategy cada medio de pago vive como un algoritmo aislado, lo cual lo hace facil de extender.

---

### Ejercicio 02 — Sistema de Notificaciones Multicanal

> Cuando un pedido cambia de estado (pendiente → enviado → entregado), el sistema notifica por correo, SMS, WhatsApp y push. No todos los usuarios tienen activos los mismos canales. Cada canal tiene su propia forma de construir y formatear el mensaje.

| Observer | Factory Method |
| --------- | --------- |
| Observer desacopla el pedido de los canales. El Pedido es el Subject. EmailNotifier, SmsNotifier y PushNotifier son Observers. Agregar un canal nuevo no modifica el Pedido. | Factory Method crea el mensaje correcto para cada canal. EmailMessageFactory genera HTML. SmsMessageFactory genera texto plano de 160 chars. PushMessageFactory genera payload JSON. |

**Diagrama de clases:**

![](src\main\dosw\semana_4\ejercicio_2\DOSW-T4-E2.png)

**Código implementado. Clases relevantes:**

```java
public class Order {
    
    private List<NotificationObserver> subscribers;
    private String state;

    public Order(String state) {
        this.state = state;
        this.subscribers = new ArrayList<>();
    }

    public void subscribe(NotificationObserver observer) {
        subscribers.add(observer);
    }

    public void unsubscribe(NotificationObserver observer) {
        subscribers.remove(observer);
    }

    public void changeState(String state) {
        this.state = state;
        OrderEvent event = new OrderEvent(state);
        notifyObservers(event);
    }

    public void printOrderState() {
        System.out.println("El estado de la orden es: " + state);
    }

    private void notifyObservers(OrderEvent event) {
        subscribers.stream().forEach(s -> s.notify(event));
    }
}
```
```java
public interface NotificationObserver {
    void notify(OrderEvent event);
}
```
```java
public interface MessageFactory {
    Message build(OrderEvent event);
}
```
```java
public interface Message {
    void print();
}
```
**Explicación:** Esta solucion es superior porque sin los patrones el pedido tendría que saber como armar el mensaje para cada canal y ademas a quien mandarselo, muchas responsabilidades. Con Observer el Pedido solo notifica a los observers y ya. Con Factory se asegura que se cree el mensaje correcto para cada canal. Es facil de extender porque si se agrega otro tipo de mensaje solo se crea el Observer y la Factory nueva, sin tener que tocar nada mas de lo que ya existe.

---

### Ejercicio 03 — Sistema de Reportes Empresariales

> La empresa genera reportes en PDF, Excel y CSV. Todos siguen los mismos 4 pasos: obtener datos → procesar información → aplicar formato → exportar archivo. Pero cada formato implementa "aplicar formato" y "exportar" de forma diferente. Además, el sistema decide dinámicamente qué tipo de reporte crear.

| Template Method | Factory Method |
| --------- | --------- |
| Template Method define la estructura del algoritmo en la clase base ReportGenerator con un método final generate() que llama en orden los 4 pasos. Las subclases sobreescriben solo los pasos variables (applyFormat, export). | Factory Method crea la instancia correcta según la solicitud. ReportFactory.create('PDF') retorna PdfReport. ReportFactory.create('CSV') retorna CsvReport. El cliente no instancia directamente. |

**Diagrama de clases:**

![](src\main\dosw\semana_4\ejercicio_3\DOSW-T4-E3.png)

**Código implementado. Clases relevantes:**

```java
public class ReportFactory {

    public static ReportGenerator create(String format) {
        if (format.equalsIgnoreCase("PDF")) {
            return new PdfReport();
        } else if (format.equalsIgnoreCase("Excel")) {
            return new ExcelReport();
        } else if (format.equalsIgnoreCase("Cav")) {
            return new CavReport();
        } else {
            throw new IllegalArgumentException("Formato no disponible");
        }
    }
}
```
```java
public abstract class ReportGenerator {
    
    public final void generate() {
        fetchData();
        processData();
        applyFormat();
        exportFile();
    }

    public void fetchData() {
        System.out.println("Obteniendo Datos");
    }

    public void processData() {
        System.out.println("Procesando Informacion");
    }

    public abstract void applyFormat();
    public abstract void exportFile();
}
```
```java
public class PdfReport extends ReportGenerator {

    @Override
    public void applyFormat() {
        System.out.println("Aplicando formato de PDF");
    }

    @Override
    public void exportFile() {
        System.out.println("Exportando archivo como PDF");
    }

}
```
```java
public class Main {
    
    public static void main(String[] args) {
        
        ReportGenerator report = ReportFactory.create("PDF");
        report.generate();
    }
}
```
**Explicación:** La solucion es superior porque con Template Method el metodo generate() final estamos definiendo una estructura fija con los 4 pasos, y las subclases solo se preocupan por lo que en verdad cambia. Y como la Factory decide que reporte crear el cliente solo pide "PDF" y ya.

---

### Ejercicio 04 — Plataforma de Videojuegos — Personajes

> Un videojuego crea guerreros, magos y arqueros. Cada personaje puede tener habilidades especiales, armadura, arma y mejoras temporales (escudo de hielo, velocidad extra, invisibilidad). El personaje se construye al inicio de la partida, pero sus poderes pueden aumentar dinámicamente durante el juego.

| Builder | Decorator |
| --------- | --------- |
| Builder construye el personaje paso a paso al inicio. WarriorBuilder permite setArmor().setWeapon().setSkill(). El Director puede construir arquetipos predefinidos (guerrero élite, mago de fuego). Evita constructores con 10 parámetros. | Decorator agrega poderes dinámicamente sin modificar la clase base del personaje. ShieldDecorator, SpeedDecorator e InvisibilityDecorator envuelven el personaje y añaden comportamiento en runtime. |

**Diagrama de clases:**

![](src\main\dosw\semana_4\ejercicio_4\DOSW-T4-E4.png)

**Código implementado. Clases relevantes:**

```java
public class WarriorBuilder {

    private String armor;
    private String skill;
    private String weapon;

    public void reset() {
        this.armor = "ninguna";
        this.skill = "ninguna";
        this.weapon = "ninguna";
    }

    public WarriorBuilder setArmor(String armor) {
        this.armor = armor;
        return this;
    }

    public WarriorBuilder setSkill(String skill) {
        this.skill = skill;
        return this;
    }

    public WarriorBuilder setWeapon(String weapon) {
        this.weapon = weapon;
        return this;
    }

    public Character build() {
        return new BaseCharacter(armor, skill, weapon);
    }
}
```
```java
public class BaseCharacter implements Character {

    private String armor;
    private String skill;
    private String weapon;

    public BaseCharacter(String armor, String skill, String weapon) {
        this.armor = armor;
        this.skill = skill;
        this.weapon = weapon;
    }

    @Override
    public void attack() {
        System.out.println("ataque base");
    }

    public String getArmor() {
        return armor;
    }

    public String getSkill() {
        return skill;
    }

    public String getWeapon() {
        return weapon;
    }
}
```
```java
public abstract class BoostDecorator implements Character {

    protected Character wrappedCharacter;
    
    public BoostDecorator(Character wrapped) {
        this.wrappedCharacter = wrapped;
    }
}
```
```java
public class Main {

    public static void main(String[] args) {

        WarriorBuilder builder = new WarriorBuilder();
        Character warrior = builder.setArmor("steel")
                                   .setWeapon("sword")
                                   .setSkill("rage")
                                   .build();

        Character powered = new ShieldDecorator(
            new SpeedDecorator(warrior));

        powered.attack();
    }
}
```
**Explicación:** Es superior porque sin Builder acabariamos con un constructor gigante lleno de parametros. Y sin Decorator cada combinacion de poderes tocaria crear una subclase nueva. Con Builder el personaje se arma paso a paso y con Decorator los poderes envuelven a la clase base y se pueden quitar facilmente.

---

### Ejercicio 05 — Integración con Sistema Bancario Antiguo

> El sistema moderno usa PaymentProcessor con métodos modernos. El banco antiguo expone LegacyBankService con métodos incompatibles (executeTransaction, verifyBalance en centavos). Además, usar LegacyBankService directamente requiere 8 pasos de inicialización que los desarrolladores no deberían conocer.

| Adapter | Facade |
| --------- | --------- |
| Adapter hace que LegacyBankService sea compatible con la interfaz PaymentProcessor. LegacyBankAdapter implementa PaymentProcessor e internamente traduce las llamadas: amount → cents, pay() → executeTransaction(). | Facade expone un método simple procesarPago(monto) que internamente orquesta los 8 pasos de inicialización y uso del LegacyBankService (o del Adapter). Los desarrolladores usan la Facade y no conocen los detalles. |

**Diagrama de clases:**

![](src\main\dosw\semana_4\ejercicio_5\DOSW-T4-E5.png)

**Código implementado. Clases relevantes:**

```java
public class BankFacade {
    public void processPayment(double amount) {
        //Métodos para inicializar conexión, sesión y contexto
        LegacyBankService context = new LegacyBankService();
        PaymentProcessor adapter = new LegacyBankAdapter(context);
        adapter.pay(amount);
    }
}
```
```java
public interface PaymentProcessor {
    void pay(double amount);
}
```
```java
public class LegacyBankAdapter implements PaymentProcessor {

    private final LegacyBankService legacy;

    public LegacyBankAdapter(LegacyBankService legacy) {
        this.legacy = legacy;
    }

    @Override
    public void pay(double amount) {
        int cents = (int) (amount * 100);
        legacy.executeTransaction("ACC", cents);
    }
}
```
```java
public class LegacyBankService {
    
    public void executeTransaction(String accountType, int amount) {
        System.out.println("Ejecutando transaccion en LegacyBankService...");
        System.out.printf("Monto: %d centavos   Cuenta: %s", amount, accountType);
    }
}
```
**Explicación:** Es mejor que una solucion sin patrones porque con Adapter se traduce la interfaz vieja a la moderna sin que el sistema tenga que interactuar directamente con LegacyBankService, y con Facade se esconde toda esa complejidad detras de un solo metodo simple.

---

### Ejercicio 06 — Motor de Recomendaciones

> Una plataforma tipo Netflix usa algoritmos de recomendación por género, historial, popularidad y similitud con otros usuarios. El usuario puede cambiar sus preferencias de recomendación en cualquier momento. Cuando esto ocurre, la página principal, las notificaciones y la lista de "sugeridos" deben actualizarse automáticamente.

| Strategy | Observer |
| --------- | --------- |
| Strategy permite intercambiar el algoritmo de recomendación en tiempo de ejecución. GenreStrategy, HistoryStrategy, PopularityStrategy y SimilarityStrategy implementan RecommendationAlgorithm. El motor cambia de algoritmo sin reiniciar. | Observer notifica automáticamente a todos los componentes cuando cambian las preferencias. HomePageComponent, NotificationService y SuggestedListComponent son Observers del evento "preferencias cambiadas". |

**Diagrama de clases:**

![](src\main\dosw\semana_4\ejercicio_6\DOSW-T4-E6.png)

**Código implementado. Clases relevantes:**

```java
public class User {
    
    private RecommendationAlgorithm strategy;
    private List<PreferenceObserver> subscribers;

    public User(RecommendationAlgorithm strategy) {
        this.strategy = strategy;
        this.subscribers = new ArrayList<>();
    }

    public void subscribe(PreferenceObserver observer) {
        subscribers.add(observer);
    }

    public void unsubscribe(PreferenceObserver observer) {
        subscribers.remove(observer);
    }

    public void changePreferences(RecommendationAlgorithm preference) {
        this.strategy = preference;
        notifySubscribers();
    }

    private void notifySubscribers() {
        subscribers.stream().forEach(s -> s.onPreferenceChanged(this));
    }

    public RecommendationAlgorithm getRecommendationAlgorithm() {
        return this.strategy;
    }
}
```
```java
public interface RecommendationAlgorithm {
    List<Content> recommend(User user);
}
```
```java
public interface PreferenceObserver {
    void onPreferenceChanged(User user);
}
```
```java
public class Main {
    public static void main(String[] args) {

        PreferenceObserver homePage = new HomePageComponent();
        PreferenceObserver suggeredList = new SuggeredListComponent();
        PreferenceObserver notificationService = new NotificationService();

        User user = new User(new GenreStrategy());
        user.subscribe(homePage);
        user.subscribe(suggeredList);
        user.subscribe(notificationService);

        user.changePreferences(new HistoryStrategy());

        user.unsubscribe(notificationService);
        user.changePreferences(new PopularityStrategy());
    }
}
```
**Explicación:** Superior a una solucion sin patrones poruqe sin strategy el encargado de las recomendaciones tendria un monton de ifs para decidir que algoritmo usar. Sin Observer cada vez que el usuario cambia de preferencia tocaria ir actualizando todo manualmente. Con Strategy el algoritmo se intercambia de manera facil y con observer todo se actualiza apenas cambian las preferencias.

---

### Ejercicio 07 — Flujo de Aprobación de Documentos

> Los documentos pasan por: revisión del autor, revisión del líder, revisión jurídica, revisión financiera y aprobación final. No todos pasan por todas las etapas. Además, el documento tiene estados propios: borrador, en revisión, aprobado, rechazado. La transición de estado depende del resultado de cada handler de la cadena.

| Chain of Responsibility | State |
| --------- | --------- |
| Chain of Responsibility encadena los validadores. Cada handler (AutorHandler, LiderHandler, JuridicoHandler) decide si procesa el documento o lo pasa al siguiente. La cadena puede configurarse distinto según el tipo de documento. | State maneja las transiciones de estado del documento. DraftState, InReviewState, ApprovedState, RejectedState. Cada estado sabe a qué estado puede transicionar y qué operaciones permite. Elimina los switch/if de estado. |

**Diagrama de clases:**

![](src\main\dosw\semana_4\ejercicio_7\DOSW-T4-E7.png)

**Código implementado. Clases relevantes:**

```java
public abstract class DocumentHandler {
    
    private DocumentHandler next;

    public DocumentHandler setNext(DocumentHandler handler) {
        this.next = handler;
        return handler;
    }

    public void handle(Document doc) {
        if (canHandle(doc)) {
            process(doc);
        } else if (next != null) {
            next.handle(doc);
        }
    }

    public abstract boolean canHandle(Document doc);
    public abstract void process(Document doc);
}
```
```java
public class Document {
    
    private DocumentState state;

    public void approve() {
        if (state == null) {
            System.out.println("Documento pasado a estado de revision");
            state = new InReviewState();
        }
        state.approve(this);
    }

    public void reject() {
        state.reject(this);
    }

    public void changeState(DocumentState state) {
        this.state = state;
    }

    public DocumentState getState() {
        return state;
    }
}
```
```java
public interface DocumentState {
    
    void approve(Document doc);
    void reject(Document doc);
}
```
```java
public class Main {
    public static void main(String[] args) {
        
        DocumentHandler handler = new AutorHandler();
        handler.setNext(new LiderHandler())
               .setNext(new FinancieroHandler())
               .setNext(new JuridicoHandler());

        Document doc = new Document();

        handler.handle(doc);
    }
}
```
**Explicación:** Con chain of responsability cada handler solo se hace su parte y decide si pasa al siguiente y con state cada estado sabe que transiciones puede hacer. El documento no sabe en que estado esta pero su estado sabe que hay que hacer.

---

### Ejercicio 08 — Sistema de Pedidos en Restaurante

> El cliente construye una hamburguesa eligiendo ingredientes, tamaño, tipo de pan, acompañamientos y extras. Después de confirmado el pedido, el sistema debe notificar a cocina (preparar), a facturación (generar cuenta) y al domiciliario (preparar ruta) sin que el pedido los conozca directamente.

| Builder | Observer |
| --------- | --------- |
| Builder construye el pedido personalizado paso a paso. OrderBuilder permite setSize().setMeat().setToppings().addSide(). El pedido resultante es inmutable una vez construido. Evita el constructor caótico con todos los ingredientes. | Observer notifica a los subsistemas cuando el pedido se confirma. KitchenService, BillingService y DeliveryService son Observers. El pedido solo hace pedido.confirm() — no sabe a quién avisar. |

**Diagrama de clases:**

![](src\main\dosw\semana_4\ejercicio_8\DOSW-T4-E8.png)

**Código implementado. Clases relevantes:**

```java
public class OrderBuilder {
    
    private Size size;
    private Meat meat;
    private List<String> toppings;
    private List<String> sides;

    public OrderBuilder() {
        this.toppings = new ArrayList<>();
        this.sides = new ArrayList<>();
    }

    public OrderBuilder setSize(Size size) {
        this.size = size;
        return this;
    }

    public OrderBuilder setMeat(Meat meat) {
        this.meat = meat;
        return this;
    }

    public OrderBuilder addTopping(String topping) {
        toppings.add(topping);
        return this;
    }

    public OrderBuilder addSide(String side) {
        sides.add(side);
        return this;
    }

    public Order build() {
        return new Order(size, meat, toppings, sides);
    }
}
```
```java
public class Order {
    
    private final Size size;
    private final Meat meat;
    private final List<String> toppings;
    private final List<String> sides;

    private List<Observer> observers;
    
    public Order(Size size, Meat meat, List<String> toppings, List<String> sides) {
        this.size = size;
        this.meat = meat;
        this.toppings = toppings;
        this.sides = sides;
        observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void confirm() {
        System.out.println("Pedido confirmado:");
        System.out.println("    Tamaño: " + size);
        System.out.println("    Carne: " + meat);
        System.out.println("    Toppings: " + toppings.stream().collect(Collectors.joining(", ")));
        System.out.println("    Sides: " + sides.stream().collect(Collectors.joining(", ")));
        System.out.println();
        observers.forEach(o -> o.onOrderConfirmed());
    }
    
}
```
```java
public interface Observer {
    void onOrderConfirmed();
}
```
```java
public class Main {
    public static void main(String[] args) {
        Order order = new OrderBuilder()
            .setSize(Size.LARGE)
            .setMeat(Meat.DOUBLE_BEEF)
            .addTopping("queso")
            .addTopping("lechuga")
            .addSide("papas")
            .addSide("gaseosa")
            .build();

        order.addObserver(new KitchenService());
        order.addObserver(new BillingService());
        order.addObserver(new DeliveryService());
        order.confirm();
    }
}
```
**Explicación:** Con builder el pedido es facil de construir como se muestra en el main, y con observer el pedido solo confirma sin saber que servicios estan esperando la confirmacion.

---

### Ejercicio 09 — Sistema de Autenticación Empresarial

> La empresa tiene 5 métodos de autenticación: usuario/contraseña, Google, Microsoft, token empresarial y biometría. Según el tipo de usuario, el sistema selecciona el mecanismo correcto. Una vez autenticado, la solicitud pasa por: validación de credenciales, validación de permisos, validación de ubicación y validación de horario laboral.

| Strategy | Chain of Responsibility |
| --------- | --------- |
| Strategy selecciona el mecanismo de autenticación. PasswordStrategy, GoogleStrategy, BiometricStrategy implementan AuthStrategy. El AuthService recibe la estrategia correcta según el tipo de usuario y llama authenticate(). | Chain of Responsibility procesa las validaciones en secuencia. CredentialValidator → PermissionValidator → LocationValidator → TimeValidator. Cada uno decide si pasa al siguiente o lanza un AccessDeniedException. |

**Diagrama de clases:**

![](src\main\dosw\semana_4\ejercicio_9\DOSW-T4-E9.png)

**Código implementado. Clases relevantes:**

```java
public interface AuthStrategy {

    public AuthResult authenticate(Credentials credentials);
}
```
```java
public abstract class BaseValidator implements Validator {
    private Validator next;

    @Override
    public Validator setNext(Validator validator) {
        this.next = validator;
        return validator;
    }

    @Override
    public void validate(AuthResult authentication) throws AccessDeniedException {
        if (next != null) {
            next.validate(authentication);
        } else {
            System.out.println("\nSe ha validado correctamente.");
        }
    }
}
```
```java
public class AuthService {
    
    private AuthStrategy strategy;

    public AuthService(AuthStrategy strategy) {
        this.strategy = strategy;
    }

    public AuthResult authenticate(Credentials credentials) {
        return strategy.authenticate(credentials);
    }

    public void setStrategy(AuthStrategy strategy) {
        this.strategy = strategy;
    }
    
}
```
```java
public class Main {
    
    public static void main(String[] args) {
        AuthService service = new AuthService(new BiometricStrategy());
        Validator chain = new CredentialValidator();

        chain.setNext(new PermissionValidator())
            .setNext(new LocationValidator())
            .setNext(new TimeValidator());

        AuthResult result = service.authenticate(new Credentials("CatrachoINXS", "contraseña123"));
        
        try {
            chain.validate(result);
        } catch (AccessDeniedException e) {
            System.out.println("\nACCESS DENIED EXCEPTION");
            e.printStackTrace();
        }
    }
}
```
**Explicación:** Es superior porque sin sdtrategy el authservice tendria que decidir con condicionales cual metodo de autenticacion usar segun el usuario y sin chain of responsibility las validaciones de permisos, ubicacion y horario quedarian todas en un metodo gigante, dificil de mantener y de probar por separado.

---

### Ejercicio 10 — Aplicación de Edición de Imágenes

> La app permite aplicar filtros acumulativos: blanco y negro, sepia, brillo, contraste y reducción de ruido. El usuario puede aplicar varios filtros sobre la misma imagen en cualquier orden. Además, cada acción debe poder deshacerse de manera individual (no solo deshacer la última).

| Decorator | Command |
| --------- | --------- |
| Decorator aplica filtros de forma acumulativa. GrayscaleDecorator, SepiaDecorator, BrightnessDecorator envuelven la imagen. Se pueden apilar en cualquier orden. Agregar un filtro nuevo no modifica los existentes. | Command encapsula cada operación del usuario como un objeto (ApplyFilterCommand, RemoveFilterCommand). El historial de comandos permite undo individual. El comando tiene execute() y undo(). |

**Diagrama de clases:**

![](src\main\dosw\semana_4\ejercicio_10\DOSW-T4-E10.png)

**Código implementado. Clases relevantes:**

```java
public class BaseImage implements Image {

    @Override
    public BufferedImage render() {
        return new BufferedImage();
    }
    
}
```
```java
public class ImageDecorator implements Image {

    protected Image wrappee;

    public ImageDecorator(Image wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public BufferedImage render() {
        return wrappee.render();
    }

    public Image getWrappee() {
        return wrappee;
    }
}
```
```java
public interface ImageCommand {
    
    public void execute();
    public void undo();
}
```
```java
public class Main {
    public static void main(String[] args) {
        
        Image image = new BaseImage();

        ApplyFilterCommand applySepia = new ApplyFilterCommand(image, "sepia");
        ApplyFilterCommand applyBrightness = new ApplyFilterCommand(applySepia.getImage(), "brightness");
        applySepia.execute();
        applyBrightness.execute();

        applyBrightness.undo();
        
    }
}
```
**Explicación:** Sin decorator cada combinacion de filtros (sepia+brillo+contraste, etc) tocaria crear una clase nueva, si hicieramos todas las combinaciones vemos que seria horrible de mantener.