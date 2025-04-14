import java.util.ArrayList;
import java.util.List;

public class StringUtils {
    public static String[] substringsBetween(String str, String open, String close) {
        if (str == null || open.isEmpty() || close.isEmpty()) {
            return null;
        }
        if (str.isEmpty()) {
            return new String[0];
        }

        List<String> substrings = new ArrayList<>();
        int startIndex = 0;

        while ((startIndex = str.indexOf(open, startIndex)) != -1) {
            startIndex += open.length();
            int endIndex = str.indexOf(close, startIndex);
            if (endIndex == -1) {
                break;
            }
            substrings.add(str.substring(startIndex, endIndex));
            startIndex = endIndex + close.length();
        }

        return substrings.isEmpty() ? null : substrings.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String str = "abc<test>def<example>ghi";
        String open = "<";
        String close = ">";

        String[] result = substringsBetween(str, open, close);
        if (result != null) {
            for (String s : result) {
                System.out.println(s);
            }
        } else {
            System.out.println("Nenhuma substring encontrada ou entrada inválida.");
        }
    }
}
