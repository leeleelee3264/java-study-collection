package me.leelee3264.springbootgettingstarted.byfunc.Hateoas;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

/**
 * @author SeungminLee
 * project spring-boot-getting-started
 * date 2021-06-23
 * description
 */
public class Greeting extends RepresentationModel<Greeting> {

    private String prefix;
    private String name;

    @JsonCreator
    public Greeting(
        @JsonProperty("prefix") String prefix,
        @JsonProperty("name") String name
    ) {
        this.prefix = prefix;
        this.name = name;
    }


    public String getPrefix() {
        return prefix;
    }

    public String getName() {
        return name;
    }
}
