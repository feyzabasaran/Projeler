package SansliMusteriBulmaProjesi;

import java.time.LocalDate;

public class User {
    String name ;
    LocalDate registerDate;

    public User() {
    }

    public User(String name, LocalDate registerDate) {
        this.name = name;
        this.registerDate = registerDate;
    }
}
