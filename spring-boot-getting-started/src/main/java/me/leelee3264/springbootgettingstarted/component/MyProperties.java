package me.leelee3264.springbootgettingstarted.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * @author SeungminLee
 * project spring-boot-getting-started
 * date 2021-06-02
 * description
 */
@Validated
@Component
@ConfigurationProperties("my")
public class MyProperties {

    private String name;
    private int age;

    @NotEmpty
    private String fullName;

    @DurationUnit(ChronoUnit.SECONDS) //이 어노테이션 없어도 된다고 함
    private Duration sessionTimeout;

    public Duration getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(Duration sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
