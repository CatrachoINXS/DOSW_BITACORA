package main.dosw.semana_4.ejercicio_6;

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
