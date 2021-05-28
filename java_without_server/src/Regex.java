import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author SeungminLee
 * project java_without_server
 * date 2021-01-11
 * description
 */
public class Regex {




    public static void testNumber(String src) {

        Pattern SRC_PHONE_FORMAT =  Pattern.compile("(\\d{3})(\\d{4})(\\d{4})");
        Pattern DEST_PHONE_FORMAT = Pattern.compile("$1-$2-$3");

        String dest = src.replaceFirst(SRC_PHONE_FORMAT.toString(), DEST_PHONE_FORMAT.toString());
        System.out.println(dest);
    }

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

    public static String removeWhiteSpace(String src) {
        return src.replaceAll("\\s", "");
    }


    public static void main(String[] args) {

//        String src = "A:COME_IN:T";
//        testFind(src);

//        String src2 = "I (Love) you";
//        extractBetween(src2);
//
//        String phone = "01012344444";
//        testNumber(phone);

        String src3 = "이름에 공백이 웬말";
        System.out.println(removeWhiteSpace(src3));


        String src5 = " Seungmin Lee ";
        System.out.println(src5.trim());

        String src4 = null;
        System.out.println(src4.trim());

    }
}
