package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validar {

    public static boolean validarDNI(String dni) {
        return dni.matches("^\\d{8}[A-HJ-NP-TV-Z]$");
    }

    public static boolean validarMatricula(String matricula) {
        String regex = "^[A-Z]{1,3}[- ]?[0-9]{1,4}[- ]?[A-Z]{1,3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(matricula);

        return matcher.matches();
    }
}
