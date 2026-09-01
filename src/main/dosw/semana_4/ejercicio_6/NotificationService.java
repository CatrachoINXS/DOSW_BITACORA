package main.dosw.semana_4.ejercicio_6;

import java.util.List;

public class NotificationService implements PreferenceObserver {

    @Override
    public void onPreferenceChanged(User user) {
        List<Content> contents = user.getRecommendationAlgorithm().recommend(user);
        contents.forEach(c -> {System.out.print("\n[Notificacion] Nueva sugerencia: ");
            c.print();});
        System.out.println();
    }
}
