package javaInAction.partTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author SeungminLee
 * project java_without_server
 * date 2021-02-17
 * description
 */
public class SimpleTest {

    public static List<String> dummyString;

    static {
        dummyString = new ArrayList<>();
        dummyString.add("마르띠리오");
        dummyString.add("아멜리아");
        dummyString.add("앙구스티아스");
        dummyString.add("막달레나");
        dummyString.add("아델라");
    }

    public void printStream() {

        List<String> newList = dummyString.stream()
                .filter( s -> {
                    System.out.println("filter :" +  s );
                    return s.length() > 3;
                })
                .filter( s-> {
                    System.out.println("2 filter: " + s);
                    return s.length() > 3;
                })
                .limit(2)
                .collect(Collectors.toList());

    }

}

