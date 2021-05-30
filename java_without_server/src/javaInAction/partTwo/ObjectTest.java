package javaInAction.partTwo;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * @author SeungminLee
 * project java_without_server
 * date 2021-05-28
 * description
 */
public class ObjectTest {


    public static void main(String[] args) {
        Object e = 1;
        System.out.println(e instanceof Integer);
        System.out.println(1 == (int)e);

        Object str = "string";
        System.out.println(str.equals("string"));
    }

}
