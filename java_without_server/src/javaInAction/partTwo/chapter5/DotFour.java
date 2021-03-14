package javaInAction.partTwo.chapter5;

import java.util.Arrays;
import java.util.List;

/**
 * @author SeungminLee
 * project java_without_server
 * date 2021-03-14
 * description
 */
public class DotFour {


    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(1,2,3,4,5);

        int standard = 2;
        boolean isBigger = number.stream()
                            .anyMatch(s -> {
                                System.out.println("caller " + s);
                                return s > standard;
                            });

        System.out.println(isBigger);
    }
}
