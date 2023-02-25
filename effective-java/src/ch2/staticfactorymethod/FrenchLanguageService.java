package ch2.staticfactorymethod;

public class FrenchLanguageService implements LanguageService {

    @Override
    public String hello() {
        return "Bonjour";
    }
}
