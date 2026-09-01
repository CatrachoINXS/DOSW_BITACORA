package main.dosw.semana_4.ejercicio_6;

import java.util.List;

public class HistoryStrategy implements RecommendationAlgorithm {

    @Override
    public List<Content> recommend(User user) {
        return List.of(
            new Content("Documental History Channel"),
            new Content("Pelicula WW2"));
    }
}