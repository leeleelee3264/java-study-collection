package javaInAction.partTwo.chapter5.dotSix;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author SeungminLee
 * project java_without_server
 * date 2021-03-14
 * description
 */
public class Trader {

    private final String name;
    private final String city;

    public static Trader of(String name, String city) {
        Objects.requireNonNull(name, "Trader name cannot be null");
        Objects.requireNonNull(city, "Trader city cannot be null");

        return new Trader(name, city);
    }

    private Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
