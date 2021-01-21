import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author SeungminLee
 * project java_without_server
 * date 2021-01-11
 * description
 */
public class Regex {

    public static void testFind(String src) {
        Pattern pattern = Pattern.compile("([^,]*):([^,]*):([^,]*)");
        Matcher mater = pattern.matcher(src);

        if(mater.find()) {
            System.out.println(mater.group(0));
            System.out.println(mater.group(1));
            System.out.println(mater.group(2));
        }
    }

    public static void extractBetween(String src) {
        Pattern pattern = Pattern.compile("\\((.*?)\\)");
        Matcher matcher = pattern.matcher(src);

        if(matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
        }
    }

    public static void main(String[] args) {

//        String src = "A:COME_IN:T";
//        testFind(src);

        String src2 = "I (Love) you";
        extractBetween(src2);
    }
}
