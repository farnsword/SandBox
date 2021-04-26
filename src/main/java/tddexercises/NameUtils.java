package tddexercises;

import java.util.Objects;

public class NameUtils {

    public static String getGreeting(String... names) {
        var namesToGreet = parseNamesIntoString(names);
        var greeting = "Hello, ";

        if (namesToGreet.matches("[A-Z]+")) {
            greeting = greeting.toUpperCase();
        }
        return greeting + namesToGreet;
    }

    private static String parseNamesIntoString(String... names) {
        if (Objects.isNull(names) || Objects.isNull(names[0])) {
            return "my friend";
        } else {
            if (names.length == 1) {
                return names[0];
            } else if (names.length == 2) {
                return names[0] + " and " + names[1];
            } else {
                return joinMultipleNamesToString(names);
            }
        }
    }

    private static String joinMultipleNamesToString(String[] names) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < names.length; i++) {
            sb.append(names[i]);
            if (i != names.length - 1) {
                sb.append(", ");
            }
            if (i == names.length - 2) {
                sb.append("and ");
            }
        }
        return sb.toString();
    }
}
