package ch2;

import java.sql.Connection;

public class FrenchLanguageService implements LanguageService {

    @Override
    public String hello() {
        return "Bonjour";
    }
}
