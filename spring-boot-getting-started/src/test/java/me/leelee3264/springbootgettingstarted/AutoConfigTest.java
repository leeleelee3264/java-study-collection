package me.leelee3264.springbootgettingstarted;

import me.leeleelee3264.leeleespringbootstarter.Food;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author SeungminLee
 * project spring-boot-getting-started
 * date 2021-05-21
 * description
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AutoConfigTest {


    @Qualifier("myFood")
    @Autowired
    Food food;

    @Test
    public void testAct() {
        System.out.println("test activate");
    }


    @Test
    public void autoConfigured_class() {
        System.out.println(food.toString());
    }
}
