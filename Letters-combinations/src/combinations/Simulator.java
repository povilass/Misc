package combinations;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Povilas on 2015.10.07.
 */
public class Simulator {

    public static void main(String[] args) {
        String letters = "abcd";


        List<String> result = iterator(letters);
        System.out.println();
        result.forEach(System.out::println);
    }

    public static List<String> iterator(String letters) {
        List<String> result = new LinkedList<>();
        if(letters.length() == 1) {
            result.add(letters);
            return result;
        } else {
            char first = letters.charAt(0);
            String left = letters.substring(1);
            List<String> found = iterator(left);

            for(String value : found) {
                List<String> extracted = extract(first, value);
                result.addAll(extracted);
            }
        }
        return result;

    }

    public static List<String> extract(char ch, String founded) {
        List<String> result = new LinkedList<>();
        for(int i = 0; i <= founded.length(); i++) {
            String inserted = founded.substring(0, i) + ch + founded.substring(i);
            result.add(inserted);
        }
        return result;

    }
}
