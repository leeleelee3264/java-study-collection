package javaInAction.partTwo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author SeungminLee
 * project java_without_server
 * date 2021-05-26
 * description
 */
public class EnumTest {

    public static void main(String[] args) {
        GEN mine = GEN.F;

//        System.out.println(mine.name());
        Map<String, String> t = new HashMap<>();
        System.out.println(t.get("eee"));
    }
}



enum GEN {



    M                ("male"),
    F                ("female"),


    ;

    private final String str;

    GEN(String s) {
        this.str = s;
    }
}