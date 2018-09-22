package test;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Repeatable(Games.class)
@interface Game {
    String name();
    String day();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Games {
    Game[] value();
}

// Repeating annotation
@Game(name = "Cricket",  day = "Sunday")
@Game(name = "Hockey",   day = "Friday")
@Game(name = "Football", day = "Saturday")
public class RepeatAnnotationTest {
    public static void main(String[] args) {
        Game[] games = RepeatAnnotationTest.class.getAnnotationsByType(Game.class);
        games = RepeatAnnotationTest.class.getAnnotation(Games.class).value();
        for(Game game : games) {
            System.out.println(game.name() + " on " + game.day());
        }
    }
}
