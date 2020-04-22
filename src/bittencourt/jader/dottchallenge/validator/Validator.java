package bittencourt.jader.dottchallenge.validator;

import java.util.regex.Pattern;

public class Validator {

    public static boolean containsCorrectAdditionalArguments(String[] args) {
        if (args.length <= 2) {
            return false;
        }

        for (int i = 2; i < args.length; i++) {
            if (isAdditionalParameterIncorrect(args[i])) {
                printParameterMessage();
                return false;
            }
        }
        return true;
    }

    private static boolean isAdditionalParameterIncorrect(String parameter) {
        if (parameterDoesNotMatchesRegex(parameter) ||
                parameterDoesNotContainRightSymbol(parameter) ||
                isIncorrectIntervalParameter(parameter) ||
                isIncorrectGreaterThanParameter(parameter) ||
                isIncorrectLowerThanParameter(parameter)) {
            return true;
        }

        return false;
    }

    private static boolean parameterDoesNotContainRightSymbol(String parameter) {
        return !parameter.contains("-") && !parameter.contains(">") && !parameter.contains("<");
    }

    private static boolean isIncorrectIntervalParameter(String parameter) {
        if (!parameter.contains("-"))
            return false;

        String[] splitParameter = parameter.split("-");

        return Boolean.FALSE.equals(splitParameter.length == 2 && splitParameterContainsValidString(splitParameter));
    }

    private static boolean isIncorrectGreaterThanParameter(String parameter) {
        if (!parameter.contains(">"))
            return false;

        String[] splitParameter = parameter.split(">");

        return Boolean.FALSE.equals(
                splitParameter.length == 2 &&
                        splitParameter[0].equals("") &&
                        parameterContainsValidString(splitParameter[1]));
    }

    private static boolean isIncorrectLowerThanParameter(String parameter) {
        if (!parameter.contains("<"))
            return false;

        String[] splitParameter = parameter.split("<");

        return Boolean.FALSE.equals(
                splitParameter.length == 2 &&
                        splitParameter[0].equals("") &&
                        parameterContainsValidString(splitParameter[1]));
    }

    private static boolean parameterDoesNotMatchesRegex(String parameter) {
        return !Pattern.matches("^[0-9\\-><]+$", parameter);
    }

    private static boolean splitParameterContainsValidString(String[] splitParameter) {
        for (String s : splitParameter) {
            if (!Pattern.matches("^[0-9]+$", s)) {
                return false;
            }
        }
        return true;
    }

    private static boolean parameterContainsValidString(String parameter) {
        return Pattern.matches("^[0-9]+$", parameter);
    }

    private static void printParameterMessage() {
        System.out.println("Additional interval parameter incorrect.");
        System.out.println("Interval parameter must match the following pattern:");
        System.out.println("x-y for interval between months: 1-3 represents between one and three months");
        System.out.println(">x for interval older than x: >12 represents older than twelve months");
        System.out.println("<x for interval younger than x: <12 represents younger than twelve months");
    }
}
